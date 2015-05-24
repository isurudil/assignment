package com.crossover.inventory.dao;

import com.crossover.inventory.util.ApiKey;
import org.apache.log4j.Logger;

import javax.ws.rs.core.MultivaluedMap;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public class EntityFactory {

    private static Logger logger = Logger.getLogger(EntityFactory.class);

    public static Customer createCustomer(MultivaluedMap<String, String> request) {
        logger.debug("Creating customer object");

        Customer customer = new Customer();

        customer.setCode(String.valueOf(request.getFirst(ApiKey.CUSTOMER_CODE)));
        customer.setName(String.valueOf(request.getFirst(ApiKey.CUSTOMER_NAME)));
        customer.setAddress(String.valueOf(request.getFirst(ApiKey.CUSTOMER_ADDRESS)));
        customer.setPhoneNo1(String.valueOf(request.getFirst(ApiKey.CUSTOMER_PHONE_NO_1)));
        customer.setPhoneNo2(String.valueOf(request.getFirst(ApiKey.CUSTOMER_PHONE_NO_2)));
        customer.setCreditLimit(new BigDecimal(request.getFirst(ApiKey.CUSTOMER_CREDIT_LIMIT)));
        customer.setCurrentCredit(new BigDecimal(request.getFirst(ApiKey.CUSTOMER_CURRENT_CREDIT)));

        logger.debug("Customer object successfully created");
        return customer;
    }

    public static Product createProduct(MultivaluedMap<String, String> request) {
        logger.debug("Creating product");

        Product product = new Product();

        product.setCode(request.getFirst(ApiKey.PRODUCT_CODE));
        product.setDescription(request.getFirst(ApiKey.PRODUCT_DESCRIPTION));
        product.setPrice(new BigDecimal(request.getFirst(ApiKey.PRODUCT_PRICE)));
        product.setQuantity(Integer.parseInt(request.getFirst(ApiKey.PRODUCT_QUANTITY)));

        return product;
    }
}
