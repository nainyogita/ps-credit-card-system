package com.publicissapient.creditcardsystem.service;

import com.publicissapient.creditcardsystem.domain.Customer;
import com.publicissapient.creditcardsystem.exception.EntityNotFoundException;

import java.util.List;

/**
 * Interface for CustomerService
 */
public interface CustomerService {

    public Customer addCustomer(Customer customer);

    public Customer findCustomerById(Long id) throws EntityNotFoundException;

    public List<Customer> findAllCustomers() throws EntityNotFoundException;

    public Customer updateCustomer(Customer customer);

}
