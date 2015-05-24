package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.Product;
import com.crossover.inventory.util.HibernateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = {"classpath*:testApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

    @Test
    public void testAddProduct() throws Exception {

        HibernateUtil.insert(new Product("p1","desc1", new BigDecimal(10.0), 3));
    }
}
