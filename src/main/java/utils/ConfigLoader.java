package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class ConfigLoader {
    private static ConfigLoader configLoader;

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }

        return configLoader;
    }

    public String getBaseUri() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL environmentPath = getClass().getClassLoader().getResource("environment.json");
        Config environmentVariable = objectMapper.readValue(new File(environmentPath.toURI()), Config.class);
        String environment =  System.getProperty("environment");
        String prop = null;

        if(environment.equals("dev")) {
            prop = environmentVariable.getDev().getUrl();
        }
        if(environment.equals("test")) {
            prop = environmentVariable.getTest().getUrl();
        }
        if(environment.equals("staging")) {
            prop = environmentVariable.getStaging().getUrl();
        }

        if (prop != null) return prop;
        else throw new RuntimeException("Property baseUri is not specified in the properties file");
    }
}