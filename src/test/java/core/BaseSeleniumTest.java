package core;

import core.BaseSeleniumPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {

    protected List<WebDriver> drivers;

    @Before
    public void setUp() {
        drivers = new ArrayList<>();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        drivers.add(new ChromeDriver());
        drivers.add(new FirefoxDriver());

        drivers.forEach(driver -> {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        });

        BaseSeleniumPage.setDriver(drivers);
    }

    @After
    public void tearDown() {
        drivers.forEach(driver -> {
            driver.close();
            driver.quit();
        });
    }

}
