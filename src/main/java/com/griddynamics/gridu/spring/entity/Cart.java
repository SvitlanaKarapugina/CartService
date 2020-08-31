package com.griddynamics.gridu.spring.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Cart {

    @Id
    private String id;
    private String cartName;
    private List<Product> products;

    protected Cart() {
        this.products = new ArrayList<>();
    }

    public <T> Cart(String cartName, List<Product> products) {
        this.cartName = cartName;
        this.products = products;
    }

   /* public void addProduct(Product product) {
        products.add(product);
    }*/

    @Override
    public String toString() {
        return "Cart [cartId=" + id + ", cartName=" + cartName + "]";
    }
}
