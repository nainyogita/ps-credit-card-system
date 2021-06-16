package com.publicissapient.creditcardsystem.repo;

import com.publicissapient.creditcardsystem.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {

}
