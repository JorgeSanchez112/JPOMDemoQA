package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesPageTest extends TestBase {
    private final String PAGE_TITLE = "Nested Frames";
    private final String PARENT_FRAME = "Parent frame";
    private final String CHILD_FRAME = "Child Iframe";

    @BeforeMethod
    public void initializeClass(){
        nestedFramesPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnNestedFrames();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(nestedFramesPage.getPageTitleText(),PAGE_TITLE);

    }

    @Test
    public void validateUsesAdviceIsVisible(){
        Assert.assertTrue(nestedFramesPage.isUseAdvicesVisible());
    }

    @Test
    public void validateSwitchToParentFrame(){
        nestedFramesPage.switchToParentFrame();
        Assert.assertEquals(nestedFramesPage.getParentText(),PARENT_FRAME);
    }

    @Test
    public void validateSwitchToChildFrame(){
        nestedFramesPage.switchToParentFrame();
        nestedFramesPage.switchToChildFrame();
        Assert.assertEquals(nestedFramesPage.getChildText(),CHILD_FRAME);
    }
}