package com.test.cs.model;

import lombok.Data;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Data
class AccountDetails {

    private long id;

    private String accountNo;

    private String customer;

    private Double balance;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private AccountType type;

    AccountDetails(Account account) {
        this.id = account.getId();
        this.accountNo = account.getAccountNo();
        this.customer = account.getCustomer().getFirstName() + " " + account.getCustomer().getLastName();
        this.type = account.getType();
    }
}
