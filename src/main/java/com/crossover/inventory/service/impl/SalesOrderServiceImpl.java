package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.ApiEntity;
import com.crossover.inventory.entity.SalesOrder;
import com.crossover.inventory.service.SalesOrderService;
import com.crossover.inventory.util.HibernateUtil;
import com.crossover.inventory.util.StatusCodes;
import com.crossover.inventory.util.StatusMessages;
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
    public ApiEntity addSalesOrder(SalesOrder salesOrder) {
        logger.info("Adding sales order : " + salesOrder);

        return insertToDB(salesOrder);
    }

    @Override
    public SalesOrder getAllSalesOrders() {
        return null;
    }

    @Override
    public ApiEntity insertToDB(ApiEntity entity) {
        try {
            HibernateUtil.insert(entity);
            entity.setStatusCode(StatusCodes.SUCCESS);
            entity.setStatusMessage(StatusMessages.SUCCESS);
            logger.info("Sales Order is successfully added to the database");
        } catch (Exception e) {
            entity.setStatusCode(StatusCodes.FAILURE);
            entity.setStatusMessage(StatusMessages.FAILURE);
            logger.info("Error occurred while adding record");
        }
        return entity;
    }
}

