package com.ristanovica89.rest_api_crud.exception;

import org.springframework.http.HttpStatus;

public class EmployeeException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public EmployeeException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public String getMessage() {
        return message;
    }
}
