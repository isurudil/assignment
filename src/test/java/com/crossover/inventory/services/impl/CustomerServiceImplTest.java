package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.Customer;
import com.crossover.inventory.util.HibernateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

    @Test
    public void testAddCustomer() {

        Customer customer = new Customer();
        customer.setName("Isuru");
        customer.setAddress("Address");
        customer.setCode("6");
        customer.setCreditLimit(new BigDecimal(12));
        customer.setPhoneNo1("phone1");
        customer.setPhoneNo2("phone2");

        try {
            HibernateUtil.insert(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
