package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(FramesPageTest.class);
    private final String FRAME_TEXT = "This is a sample page";

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing FramesPageTest Class------------------");
        framesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnFrames();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Frames";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(framesPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateUseAdviceTextIsVisible(){
        logger.info("-------------------validateUseAdviceTextIsVisible-----------------------");
        Assert.assertTrue(framesPage.isUseAdvicesTextVisible());
    }

    @Test(groups = {"Functional"})
    public void validateChangeToBigFrame(){
        logger.info("-------------------validateChangeToBigFrame-----------------------");
        framesPage.switchToBigFrame();
        Assert.assertEquals(framesPage.getFrameText(),FRAME_TEXT);
    }

    @Test(groups = {"Functional"})
    public void validateChangeToShortFrame(){
        logger.info("-------------------validateChangeToShortFrame-----------------------");
        framesPage.switchToShortFrame();
        Assert.assertEquals(framesPage.getFrameText(),FRAME_TEXT);
    }
}