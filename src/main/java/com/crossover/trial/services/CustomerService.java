package com.crossover.trial.services;

import com.crossover.trial.dao.Customer;

import java.util.List;

public interface CustomerService {

    public void addCustomer(Customer customer);
    public void deleteCustomer(String code);
    public List<Customer> getAllCustomers();
}
