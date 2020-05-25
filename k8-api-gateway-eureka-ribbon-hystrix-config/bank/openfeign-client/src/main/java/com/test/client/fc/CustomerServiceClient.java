package com.test.client.fc;

import com.test.client.dto.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface CustomerServiceClient {

 @GetMapping(value = "/customer/all")
 public List<Customer> getAllCustomer();

 @GetMapping(value = "/customer/{id}")
 public Customer getCustomer(@PathVariable("id") int customerId);

}