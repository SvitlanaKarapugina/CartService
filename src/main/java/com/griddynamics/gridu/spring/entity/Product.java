package com.griddynamics.gridu.spring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id;

    public Product(String name) {
       this.id = name;
    }
}
