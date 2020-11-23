package com.griddynamics.gridu.cartService.tests.steps;

import com.griddynamics.qa.sprimber.engine.scope.annotation.ScenarioComponent;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ScenarioComponent
public class CartServiceSteps {

    private Response response;
    private String cartId;
    private String path = "http://localhost:8080/carts/";
    private static String validCreateCartRequest = "{\n" +
            "    \"cartName\": \"New_Test_Cart\",\n" +
            "    \"products\": [\n" +
            "    ]\n" +
            "}";


    @Step("When I get first cart info")
    @When("I get first cart info")
    public void iGetFirstCartInfo() {
        cartId = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(path + "0")
                .then().extract().path("id");
    }

    @Step("Then Next products are present on cart")
    @Then("Next products are present on cart")
    public void nextProductsArePresentOnCart(DataTable table) {
        List<String> expectedItems = table.asList(String.class);
        List<String> actualItems = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(String.format(path + "%s/products", cartId))
                .then().extract().path("name");

        assertThat(actualItems).isNotNull();
        assertThat(actualItems).hasSameSizeAs(expectedItems);
        assertThat(actualItems).isEqualTo(expectedItems);
    }

    @Step("When I create new cart")
    @When("I create new cart")
    public void iCreateNewCart() {
        Response createCart = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(validCreateCartRequest)
                .post(path)
                .then().extract().response();
        cartId = createCart.jsonPath().getJsonObject("id");
        assertEquals(201, createCart.getStatusCode());
    }

    @Step("When I add {string} product with {string} qty and {string}$ price to this cart")
    @When("I add {string} product with {string} qty and {string}$ price to this cart")
    public void iAddTopProductWithQtyAnd$PriceToThisCart(String productName, String price, String quantity) {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", productName);
        requestParams.put("price", price);
        requestParams.put("quantity", quantity);

        Response addProductToCart = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(requestParams)
                .post(String.format(path + "%s/", cartId))
                .then().extract().response();
        assertEquals(200, addProductToCart.getStatusCode());
    }

    @Step("When I delete first cart")
    @When("I delete first cart")
    public void iDeleteFirstCart() {
        Response deleteCart = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(validCreateCartRequest)
                .delete(String.format(path + "%s/", cartId))
                .then().extract().response();
        assertEquals(200, deleteCart.getStatusCode());
    }

    @Step("Then First cart was deleted")
    @Then("First cart was deleted")
    public void firstCartWasDeleted() {
        List<String> cartIds = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(path)
                .then().extract().path("id");
        assertThat(cartIds.contains(cartId)).isFalse();
    }

    @Step("Then the carts endpoint exists and response status code should be {int}")
    @Then("the carts endpoint exists and response status code should be {int}")
    public void responseStatusCodeShouldBe(int code) {
        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(path)
                .then().extract().response();
        assertEquals(code, response.getStatusCode());
    }

    @Step("Then New cart is exists")
    @Then("New cart is exists")
    public void newCartIsExists() {
        Response response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .get(String.format(path + "%s/", cartId))
                .then().extract().response();
        assertEquals(200, response.statusCode());
        assertThat(response.jsonPath().getJsonObject("cartName") != null).isTrue();
    }
}
