package com.publicissapient.creditcardsystem;

import com.publicissapient.creditcardsystem.domain.Account;
import com.publicissapient.creditcardsystem.domain.AccountSummary;
import com.publicissapient.creditcardsystem.domain.Customer;
import com.publicissapient.creditcardsystem.service.AccountService;
import com.publicissapient.creditcardsystem.web.rs.AccountResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit test cases for GetAllAccounts API
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class GetAllAccountsResourceUnitTest {

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
     * @return List<Account>
     */
    public static List<Account> createMockAccountRs() {

        List<Account> accounts = new ArrayList<>();

        //Create Object 1
        Customer customer = new Customer();
        customer.setName("Test name");

        AccountSummary accountSummary = new AccountSummary();
        accountSummary.setBalance(new BigDecimal("100"));

        Account account1 = new Account();
        account1.setCardNumber("4556848408");
        account1.setCustomer(customer);
        account1.setAccountSummary(accountSummary);

        //Create Object 2
        Customer customer2 = new Customer();
        customer2.setName("Test name 2");

        AccountSummary accountSummary2 = new AccountSummary();
        accountSummary2.setBalance(new BigDecimal("200"));

        Account account2 = new Account();
        account2.setCardNumber("02188191");
        account2.setCustomer(customer2);
        account2.setAccountSummary(accountSummary2);

        //Add to List
        accounts.add(account1);
        accounts.add(account2);

        return accounts;
    }

    /**
     * Case 1: Test to verify findAll service call to get All accounts
     */
    @DisplayName("verifies that controller calls accountService for fetching all accounts")
    @Test
    public void shouldCallAccountService() throws Exception {
        List<Account> mockAccounts = createMockAccountRs();
        Mockito.when(accountService.findAllAccounts()).thenReturn(null);
        accountResource.getAllAccounts();

        verify(accountService, times(1)).findAllAccounts();
    }

    /**
     * Case 2: Test to verify response List<Account> for get All accounts
     */
    @DisplayName("verifies that controller returns the list of all accounts")
    @Test
    public void shouldReturnAllAccounts() throws Exception {
        List<Account> mockAccounts = createMockAccountRs();
        Mockito.when(accountService.findAllAccounts()).thenReturn(mockAccounts);
        ResponseEntity<List<Account>> response = accountResource.getAllAccounts();

        assertEquals(2, response.getBody().size());
        assertEquals("Test name", response.getBody().get(0).getCustomer().getName());
    }

    /**
     * Case 2: Test to verify response status Code for get All accounts
     */
    @DisplayName("verifies that controller returns 200 status for success response")
    @Test
    public void shouldReturnResponseStatus() throws Exception {
        List<Account> mockAccounts = createMockAccountRs();
        Mockito.when(accountService.findAllAccounts()).thenReturn(mockAccounts);
        ResponseEntity<List<Account>> response = accountResource.getAllAccounts();

        assertEquals(200, response.getStatusCodeValue());
    }

}
