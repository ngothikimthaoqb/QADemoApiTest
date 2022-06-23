package utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/main/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }

        return configLoader;
    }

    public String getBaseUri() {
        String prop = properties.getProperty("baseUri");
        if (prop != null) return prop;
        else throw new RuntimeException("Property baseUri is not specified in the properties file");
    }
}

