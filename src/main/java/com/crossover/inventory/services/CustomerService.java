package com.crossover.inventory.services;

import com.crossover.inventory.dao.Customer;

import java.util.List;

public interface CustomerService {

    public void addCustomer(Customer customer);
    public void deleteCustomer(String code);
    public List<Customer> getAllCustomers();
}
