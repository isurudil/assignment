package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.Customer;
import com.crossover.inventory.util.HibernateUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import java.math.BigDecimal;

public class CustomerServiceImplTest extends TestCase {

    public void testAddCustomer(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Customer customer = new Customer();
        customer.setName("Isuru");
        customer.setAddress("Address");
        customer.setCode("123");
        customer.setCreditLimit(new BigDecimal(12));
        customer.setPhoneNo1("phone1");
        customer.setPhoneNo2("phone2");

        session.save(customer);
        try {
            session.getTransaction().commit();
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }
    }
}
