package com.api.Base;

import com.api.configurations.Configuration;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.Map;
import java.util.Properties;

public class BaseTest {
    //private BaseTest(){}

    protected Configuration config;
    protected Properties prop;
    protected String baseURL;
    private RequestSpecification requestSpecification;
    public static Map<String, Object> dataFromJsonFile;

    /*static {
        try {
            String env = System.getProperty("env") == null ? "dev" : System.getProperty("env");
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("airlines/" + env + "/airlinesApiData.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*public String getBaseUri() {
        return baseURI = prop.getProperty("base_url");
    }*/

    /*protected void setAuthToken(String token){
        requestSpecification.header("Authorization","Bearer "+token);
    }*/
    @Parameters("BaseURL")
    @BeforeSuite //(alwaysRun = true)
    protected void setup(String BaseURL) {
        System.out.println("Base class ");
        config = new Configuration();
        prop = config.initProperties();
        prop.setProperty("base_url",BaseURL);
        //this.baseURL = prop.getProperty("base_url");
    }
}