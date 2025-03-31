package com.api.configurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private FileInputStream ip;
    private static Properties prop;
    public Properties initProperties() {
        prop = new Properties();
        String envName = System.getProperty("env");

        try {
            if (envName == null) {
                System.out.println("No Environment Details passed, Running TCs on default environment");
                ip = new FileInputStream("src/test/resources/config/config.properties");
            } else {
                System.out.println("Running TCs on " + envName + " environment");

                switch (envName.toLowerCase().trim()) {
                    case "DIT":
                        ip = new FileInputStream("src/test/resources/config/dit.config.properties");
                        break;
                    case "FIT":
                        ip = new FileInputStream("src/test/resources/config/fit.config.properties");
                        break;
                    case "IAT":
                        ip = new FileInputStream("src/test/resources/config/iat.config.properties");
                        break;
                    default:
                        System.out.println("Running with default configurations");
                        ip = new FileInputStream("src/test/resources/config/config.properties");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{
            prop.load(ip);
        }catch (IOException e){
            e.printStackTrace();
        }
    return prop;
    }

    public static String getProperty(String value) {
        return prop.get(value).toString();
    }
}