package driver.factorydriver;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager {

    @Override
    public void createDriver() throws MalformedURLException {
        EdgeOptions browserOptions = new EdgeOptions();
        browserOptions.setCapability("platformName", "Windows 11");
        browserOptions.setCapability("browserVersion", "99");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        driver = new RemoteWebDriver(new URL("https://oauth-artdianic-8d06b:11d3ad12-2491-4b08-82ab-d2efbfb90a84@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), browserOptions);
    }
}