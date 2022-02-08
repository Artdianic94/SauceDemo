package utilities;

import org.openqa.selenium.By;

public class Locators {
    public By loginLogo = By.className("login_logo");//classname
    public By bodyElement = By.tagName("body");//tagname
    public By productName = By.linkText("Sauce Labs Backpack");//linktext
    public By partOfProductName = By.partialLinkText("T-Shirt");//partiallinktext
    public By productContainer = By.xpath("//select[@data-test='product_sort_container']");//по атрибуту
    public By menuItem = By.xpath("//a[normalize-space()='All Items']");//по тексту
    public By menuContainsReset = By.xpath("//a[contains(@id,'reset')]");//по частичному совпадению атрибута
    public By selectContainerContainsText = By.xpath("//span[contains(text(),'Name')]");//по частичному совпадению текста
    public By ancestorOfMenuButton = By.xpath("//button[text()='Open Menu']//ancestor::div[@id='root']");//ancestor
    public By optionParent = By.xpath("//option[contains(text(), 'Price (high to low)')]//parent::select");//parent
    public By buttonIdAndText = By.xpath("//button[@id='react-burger-menu-btn' and normalize-space()='Open Menu']");//поиск элемента с условием AND
    public By buttonClass = By.cssSelector(".bm-burger-button");//.class
    public By idTitleLink = By.cssSelector("#item_1_title_link");//#id
    public By footerTagName = By.cssSelector("footer");//tagname
    public By altImgBegin = By.cssSelector("[alt^='Swag']");//[attribute^=value]
    public By endWithWord = By.cssSelector("[class$='facebook']");//[attribute$=value]
    public By attributeWithWord = By.cssSelector("[alt*='Bot']");//[attribute*=value]
    public By socialNetworksFirst = By.cssSelector("li:first-child");
    public By socialNetworksSecond = By.cssSelector("li:nth-child(2)");
}
