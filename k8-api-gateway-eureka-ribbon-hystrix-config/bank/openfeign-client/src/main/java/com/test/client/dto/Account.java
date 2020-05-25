package com.test.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.style.ToStringCreator;

public class Account {
    private Integer id;
    private String accountNo;
    private AccountType type;
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(final AccountType type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("id", this.getId())
            .append("name", this.getAccountNo())
            //.append("birthDate", this.getBirthDate())
            .append("type", this.getType().getName())
            .append("customerFirstName", this.getCustomer().getFirstName())
            .append("customerLastName", this.getCustomer().getLastName())
            .toString();
    }

}
