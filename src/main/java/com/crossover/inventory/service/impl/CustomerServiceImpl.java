package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.ApiEntity;
import com.crossover.inventory.entity.Customer;
import com.crossover.inventory.service.CustomerService;
import com.crossover.inventory.util.HibernateUtil;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/customers")
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ApiEntity addCustomer(Customer customer) {
        logger.info("Adding customer : " + customer);

        return insertToDB(customer);
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void deleteCustomer(String code) {

    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Customer> getAllCustomers() {
        System.out.println("Getting all the customers");
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

    @Override
    public ApiEntity insertToDB(ApiEntity entity) {
        try {
            HibernateUtil.insert(entity);
            entity.setStatusCode("S1000");
            logger.info("Customer is successfully added to the database");
        } catch (Exception e) {
            logger.info("Error occurred");
            entity.setStatusCode("E1001");
        }
        return entity;
    }
}
