package pages;

import core.BaseSeleniumPage;
import init.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseSeleniumPage {

    public MainPage() {
        drivers.forEach(driver -> {
            driver.get(Config.getProperty("url"));
            PageFactory.initElements(driver, this);
        });
    }

    @FindBy(xpath = "//a[@id='login-from-header']")
    private WebElement loginEntryButton;

    @FindBy(xpath = "//a[@id='scribd-login']")
    private WebElement scribdButton;

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement signIn;

    @FindBy(xpath = "//button[@class='osano-cm-dialog__close osano-cm-close']")
    private WebElement closeDialog;

    @FindBy(xpath = "//a[text()='Sign in with email']")
    private WebElement signInWithLogin;

    @FindBy(xpath = "//input[@id='login_or_email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='login_password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[not(@id='upload') and @href='/upload']")
    private WebElement uploadButton;


    public void signIn(String login, String password) {
        loginEntryButton.click();
        scribdButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeDialog.click();
        signIn.click();
        signInWithLogin.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
        new WebDriverWait(drivers.get(0), 60)
                .until(ExpectedConditions.elementToBeClickable(uploadButton));
    }
}
