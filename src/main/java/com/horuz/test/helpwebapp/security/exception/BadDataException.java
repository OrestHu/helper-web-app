package com.horuz.test.helpwebapp.security.exception;

import org.springframework.http.HttpStatus;

public class BadDataException extends RuntimeException {
    private HttpStatus httpStatus;

    public BadDataException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BadDataException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
