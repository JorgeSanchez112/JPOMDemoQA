package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccordianPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        accordianPage = homePage.clickOnSectionWidgets().clickOnAccordian();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(accordianPage.getPageTitleText(),pageTitle);
    }

    @Parameters("firstTopicTitle")
    @Test
    public void isFirstTopicTitleCorrect(String firstTopicTitle){
        Assert.assertEquals(accordianPage.getCard1TopicText(),firstTopicTitle);
    }

    @Parameters("secondTopicTitle")
    @Test
    public void isSecondTopicTitleCorrect(String secondTopicTitle){
        Assert.assertEquals(accordianPage.getCard2TopicText(),secondTopicTitle);
    }

    @Parameters("thirdTopicTitle")
    @Test
    public void isThirdTopicTitleCorrect(String thirdTopicTitle){
        Assert.assertEquals(accordianPage.getCard3TopicText(),thirdTopicTitle);
    }

    @Test
    public void validateFirstContentCardIsShown(){
        accordianPage.clickOnFirstCard();
        Assert.assertTrue(accordianPage.firstContentIsVisible());
    }

    @Test
    public void validateSecondContentCardIsShown(){
        accordianPage.clickOnSecondCard();
        Assert.assertTrue(accordianPage.secondContentIsVisible());
    }

    @Test
    public void validateThirdContentCardIsShown(){
        accordianPage.clickOnThirdCard();
        Assert.assertTrue(accordianPage.thirdContentIsVisible());
    }
}
