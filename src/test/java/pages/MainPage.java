package pages;

import core.BaseSeleniumPage;
import init.Config;
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

    @FindBy(xpath = "//input[@id=\"sign_in_up_email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@id=\"sign_in_up_submit\"]")
    private WebElement buttonEmailSubmit;

    @FindBy(xpath = "//button[@id=\"enter_password_submit\"]")
    private WebElement buttonPasswordSubmit;

    @FindBy(xpath = "//div[@class=\"recaptcha-checkbox-border\"]")
    private WebElement captcha;


    public MainPage() {
        drivers.forEach(driver -> {
            driver.get(Config.getProperty("url"));
            PageFactory.initElements(driver, this);
        });
    }

    public void createAccount(String email, String password) {
        createAccountButton.click();
        emailInput.sendKeys(email);
        buttonEmailSubmit.click();

    }
}
