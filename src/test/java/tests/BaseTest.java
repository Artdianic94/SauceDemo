package tests;

import driver.factorydriver.DriverFactory;
import driver.factorydriver.DriverManager;
import driver.factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver driver;
    DriverManager driverManager;

    @BeforeClass
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        System.out.println("Start Driver");
        driverManager.setTimeout();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}