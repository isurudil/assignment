package com.crossover.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalesOrder {
    String orderNumner;
    Customer customer;
    BigDecimal totalPrice;
    List<OrderLine> orderLines = new ArrayList<>();

    public String getOrderNumner() {
        return orderNumner;
    }

    public void setOrderNumner(String orderNumner) {
        this.orderNumner = orderNumner;
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
