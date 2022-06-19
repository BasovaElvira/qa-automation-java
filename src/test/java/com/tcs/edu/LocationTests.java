package com.tcs.edu;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

@Nested
public class LocationTests {
    @BeforeAll
    public static void setUpAuth() {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("admin");
        RestAssured.authentication = authScheme;
    }

    @BeforeAll
    public static void setUpErrorLogging() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @DisplayName("Create Location")
    public void shouldCreateLocation() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"postalCode\": \"" + new Random().nextInt(999999) + "\",\n" +
                        "  \"streetAddress\": \"International\",\n" +
                        "  \"city\": \"Cri-city\",\n" +
                        "  \"province\": \"Cri\",\n" +
                        "  \"departments\": [\n" +
                        "    {\n" +
                        "      \"id\": 1\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"country\": {\n" +
                        "    \"id\": 3\n" +
                        "  }\n" +
                        "}")
        .when()
                .post("/api/locations")
        .then()
                .statusCode(201)
                .body("id", not(empty()));
    }

    @Test
    @DisplayName("Create location with the same parameters")
    public void shouldReturnError() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"postalCode\": \"1\",\n" +
                        "  \"streetAddress\": \"International\",\n" +
                        "  \"city\": \"Cri-city\",\n" +
                        "  \"province\": \"Cri\",\n" +
                        "  \"departments\": [\n" +
                        "    {\n" +
                        "      \"id\": 1\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"country\": {\n" +
                        "    \"id\": 3\n" +
                        "  }\n" +
                        "}")
        .when()
                .post("/api/locations")
        .then()
                .statusCode(500);
    }

    @Test
    @DisplayName("Get location")
    public void shouldReturnLocation() {
        RequestSpecification h = RestAssured.given();
        Response res = h.get("/api/locations");
        ResponseBody body = res.getBody();
        JsonPath jsnPath = res.jsonPath();
        int id = jsnPath.get("[0].id");
        when()
                .get("/api/locations/" + id)
        .then()
                .statusCode(200)
                .body(
                        "id", is(id)
                );
    }

    @Test
    @DisplayName("Delete location")
    public void shouldDeleteLocation() {
        RequestSpecification h = RestAssured.given();
        Response res = h.get("/api/locations");
        JsonPath jsnPath = res.jsonPath();
        int id = jsnPath.get("[0].id");
        when()
                .delete("/api/locations/" + id)
        .then()
                .statusCode(204);
        when()
                .get("/api/locations/" + id)
        .then()
                .statusCode(404);

    }

    }
