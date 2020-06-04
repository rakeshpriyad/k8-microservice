package com.test.cs.controller;

import com.test.cs.exception.ResourceNotFoundException;
import com.test.cs.model.AccountRequest;
import com.test.cs.service.AccountService;
import com.test.cs.model.Account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 */
@RequestMapping("/account")
@RestController
@RequiredArgsConstructor
@Slf4j
class AccountController {

	@Autowired
    private AccountService accountService;
    //private AccountRepository accountRepository;

    /**
     * Create Account
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountService.save(account);
    }

    /**
     * Read single Account
     */
    @GetMapping(value = "/{accountId}")
    public Optional<Account> findAccount(@PathVariable("accountId") int accountId) {
        return accountService.findById(accountId);
    }

    /**
     * Read List of Accounts
     */
    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    /**
     * Update Account
     */
    @PutMapping(value = "/{accountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccount(@PathVariable("accountId") int accountId, @Valid @RequestBody AccountRequest accountRequest) {
        final Optional<Account> account = accountService.findById(accountId);

        final Account accountModel = account.orElseThrow(() -> new ResourceNotFoundException("Customer "+accountId+" not found"));
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        accountModel.setAccountNo(accountRequest.getAccountNo());

        log.info("Saving Account {}", accountModel);
        accountService.save(accountModel);
    }
}
