package com.api.Routs;

public class AuthRouts {
    private static String BASE_PATH = "/api/auth/";
    private static final String LOGIN = "login";
    private static final String SIGNUP = "signup";
    private static final String FORGOTPASSWORD = "forgot-Password";

    //public static String worker(){return API + HR + VERSION + WORKERS;}
    public static String login(){
        return BASE_PATH + LOGIN;
    }
    public static String signup(){
        return BASE_PATH + SIGNUP;
    }
    public static String forgotpassword(){
        return BASE_PATH + FORGOTPASSWORD;
    }








}
