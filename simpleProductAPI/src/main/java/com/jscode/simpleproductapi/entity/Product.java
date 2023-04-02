package com.jscode.simpleproductapi.entity;

import lombok.Getter;

import javax.persistence.*;

@Table
@Entity
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    private boolean isOnSale;
    private int cost;

}
