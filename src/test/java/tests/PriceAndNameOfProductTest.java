package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedinPage;
import pages.LoginPOMPage;
import pages.ShoppingCartPOMPage;
import staticdata.WebUrl;
import utilities.Retry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@Epic("Web test")
@Feature("Price and name")
@Story("Price and Name on page and in the shopping cart are equal")
public class PriceAndNameOfProductTest extends BaseTest {
    LoginPOMPage loginPOMPage;
    ShoppingCartPOMPage shoppingCartPOMPage;
    LinkedinPage linkedinPage;
    private static Logger LOGGER = LogManager.getLogger(PriceAndNameOfProductTest.class.getName());

    @Test(retryAnalyzer = Retry.class)
    @Description("Check price on page")
    @Link("https://instagram.com")
    @Issue("COVID-19")
    @Severity(SeverityLevel.NORMAL)
    public void priceTest() throws IOException {
        loginPOMPage = new LoginPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        LOGGER.info("Open registration page");
        loginPOMPage.openRegistrationPage();
        LOGGER.info("input sign in");
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL_FIRST);
        loginPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        loginPOMPage.loginButton();
        shoppingCartPOMPage.addProductToShopCart();
        String priceOnPage = shoppingCartPOMPage.priceOnPage();
        shoppingCartPOMPage.goToShoppingCart();
        String priceInShoppingCart = shoppingCartPOMPage.priceInShoppingCart();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshotPriceTest.png"), sourceFile);
        Assert.assertEquals(priceInShoppingCart, priceOnPage, "Prices are not equal");
    }
    @Description("Check name on page")
    @Link("https://instagram.com")
    @Issue("COVID-19")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = Retry.class)
    public void nameTest() throws IOException {
        loginPOMPage = new LoginPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        loginPOMPage.openRegistrationPage();
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL_FIRST);
        loginPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        loginPOMPage.loginButton();
        shoppingCartPOMPage.addProductToShopCart();
        String nameOnPage = shoppingCartPOMPage.nameOnPage();
        shoppingCartPOMPage.goToShoppingCart();
        String nameInShoppingCart = shoppingCartPOMPage.nameInShoppingCart();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshotNameTest.png"), sourceFile);
        Assert.assertEquals(nameInShoppingCart, nameOnPage, "Names are not equal");
    }
    @Description("Check linkedin")
    @Link("https://instagram.com")
    @Issue("COVID-19")
    @Severity(SeverityLevel.NORMAL)
    @Test(retryAnalyzer = Retry.class)
    public void linkedinWithWaitTest() throws IOException {
        loginPOMPage = new LoginPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        linkedinPage = new LinkedinPage(driver);
        loginPOMPage.openRegistrationPage();
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL_FIRST);
        loginPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        loginPOMPage.loginButton();
        driverManager.removeTimeout();
        linkedinPage.openLinkedin();
        linkedinPage.newTabForLinkedin();
        boolean isVisible = linkedinPage.getLogo();
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshotLinkedinWithWaitTest.png"), sourceFile);
        Assert.assertTrue(isVisible, "Logo isn't visible");
    }
}
