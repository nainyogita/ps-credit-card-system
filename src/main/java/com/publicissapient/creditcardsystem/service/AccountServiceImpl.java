package com.publicissapient.creditcardsystem.service;

import com.publicissapient.creditcardsystem.domain.Account;
import com.publicissapient.creditcardsystem.exception.RequestValidationException;
import com.publicissapient.creditcardsystem.repo.AccountRepo;
import com.publicissapient.creditcardsystem.repo.AccountSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * AccountServiceImpl Service
 * Contains method for saving and retrieving account details
 */
@Service
public class AccountServiceImpl implements AccountService {

    public final AccountRepo accountRepo;
    public final AccountSummaryRepo accountSummaryRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, AccountSummaryRepo accountSummaryRepo) {
        this.accountRepo = accountRepo;
        this.accountSummaryRepo = accountSummaryRepo;
    }

    /**
     * This method creates account through Account Repository
     *
     * @param account of type Account
     * @return Account
     * @throws RequestValidationException
     */
    @Override
    public Account createAccount(Account account) {
        account.getAccountSummary().setAccount(account);
        try {
            return accountRepo.save(account);
        } catch (ConstraintViolationException e) {
            throw new RequestValidationException("Request Validation Exception - Constraint Violated");
        }
    }

    /**
     * This method retrieves all accounts through Account Repository
     *
     * @return Account
     */
    @Override
    public List<Account> findAllAccounts() {
        return accountRepo.findAll();
    }
}
