package com.crossover.inventory.services;

import com.crossover.inventory.dao.SalesOrder;

import javax.ws.rs.core.MultivaluedMap;

public interface SalesOrderService {

    public void addSalesOrder(MultivaluedMap<String, String> request);
    public SalesOrder getAllSalesOrders();
}
