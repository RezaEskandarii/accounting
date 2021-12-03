package com.accounting.exceptions;

import com.accounting.commons.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
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
    public ResponseEntity<Object> handleNotFoundException(ItemNotFoundException e) {

        var exception = new ApiResponse(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z")),
                null
        );

        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }


}
