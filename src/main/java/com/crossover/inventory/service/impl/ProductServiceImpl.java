package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.ApiEntity;
import com.crossover.inventory.entity.Customer;
import com.crossover.inventory.entity.Product;
import com.crossover.inventory.service.ProductService;
import com.crossover.inventory.util.HibernateUtil;
import com.crossover.inventory.util.HqlUtil;
import com.crossover.inventory.util.StatusCodes;
import com.crossover.inventory.util.StatusMessages;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("/products")
public class ProductServiceImpl implements ProductService {

    private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public ApiEntity addProduct(Product product) {
        logger.info("Adding product : " + product);

        return insertToDB(product);
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void deleteProduct(String code) {
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = HibernateUtil.getAll(HqlUtil.ALL_PRODUCTS);
        return products;
    }

    @GET
    @Path("/unit-price")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public BigDecimal getUnitPrice(/*String code*/) {
        return null;
    }

    @Override
    public ApiEntity insertToDB(ApiEntity entity) {
        try {
            HibernateUtil.insert(entity);
            entity.setStatusCode(StatusCodes.SUCCESS);
            entity.setStatusMessage(StatusMessages.SUCCESS);
            logger.info("Product is successfully added to the database");
        } catch (Exception e) {
            logger.info("Error occurred");
            entity.setStatusCode(StatusCodes.FAILURE);
            entity.setStatusMessage(StatusMessages.FAILURE);
        }
        return entity;
    }
}
