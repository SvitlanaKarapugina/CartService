package com.griddynamics.gridu.spring.controller;

import com.griddynamics.gridu.spring.entity.Cart;
import com.griddynamics.gridu.spring.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController("rest")
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping(name = "showAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> findAllCarts() {
        return cartService.findAll();
    }

    @PostMapping(name = "createCart", path = "/{createContact}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody Cart cart) {
        cartService.createCart(cart);
    }

    @DeleteMapping(name = "deleteCart", path = "/{deleteCart}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteContact(@RequestBody Cart cart) {
        cartService.deleteCart(cart);
    }

}
