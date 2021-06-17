package com.publicissapient.creditcardsystem.exception;

/**
 * List of Contract Error codes
 */
public enum ContractErrorCodes {

    /**
     * Error code for invalid credit card number
     */
    INVALID_CREDIT_CARD_NUMBER("ERR_1005"),

    /**
     * Error code for invalid customer name
     */
    INVALID_CUSTOMER_NAME("ERR_1006"),

    /**
     * Error code for invalid request param
     */
    INVALID_REQUEST_PARAM("ERR_1007"),

    /**
     * Error code for entity not found
     */
    ENTITY_NOT_FOUND("ERR_2001");

    private final String errorCode;
    private final String description;

    ContractErrorCodes(String errorCode) {
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
