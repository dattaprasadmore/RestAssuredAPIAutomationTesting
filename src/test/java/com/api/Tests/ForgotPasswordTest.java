package com.api.Tests;

import com.api.Base.AuthServices;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description = "Verify Forgot password test")
    public void createAccountTest() {
        AuthServices authServices = new AuthServices();
        Response response = authServices.forgotPassword("dattaprasad.more@gmail.com");
        System.out.println(response.asPrettyString());
    }
}