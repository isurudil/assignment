package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.BaseEntity;
import com.crossover.inventory.entity.Customer;
import com.crossover.inventory.service.CustomerService;
import com.crossover.inventory.util.HibernateUtil;
import com.crossover.inventory.util.HqlUtil;
import com.crossover.inventory.util.StatusCodes;
import com.crossover.inventory.util.StatusMessages;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/customers")
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Customer addCustomer(Customer customer) {
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
        List<Customer> customers = HibernateUtil.getAll(HqlUtil.ALL_CUSTOMERS);
        return customers;
    }

    @Override
    public Customer insertToDB(BaseEntity entity) {
        try {
            HibernateUtil.saveOrUpdate(entity);
            entity.setStatusCode(StatusCodes.SUCCESS);
            entity.setStatusMessage(StatusMessages.SUCCESS);
            logger.info("Customer is successfully added to the database");
        } catch (Exception e) {
            entity.setStatusCode(StatusCodes.FAILURE);
            entity.setStatusMessage(StatusMessages.FAILURE);
            logger.info("Error occurred");
        }
        return (Customer) entity;
    }
}
