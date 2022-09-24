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



    @Test
    public void check() {
        MainPage mainPage = new MainPage();
        mainPage.createAccount(Config.getProperty("login"), Config.getProperty("password"));

    }

}
