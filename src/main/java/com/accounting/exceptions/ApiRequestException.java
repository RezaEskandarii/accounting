package com.accounting.exceptions;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestException(String message, HttpStatus status) {
        super(message);
    }
}
