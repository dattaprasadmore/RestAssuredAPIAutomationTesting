package com.api.Tests;

import com.api.Base.AuthServices;
import com.api.Base.UserProfileManagementService;
import com.api.models.requests.users.LoginRequest;
import com.api.models.response.users.LoginResponse;
import com.api.models.response.users.UserProfileResponse;

import org.testng.annotations.Test;
import io.restassured.response.Response;

public class GetProfileRequestTest {
    @Test
    public void getProfileInfoTest(){
        AuthServices authServices = new AuthServices();
        Response response = authServices.login(new LoginRequest("dattaprasad","Durga@12345"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        Response profileResponse = userProfileManagementService.getUserProfile(loginResponse.getToken());
        UserProfileResponse userProfileResponse = profileResponse.as(UserProfileResponse.class);
        System.out.println(userProfileResponse.getUsername());
    }
}
