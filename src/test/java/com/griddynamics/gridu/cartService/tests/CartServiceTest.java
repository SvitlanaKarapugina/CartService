package com.griddynamics.gridu.cartService.tests;

import com.griddynamics.gridu.spring.CartApplication;
import com.griddynamics.gridu.spring.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class)
public class CartServiceTest {

    @Autowired
    CartService cartService;

    /*@Test
    public void testCreateCart() {
        final int qty = 7;
        final String productName = "Jeans";
        Cart cart = new Cart(UUID.randomUUID().toString(), productName);
        cartService.createCart(cart);
        assertThat(cartService.getCartById(cart.getCartId()))
                .describedAs("Cart should be added")
                .isNotEmpty();
    }*/

    @Test
    public void testDeleteCart() {
        String cartId = cartService.findAll().get(0).getId();
        cartService.deleteCart(cartId);
        assertThat(cartService.getCartById(cartId))
                .describedAs("Cart should be deleted")
                .isNull();
    }

    @Test
    public void testGetCartById() {
        String cartId = cartService.findAll().get(0).getId();
        cartService.deleteCart(cartId);
        assertThat(cartService.getCartById(cartId))
                .describedAs("Cart Id ")
                .isEqualTo(cartId);
    }

    @Test
    public void testGetAllCards() {
        assertThat(this.cartService.findAll().size())
                .describedAs("Cart Id ")
                .isEqualTo(4);
    }

    @Test
    public void testAddItemToCart() {
        assertThat(cartService.findAll().size())
                .describedAs("Cart Id ")
                .isEqualTo(9);
    }
}
