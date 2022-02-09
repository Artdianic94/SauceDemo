package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.WebUrl;

public class PriceAndNameOfProductTest extends BaseTest {
    @Test
    public void priceTest() {
        driver.get(WebUrl.SAUCE_DEMO_URL);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(WebUrl.EMAIL);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(WebUrl.PASSWORD);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        String priceOnPage = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String priceInShoppingCart = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        Assert.assertEquals(priceInShoppingCart, priceOnPage, "Prices are not equal");
    }

    @Test
    public void nameTest() {
        driver.get(WebUrl.SAUCE_DEMO_URL);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(WebUrl.EMAIL);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(WebUrl.PASSWORD);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        String nameOnPage = driver.findElement(By.xpath("//a[@id='item_4_title_link']/div[@class='inventory_item_name']")).getText();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String nameInShoppingCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(nameInShoppingCart, nameOnPage, "Names are not equal");
    }
}
