package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenLinksPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(BrokenLinksPageTest.class);

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing BrokenLinksPageTest Class------------------");
        brokenLinksPage = homePage.clickOnSectionElements().clickOnBrokenLinksImageSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Broken Links - Images";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(brokenLinksPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateImage() throws IOException {
        logger.info("-------------------validateImage-----------------------");
        Assert.assertTrue(brokenLinksPage.isDisplayedValidImage());
    }

    @Test(groups = {"Smoke","Functional"})
    public void validateBrokeImage() throws IOException {
        logger.info("-------------------validateBrokeImage-----------------------");
        Assert.assertTrue(brokenLinksPage.isDisplayedBrokenImage());
    }

    @Test(groups = {"Smoke","Functional"})
    public void validateLink() throws IOException {
        logger.info("-------------------validateLink-----------------------");
        Assert.assertFalse(brokenLinksPage.isAValidLink());
    }

    @Test(groups = {"Smoke","Functional"})
    public void validateBrokenLink() throws IOException {
        logger.info("-------------------validateBrokenLink-----------------------");
        Assert.assertFalse(brokenLinksPage.isABrokenLink());
    }
}
