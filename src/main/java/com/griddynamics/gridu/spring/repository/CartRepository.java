package com.griddynamics.gridu.spring.repository;

import com.griddynamics.gridu.spring.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    @Query(value = "id:?0, products.id:?1")
    void addProductToCart(String cartId, String productId);

    @Query(value = "id:?0, products.name:?1")
    void deleteProductFromCart(String cartId, String productId);
}
