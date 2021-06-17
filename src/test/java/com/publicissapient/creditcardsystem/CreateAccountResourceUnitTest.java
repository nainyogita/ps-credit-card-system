package com.publicissapient.creditcardsystem;

import com.publicissapient.creditcardsystem.domain.Account;
import com.publicissapient.creditcardsystem.domain.AccountSummary;
import com.publicissapient.creditcardsystem.domain.Customer;
import com.publicissapient.creditcardsystem.exception.CardValidationException;
import com.publicissapient.creditcardsystem.helper.ValidationHelper;
import com.publicissapient.creditcardsystem.service.AccountService;

import com.publicissapient.creditcardsystem.web.rs.AccountResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

/**
 * Unit test cases for Create Account API
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class CreateAccountResourceUnitTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountResource accountResource;

    @BeforeEach
    void setUp() {
        accountResource = new AccountResource(accountService);
    }

    /**
     * Helper method to create input request of Account Type
     *
     * @return Account
     */
    public static Account createAccountRequest() {
        Customer customer = new Customer();
        customer.setName("Test name");

        AccountSummary accountSummary = new AccountSummary();
        accountSummary.setBalance(new BigDecimal("100"));

        Account account = new Account();
        account.setCardNumber("4556848408");
        account.setCustomer(customer);
        account.setAccountSummary(accountSummary);

        return account;
    }

    /**
     * Case 1: Test to verify createAccount service call for create account
     */
    @DisplayName("verifies that controller calls the account Service for account creation")
    @Test
    public void shouldCallAccountService() throws Exception {
        Account account = createAccountRequest();
        Mockito.when(accountService.createAccount(account)).thenReturn(account);
        accountResource.createAccount(account);

        verify(accountService, times(1)).createAccount(account);
    }

    /**
     * Case 2: Test to verify validation error scenario for create account
     */
    @DisplayName("verifies that validation error is returned if card number is null")
    @Test
    public void shouldReturnValidationError() throws Exception {
        Account account = createAccountRequest();
        account.setCardNumber(null);

        assertThrows(CardValidationException.class, () -> {
            accountResource.createAccount(account);
        });

        verify(accountService, never()).createAccount(account);
    }

    /**
     * Case 3: Test to verify checkLuhn sum validation for card Number
     */
    @DisplayName("verifies that checkLuhnSum method is called for Cardnumber verification")
    @Test
    public void shouldCallCheckLuhnSum() {
        Account account = createAccountRequest();
        account.setCardNumber("4556848407");

        assertThrows(CardValidationException.class, () -> {
            accountResource.createAccount(account);
        });

        verify(accountService, never()).createAccount(account);
    }

    /**
     * Case 4: Test to verify response Status for valid payload
     */
    @DisplayName("verifies that returns 201 status response for valid payload")
    @Test
    public void shouldReturnSuccessHttpStatus() {
        Account account = createAccountRequest();
        Mockito.when(accountService.createAccount(account)).thenReturn(account);

        ResponseEntity<Account> response = accountResource.createAccount(account);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody().getCustomer().getName());
    }
}
