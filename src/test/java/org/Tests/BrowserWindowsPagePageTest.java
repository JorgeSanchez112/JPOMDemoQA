package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BrowserWindowsPagePageTest extends TestBase {
    @BeforeMethod
    public void InitializeClass(){
        browserWindowsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnBrowserWindows();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(browserWindowsPage.getPageTitleText(), pageTitle);
    }

    @Parameters("uRLOfSamplePage")
    @Test
    public void validateChangeOfTab(String uRLOfSamplePage){
        browserWindowsPage.clickOnNewTabButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getBrowserWindowsUrlText(), uRLOfSamplePage);
        Assert.assertTrue(browserWindowsPage.newTabTextIsVisible());
    }

    @Parameters("uRLOfSamplePage")
    @Test
    public void validateNewWindowAppear(String uRLOfSamplePage){
        browserWindowsPage.clickOnNewWindowButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getBrowserWindowsUrlText(), uRLOfSamplePage);
        Assert.assertTrue(browserWindowsPage.newTabTextIsVisible());
    }

    @Parameters("messageOfNewWindow")
    @Test
    public void validateNewWindowMessage(String messageOfNewWindow){
        browserWindowsPage.clickOnNewWindowMessageButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getMessageOfNewWindow(), messageOfNewWindow);
    }
}
