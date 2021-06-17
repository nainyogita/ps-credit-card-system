package com.publicissapient.creditcardsystem.exception;

/**
 * CustomException - RequestValidationException
 */
public class CardValidationException extends RuntimeException {

    public CardValidationException(String message) {
        super(message);
    }

    public CardValidationException(){
        super();
    }
    public CardValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
