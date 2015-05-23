package com.crossover.trial.services;

import com.crossover.trial.dao.Product;

import javax.xml.ws.Response;
import java.util.List;

public interface ProductService {

    public Response addProduct();
    public Response deleteProduct(String code);
    public List<Product> getAllProducts();

}
