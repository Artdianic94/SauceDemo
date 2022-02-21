package driver.factorydriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.PropertiesManager;

public class MozillaDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.chrome.driver", propertiesManager.get("PATH_TO_MOZILLA_DRIVER"));
        driver = new FirefoxDriver();
    }
}