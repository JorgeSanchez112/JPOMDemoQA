package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BSAPITest extends TestBase {
    private final Logger logger = LogManager.getLogger(BSAPITest.class);

    @BeforeMethod(groups = {"UI"})
    public void initializeClass(){
        logger.info("-------------------Initializing BSAPITest Class------------------");
        bsapiPage = homePage.clickOnSectionBookStoreApplication().clickOnBookstoreApi();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void isBookStoreAPITitleVisible(){
        logger.info("-------------------isBookStoreAPITitleVisible-----------------------");
        Assert.assertTrue(bsapiPage.isTitleVisible());
    }

    @Test(groups = {"UI"})
    public void isAccountSubtitleVisible(){
        logger.info("-------------------isAccountSubtitleVisible-----------------------");
        Assert.assertTrue(bsapiPage.isAccountSubtitleVisible());
    }

    @Test(groups = {"UI"})
    public void isBookstoreSubtitleVisible(){
        logger.info("-------------------isBookstoreSubtitleVisible-----------------------");
        Assert.assertTrue(bsapiPage.isBookstoreSubtitleVisible());
    }
}
