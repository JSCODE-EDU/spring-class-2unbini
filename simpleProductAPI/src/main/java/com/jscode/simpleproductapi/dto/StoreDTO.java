package com.jscode.simpleproductapi.dto;

public class StoreDTO {
    public final String name;
    public final String address;
    public final String telephoneNumber;

    public StoreDTO(String name, String address, String telephoneNumber) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
}
