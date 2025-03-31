package com.api.utils;

import net.datafaker.Faker;

public class RandomDataGenerator {

    public static Faker faker = new Faker();

    public static String getRandomFirstName(){
        return faker.name().firstName();
    }
    public static String getRandomLastName(){
        return faker.name().lastName();
    }
    public static String getRandomAlphaNumericText(int length){
        return faker.text().text(length);
    }
    public static String getBuildingName(){
        return faker.address().buildingNumber();
    }
    public static String getStreetName(){
        return faker.address().streetName();
    }
    public static String getCityName(){
        return faker.address().cityName();
    }
    public static String getState(){
        return faker.address().state();
    }
    public static String getCountryCode(){
        return faker.address().countryCode();
    }
    public static String getPostalCode(){
        return faker.address().postcode();
    }
    public static String emails(){
        return faker.internet().emailAddress();
    }
    public static String getPhoneNumber(){
        return faker.phoneNumber().phoneNumberInternational();
    }
    public static String getCellPhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }
}
