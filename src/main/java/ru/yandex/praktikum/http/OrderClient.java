package ru.yandex.praktikum.http;

import io.qameta.allure.Step;
import ru.yandex.praktikum.http.model.Order;

import static io.restassured.RestAssured.given;

public class OrderClient extends StellarClient {

    public final String CREATE_ORDER = "/api/orders";

    @Step("Создание заказа авторизованным пользователем с ингредиентами")
    public io.restassured.response.ValidatableResponse createOrderByAuthUserWithIngredient(Order ingredients, String accessToken) {
        return given().spec(baseSpec())
                .header("Authorization", accessToken)
                .body(ingredients)
                .when()
                .post(CREATE_ORDER)
                .then();
    }

    @Step("Создание заказа неавторизованным пользователем с ингредиентами")
    public io.restassured.response.ValidatableResponse createOrderByNotAuthUserWithIngredients(Order order) {
        return given().spec(baseSpec())
                .body(order)
                .when()
                .post(CREATE_ORDER)
                .then();
    }

    @Step("Создание заказа авторизованным пользователем без ингредиентов")
    public io.restassured.response.ValidatableResponse createOrderByAuthUserWithoutIngredients(String accessToken) {
        return given().spec(baseSpec())
                .header("Authorization", accessToken)
                .when()
                .post(CREATE_ORDER)
                .then();
    }

    @Step("Создание заказа авторизованным пользователем с неверным хешем ингредиентов")
    public io.restassured.response.ValidatableResponse createOrderByAuthUserWithWrongIngredients(Order order, String accessToken) {
        return given().spec(baseSpec())
                .header("Authorization", accessToken)
                .body(order)
                .when()
                .post(CREATE_ORDER)
                .then();
    }

    @Step("Получение заказов авторизованного пользователя")
    public io.restassured.response.ValidatableResponse getUserOrdersWithAuth(String accessToken) {
        return given().spec(baseSpec())
                .header("Authorization", accessToken)
                .when()
                .get(CREATE_ORDER)
                .then();
    }

    @Step("Получение заказов неавторизованного пользователя")
    public io.restassured.response.ValidatableResponse getUserOrdersWithoutAuth() {
        return given().spec(baseSpec())
                .when()
                .get(CREATE_ORDER)
                .then();
    }
}
