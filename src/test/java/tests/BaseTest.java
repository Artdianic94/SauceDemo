package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.PropertiesManager;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        PropertiesManager propertiesManager = new PropertiesManager();
        System.setProperty("webdriver.chrome.driver", propertiesManager.get("PATH_TO_CHROME_DRIVER"));
        driver = new ChromeDriver();
        System.out.println("Start Driver");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}