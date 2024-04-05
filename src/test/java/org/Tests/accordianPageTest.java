package org.Tests;

import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class accordianPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(accordianPageTest.class);

    @BeforeMethod(groups = {"UI", "Smoke"})
    public void initializeClass(){
        logger.info("-------------------Initializing AccordianPageTest Class------------------");
        accordianPage = homePage.clickOnSectionWidgets().clickOnAccordian();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = "UI")
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Accordian";

        logger.info("-------------------ValidateCorrectedPageTitle-----------------------");
        Assert.assertEquals(accordianPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = "UI")
    public void isFirstTopicTitleCorrect(){
        String FIRST_TOPIC_TITLE = "What is Lorem Ipsum?";

        logger.info("-------------------isFirstTopicTitleCorrect-----------------------");
        Assert.assertEquals(accordianPage.getCard1TopicText(), FIRST_TOPIC_TITLE);
    }

    @Test(groups = "UI")
    public void isSecondTopicTitleCorrect(){
        String SECOND_TOPIC_TITLE = "Where does it come from?";

        logger.info("-------------------isSecondTopicTitleCorrect-----------------------");
        Assert.assertEquals(accordianPage.getCard2TopicText(), SECOND_TOPIC_TITLE);
    }

    @Test(groups = "UI")
    public void isThirdTopicTitleCorrect(){
        String THIRD_TOPIC_TITLE = "Why do we use it?";

        logger.info("-------------------isThirdTopicTitleCorrect-----------------------");
        Assert.assertEquals(accordianPage.getCard3TopicText(), THIRD_TOPIC_TITLE);
    }

    @Test(groups = "Smoke")
    public void validateFirstContentCardIsShown(){
        logger.info("-------------------validateFirstContentCardIsShown-----------------------");
        accordianPage.clickOnFirstCard();
        Assert.assertTrue(accordianPage.firstContentIsVisible());
    }

    @Test(groups = "Smoke")
    public void validateSecondContentCardIsShown(){
        logger.info("-------------------validateSecondContentCardIsShown-----------------------");
        accordianPage.clickOnSecondCard();
        Assert.assertTrue(accordianPage.secondContentIsVisible());
    }

    @Test(groups = "Smoke")
    public void validateThirdContentCardIsShown(){
        logger.info("-------------------validateThirdContentCardIsShown-----------------------");
        accordianPage.clickOnThirdCard();
        Assert.assertTrue(accordianPage.thirdContentIsVisible());
    }
}