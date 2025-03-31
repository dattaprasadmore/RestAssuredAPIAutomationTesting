package com.api.Routs;

public class UserRouts {

    private static final String API = "/api";
    private static final String USERS = "/users/";
    public static String getProfile(){
        return API + USERS + "profile";
    }
}