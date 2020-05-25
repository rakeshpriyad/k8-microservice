package com.test.client.controller;

import com.test.client.dto.Customer;
import com.test.client.fc.CustomerServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 */
@RestController
public class CustomerClientController {
	@Autowired
	CustomerServiceClient client;

	@GetMapping(value = "/fetchCustomers")
	public  ResponseEntity<?> getAllCustomer(){
		return ResponseEntity.ok(client.getAllCustomer());
	}

	@GetMapping("/fetchCustomer/{id}")
	public ResponseEntity <?> fetchCustomers(@PathVariable int id) {
		return ResponseEntity.ok(client.getCustomer(id));
	}

}
