package com.test.client.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

/**
 * Simple JavaBean domain object representing an Customer.
 *
 */
public class Customer {

    private Integer id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private Set<Account> accounts;
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    protected Set<Account> getAccountInternal() {
        if (this.accounts == null) {
            this.accounts = new HashSet<>();
        }
        return this.accounts;
    }

    public List<Account> getAccount() {
        final List<Account> sortedPets = new ArrayList<>(getAccountInternal());
        PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPets);
    }

    public void addAccount(Account account) {
        getAccountInternal().add(account);
        account.setCustomer(this);
    }

    public void setId(final Integer id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getId())
            .append("lastName", this.getLastName())
            .append("firstName", this.getFirstName())
            .append("address", this.address)
            .append("city", this.city)
            .append("telephone", this.telephone)
            .toString();
    }
}
