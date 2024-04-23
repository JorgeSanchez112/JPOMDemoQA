package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(ProgressBarPageTest.class);
    private final String PAGE_TITLE = "Progress Bar";

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing ProgressBarPageTest Class------------------");
        progressBarPage = homePage.clickOnSectionWidgets().clickOnProgressBar();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(progressBarPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectLabelText(){
        logger.info("-------------------validateCorrectLabelText-----------------------");
        Assert.assertEquals(progressBarPage.getLabelText(), PAGE_TITLE);
    }

    @Test(groups = {"Smoke"})
    public void validateProgressBar(){
        String FULL_BAR_PERCENTAGE = "100%";

        logger.info("-------------------validateProgressBar-----------------------");
        progressBarPage.startProgressBarAndWaitTo100Percent();
        Assert.assertEquals(progressBarPage.getPercentText(), FULL_BAR_PERCENTAGE);
    }

    @Test(groups = {"Functional"})
    public void validateReturnToBasePage(){
        String EMPTY_BAR_PERCENTAGE = "0%";

        logger.info("-------------------validateReturnToBasePage-----------------------");
        progressBarPage.startProgressBarTillEndAndRestartBar();
        Assert.assertEquals(progressBarPage.getPercentText(), EMPTY_BAR_PERCENTAGE);
    }
}