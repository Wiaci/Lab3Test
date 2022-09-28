package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest {

    protected static List<WebDriver> drivers;

    public static void init() {
        drivers = new ArrayList<>();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();


        drivers.add(new ChromeDriver());
        //drivers.add(new FirefoxDriver());

        drivers.forEach(driver -> {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        });

        BaseSeleniumPage.setDriver(drivers);
    }

    @AfterAll
    public static void tearDown() {
        drivers.forEach(driver -> {
            driver.close();
            driver.quit();
        });
    }

}
