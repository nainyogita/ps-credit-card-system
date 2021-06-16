package com.publicissapient.creditcardsystem.exception;

import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;


public class CustomException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public CustomException(String message, HttpStatus httpStatus, ZonedDateTime zonedTimeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = zonedTimeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }
}
