package com.publicissapient.creditcardsystem.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public Customer() {
    }

    public Long getCustomerId() {
        return id;
    }

    public void setCustomerId(Long customerId) {
        this.id = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(Long id, String name, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    /*
    TODO - To be used for login functionality
    private String email;
    private String password;
    */

}
