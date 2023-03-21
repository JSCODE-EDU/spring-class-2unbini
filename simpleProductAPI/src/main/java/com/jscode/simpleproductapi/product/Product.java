package com.jscode.simpleproductapi.product;

public class Product {
    final int id;
    final String name;
    final boolean isOnSale;
    final int cost;

    public Product(int id, String name, boolean isOnSale, int cost) {
        this.id = id;
        this.name = name;
        this.isOnSale = isOnSale;
        this.cost = cost;
    }
}
