package com.api.Tests;

import com.api.Base.AuthServices;
import com.api.models.requests.users.LoginRequest;
import com.api.models.response.users.LoginResponse;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTetsts {

    @Test
    public void LoginTest() {

        LoginRequest loginRequest = new LoginRequest("dattaprasad", "Durga@12345");
        AuthServices AuthService = new AuthServices();
        Response response = AuthService.login(loginRequest);
        response.prettyPrint();
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getId());
        System.out.println(loginResponse.getUsername());
        System.out.println(loginResponse.getEmail());
        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getEmail(), "dattaprasad.more@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 91);

    }

}
