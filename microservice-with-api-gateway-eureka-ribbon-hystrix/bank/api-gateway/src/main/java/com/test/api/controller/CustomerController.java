package com.test.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CustomerController {
	
	@Autowired
    RestTemplate restTemplate;
 
    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getStudents(@PathVariable int customerId)
    {
        System.out.println("Getting Customer details for " + customerId);
 
        String response = restTemplate.exchange("http://customer-service/customer/{customerId}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, customerId).getBody();
 
        System.out.println("Response Body " + response);
 
        return "customerId Id -  " + customerId + " [ Customer Details " + response+" ]";
    }
    
    public String  fallbackMethod(int employeeid){
    	
    	return "Fallback response:: No Customer details available temporarily";
    }
 
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
