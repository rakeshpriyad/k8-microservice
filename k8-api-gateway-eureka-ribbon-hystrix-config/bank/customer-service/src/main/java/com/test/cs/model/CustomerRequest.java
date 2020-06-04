package com.test.cs.model;

import lombok.Data;

@Data
public class CustomerRequest {
    private int id;

   /* @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;*/

    private String firstName;

    private String lastName;
    private String city;
    private String address;
    private String telephone;
}
