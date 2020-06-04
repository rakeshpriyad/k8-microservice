package com.test.cs.service;

import com.test.cs.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer save(Customer owner);

    Optional<Customer> findById(int customerId);

    List<Customer> findAll();
}
