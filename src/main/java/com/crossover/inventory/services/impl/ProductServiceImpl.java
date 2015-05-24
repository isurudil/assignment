package com.crossover.inventory.services.impl;

import com.crossover.inventory.dao.Product;
import com.crossover.inventory.services.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("/products")
public class ProductServiceImpl implements ProductService {

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public void addProduct() {
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
