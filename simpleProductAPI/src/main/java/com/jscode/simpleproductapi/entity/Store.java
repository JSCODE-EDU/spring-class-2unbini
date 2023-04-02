package com.jscode.simpleproductapi.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    private String address;
    private String telephoneNumber;
}
