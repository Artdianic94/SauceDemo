package loadablecomponentpage;

import org.openqa.selenium.WebDriver;

abstract class BasePage {
    WebDriver driver;

    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
