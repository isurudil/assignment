package com.crossover.inventory.service;

import com.crossover.inventory.entity.ApiEntity;
import com.crossover.inventory.entity.Customer;

import java.util.List;

public interface CustomerService extends BaseService{

    public ApiEntity addCustomer(Customer customer);
    public void deleteCustomer(String code);
    public List<Customer> getAllCustomers();
}
