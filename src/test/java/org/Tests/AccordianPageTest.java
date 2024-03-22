package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordianPageTest extends TestBase {
    private final String PAGE_TITLE = "Accordian";
    private final String FIRST_TOPIC_TITLE = "What is Lorem Ipsum?";
    private final String SECOND_TOPIC_TITLE = "Where does it come from?";
    private final String THIRD_TOPIC_TITLE = "Why do we use it?";

    @BeforeMethod
    public void initializeClass(){
        accordianPage = homePage.clickOnSectionWidgets().clickOnAccordian();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(accordianPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void isFirstTopicTitleCorrect(){
        Assert.assertEquals(accordianPage.getCard1TopicText(),FIRST_TOPIC_TITLE);
    }

    @Test
    public void isSecondTopicTitleCorrect(){
        Assert.assertEquals(accordianPage.getCard2TopicText(),SECOND_TOPIC_TITLE);
    }

    @Test
    public void isThirdTopicTitleCorrect(){
        Assert.assertEquals(accordianPage.getCard3TopicText(),THIRD_TOPIC_TITLE);
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