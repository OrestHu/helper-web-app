package com.horuz.test.helpwebapp.security.exception;

import com.horuz.test.helpwebapp.post.exception.PostExistException;
import com.horuz.test.helpwebapp.post.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler extends Throwable {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handlerException(RuntimeException ex){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        FieldError fieldError = ex.getBindingResult().getAllErrors().stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .findFirst()
                .orElseThrow();
        String messageError = String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage());

        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, messageError);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ProblemDetail handlerBadCredentialsException(){
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "Unknown error occurred");
    }
    @ExceptionHandler(AuthenticationException.class)
    public ProblemDetail handlerAuthenticationException(){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "User not found");
    }

    @ExceptionHandler(BadDataException.class)
    public ResponseEntity<Object> handleMarkerNotFoundException(BadDataException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(PostExistException.class)
    public ResponseEntity<Object> handlePostExistException(PostExistException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Object> handlePostNotFoundException(PostNotFoundException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
    }
}