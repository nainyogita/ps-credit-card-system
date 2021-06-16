package com.publicissapient.creditcardsystem.repo;

import com.publicissapient.creditcardsystem.domain.AccountSummary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Account Summary Repository for Account Summary Model
 */
public interface AccountSummaryRepo extends JpaRepository<AccountSummary,Long> {
}
