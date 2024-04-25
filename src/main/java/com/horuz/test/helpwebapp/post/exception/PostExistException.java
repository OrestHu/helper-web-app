package com.horuz.test.helpwebapp.post.exception;

import org.springframework.http.HttpStatus;

public class PostExistException extends RuntimeException {
    private HttpStatus httpStatus;

    public PostExistException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public PostExistException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}