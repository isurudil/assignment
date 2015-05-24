package com.crossover.inventory.services;

import com.crossover.inventory.dao.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    public void addProduct();
    public void deleteProduct(String code);
    public List<Product> getAllProducts();
    public BigDecimal getUnitPrice(/*String code*/);

}
