package com.test.cs.repository;

import java.util.List;
import java.util.Optional;

import com.test.cs.model.Account;
import com.test.cs.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     * Retrieve all {@link AccountType}s from the data store.
     * @return a Collection of {@link AccountType}s.
     */
    @Query("SELECT actType FROM AccountType actType ORDER BY actType.name")
    List<AccountType> findAccountTypes();

    @Query("FROM AccountType actType WHERE actType.id = :typeId")
    Optional<AccountType> findAccountTypeById(@Param("typeId") int typeId);


}

