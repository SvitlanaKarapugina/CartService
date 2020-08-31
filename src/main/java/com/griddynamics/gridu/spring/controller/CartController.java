package com.griddynamics.gridu.spring.controller;

import com.griddynamics.gridu.spring.entity.Cart;
import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController("rest")
@RequestMapping("/carts")
public class CartController {
    @Autowired
    CartService cartService;

    //Create a new cart
    @PostMapping(name = "createCart", path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCart(@RequestBody Cart cart) {
        cartService.createCart(cart);
    }

    //Get a cart by id
    @GetMapping(name = "getCartById", path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart getCartById(@PathVariable("id") String id) {
        return cartService.getCartById(id);
    }

    //Delete cart by id
    @DeleteMapping(name = "deleteCart", path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteContact(@PathVariable("id") String id) {
        cartService.deleteCart(id);
    }

    //Get all carts in the system
    @GetMapping(name = "showAll", path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cart> findAllCarts() {
        return cartService.findAll();
    }

    //Add product to Cart
    @PostMapping(name = "addProductToCart", path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addProductToCart(@PathVariable("id") String id, @RequestBody Product product) {
        cartService.addProductToCart(id, product);
    }

    //Get all products on cart
    @GetMapping(name = "showAllProducts", path = "/{id}/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProductsFromCart(@PathVariable("id") String id) {
        return cartService.getCartById(id).getProducts();
    }

    //Delete product from cart
    @PostMapping(name = "deleteProductFromCart", path = "/{id}/deleteProduct/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProductFromCart(@PathVariable("id") String id, @PathVariable("productId") String productId) {
        cartService.deleteProductFromCart(id, productId);
    }
}
