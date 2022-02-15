package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrl;

public class LoginPOMPage extends BasePage {
    private By EMAIL_INPUT = By.xpath("//input[@id='user-name']");
    private By PWD_INPUT = By.xpath("//input[@id='password']");
    private By LOG_BUTT = By.xpath("//input[@value='Login']");

    public LoginPOMPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationPage() {
        driver.get(WebUrl.SAUCE_DEMO_URL);
    }

    public void inputIntoEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void inputIntoPassword(String pwd) {
        driver.findElement(PWD_INPUT).sendKeys(pwd);
    }

    public void loginButton() {
        driver.findElement(LOG_BUTT).click();
    }
}
