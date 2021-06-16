package com.publicissapient.creditcardsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(name = "account_summary")
public class AccountSummary implements Serializable {

    private BigDecimal totalLimit = BigDecimal.valueOf(0);

    private BigDecimal balance = BigDecimal.valueOf(1500);

    private String currency = Currency.getInstance("GBP").getSymbol();

    private String balanceType;

    @Id
    @Column(name = "account_id")
    private Long id;

    @OneToOne
    @MapsId
    @JsonBackReference
    @JoinColumn(name = "account_id")
    private Account account;

    public AccountSummary(BigDecimal totalLimit, BigDecimal balance, String currency, String balanceType, Long id, Account account) {
        this.totalLimit = totalLimit;
        this.balance = balance;
        this.currency = currency;
        this.balanceType = balanceType;
        this.id = id;
        this.account = account;
    }

    public AccountSummary() {
    }

    public BigDecimal getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(BigDecimal totalLimit) {
        this.totalLimit = totalLimit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
