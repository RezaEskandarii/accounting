package com.accounting.shared.exceptions;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends ApplicationException{
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
