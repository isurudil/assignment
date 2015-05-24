package com.crossover.inventory.services;

import com.crossover.inventory.dao.SalesOrder;

import javax.ws.rs.core.MultivaluedMap;

public interface SalesOrderService {

    public void addSalesOrder(SalesOrder salesOrder) throws Exception;
    public SalesOrder getAllSalesOrders();
}
