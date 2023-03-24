package com.jscode.simpleproductapi.entity;

import javax.persistence.*;

@Table
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    private boolean isOnSale;
    private int cost;

}
