package com.accounting.commons;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiResponse {

    public Object message;
    public HttpStatus statusCode;
    public ZonedDateTime zonedDateTime;
    public Object data;

    public ApiResponse(String message, HttpStatus statusCode, ZonedDateTime zonedDateTime, Object data) {
        this.message = message;
        this.statusCode = statusCode;
        this.zonedDateTime = zonedDateTime;
        this.data = data;
    }

    public ApiResponse(Object data, HttpStatus statusCode) {
        this.statusCode = statusCode;
        this.data = data;
    }


    public ApiResponse() {
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", statusCode=" + statusCode +
                ", zonedDateTime=" + zonedDateTime +
                ", data=" + data +
                '}';
    }
}
