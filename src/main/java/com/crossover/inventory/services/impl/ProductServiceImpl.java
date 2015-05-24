package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.Customer;
import com.crossover.inventory.dao.EntityFactory;
import com.crossover.inventory.dao.Product;
import com.crossover.inventory.services.ProductService;
import com.crossover.inventory.util.HibernateUtil;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.math.BigDecimal;
import java.util.List;

@Path("/products")
public class ProductServiceImpl implements ProductService {

    private static Logger logger = Logger.getLogger(ProductServiceImpl.class);

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addProduct(MultivaluedMap<String, String> request) throws Exception {
        logger.info("Adding product : " + request);

        Product product = EntityFactory.createProduct(request);

        HibernateUtil.insert(product);
        logger.info("Product is successfully added to the database");
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
        return null;
    }

    @GET
    @Path("/unit-price")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public BigDecimal getUnitPrice(/*String code*/) {
        return null;
    }
}
