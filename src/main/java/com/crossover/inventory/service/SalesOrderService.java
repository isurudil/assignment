package com.crossover.inventory.service;

import com.crossover.inventory.entity.SalesOrder;

public interface SalesOrderService {

    public void addSalesOrder(SalesOrder salesOrder) throws Exception;
    public SalesOrder getAllSalesOrders();
}
