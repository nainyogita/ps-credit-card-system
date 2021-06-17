package com.publicissapient.creditcardsystem;

import java.math.BigDecimal;

/**
 * Holds constant values for this api
 */
public final class Constants {

    /**
     * Max length for credit card number
     */
    public static final Integer CARD_MAX_LENGTH = 16;

    /**
     * Default Total amount limit for credit card
     */
    public static final BigDecimal TOTAL_LIMIT = BigDecimal.valueOf(2000);

    /**
     * Default Balance amount for credit card
     */
    public static final BigDecimal BALANCE_AMOUNT = BigDecimal.valueOf(0);

    /**
     * Default locale is GBP
     */
    public static final String DEFAULT_LOCALE = "GBP";
}
