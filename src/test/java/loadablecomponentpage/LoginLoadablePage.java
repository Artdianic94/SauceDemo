package loadablecomponentpage;

import fluentpage.LoginFluentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLoadablePage extends BasePage {
    private By EMAIL_INPUT = By.xpath("//input[@id='user-name']");
    private By PWD_INPUT = By.xpath("//input[@id='password']");
    private By LOG_BUTT = By.xpath("//input[@value='Login']");
    private By PRODUCT_SORT_CONTAINER = By.xpath("//select[@data-test='product_sort_container']");

    public LoginLoadablePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(PRODUCT_SORT_CONTAINER).isDisplayed();
    }

    public LoginLoadablePage inputEmail(String emailFirst) {
        driver.findElement(EMAIL_INPUT).sendKeys(emailFirst);
        return this;
    }

    public LoginLoadablePage inputPassword(String password) {
        driver.findElement(PWD_INPUT).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(LOG_BUTT).click();
    }
}

