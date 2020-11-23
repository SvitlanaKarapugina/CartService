package com.griddynamics.gridu.cartService.tests.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceSteps {

    private String productId;
    private String path = "http://localhost:8080/products/";

    @When("I create new product {string} with price {string}$ and qty {string}")
    public void iCreateNewProductTestWatchWithPrice$(String productName, String price, String qty) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", productName);
        requestParams.put("price", price);
        requestParams.put("quantity", qty);

        Response createProduct = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(requestParams)
                .post(path)
                .then().extract().response();
        productId = createProduct.jsonPath().getJsonObject("productId");
        assertEquals(201, createProduct.statusCode());
    }

    @Then("Next products were created")
    public void nextProductsWereCreated(DataTable table) {
        List<String> expectedItems = table.asList(String.class);
        List<String> response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(path)
                .then().extract().path("name");
        assertTrue(response.containsAll(expectedItems));
    }

    @When("I delete created product from product list")
    public void iDeleteTestDeleteProductFromProductList() {
        Response product = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .delete(path + productId)
                .then().extract().response();
        assertEquals(200, product.statusCode());
    }

    @Then("The {string} was deleted")
    public void theTestDeleteProductWasDeleted(String productName) {
        List<String> products = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(path)
                .then().extract().path("productName");
        assertFalse(products.contains(productName));
    }
}
