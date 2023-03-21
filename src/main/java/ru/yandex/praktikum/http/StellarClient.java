package ru.yandex.praktikum.http;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class StellarClient {
    private final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    protected RequestSpecification baseSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}
