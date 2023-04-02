package com.jscode.simpleproductapi.dto;

import lombok.Getter;

@Getter
public class SimpleProduct {
    public final String name;
    public final boolean isOnSale;
    public final int cost;

    public SimpleProduct(String name, boolean isOnSale, int cost) {
        this.name = name;
        this.isOnSale = isOnSale;
        this.cost = cost;
    }
}
