package com.griddynamics.gridu.spring.testData;

import com.griddynamics.gridu.spring.entity.Cart;
import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.repository.CartRepository;
import com.griddynamics.gridu.spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class SetUpDefaultData implements CommandLineRunner {

    @Autowired
    private CartRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        this.repository.deleteAll();
        this.productRepository.deleteAll();
        List<Cart> items = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("polo", 15, 1))));
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("jeans", 45, 1))));
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("rainbow", 5, 1))));
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("milk", 5, 2))));
        products.add(new Product("testP1", 5, 2));
        products.add(new Product("testP2", 15, 1));
        products.add(new Product("testP3", 905, 1));
        this.productRepository.saveAll(products);
        this.repository.saveAll(items);
    }
}
