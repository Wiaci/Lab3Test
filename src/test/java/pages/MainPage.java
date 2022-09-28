package pages;

import core.BaseSeleniumPage;
import init.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.Presentation;

import java.util.List;

public class MainPage extends BaseSeleniumPage {

    public MainPage() {
        drivers.forEach(driver -> {
            driver.get(Config.getProperty("url"));
            PageFactory.initElements(driver, this);
        });
    }

    @FindBy(xpath = "//*[@id='signup-from-header']")
    private WebElement signUpButton;

    @FindBy(xpath = "//*[text()='Sign up with Google']")
    private WebElement signUpWithGoogleButton;

    @FindBy(xpath = "//*[@id='identifierId']")
    private WebElement emailGoogle;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]")
    private WebElement emailGoogleSubmit;

    @FindBy(xpath = "//*[text()='Sign up with email']")
    private WebElement signUpWithEmailButton;

    @FindBy(xpath = "//*[@id='word_user[name]']")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id='email_address[email]']")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='word_user[password]']")
    private WebElement passwordEmailInput;

    @FindBy(xpath = "//*[text()='Sign up']")
    private WebElement signUpSubmit;

    @FindBy(xpath = "//div[@class='details']")
    WebElement linkToPresentation;

    @FindBy(xpath = "//a[@class='iso_slideshow_link thumbnail-link']")
    WebElement actualLink;

    @FindBy(xpath = "//input[@id='nav-search-query']")
    private WebElement searchField;

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

    public Presentation openRandomPresentation() {
        String author = linkToPresentation.findElement(By.xpath("//a[@class='j-author_text notranslate']")).getText();
        String title = linkToPresentation.findElement(By.xpath("//span[@class='title title-link antialiased']")).getText();
        actualLink.click();
        String url = drivers.get(0).getCurrentUrl();
        return new Presentation(title, author, url);
    }

    @FindBy(xpath = "//a[@class='title title-link antialiased j-slideshow-title']")
    private List<WebElement> links;

    public boolean isTherePresentation(String title) {
        for (WebElement link : links) {
            if (title.equals(link.getText())) return true;
        }
        return false;
    }

    @FindBy(xpath = "//div[@class='columns text-center']/a")
    private List<WebElement> letters;

    @FindBy(xpath = "//li[@class='page-link']/a")
    private List<WebElement> options;

    public boolean searchWithIndex(String title) {
        String lowerTitle = title.toLowerCase();
        for (WebElement letter : letters) {
            if (lowerTitle.startsWith(letter.getText())) {
                letter.click();
                break;
            }
        }
        for (WebElement option : options) {
            if (option.getText().contains(" -> ")) {
                String[] parts = option.getText().split(" -> ");
                if (lowerTitle.compareTo(parts[0]) > 0 && lowerTitle.compareTo(parts[1]) < 0) {
                    option.click();
                    break;
                }
            }
        }
        for (WebElement option : options) {
            if (option.getText().contains(" -> ")) {
                String[] parts = option.getText().split(" -> ");
                if (lowerTitle.compareTo(parts[0]) > 0 && lowerTitle.compareTo(parts[1]) < 0) {
                    option.click();
                    break;
                }
            }
        }
        for (WebElement option : options) {
            if (option.getText().equals(title)) {
                return true;
            }
        }
        return false;
    }


    public void signUpWithGoogle() {
        drivers.forEach(driver -> {
            signUpButton.click();
            String originalWindow = driver.getWindowHandle();
            signUpWithGoogleButton.click();
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(emailGoogle));
            emailGoogle.sendKeys("vyachproz7@gmail.com");
            emailGoogleSubmit.click();
        });
    }



    public void signUpWithEmail() {
        signUpButton.click();
        signUpWithEmailButton.click();
        nameInput.sendKeys("vladislavAlekseev0101");
        emailInput.sendKeys("vladislavalekseev0101@proton.me");
        passwordEmailInput.sendKeys("vladislavalekseev0101@proton.me");
        signUpSubmit.click();
    }







    public void search(String presentationTitle) {
        searchField.sendKeys(presentationTitle);
        searchField.submit();
    }
}
