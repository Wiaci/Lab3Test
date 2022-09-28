package test;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.PresentationPage;

public class GuestActionsTest extends BaseSeleniumTest {

    @BeforeAll
    public static void setUp() {
        init();
    }

    @Test
    public void open() {
        MainPage mainPage = new MainPage();
        Presentation presentation = mainPage.openRandomPresentation();
        PresentationPage presentationPage = new PresentationPage(presentation.getUrl());
        Presentation presentation1 = presentationPage.getData();
        Assertions.assertEquals(presentation.getTitle(), presentation1.getTitle());
        Assertions.assertEquals(presentation.getUrl(), presentation1.getUrl());
        Assertions.assertEquals(presentation.getAuthor(), presentation1.getAuthor());
    }

    @Test
    public void searchExistingPresentation() {
        String title = "Hiring time-vs-money a better more affordable way to Hire.";
        MainPage mainPage = new MainPage();
        mainPage.search(title);
        Assertions.assertTrue(mainPage.isTherePresentation(title));
    }

    @Test
    public void searchNonExistingPresentation() {
        String title = "Aqvadiskadteaka";
        MainPage mainPage = new MainPage();
        mainPage.search(title);
        Assertions.assertTrue(mainPage.isTherePresentation(title));
    }

    @Test
    public void searchInIndex() {
        String title = "Hiriart riedemann, vivianne ¿que estan viviendo los jovenes";
        MainPage mainPage = new MainPage();
        mainPage.searchWithIndex(title);
    }



}
