package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FramesPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        framesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnFrames();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(framesPage.getPageTitleText(),pageTitle);
    }

    @Test
    public void validateUseAdviceTextIsVisible(){
        Assert.assertTrue(framesPage.isUseAdvicesTextVisible());
    }

    @Parameters("frameText")
    @Test
    public void validateChangeToBigFrame(String frameText){
        framesPage.switchToBigFrame();
        Assert.assertEquals(framesPage.getFrameText(),frameText);
    }

    @Parameters("frameText")
    @Test
    public void validateChangeToShortFrame(String frameText){
        framesPage.switchToShortFrame();
        Assert.assertEquals(framesPage.getFrameText(),frameText);
    }
}
