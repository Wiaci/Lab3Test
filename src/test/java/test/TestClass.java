package test;

import core.BaseSeleniumTest;
import init.Config;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.UploadPage;

public class TestClass extends BaseSeleniumTest {



    @Test
    public void signInTest() {
        MainPage mainPage = new MainPage();
        mainPage.signIn(Config.getProperty("login"), Config.getProperty("password"));
    }

    @Test
    public void upload() {
        MainPage mainPage = new MainPage();
        mainPage.signIn(Config.getProperty("login"), Config.getProperty("password"));
        UploadPage uploadPage = new UploadPage();
        uploadPage.sendFile("C:\\Users\\vyach\\IdeaProjects\\Lab3Test\\src\\main\\resources\\test2.docx",
                "hello world", "hello world war");
    }

}
