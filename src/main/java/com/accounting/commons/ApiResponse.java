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
        this.statusCode = statusCode != null ? statusCode : HttpStatus.OK;
        this.zonedDateTime = zonedDateTime;
        this.data = data;
    }

    public ApiResponse(Object data, HttpStatus statusCode) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public ApiResponse setMessage(Object message) {
        this.message = message;
        return this;
    }

    public ApiResponse setStatusCode(HttpStatus status) {
        this.statusCode = status;
        return this;
    }

    public ApiResponse setZonedDateTime(ZonedDateTime dateTime) {
        this.zonedDateTime = dateTime;
        return this;
    }

    public ApiResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public ApiResponse() {
    }

    public ApiResponse(Object data) {
        this.data = data;
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
