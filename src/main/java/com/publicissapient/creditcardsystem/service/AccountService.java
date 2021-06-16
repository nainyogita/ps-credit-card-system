package com.publicissapient.creditcardsystem.service;

import com.publicissapient.creditcardsystem.domain.Account;

import java.util.List;

public interface AccountService {

    public Account addAccount(Account account);

    public List<Account> findAllAccounts();
}
