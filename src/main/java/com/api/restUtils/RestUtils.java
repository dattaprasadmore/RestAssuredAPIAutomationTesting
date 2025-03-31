package com.api.restUtils;

import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import com.api.reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request Body is");
        ExtentReportManager.logJSON(queryableRequestSpecification.getBody());
    }
    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request Body is");
        ExtentReportManager.logJSON(response.getBody().prettyPrint());
    }
    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers){
        //We can add log().all() here
        return BaseRequestSpecification.getDefaultRequestSpec()
                .basePath(endPoint)
                .headers(headers)
                .body(requestPayload);
    }
    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload){
        //We can add log().all() here
        return BaseRequestSpecification.getDefaultRequestSpec()
                .basePath(endPoint)
                .body(requestPayload);
    }
    private static RequestSpecification getRequestSpecification(String endPoint){
        //We can add log().all() here
        return BaseRequestSpecification.getDefaultRequestSpec()
                .basePath(endPoint);
    }
    private static RequestSpecification getRequestSpecification(String endPoint, String token){
        //We can add log().all() here
        return BaseRequestSpecification.getDefaultRequestSpec()
                .basePath(endPoint)
                .header("Authorization","Bearer "+token);
    }

    public static Response performGet(String endPoint){
        //RequestSpecification requestSpecification = given().contentType("application/json");
        RequestSpecification requestSpecification = getRequestSpecification(endPoint);
        Response response = requestSpecification.get();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performGet(String endPoint, String token){
        //RequestSpecification requestSpecification = given().contentType("application/json");
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, token);
        Response response = requestSpecification.get();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
    public static Response performPost(String endPoint, Object payload, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,payload,headers);
        Response response =  requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
    public static Response performPost(String endPoint, Object payload){
        //Editing here
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,payload);
        Response response =  requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
    public static Response performPut(String endPoint, Object payload, Map<String, String> headers){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,payload,headers);
        Response response =  requestSpecification.put();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
    public static Response performPut(String endPoint, Object payload){
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,payload);
        Response response =  requestSpecification.put();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    /*private static void setAuthToken(String token){
        specBuilder.addHeader("Authorization","Bearer "+token);
    }*/
}