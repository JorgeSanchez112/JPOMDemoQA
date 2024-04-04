package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(NestedFramesPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing NestedFramesPageTest Class------------------");
        nestedFramesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnNestedFrames();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Nested Frames";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(nestedFramesPage.getPageTitleText(), PAGE_TITLE);

    }

    @Test(groups = {"UI"})
    public void validateUsesAdviceIsVisible(){
        logger.info("-------------------validateUsesAdviceIsVisible-----------------------");
        Assert.assertTrue(nestedFramesPage.isUseAdvicesVisible());
    }

    @Test(groups = {"Functional"})
    public void validateSwitchToParentFrame(){
        String PARENT_FRAME = "Parent frame";

        logger.info("-------------------validateSwitchToParentFrame-----------------------");
        nestedFramesPage.switchToParentFrame();
        Assert.assertEquals(nestedFramesPage.getParentText(), PARENT_FRAME);
    }

    @Test(groups = {"Functional"})
    public void validateSwitchToChildFrame(){
        String CHILD_FRAME = "Child Iframe";

        logger.info("-------------------validateSwitchToChildFrame-----------------------");
        nestedFramesPage.switchToParentFrame();
        nestedFramesPage.switchToChildFrame();
        Assert.assertEquals(nestedFramesPage.getChildText(), CHILD_FRAME);
    }
}