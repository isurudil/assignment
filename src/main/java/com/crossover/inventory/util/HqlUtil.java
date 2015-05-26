package com.crossover.inventory.util;

public class HqlUtil {
    public static final String ALL_SALES_ORDERS = "SELECT orderNumber,customerCode, totalPrice FROM SalesOrder";
    public static final String ALL_CUSTOMERS = "FROM Customer";
    public static final String ALL_PRODUCTS = "FROM Product";
}
