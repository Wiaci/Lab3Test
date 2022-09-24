package pages;

import core.BaseSeleniumPage;
import init.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BaseSeleniumPage {

    @FindBy(xpath = "//button[text()=\"I Accept\"]")
    private WebElement cookiesAccept;

    @FindBy(xpath = "//input[@placeholder=\"Search\"]")
    private WebElement searchArea;

    @FindBy(xpath = "//button[text()=\"Sign up for free\"]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//button[text()=\"Sign in\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"sign_in_up_email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@id=\"sign_in_up_submit\"]")
    private WebElement buttonEmailSubmit;

    @FindBy(xpath = "//button[@id='enter_password_submit']")
    private WebElement buttonPasswordSubmit;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement captcha;


    public MainPage() {
        drivers.forEach(driver -> {
            driver.get(Config.getProperty("url"));
            PageFactory.initElements(driver, this);
        });
    }

    public void createAccount(String email, String password) {
        cookiesAccept.click();
        signInButton.click();
        //createAccountButton.click();
        //drivers.get(0).manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        emailInput.click();
        emailInput.sendKeys(email);
        buttonEmailSubmit.click();

    }
}
