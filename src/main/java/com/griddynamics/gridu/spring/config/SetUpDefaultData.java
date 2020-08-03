package com.griddynamics.gridu.spring.config;

import com.griddynamics.gridu.spring.entity.Cart;
import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetUpDefaultData {

    @Autowired
    private CartRepository repository;

    private static List<Cart> items = new ArrayList<>();

    static {
        items.add(new Cart("123", 1, (Set) new Product("polo")));
        items.add(new Cart("124", 2, (Set) new Product("jeans")));
        items.add(new Cart("99", 2, (Set) new Product("rainbow")));
        items.add(new Cart("100", 1, (Set) new Product("milk")));
    }

    @PostConstruct
    public void init() {
        repository.saveAll(items);
    }
}
