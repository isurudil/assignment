package com.crossover.inventory.service;

import com.crossover.inventory.entity.BaseEntity;
import com.crossover.inventory.entity.Customer;

import java.util.List;

public interface CustomerService extends BaseService{

    public BaseEntity addCustomer(Customer customer);
    public void deleteCustomer(String code);
    public List<Customer> getAllCustomers();
}
