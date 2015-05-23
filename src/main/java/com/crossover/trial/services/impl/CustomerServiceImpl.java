package com.crossover.trial.services.impl;

import com.crossover.trial.dao.Customer;
import com.crossover.trial.dao.Test;
import com.crossover.trial.services.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/customers")
public class CustomerServiceImpl implements CustomerService {

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(String code) {

    }

    @GET
    @Path("/get-all")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Customer> getAllCustomers(){
        Customer customer = new Customer();
        customer.setName("Isuru");
        customer.setAddress("Address");
        customer.setCode("1235");
        customer.setCreditLimit(new BigDecimal(12));
        customer.setPhoneNo1("phone1");
        customer.setPhoneNo2("phone2");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        return customerList;
    }

    @GET
    @Path("/test")

    @Produces(MediaType.APPLICATION_JSON)
    public Test getAll(){
        return new Test("isuru", "26");
    }

}
