package com.test.cs.service;

import com.test.cs.model.Account;
import com.test.cs.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountService extends JpaRepository<Account, Integer> {

    /**
     * Retrieve all {@link AccountType}s from the data store.
     * @return a Collection of {@link AccountType}s.
     */
    @Query("SELECT actType FROM AccountType actType ORDER BY actType.name")
    List<AccountType> findAccountTypes();

    @Query("FROM AccountType actType WHERE actType.id = :typeId")
    Optional<AccountType> findfindAccountTypeById(@Param("typeId") int typeId);


}

