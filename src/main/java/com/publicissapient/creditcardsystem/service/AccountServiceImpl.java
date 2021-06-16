package com.publicissapient.creditcardsystem.service;

import com.publicissapient.creditcardsystem.domain.Account;
import com.publicissapient.creditcardsystem.repo.AccountRepo;
import com.publicissapient.creditcardsystem.repo.AccountSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    public final AccountRepo accountRepo;
    public final AccountSummaryRepo accountSummaryRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, AccountSummaryRepo accountSummaryRepo) {
        this.accountRepo = accountRepo;
        this.accountSummaryRepo = accountSummaryRepo;
    }

    @Override
    public Account addAccount(Account account) {
        account.getSummary().setAccount(account);
        return accountRepo.save(account);
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountRepo.findAll();
    }
}
