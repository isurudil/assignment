package com.crossover.inventory.service.impl;

import com.crossover.inventory.entity.BaseEntity;
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
    public BaseEntity addProduct(Product product) {
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
    @Path("/unit/{product-code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Product getUnitPrice(@PathParam("product-code") String productCode) {
        Product product = new Product();
        try {
            product = (Product) HibernateUtil.getBy("Product", "code", productCode).get(0);
            product.setStatusCode(StatusCodes.SUCCESS);
            product.setStatusMessage(StatusMessages.SUCCESS);
            logger.info("Product code is successfully retrieved by the database");
        } catch (Exception e) {
            logger.info("Error occurred");
            product.setStatusCode(StatusCodes.FAILURE);
            product.setStatusMessage(StatusMessages.FAILURE);
        }
        return product;
    }

    @Override
    public BaseEntity insertToDB(BaseEntity entity) {
        Product product = (Product) entity;
        try {
            HibernateUtil.saveOrUpdate(entity);
            entity.setStatusCode(StatusCodes.SUCCESS);
            entity.setStatusMessage(StatusMessages.SUCCESS);
            logger.info("Product is successfully added to the database");
        } catch (Exception e) {
            logger.info("Error occurred");
            entity.setStatusCode(StatusCodes.FAILURE);
            entity.setStatusMessage(StatusMessages.FAILURE);
        }
        return product;
    }
}
