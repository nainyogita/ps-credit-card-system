package com.publicissapient.creditcardsystem.service;

import com.publicissapient.creditcardsystem.domain.Customer;
import com.publicissapient.creditcardsystem.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer customer);

    public Customer findCustomerById(Long id) throws CustomerNotFoundException;

    public List<Customer> findAllCustomers();

    public Customer updateCustomer(Customer customer);

}
