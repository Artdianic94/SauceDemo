package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPOMPage;
import pages.ShoppingCartPOMPage;
import staticdata.WebUrl;

public class PriceAndNameOfProductTest extends BaseTest {
    RegistrationPOMPage registrationPOMPage;
    ShoppingCartPOMPage shoppingCartPOMPage;

    @Test
    public void priceTest() {
        registrationPOMPage = new RegistrationPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        registrationPOMPage.openRegistrationPage();
        registrationPOMPage.inputIntoEmail(WebUrl.EMAIL);
        registrationPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        registrationPOMPage.registrationButton();
        shoppingCartPOMPage.addProductToShopCart();
        String priceOnPage = shoppingCartPOMPage.priceOnPage();
        shoppingCartPOMPage.goToShoppingCart();
        String priceInShoppingCart = shoppingCartPOMPage.priceInShoppingCart();
        Assert.assertEquals(priceInShoppingCart, priceOnPage, "Prices are not equal");
    }

    @Test
    public void nameTest() {
        registrationPOMPage = new RegistrationPOMPage(driver);
        shoppingCartPOMPage = new ShoppingCartPOMPage(driver);
        registrationPOMPage.openRegistrationPage();
        registrationPOMPage.inputIntoEmail(WebUrl.EMAIL);
        registrationPOMPage.inputIntoPassword(WebUrl.PASSWORD);
        registrationPOMPage.registrationButton();
        shoppingCartPOMPage.addProductToShopCart();
        String nameOnPage = shoppingCartPOMPage.nameOnPage();
        shoppingCartPOMPage.goToShoppingCart();
        String nameInShoppingCart = shoppingCartPOMPage.nameInShoppingCart();
        Assert.assertEquals(nameInShoppingCart, nameOnPage, "Names are not equal");
    }
}
