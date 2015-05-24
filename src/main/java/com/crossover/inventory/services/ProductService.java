package com.crossover.inventory.services;

import com.crossover.inventory.dao.Product;

import javax.ws.rs.core.MultivaluedMap;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    public void addProduct(Product product) throws Exception;
    public void deleteProduct(String code);
    public List<Product> getAllProducts();
    public BigDecimal getUnitPrice(/*String code*/);

}
