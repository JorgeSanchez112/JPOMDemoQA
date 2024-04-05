package org.Tests;

import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class framesPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(framesPageTest.class);
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