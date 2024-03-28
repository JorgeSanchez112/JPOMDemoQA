package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(ProgressBarPageTest.class);
    private final String PAGE_TITLE = "Progress Bar";
    private final String FULL_BAR_PERCENTAGE = "100%";
    private final String EMPTY_BAR_PERCENTAGE = "0%";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing ProgressBarPageTest Class------------------");
        progressBarPage = homePage.clickOnSectionWidgets().clickOnProgressBar();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(progressBarPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateCorrectLabelText(){
        logger.info("-------------------validateCorrectLabelText-----------------------");
        Assert.assertEquals(progressBarPage.getLabelText(), PAGE_TITLE);
    }

    @Test
    public void validateProgressBar(){
        logger.info("-------------------validateProgressBar-----------------------");
        progressBarPage.startProgressBarAndWaitTo100Percent();
        Assert.assertEquals(progressBarPage.getPercentText(), FULL_BAR_PERCENTAGE);
    }

    @Test
    public void validateReturnToBasePage(){
        logger.info("-------------------validateReturnToBasePage-----------------------");
        progressBarPage.startProgressBarTillEndAndRestartBar();
        Assert.assertEquals(progressBarPage.getPercentText(), EMPTY_BAR_PERCENTAGE);
    }
}