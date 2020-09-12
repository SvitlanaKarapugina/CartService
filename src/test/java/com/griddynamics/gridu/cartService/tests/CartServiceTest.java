package com.griddynamics.gridu.cartService.tests;

import com.griddynamics.gridu.spring.CartApplication;
import com.griddynamics.gridu.spring.entity.Cart;
import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.service.CartService;
import com.griddynamics.gridu.spring.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class)
public class CartServiceTest {

    @Autowired
    CartService cartService;


    @Test
    public void testCreateCart() {
        Cart cart = new Cart(UUID.randomUUID().toString(), Arrays.asList(new Product("polo", 15, 1)));
        cartService.createCart(cart);
        assertThat(cartService.getCartById(cart.getId()))
                .describedAs("Cart should be added.")
                .isNotNull();
    }

    @Test
    public void testDeleteCart() {
        String cartId = cartService.findAll().get(0).getId();
        cartService.deleteCart(cartId);
        List<String> cardIdsList = cartService.findAll().stream().map(a -> a.getId()).collect(Collectors.toList());
        assertThat(cartId)
                .describedAs("Cart should be deleted.")
                .isNotIn(cardIdsList);
    }

    @Test
    public void testGetCartById() {
        String cartId = cartService.findAll().get(0).getId();
        List<String> cardIdsList = cartService.findAll().stream().map(a -> a.getId()).collect(Collectors.toList());
        assertThat(cartId)
                .describedAs("Cart Id.")
                .isIn(cardIdsList);
    }

    @Test
    public void testGetAllCards() {
        assertThat(this.cartService.findAll().size())
                .describedAs("Cart count.")
                .isEqualTo(4);
    }

    @Test
    public void testAddItemToCart() {
        String cartId = cartService.findAll().get(0).getId();
        Product product = new Product("testP1", 5, 2);
        cartService.addProductToCart(cartId, product);
        List<Product> productList = cartService.getCartById(cartId).getProducts();
        assertThat(product)
                .describedAs("Product should be added to Cart.")
                .isIn(productList);
    }

    @Test
    public void testGetAllProductsFromCart() {
        String cartId = cartService.findAll().get(0).getId();
        Product product = new Product("testP1", 5, 2);
        cartService.addProductToCart(cartId, product);
        List<Product> productList = cartService.getCartById(cartId).getProducts();
        assertThat(productList.size())
                .describedAs("Products on Cart.")
                .isEqualTo(3);
    }

    /*@Test
    public void testDeleteProductFromCart() {
        String cartId = cartService.findAll().get(0).getId();
        Product product = cartService.getCartById(cartId).getProducts().get(0);
        cartService.deleteProductFromCart(cartId, product.getProductId());
        assertThat(cartService.getCartById(cartId).getProducts())
                .describedAs("Products on Cart.")
                .isEqualTo(0);
    }*/
}
