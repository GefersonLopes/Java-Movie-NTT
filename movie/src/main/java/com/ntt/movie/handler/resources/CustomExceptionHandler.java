package com.ntt.movie.handler.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ntt.movie.handler.ErrorResponse;
import com.ntt.movie.handler.exception.ExceptionBadRequest;
import com.ntt.movie.handler.exception.ExceptionNotFound;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ExceptionNotFound.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ExceptionNotFound ex) {
      ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
      return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExceptionBadRequest.class)
    public ResponseEntity<ErrorResponse> handleExceptionBadRequest(ExceptionBadRequest ex) {
      ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
      return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
      return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
