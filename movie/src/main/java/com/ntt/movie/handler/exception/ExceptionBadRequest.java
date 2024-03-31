package com.ntt.movie.handler.exception;

public class ExceptionBadRequest extends RuntimeException {
  public ExceptionBadRequest(String message) {
    super(message);
  }
}
