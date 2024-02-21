package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NestedFramesPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        nestedFramesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnNestedFrames();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(nestedFramesPage.getPageTitleText(),pageTitle);

    }

    @Test
    public void validateUsesAdviceIsVisible(){
        Assert.assertTrue(nestedFramesPage.isUseAdvicesVisible());
    }

    @Parameters("parentFrame")
    @Test
    public void validateSwitchToParentFrame(String parentFrame){
        nestedFramesPage.switchToParentFrame();
        Assert.assertEquals(nestedFramesPage.getParentText(),parentFrame);
    }

    @Parameters("childIframe")
    @Test
    public void validateSwitchToChildFrame(String childIframe){
        nestedFramesPage.switchToParentFrame();
        nestedFramesPage.switchToChildFrame();
        Assert.assertEquals(nestedFramesPage.getChildText(),childIframe);
    }

}
