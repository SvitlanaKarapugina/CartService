package com.griddynamics.gridu.spring.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    private String name;
    private int price;
    private int quantity;

    protected Product() {
    }

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
