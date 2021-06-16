package com.publicissapient.creditcardsystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private Long cardNumber;

    @Column(columnDefinition = "boolean default false")
    private Boolean cardActive;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    @PrimaryKeyJoinColumn
    private AccountSummary accountSummary;

    public Account() {
    }

    public Account(Long id, Long cardNumber, Boolean active, Customer customer, AccountSummary summary) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardActive = active;
        this.customer = customer;
        this.accountSummary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }


    public Boolean getCardActive() {
        return cardActive;
    }

    public void setCardActive(Boolean cardActive) {
        this.cardActive = cardActive;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountSummary getAccountSummary() {
        return accountSummary;
    }

    public void setAccountSummary(AccountSummary accountSummary) {
        this.accountSummary = accountSummary;
    }


}

