package com.griddynamics.gridu.cartService.tests;

import com.griddynamics.gridu.spring.CartApplication;
import com.griddynamics.gridu.spring.entity.Product;
import com.griddynamics.gridu.spring.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void testCreateProduct() {
        Product product = new Product("testP1", 5, 2);
        productService.createProduct(product);
        assertThat(product)
                .describedAs("Product should be in product list.")
                .isIn(productService.findAll());
    }

    @Test
    public void testGetProductInfo() {
        Product product = new Product("testP1", 5, 2);
        productService.createProduct(product);
        Optional<Product> product2 = productService.getProductById(product.getProductId());
        assertThat(product2.get())
                .describedAs("Products info should be correct.")
                .isEqualTo(product);
    }

    @Test
    public void testGetAllProducts() {
         assertThat(productService.findAll().size())
                .describedAs("Products size.")
                .isEqualTo(4);
    }

    @Test
    public void testDeleteProductById() {
        Product product = productService.findAll().get(0);
        productService.deleteProduct(product.getProductId());
        assertThat(product)
                .describedAs("Products should be deleted.")
                .isNotIn(productService.findAll());
    }
}
