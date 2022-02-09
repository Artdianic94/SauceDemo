package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.PropertiesManager;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.chrome.driver", propertiesManager.get("PATH_TO_CHROME_DRIVER"));
        driver = new ChromeDriver();
        System.out.println("Start Driver");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}