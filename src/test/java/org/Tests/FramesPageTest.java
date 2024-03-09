package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesPageTest extends TestBase {
    private final String PAGE_TITLE = "Frames";
    private final String FRAME_TEXT = "This is a sample page";

    @BeforeMethod
    public void initializeClass(){
        framesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnFrames();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(framesPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateUseAdviceTextIsVisible(){
        Assert.assertTrue(framesPage.isUseAdvicesTextVisible());
    }

    @Test
    public void validateChangeToBigFrame(){
        framesPage.switchToBigFrame();
        Assert.assertEquals(framesPage.getFrameText(),FRAME_TEXT);
    }

    @Test
    public void validateChangeToShortFrame(){
        framesPage.switchToShortFrame();
        Assert.assertEquals(framesPage.getFrameText(),FRAME_TEXT);
    }
}
