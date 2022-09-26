package pages;

import core.BaseSeleniumPage;
import init.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Watchable;

public class UploadPage extends BaseSeleniumPage {

    public UploadPage() {
        drivers.forEach(driver -> {
            driver.get(Config.getProperty("url") + "/upload");
            PageFactory.initElements(driver, this);
        });
    }

    @FindBy(xpath = "//*[@id='local-upload']")
    private WebElement fileUpload;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement descriptionInput;

    @FindBy(xpath = "//input[@id='tags']")
    private WebElement tagsInput;

    @FindBy(xpath = "//select[@id='category']")
    private WebElement categorySelect;

    @FindBy(xpath = "//option[@value='4']")
    private WebElement categoryOption;

    @FindBy(xpath = "//button[text()='Publish']")
    private WebElement publishButton;

    public void sendFile(String path, String description, String tags) {
        fileUpload.sendKeys(path);
        WebDriverWait wait = new WebDriverWait(drivers.get(0), 60);
        wait.until(ExpectedConditions.elementToBeClickable(descriptionInput));
        descriptionInput.sendKeys(description);
        tagsInput.sendKeys(tags);
        categorySelect.click();
        categoryOption.click();
        wait.until(ExpectedConditions.elementToBeClickable(publishButton));
        publishButton.click(); ////a[normalize-space(.) = 'How to think like a startup']
    }

}
