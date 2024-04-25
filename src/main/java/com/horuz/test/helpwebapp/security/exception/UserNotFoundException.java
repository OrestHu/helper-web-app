package com.horuz.test.helpwebapp.security.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public UserNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public UserNotFoundException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
