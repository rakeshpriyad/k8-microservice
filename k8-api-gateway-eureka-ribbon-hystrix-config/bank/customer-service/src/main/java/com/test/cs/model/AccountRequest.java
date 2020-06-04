package com.test.cs.model;

import lombok.Data;

import javax.validation.constraints.Size;
@Data
public class AccountRequest {
    private int id;

    @Size(min = 1)
    private String accountNo;

    private int typeId;
}
