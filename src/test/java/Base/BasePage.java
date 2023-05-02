package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver tdriver;

    public BasePage(WebDriver driver) {
        tdriver = driver;
        PageFactory.initElements(driver, this);
    }
}
