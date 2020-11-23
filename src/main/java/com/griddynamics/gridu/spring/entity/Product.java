package com.griddynamics.gridu.spring.entity;

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

    public Product(String productId, String name, int price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        return this.name.equals(product.name) &&
                this.hashCode() == product.hashCode();
    }
}

