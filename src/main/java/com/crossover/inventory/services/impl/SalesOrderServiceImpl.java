package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.SalesOrder;
import com.crossover.inventory.services.SalesOrderService;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/sales-orders")
public class SalesOrderServiceImpl implements SalesOrderService {

    private static Logger logger = Logger.getLogger(SalesOrderServiceImpl.class);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addSalesOrder(SalesOrder salesOrder) {
        logger.info("Adding sales order : " + salesOrder);
    }

    @Override
    public SalesOrder getAllSalesOrders() {
        return null;
    }
}
