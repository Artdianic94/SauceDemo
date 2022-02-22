package tests;

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
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL_FIRST);
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
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL_FIRST);
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
        loginPOMPage.inputIntoEmail(WebUrl.EMAIL_FIRST);
        loginPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        loginPOMPage.loginButton();
        driverManager.removeTimeout();
        linkedinPage.openLinkedin();
        linkedinPage.newTabForLinkedin();
        boolean isVisible = linkedinPage.getLogo();
        Assert.assertTrue(isVisible, "Logo isn't visible");
    }
}
