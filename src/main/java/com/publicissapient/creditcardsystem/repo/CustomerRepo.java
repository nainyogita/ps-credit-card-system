package com.publicissapient.creditcardsystem.repo;

import com.publicissapient.creditcardsystem.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerById(Long customerId);
}
