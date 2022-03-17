package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPOMPage extends BasePage {
    private By PRODUCT_BUTT = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By PRODUCT_PRICE_ON_PAGE = By.xpath("//div[@class='inventory_item_price']");
    private By SHOPPING_CART = By.xpath("//a[@class='shopping_cart_link']");
    private By PRODUCT_PRICE_IN_SHOP_CART = By.xpath("//div[@class='inventory_item_price']");
    private By PRODUCT_NAME_ON_PAGE = By.xpath("//a[@id='item_4_title_link']/div[@class='inventory_item_name']");
    private By PRODUCT_NAME_IN_SHOPPING_CART = By.xpath("//div[@class='inventory_item_name']");

    public ShoppingCartPOMPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on product button")
    public void addProductToShopCart() {
        driver.findElement(PRODUCT_BUTT).click();
    }

    @Step("Get price of product on page")
    public String priceOnPage() {
        return driver.findElement(PRODUCT_PRICE_ON_PAGE).getText();
    }

    @Step("Go to shopping cart")
    public void goToShoppingCart() {
        driver.findElement(SHOPPING_CART).click();
    }

    @Step("Get price in shopping cart")
    public String priceInShoppingCart() {
        return driver.findElement(PRODUCT_PRICE_IN_SHOP_CART).getText();
    }

    public String nameOnPage() {
        return driver.findElement(PRODUCT_NAME_ON_PAGE).getText();
    }

    public String nameInShoppingCart() {
        return driver.findElement(PRODUCT_NAME_IN_SHOPPING_CART).getText();
    }
}
