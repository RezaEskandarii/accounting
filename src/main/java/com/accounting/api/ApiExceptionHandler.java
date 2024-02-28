package com.accounting.api;

import com.accounting.commons.ApiResponse;
import com.accounting.shared.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private ResponseEntity<Object> handleException(Exception e, HttpStatus status, String message) {
        var exception = new ApiResponse(
                message,
                status,
                ZonedDateTime.now(ZoneId.of("Z")),
                null
        );

        return new ResponseEntity<>(exception, status);
    }

    @ExceptionHandler(value = {ApiRequestException.class, ItemNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleApiRequestException(Exception e) {
        return handleException(e, HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(value = {SQLException.class, DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleDatabaseException(Exception e) {
        return handleException(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(value = {DuplicatedItemException.class, InvalidDataException.class, ConflictException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleConflictException(Exception e) {
        if (e instanceof ConflictException || e instanceof DuplicatedItemException) {
            assert e instanceof DuplicatedItemException;
            List<String> errorMessages = ((DuplicatedItemException) e).getErrors() != null ?
                    ((DuplicatedItemException) e).getErrors()
                     : new ArrayList<>();
            return handleException(e, HttpStatus.CONFLICT, errorMessages != null ? String.join(", ", errorMessages) : e.getMessage());
        }
        return null;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected @NotNull ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                           HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        var resp = new ApiResponse(validationList);

        return new ResponseEntity<>(resp, status);
    }
}
