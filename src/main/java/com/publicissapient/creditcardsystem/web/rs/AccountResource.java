package com.publicissapient.creditcardsystem.web.rs;

import com.publicissapient.creditcardsystem.domain.Account;
import com.publicissapient.creditcardsystem.exception.RequestValidationException;
import com.publicissapient.creditcardsystem.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * This is the Rest Controller implementation for Account Resource
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountResource {

    Logger logger = LoggerFactory.getLogger(AccountResource.class);
    private final AccountService accountService;

    @Autowired
    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * This operation gets the list of all accounts
     * REST Endpoint - GET /api/accounts
     *
     * @return List<Account>
     */
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        logger.info("Request received-> Get Account");
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    /**
     * This operation is used for account creation
     * REST Endpoint - POST /api/accounts/create
     *
     * @param account of Type Account
     *                :: one-to-one <-> Account Summary
     *                :: many-to-one <- Customer
     * @return ResponseEntity with Account and HTTP Status code
     * @throws RequestValidationException
     */
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) throws RequestValidationException {
        logger.info("Request received -> Create Account");
        Account newAccount = accountService.createAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
}
