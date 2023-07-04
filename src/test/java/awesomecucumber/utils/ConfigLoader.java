package awesomecucumber.utils;

import awesomecucumber.constants.EnvType;

import java.util.Properties;

import static awesomecucumber.utils.PropertyUtils.*;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        EnvType envType = EnvType.valueOf(env);
        if (envType == EnvType.PROD) {
            properties = propertyLoader("src/test/resources/prod_config.properties");
        } else if (envType == EnvType.STAGE) {
            properties = propertyLoader("src/test/resources/stage_config.properties");
        } else {
            throw new IllegalStateException("INVALID ENV: " + env);

            /*case PROD -> properties = propertyLoader("src/test/resources/prod_config.properties");
            case STAGE ->properties = propertyLoader("src/test/resources/stage_config.properties");
            default ->throw new IllegalStateException("INVALID ENV: " + env);*/
        }

    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("Property baseUrl is not specified in the stg_config.properties file");
    }
}
