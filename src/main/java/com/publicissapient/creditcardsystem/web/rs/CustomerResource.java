package com.publicissapient.creditcardsystem.web.rs;

import com.publicissapient.creditcardsystem.domain.Customer;
import com.publicissapient.creditcardsystem.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the Rest Controller implementation for Account Resource
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerService.findAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customer = customerService.findCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer updateCustomer = customerService.updateCustomer(customer);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }
}
