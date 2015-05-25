package com.crossover.inventory.service;

import com.crossover.inventory.entity.ApiEntity;
import com.crossover.inventory.entity.SalesOrder;

public interface SalesOrderService extends BaseService{

    public ApiEntity addSalesOrder(SalesOrder salesOrder);
    public SalesOrder getAllSalesOrders();
}
