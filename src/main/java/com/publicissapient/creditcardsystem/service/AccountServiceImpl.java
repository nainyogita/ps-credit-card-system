package com.publicissapient.creditcardsystem.service;

import com.publicissapient.creditcardsystem.domain.Account;
import com.publicissapient.creditcardsystem.exception.CardValidationException;
import com.publicissapient.creditcardsystem.repo.AccountRepo;
import com.publicissapient.creditcardsystem.repo.AccountSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @throws CardValidationException
     */
    @Override
    public Account createAccount(Account account) {
        account.getAccountSummary().setAccount(account);
        return accountRepo.save(account);
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
