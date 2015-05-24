package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.Customer;
import com.crossover.inventory.dao.SalesOrder;
import com.crossover.inventory.util.HibernateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SalesOrderServiceImplTest {

    @Test
    public void testAddSalesOrder() throws Exception {
        Customer customer = new Customer();
        customer.setCode("2");

        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCustomerCode(customer.getCode());
        salesOrder.setOrderNumber("3232");
        salesOrder.setTotalPrice(new BigDecimal(10.0));

        HibernateUtil.insert(salesOrder);
    }

    public void testGetAllSalesOrders() throws Exception {

    }
}
