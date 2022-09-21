package test;

import core.BaseSeleniumPage;
import core.BaseSeleniumTest;
import init.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestClass extends BaseSeleniumTest {

    @BeforeEach
    public void setUp() {
        drivers = new ArrayList<>();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().avoidBrowserDetection().setup();

        //System.setProperty("webdriver.chrome.driver", Config.getProperty("chrome_driver_path"));
        //System.setProperty("webdriver.gecko.driver", Config.getProperty("mozilla_driver_path"));

        drivers.add(new ChromeDriver());
        drivers.add(new FirefoxDriver());

        drivers.forEach(driver -> {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        });

        BaseSeleniumPage.setDriver(drivers);
    }

    @Test
    public void check() {
        MainPage mainPage = new MainPage();
        mainPage.createAccount(Config.getProperty("login"), Config.getProperty("password"));

    }

}
