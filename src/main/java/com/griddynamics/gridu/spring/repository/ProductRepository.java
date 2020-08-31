package com.griddynamics.gridu.spring.repository;

import com.griddynamics.gridu.spring.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
