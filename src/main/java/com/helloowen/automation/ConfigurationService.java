package com.helloowen.automation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationService {

    private Properties defaultProperties;

    public ConfigurationService() {
        defaultProperties = new Properties();
        try {
            InputStream in = ConfigurationService.class.getClassLoader().getResourceAsStream("application.properties");
            defaultProperties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return (String) defaultProperties.get(key);
    }

}
