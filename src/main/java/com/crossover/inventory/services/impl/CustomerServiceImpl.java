package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.Customer;
import com.crossover.inventory.dao.EntityFactory;
import com.crossover.inventory.services.CustomerService;
import com.crossover.inventory.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/customers")
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addCustomer(MultivaluedMap<String, String> request) throws Exception {
        logger.info("Adding customer : " + request);

        Customer customer = EntityFactory.createCustomer(request);

        executeQuery(customer);
    }

    private void executeQuery(Customer customer) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        try {
            transaction.commit();
        } catch (ConstraintViolationException e) {
            transaction.rollback();
            logger.error("Error occurred while adding customer ", e);
            throw new Exception("Error occurred while adding customer");
        }
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
}
