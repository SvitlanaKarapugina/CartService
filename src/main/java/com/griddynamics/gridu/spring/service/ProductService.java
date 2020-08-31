package com.griddynamics.gridu.spring.service;

import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Get all items
    public List<Product> findAll() {
        return repository.findAll();
    }

    // Get item by id
    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    //Create item
    public Product createProduct(Product product) {
        return repository.insert(product);
    }

    //Delete item
    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
