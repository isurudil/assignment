package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.Customer;
import com.crossover.inventory.entity.SalesOrder;
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

        HibernateUtil.saveOrUpdate(salesOrder);
    }

    public void testGetAllSalesOrders() throws Exception {

    }
}
