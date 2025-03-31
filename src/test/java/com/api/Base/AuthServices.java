package com.api.Base;

import com.api.Routs.AuthRouts;
import com.api.models.requests.users.LoginRequest;
import com.api.models.requests.users.SignupRequest;
import io.restassured.response.Response;
import static com.api.restUtils.RestUtils.performPost;

public class AuthServices extends BaseTest{
    public Response login(LoginRequest payload){
        return performPost(AuthRouts.login(),payload);
    }
    public Response signup(SignupRequest payload){
        return performPost(AuthRouts.signup(),payload);
    }
    public Response forgotPassword(String emailAddress){
        return performPost(AuthRouts.forgotpassword(),emailAddress);
    }
}