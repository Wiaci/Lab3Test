package soundcloud;

import core.BaseSeleniumPage;
import init.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    private WebElement searchArea;

    @FindBy(xpath = "//button[text()=\"Create account\"]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//button[text()=\"Sign in\"]")
    private WebElement signInButton;

    public MainPage() {
        drivers.forEach(driver -> {
            driver.get(Config.getProperty("url"));
            PageFactory.initElements(driver, this);
        });
    }
}
