package com.griddynamics.gridu.spring.repository;

import com.griddynamics.gridu.spring.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

}
