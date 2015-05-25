package com.crossover.inventory.service;

import com.crossover.inventory.entity.Customer;

import java.util.List;

public interface CustomerService {

    public void addCustomer(Customer customer) throws Exception;
    public void deleteCustomer(String code);
    public List<Customer> getAllCustomers();
}
