package com.griddynamics.gridu.spring.service;

import com.griddynamics.gridu.spring.entity.Cart;
import com.griddynamics.gridu.spring.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public List<Cart> findAll() {
        return repository.findAll();
    }

    public Optional<Cart> getCartById(String cardId) {
        return repository.findById(cardId);
    }

    public String getAllCartInfo(Cart cart) {
        return repository.findAll().toString();
    }

    public Cart createCart(Cart cart) {
        return repository.save(cart);
    }

    public void deleteCart(Cart cart) {
        repository.delete(cart);
    }
}
