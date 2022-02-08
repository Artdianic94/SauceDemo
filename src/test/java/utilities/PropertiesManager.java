package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private final String propertyFilePath;
    private Properties prop;
///Users/da/Desktop/SauceDemo/src/test/resources/config.properties
    public PropertiesManager() {
        propertyFilePath = System.getProperty("/Users/da") + "/src/test/resources/config.properties";
    }

    private void loadData() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String propertyName) {
        loadData();
        return prop.getProperty(propertyName);
    }

}