package tests;

import driver.factorydriver.DriverFactory;
import driver.factorydriver.DriverManager;
import driver.factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.TestListeners;

import java.net.MalformedURLException;

@Listeners(TestListeners.class)
public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;

    @BeforeSuite
    @Parameters({"browser"})
    public void setUp(@Optional("remote") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        DriverType driverType = null;
        if (browser.equals("remote")) {
            driverType = DriverType.REMOTE;
        }
        driverManager = factory.getManager(driverType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        System.getProperty("configuration");
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
