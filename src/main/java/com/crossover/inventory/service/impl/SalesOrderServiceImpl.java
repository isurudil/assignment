package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.SalesOrder;
import com.crossover.inventory.service.SalesOrderService;
import com.crossover.inventory.util.HibernateUtil;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sales-orders")
public class SalesOrderServiceImpl implements SalesOrderService {

    private static Logger logger = Logger.getLogger(SalesOrderServiceImpl.class);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addSalesOrder(SalesOrder salesOrder) throws Exception {
        logger.info("Adding sales order : " + salesOrder);

        HibernateUtil.insert(salesOrder);

        logger.info("Sales Order is successfully added to the database");
    }

    @Override
    public SalesOrder getAllSalesOrders() {
        return null;
    }
}
