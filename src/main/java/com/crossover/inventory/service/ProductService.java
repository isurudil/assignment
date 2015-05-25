package com.crossover.inventory.service;

import com.crossover.inventory.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    public void addProduct(Product product) throws Exception;
    public void deleteProduct(String code);
    public List<Product> getAllProducts();
    public BigDecimal getUnitPrice(/*String code*/);

}
