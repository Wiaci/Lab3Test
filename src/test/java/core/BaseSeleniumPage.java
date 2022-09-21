package core;

import org.openqa.selenium.WebDriver;

import java.util.List;

abstract public class BaseSeleniumPage {
    protected static List<WebDriver> drivers;

    public static void setDriver(List<WebDriver> webDrivers) {
        drivers = webDrivers;
    }
}
