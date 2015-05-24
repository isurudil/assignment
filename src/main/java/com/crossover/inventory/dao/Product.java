package com.crossover.inventory.dao;

import java.math.BigDecimal;

public class Product {

    String code;
    String description;
    BigDecimal price;
    int quantity;

    public Product() {
    }

    public Product(String code, String description, BigDecimal price, int quantity) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
