package com.publicissapient.creditcardsystem.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * POJO for CustomException model
 * Used in CustomExceptionHandler to refine the error response.
 */
public class CustomException {

    private final String errorCode;
    private final String description;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;


    public CustomException(String errorCode, String description, HttpStatus httpStatus, ZonedDateTime zonedTimeStamp) {
        this.errorCode = errorCode;
        this.description = description;
        this.httpStatus = httpStatus;
        this.timeStamp = zonedTimeStamp;
    }

    /**
     * Getters and Setters
     */
    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
