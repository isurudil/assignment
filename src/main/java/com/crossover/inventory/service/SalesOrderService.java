package com.crossover.inventory.service;

import com.crossover.inventory.entity.BaseEntity;
import com.crossover.inventory.entity.SalesOrder;

import java.util.List;

public interface SalesOrderService extends BaseService{

    public BaseEntity addSalesOrder(SalesOrder salesOrder);
    public List<SalesOrder> getAllSalesOrders();
}
