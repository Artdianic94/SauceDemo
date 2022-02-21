package fluentpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFluentPage extends BasePage {
    private By EMAIL_INPUT = By.xpath("//input[@id='user-name']");
    private By PWD_INPUT = By.xpath("//input[@id='password']");
    private By LOG_BUTT = By.xpath("//input[@value='Login']");

    public LoginFluentPage(WebDriver driver) {
        super(driver);
    }

    public LoginFluentPage inputEmail(String emailFirst) {
        driver.findElement(EMAIL_INPUT).sendKeys(emailFirst);
        return this;
    }

    public LoginFluentPage inputPassword(String password) {
        driver.findElement(PWD_INPUT).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(LOG_BUTT).click();
    }
}
