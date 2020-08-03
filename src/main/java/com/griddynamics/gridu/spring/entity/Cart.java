package com.griddynamics.gridu.spring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
public class Cart {

    @Id
    private String cartId;
    private int quantity;
    private String productName;
    private Set<Product> products;

    public Cart() {
    }

    public Cart(String cartId, int quantity, String name) {
        super();
        this.cartId = cartId;
        this.quantity = quantity;
        this.productName = name;
    }

    public Cart(String cartId, int quantity, Set products) {
        super();
        this.cartId = cartId;
        this.quantity = quantity;
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", products=" + products + "]";
    }
}
