package com.publicissapient.creditcardsystem.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private Long cardNumber;

    private Boolean active;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    @JsonManagedReference
    @PrimaryKeyJoinColumn
    private AccountSummary summary;

    public Account() {
    }

    public Account(Long id, Long cardNumber, Boolean active, Customer customer, AccountSummary summary) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.active = active;
        this.customer = customer;
        this.summary = summary;
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


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountSummary getSummary() {
        return summary;
    }

    public void setSummary(AccountSummary summary) {
        this.summary = summary;
    }


}

