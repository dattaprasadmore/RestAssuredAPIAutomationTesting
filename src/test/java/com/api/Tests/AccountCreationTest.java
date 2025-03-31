package com.api.Tests;

import com.api.Base.AuthServices;
import com.api.models.requests.users.SignupRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
public class AccountCreationTest {
    @Test(description = "Create New Account test")
    public void createAccountTest(){

        SignupRequest signupRequest = SignupRequest.builder()
                .username("Anil1231")
                .email("aanil@yahoo.com")
                .firstName("Anil")
                .password("Aanil123")
                .lastName("Patil")
                .mobileNumber("23423423")
                .build();
        AuthServices authServices = new AuthServices();
        Response response = authServices.signup(signupRequest);
        Assert.assertEquals(response.asPrettyString(), "User Registered Successfully.!!!");
        Assert.assertEquals(response.statusCode(), 201);
    }
}