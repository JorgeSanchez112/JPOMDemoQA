package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(NestedFramesPageTest.class);
    private final String PAGE_TITLE = "Nested Frames";
    private final String PARENT_FRAME = "Parent frame";
    private final String CHILD_FRAME = "Child Iframe";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing NestedFramesPageTest Class------------------");
        nestedFramesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnNestedFrames();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(nestedFramesPage.getPageTitleText(),PAGE_TITLE);

    }

    @Test
    public void validateUsesAdviceIsVisible(){
        logger.info("-------------------validateUsesAdviceIsVisible-----------------------");
        Assert.assertTrue(nestedFramesPage.isUseAdvicesVisible());
    }

    @Test
    public void validateSwitchToParentFrame(){
        logger.info("-------------------validateSwitchToParentFrame-----------------------");
        nestedFramesPage.switchToParentFrame();
        Assert.assertEquals(nestedFramesPage.getParentText(),PARENT_FRAME);
    }

    @Test
    public void validateSwitchToChildFrame(){
        logger.info("-------------------validateSwitchToChildFrame-----------------------");
        nestedFramesPage.switchToParentFrame();
        nestedFramesPage.switchToChildFrame();
        Assert.assertEquals(nestedFramesPage.getChildText(),CHILD_FRAME);
    }
}