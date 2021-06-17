package com.publicissapient.creditcardsystem.service;

import com.publicissapient.creditcardsystem.domain.Customer;
import com.publicissapient.creditcardsystem.exception.EntityNotFoundException;
import com.publicissapient.creditcardsystem.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepo.findCustomerById(id)
                .orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

}
