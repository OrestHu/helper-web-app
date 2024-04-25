package com.horuz.test.helpwebapp.post.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public PostNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public PostNotFoundException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}