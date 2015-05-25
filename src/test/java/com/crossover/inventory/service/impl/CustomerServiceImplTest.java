package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.Customer;
import com.crossover.inventory.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

    private static Logger logger = Logger.getLogger(CustomerServiceImplTest.class);

    @Test
    public void testAddCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setName("Isuru");
        customer.setAddress("Address");
        customer.setCode("8");
        customer.setCreditLimit(new BigDecimal(12));
        customer.setPhoneNo1("phone1");
        customer.setPhoneNo2("phone2");

        HibernateUtil.insert(customer);
    }
}
