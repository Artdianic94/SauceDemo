package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LinkedinPage extends BasePage {
    private By LINKEDIN_LINK_LOGO = By.xpath("//a[text()='LinkedIn']");
    private By LINKEDIN_LOGO = By.className("nav__logo-link");

    public LinkedinPage(WebDriver driver) {
        super(driver);
    }

    public void openLinkedin() {
        driver.findElement(LINKEDIN_LINK_LOGO).click();
    }

    public void newTabForLinkedin() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public boolean getLogo() {
        return driver.findElement(LINKEDIN_LOGO).isDisplayed();
    }
}
