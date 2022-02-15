package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPOMPage;
import pages.ShoppingCartPOMPage;
import staticdata.WebUrl;

public class PriceAndNameOfProductTest extends BaseTest {
    LoginPOMPage loginPOMPage;
    ShoppingCartPOMPage shoppingCartPOMPage;

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
}
