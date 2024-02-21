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

    @Test
    public void validateChangeToBigFrame(){
        framesPage.switchToBigFrame();
        Assert.assertTrue(framesPage.validateTextFrames());
    }

    @Test
    public void validateChangeToShortFrame(){
        framesPage.switchToShortFrame();
        Assert.assertTrue(framesPage.validateTextFrames());
    }
}
