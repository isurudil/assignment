package com.crossover.inventory.service;

import com.crossover.inventory.entity.ApiEntity;
import com.crossover.inventory.entity.SalesOrder;

import java.util.List;

public interface SalesOrderService extends BaseService{

    public ApiEntity addSalesOrder(SalesOrder salesOrder);
    public List<SalesOrder> getAllSalesOrders();
}
