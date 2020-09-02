package com.griddynamics.gridu.spring.controller;

import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@org.springframework.web.bind.annotation.RestController("rest")
//@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    //Create a new product
    @PostMapping(name = "createProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }

    //Get a product info by id
    @GetMapping(name = "getProductById", path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Product> getProductById(@PathVariable("id") String id) {
        return productService.getProductById(id);
    }

    //Delete cart by id
    @DeleteMapping(name = "deleteProduct", path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
    }
}
