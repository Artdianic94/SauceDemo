package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LinkedinPage;
import pages.LoginPOMPage;
import pages.ShoppingCartPOMPage;
import staticdata.WebUrl;

public class PriceAndNameOfProductTest extends BaseTest {
    LoginPOMPage loginPOMPage;
    ShoppingCartPOMPage shoppingCartPOMPage;
    LinkedinPage linkedinPage;

    @Test
    public void priceTest() {
        loginPOMPage = new LoginPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        loginPOMPage.openRegistrationPage();
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL);
        loginPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        loginPOMPage.loginButton();
        shoppingCartPOMPage.addProductToShopCart();
        String priceOnPage = shoppingCartPOMPage.priceOnPage();
        shoppingCartPOMPage.goToShoppingCart();
        String priceInShoppingCart = shoppingCartPOMPage.priceInShoppingCart();
        Assert.assertEquals(priceInShoppingCart, priceOnPage, "Prices are not equal");
    }

    @Test
    public void nameTest() {
        loginPOMPage = new LoginPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        loginPOMPage.openRegistrationPage();
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL);
        loginPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        loginPOMPage.loginButton();
        shoppingCartPOMPage.addProductToShopCart();
        String nameOnPage = shoppingCartPOMPage.nameOnPage();
        shoppingCartPOMPage.goToShoppingCart();
        String nameInShoppingCart = shoppingCartPOMPage.nameInShoppingCart();
        Assert.assertEquals(nameInShoppingCart, nameOnPage, "Names are not equal");
    }

    @Test
    public void linkedinWithWaitTest() {
        loginPOMPage = new LoginPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        linkedinPage = new LinkedinPage(driver);
        loginPOMPage.openRegistrationPage();
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL);
        loginPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        loginPOMPage.loginButton();
        removeTimeout();
        linkedinPage.openLinkedin();
        linkedinPage.newTabForLinkedin();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav__logo-link")));
        boolean isVisible = linkedinPage.getLogo();
        Assert.assertTrue(isVisible, "Logo isn't visible");
    }
}
