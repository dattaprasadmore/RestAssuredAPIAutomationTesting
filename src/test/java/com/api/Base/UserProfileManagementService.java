package com.api.Base;

import com.api.Routs.UserRouts;
import io.restassured.response.Response;

import static com.api.restUtils.RestUtils.performGet;

public class UserProfileManagementService {

    public Response getUserProfile(String token){
        String service = UserRouts.getProfile();
        return performGet(service, token);
    }

    /*public Response updateUserProfile(String token, ProfileRequest payload){
        String service = UserRouts.getProfile();
        return performPut(service,payload);
    }*/
}