package com.test.cs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.test.cs.exception.ResourceNotFoundException;
import com.test.cs.model.Account;
import com.test.cs.model.Customer;
import com.test.cs.model.CustomerRequest;
import com.test.cs.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 */
@RequestMapping("/customer")
@RestController
@RequiredArgsConstructor
@Slf4j
class CustomerController {

	@Autowired
    private ICustomerService customerService;
   // private CustomerRepository customerService;
	
//	Logger log = LoggerFactory.getLogger(OwnerResource.class);

    /**
     * Create Customer
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Valid @RequestBody Customer owner) {
        return customerService.save(owner);
    }

    /**
     * Read single Customer
     */
    @GetMapping(value = "/{customerId}")
    public Optional<Customer> findCustomer(@PathVariable("customerId") int customerId) {
        return customerService.findById(customerId);
    }

    /**
     * Read List of Customers
     */
    @GetMapping(value = "/all")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    /**
     * Update Customer
     */
    @PutMapping(value = "/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") int customerId, @Valid @RequestBody CustomerRequest ownerRequest) {
        final Optional<Customer> customer = customerService.findById(customerId);
       for(Account account:  customer.get().getAccount()) {
           System.out.println(account.getAccountNo());
       }
        final Customer customerModel = customer.orElseThrow(() -> new ResourceNotFoundException("Customer "+customerId+" not found"));
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        customerModel.setFirstName(ownerRequest.getFirstName());
        customerModel.setLastName(ownerRequest.getLastName());
        customerModel.setCity(ownerRequest.getCity());
        customerModel.setAddress(ownerRequest.getAddress());
        customerModel.setTelephone(ownerRequest.getTelephone());
        log.info("Saving owner {}", customerModel);
        customerService.save(customerModel);
    }
}
