package com.jscode.simpleproductapi.dto;


public class ProductDTO {
    public final String name;
    public final boolean isOnSale;
    public final int cost;

    public ProductDTO(String name, boolean isOnSale, int cost) {
        this.name = name;
        this.isOnSale = isOnSale;
        this.cost = cost;
    }
}
