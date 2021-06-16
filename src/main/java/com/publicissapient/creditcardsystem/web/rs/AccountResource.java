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
     * Get a list of all accounts stored
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        logger.info("Request received-> Get Account");
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    /**
     * @param account
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) throws RequestValidationException {
        logger.info("Request received -> Create Account");
        Account newAccount = accountService.createAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }
}
