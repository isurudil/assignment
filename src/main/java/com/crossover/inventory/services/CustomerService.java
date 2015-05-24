package com.crossover.inventory.services;

import com.crossover.inventory.dao.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;
import java.util.Map;

public interface CustomerService {

    public void addCustomer(Customer customer) throws Exception;
    public void deleteCustomer(String code);
    public List<Customer> getAllCustomers();
}
