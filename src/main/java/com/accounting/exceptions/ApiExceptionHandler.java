package com.accounting.exceptions;

import com.accounting.commons.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<ApiResponse> handleApiRequestException(ApiRequestException e) {

        var exception = new ApiResponse(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("z")),
                null
        );

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
