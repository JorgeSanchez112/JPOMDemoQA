package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenLinksPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(BrokenLinksPageTest.class);
    private final String PAGE_TITLE = "Broken Links - Images";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing BrokenLinksPageTest Class------------------");
        brokenLinksPage = homePage.clickOnSectionElements().clickOnBrokenLinksImageSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(brokenLinksPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateImage() throws IOException {
        logger.info("-------------------validateImage-----------------------");
        Assert.assertTrue(brokenLinksPage.isDisplayedValidImage());
    }

    @Test
    public void validateBrokeImage() throws IOException {
        logger.info("-------------------validateBrokeImage-----------------------");
        Assert.assertTrue(brokenLinksPage.isDisplayedBrokenImage());
    }

    @Test
    public void validateLink() throws IOException {
        logger.info("-------------------validateLink-----------------------");
        Assert.assertFalse(brokenLinksPage.isAValidLink());
    }

    @Test
    public void validateBrokenLink() throws IOException {
        logger.info("-------------------validateBrokenLink-----------------------");
        Assert.assertFalse(brokenLinksPage.isABrokenLink());
    }
}
