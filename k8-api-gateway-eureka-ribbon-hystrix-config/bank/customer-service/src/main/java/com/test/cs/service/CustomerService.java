package com.test.cs.service;

import com.test.cs.model.Customer;
import com.test.cs.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
