package com.publicissapient.creditcardsystem.exception;

/**
 * Enum for Unexpected Errors
 */
public enum UnexpectedErrorCodes {

    UNEXPECTED_TECHNICAL_ERROR("ERR_5000");

    private final String errorCode;
    private final String description;

    UnexpectedErrorCodes(String errorCode) {
        this.errorCode = errorCode;
        this.description = name();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
