package com.accounting.api;

import com.accounting.commons.ApiResponse;
import com.accounting.shared.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
@EnableAutoConfiguration
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(value = {ApiRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

        var exception = new ApiResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z")),
                null
        );

        return new ResponseEntity<>(exception, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    @ExceptionHandler(value = {ItemNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNotFoundException(ItemNotFoundException e) {

        var exception = new ApiResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z")),
                null
        );

        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
        var resp = new ApiResponse().setMessage(validationList);

        return new ResponseEntity<>(resp, status);
    }

    @ExceptionHandler(value = SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleSqlException(SQLException e) {

        log.error(e.getMessage());
        var resp = new ApiResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(resp, resp.statusCode);
    }


    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e) {

        log.error(e.getMessage());
        var resp = new ApiResponse().setStatusCode(HttpStatus.CONFLICT);

        return new ResponseEntity<>(resp, resp.statusCode);
    }


    @ExceptionHandler(value = DuplicatedItemException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleDuplicatedItemException(DuplicatedItemException e) {

        var resp = new ApiResponse().setStatusCode(HttpStatus.CONFLICT);

        if (e != null && e.getErrors() != null) {
            resp.message = e.getErrors().stream().map(x -> x = this.messageSource.getMessage(x, null, Locale.ENGLISH));
        }

        return new ResponseEntity<>(resp, resp.statusCode);
    }

    @ExceptionHandler(value = InvalidDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleInvalidDataException(InvalidDataException e) {

        var resp = badRequestResponse();
        if (e != null && e.getErrors() != null) {
            resp.message = e.getErrors().stream().map(x -> x = this.messageSource.getMessage(x, null, Locale.ENGLISH));
        }

        return new ResponseEntity<>(resp, resp.statusCode);
    }


    @ExceptionHandler(value = ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleConflictException(ConflictException e) {

        var resp = badRequestResponse();
        if (e != null && e.getErrors() != null) {
            resp.message = e.getErrors().stream().map(x -> x = this.messageSource.getMessage(x, null, Locale.ENGLISH));
        }

        return new ResponseEntity<>(resp, resp.statusCode);
    }


    private ApiResponse badRequestResponse() {
        return new ApiResponse().setStatusCode(HttpStatus.BAD_REQUEST);
    }

}
