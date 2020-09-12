package com.griddynamics.gridu.spring.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {

    @Id
    private String productId;
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
