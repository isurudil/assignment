package com.crossover.inventory.dao;

import java.math.BigDecimal;
import java.util.List;

public class SalesOrderOriginal {

    String orderNumber;
    Customer customer;
    BigDecimal totalPrice;
    List<OrderLine> orderLines;

    public SalesOrderOriginal() {
    }

    public SalesOrderOriginal(String orderNumber, Customer customer, BigDecimal totalPrice, List<OrderLine> orderLines) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.orderLines = orderLines;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}