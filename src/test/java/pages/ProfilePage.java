package pages;

import core.BaseSeleniumPage;
import init.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseSeleniumPage {

    public ProfilePage(String username) {
        drivers.forEach(driver -> {
            driver.get(Config.getProperty("url") + "/" + username);
            PageFactory.initElements(driver, this);
        });
    }

    @FindBy(xpath = "//*[@id='email_content']")
    private WebElement emailTab;

    @FindBy(xpath = "//div[@id='email_settings_container']/div/a[@href='https://www.scribd.com/your-account']")
    private WebElement goToProfile;

    @FindBy(xpath = "//p[@data-testid='email']")
    private WebElement emailP;

    @FindBy(xpath = "//p[@class='KxFuZ0' and not(@data-testid) and not(@data-e2e)]")
    private WebElement usernameP;

    @FindBy(xpath = "//a[@title='Edit profile']")
    private WebElement editProfile;

    @FindBy(xpath = "//*[@id=\"j-sticky-widgets-profile\"]/div[1]/div[1]/h1")
    private WebElement usernameH1;

    public boolean checkProfileData(String username, String email) {
        String usernameInProfile = "";
        usernameInProfile = usernameH1.getText();
        drivers.forEach(driver -> {
            editProfile.click();
            emailTab.click();
            String originalWindow = driver.getWindowHandle();
            goToProfile.click();
            for (String windowHandle : driver.getWindowHandles()) {
                if(!originalWindow.contentEquals(windowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        });
        return usernameInProfile.equals(username) && username.equals(usernameP.getText())
                && email.equals(emailP.getText());

    }


}
