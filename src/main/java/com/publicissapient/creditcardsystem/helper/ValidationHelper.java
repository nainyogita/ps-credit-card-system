package com.publicissapient.creditcardsystem.helper;

import org.springframework.stereotype.Component;

@Component
public class ValidationHelper {

    public static boolean LuhnChecker(String cardNumber) {

        Boolean result = false;
        Boolean isSecond = false; //Denotes if cursor is at alternate/second position
        int digit = 0, sum = 0; //Digit

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            digit = Integer.valueOf(cardNumber.charAt(i) - '0');
            if (isSecond)
                digit = digit * 2;

            sum += (digit / 10) + (digit % 10);
            isSecond = !isSecond;
        }
        return (sum % 10 == 0);
    }
}
