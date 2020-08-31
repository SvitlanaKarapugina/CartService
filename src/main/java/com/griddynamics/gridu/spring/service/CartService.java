package com.griddynamics.gridu.spring.service;

import com.griddynamics.gridu.spring.entity.Cart;
import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.repository.CartRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public List<Cart> findAll() {
        return repository.findAll();
    }

    public Cart getCartById(String cardId) {
        return repository.findById(cardId).get();
    }

    public Cart createCart(Cart cart) {
        return repository.insert(cart);
    }

    public void deleteCart(String id) {
        repository.deleteById(id);
    }

    public void addProductToCart(String cartId, Product product) {
        Cart cart = repository.findById(cartId).get();
        cart.getProducts().add(product);
        repository.save(cart);
    }

    public void deleteProductFromCart(String cartId, String productId) {
        Cart cart = repository.findById(cartId).get();
        var product = cart.getProducts()
                .stream()
                .filter(x -> x.getName().equals(productId))
                .findFirst();
        cart.getProducts().remove(product.get());
        repository.save(cart);
    }
}
