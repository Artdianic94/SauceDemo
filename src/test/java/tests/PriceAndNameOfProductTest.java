package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedinPage;
import pages.LoginPOMPage;
import pages.ShoppingCartPOMPage;
import staticdata.WebUrl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PriceAndNameOfProductTest extends BaseTest {
    LoginPOMPage loginPOMPage;
    ShoppingCartPOMPage shoppingCartPOMPage;
    LinkedinPage linkedinPage;

    @Test
    public void priceTest() throws IOException {
        loginPOMPage = new LoginPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        loginPOMPage.openRegistrationPage();
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

    @Test
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

    @Test
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
