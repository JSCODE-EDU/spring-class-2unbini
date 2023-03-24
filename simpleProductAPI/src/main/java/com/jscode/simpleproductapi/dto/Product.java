package com.jscode.simpleproductapi.dto;

public class Product {
    public final int id;
    public final String name;
    public final boolean isOnSale;
    public final int cost;

    public Product(int id, String name, boolean isOnSale, int cost) {
        this.id = id;
        this.name = name;
        this.isOnSale = isOnSale;
        this.cost = cost;
    }
}
