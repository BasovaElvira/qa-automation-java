package com.tcs.edu;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

@Nested
public class LocationTests {

    private Connection connection;

    @BeforeEach
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/app-db",
                "app-db-admin",
                "P@ssw0rd"
        );
    }

    @AfterEach
    public void disconnect() throws SQLException {
        connection.close();
    }

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
    public void shouldCreateLocation() throws  SQLException {

        int postalCode = new Random().nextInt(999999);

        PreparedStatement sql = connection.prepareStatement(
                String.format("SELECT*FROM location WHERE='" + postalCode + "'")
        );

        given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"postalCode\": \"" + postalCode + "\",\n" +
                        "  \"streetAddress\": \"International\",\n" +
                        "  \"city\": \"Cri-cit\",\n" +
                        "  \"province\": \"Cri\",\n" +
                        "  }\n" +
                        "}")
        .when()
                .post("/api/locations")
        .then()
                .statusCode(201)
                .body("id", not(empty()));

        ResultSet keys = sql.getGeneratedKeys();
        assertThat(keys.next(), is(true));
        assertThat(keys.getString(2), is("International"));
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
                .statusCode(400);
    }

    @Test
    @DisplayName("Get location")
    public void shouldReturnLocation() throws SQLException {

        PreparedStatement sql = connection.prepareStatement(
                "SELECT*FROM location WHERE Id = '0'"
        );
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

        ResultSet keys = sql.getGeneratedKeys();
        assertThat(keys.next(), is(true));
        assertThat(keys.getString(1), is(id));


    }

    @Test
    @DisplayName("Delete location")
    public void shouldDeleteLocation() throws SQLException {

        PreparedStatement sql = connection.prepareStatement(
                "SELECT*FROM location WHERE Id = '0'"
        );
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

        ResultSet keys = sql.getGeneratedKeys();
        assertThat(keys.next(), is(true));
        assertThat(keys.getString(1), not(id));
    }

    }
