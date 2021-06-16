package com.publicissapient.creditcardsystem.repo;

import com.publicissapient.creditcardsystem.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Account Repository for Accounts Model
 */
public interface AccountRepo extends JpaRepository<Account,Long> {

}
