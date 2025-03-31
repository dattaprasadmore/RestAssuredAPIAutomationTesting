package com.api.Tests;

import com.api.Base.AuthServices;
import com.api.Base.BaseTest;
import com.api.Base.UserProfileManagementService;
import com.api.models.requests.users.LoginRequest;
import com.api.models.requests.users.ProfileRequest;
import com.api.models.response.users.LoginResponse;
import com.api.models.response.users.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest extends BaseTest {
    @Test
    public void UpdateProfileTest(){
        AuthServices authService = new AuthServices();
        Response response = authService.login(new LoginRequest("dattaprasad","Durga@12345"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());

        System.out.println("-------------------------------------------------------------------------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getUserProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"dattaprasad");

        System.out.println("-------------------------------------------------------------------------");

        ProfileRequest profileRequest =  ProfileRequest.builder()
                .firstName("MM")
                .lastName("MM")
                .email("dattaprasad.more@gmail.com")
                .mobileNumber("12121212")
                .build();

        /*response = userProfileManagementService.updateUserProfile(loginResponse.getToken(),profileRequest);
        System.out.println(response.asPrettyString());*/
    }
}