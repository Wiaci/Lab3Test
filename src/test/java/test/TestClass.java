package test;

import core.BaseSeleniumTest;
import init.Config;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProfilePage;
import pages.UploadPage;

public class TestClass extends BaseSeleniumTest {

    private static MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        init();
        mainPage = new MainPage();
        mainPage.signIn(Config.getProperty("login"), Config.getProperty("password"));
    }

    @Test
    public void check() {
        String username = Config.getProperty("username");
        String login = Config.getProperty("login");
        ProfilePage profilePage = new ProfilePage(username);
        Assertions.assertTrue(profilePage.checkProfileData(username, login));
    }


    @Test
    public void signUpTest() {
        MainPage mainPage = new MainPage();
        mainPage.signUpWithEmail();
    }


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
