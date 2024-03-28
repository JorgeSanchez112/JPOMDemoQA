package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordianPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(AccordianPageTest.class);
    private final String PAGE_TITLE = "Accordian";
    private final String FIRST_TOPIC_TITLE = "What is Lorem Ipsum?";
    private final String SECOND_TOPIC_TITLE = "Where does it come from?";
    private final String THIRD_TOPIC_TITLE = "Why do we use it?";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing AccordianPageTest Class------------------");
        accordianPage = homePage.clickOnSectionWidgets().clickOnAccordian();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------ValidateCorrectedPageTitle-----------------------");
        Assert.assertEquals(accordianPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void isFirstTopicTitleCorrect(){
        logger.info("-------------------isFirstTopicTitleCorrect-----------------------");
        Assert.assertEquals(accordianPage.getCard1TopicText(),FIRST_TOPIC_TITLE);
    }

    @Test
    public void isSecondTopicTitleCorrect(){
        logger.info("-------------------isSecondTopicTitleCorrect-----------------------");
        Assert.assertEquals(accordianPage.getCard2TopicText(),SECOND_TOPIC_TITLE);
    }

    @Test
    public void isThirdTopicTitleCorrect(){
        logger.info("-------------------isThirdTopicTitleCorrect-----------------------");
        Assert.assertEquals(accordianPage.getCard3TopicText(),THIRD_TOPIC_TITLE);
    }

    @Test
    public void validateFirstContentCardIsShown(){
        logger.info("-------------------validateFirstContentCardIsShown-----------------------");
        accordianPage.clickOnFirstCard();
        Assert.assertTrue(accordianPage.firstContentIsVisible());
    }

    @Test
    public void validateSecondContentCardIsShown(){
        logger.info("-------------------validateSecondContentCardIsShown-----------------------");
        accordianPage.clickOnSecondCard();
        Assert.assertTrue(accordianPage.secondContentIsVisible());
    }

    @Test
    public void validateThirdContentCardIsShown(){
        logger.info("-------------------validateThirdContentCardIsShown-----------------------");
        accordianPage.clickOnThirdCard();
        Assert.assertTrue(accordianPage.thirdContentIsVisible());
    }
}