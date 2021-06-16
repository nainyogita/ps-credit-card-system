package com.publicissapient.creditcardsystem.exception;

/**
 * CustomException - RequestValidationException
 */
public class RequestValidationException extends RuntimeException {

    public RequestValidationException(String message) {
        super(message);
    }

    public RequestValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
