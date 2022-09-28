package pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.Presentation;

public class PresentationPage extends BaseSeleniumPage {

    public PresentationPage(String url) {
        drivers.forEach(driver -> {
            driver.get(url);
            PageFactory.initElements(driver, this);
        });
    }

    @FindBy(xpath = "(//span[@class='j-title-breadcrumb'])[2]")
    private WebElement titleSpan;

    @FindBy(xpath = "(//span[@itemprop='name'])[2]")
    private WebElement authorSpan;

    @FindBy(xpath = "(//button[@class='button-ds share share-event-logging new-player-share-modal-trigger'])[2]")
    private WebElement shareButton;

    @FindBy(xpath = "//*[@id='share-link-url']")
    private WebElement shareLinkInput;

    public Presentation getData() {
        String title = titleSpan.getText();
        String author = authorSpan.getText();
        shareButton.click();
        String url = shareLinkInput.getAttribute("value");
        return new Presentation(title, author, url);
    }

}
