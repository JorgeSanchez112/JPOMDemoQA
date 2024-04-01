package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(FramesPageTest.class);
    private final String PAGE_TITLE = "Frames";
    private final String FRAME_TEXT = "This is a sample page";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing FramesPageTest Class------------------");
        framesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnFrames();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(framesPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateUseAdviceTextIsVisible(){
        logger.info("-------------------validateUseAdviceTextIsVisible-----------------------");
        Assert.assertTrue(framesPage.isUseAdvicesTextVisible());
    }

    @Test
    public void validateChangeToBigFrame(){
        logger.info("-------------------validateChangeToBigFrame-----------------------");
        framesPage.switchToBigFrame();
        Assert.assertEquals(framesPage.getFrameText(),FRAME_TEXT);
    }

    @Test
    public void validateChangeToShortFrame(){
        logger.info("-------------------validateChangeToShortFrame-----------------------");
        framesPage.switchToShortFrame();
        Assert.assertEquals(framesPage.getFrameText(),FRAME_TEXT);
    }
}
