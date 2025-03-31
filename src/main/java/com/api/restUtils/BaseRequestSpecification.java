package com.api.restUtils;

import com.api.configurations.Configuration;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.impl.client.CloseableHttpClient;

public final class BaseRequestSpecification {
    private CloseableHttpClient httpClient;
    private RestAssuredConfig config;
    private BaseRequestSpecification(){}
    private static final String BASE_URL = Configuration.getProperty("base_url");

    public static RequestSpecification getDefaultRequestSpec(){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }
}