package com.accounting.commons;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiResponse {

    private final String message;
    private final HttpStatus statusCode;
    private final ZonedDateTime zonedDateTime;
    private final Object data;

    public ApiResponse(String message, HttpStatus statusCode, ZonedDateTime zonedDateTime, Object data) {
        this.message = message;
        this.statusCode = statusCode;
        this.zonedDateTime = zonedDateTime;
        this.data = data;
    }
}
