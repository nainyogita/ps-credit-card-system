package com.publicissapient.creditcardsystem;

import com.publicissapient.creditcardsystem.domain.Account;
import com.publicissapient.creditcardsystem.domain.AccountSummary;
import com.publicissapient.creditcardsystem.domain.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for createAccount and getAllAccount API's
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class AccountResourceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int randomServerPort;

    private String localhost = "http://localhost:";

    /**
     * Method to create input request of Account Type
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
     * Method to create POST request body payload json
     *
     * @param account Account
     * @return HttpEntity
     */
    public static HttpEntity<Account> createPostBody(Account account) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Account> request = new HttpEntity<>(account, headers);
        return request;
    }

    /**
     * Case 1: Test to verify green path scenario for create account
     */
    @DisplayName("verifies if createAccount method creates a new account")
    @Test
    public void shouldCreateNewAccountSuccessfully() throws Exception {
        Account accountRequest = createAccountRequest();

        final String baseUrl = localhost + randomServerPort + "/api/accounts/create";
        URI uri = new URI(baseUrl);

        ResponseEntity<Account> response = restTemplate.postForEntity(
                uri, createPostBody(accountRequest), Account.class);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody().getCustomer().getName());
    }

    /**
     * Case 2:  Test to verify red path scenario for invalid request param in create account
     */
    @DisplayName("verifies if createAccount method returns error for bad request")
    @Test
    public void shouldProvideRequestValidation() throws URISyntaxException {
        Account accountRequest = createAccountRequest();
        accountRequest.setCardNumber("12345678");

        final String baseUrl = localhost + randomServerPort + "/api/accounts/create";
        URI uri = new URI(baseUrl);

        ResponseEntity<Account> response = restTemplate.postForEntity(
                uri, createPostBody(accountRequest), Account.class);

        assertEquals(400, response.getStatusCodeValue());
        assertNull(response.getBody().getAccountSummary());
    }


    /**
     * Case 3:  Test to verify green path scenario for get all accounts
     */
    @DisplayName("verifies if getAllAccounts returns list of accounts")
    @Test
    void getAllAccounts() throws URISyntaxException {
        final String baseUrl = localhost + randomServerPort + "/api/accounts/";
        URI uri = new URI(baseUrl);

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
}
