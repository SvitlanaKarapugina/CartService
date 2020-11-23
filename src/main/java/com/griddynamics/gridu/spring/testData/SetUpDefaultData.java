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
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("3", "polo", 15, 1), new Product("11", "jean", 20, 1),
                new Product("10", "coat", 20, 1))));
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("4", "jeans", 45, 1))));
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("5", "rainbow", 5, 1))));
        items.add(new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("6", "milk", 5, 2))));
        products.add(new Product("7", "testP1", 5, 2));
        products.add(new Product("8", "testP2", 15, 1));
        products.add(new Product("9", "testP3", 905, 1));
        this.productRepository.saveAll(products);
        this.repository.saveAll(items);
    }
}
