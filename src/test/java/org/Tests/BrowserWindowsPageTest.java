package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BrowserWindowsPageTest extends TestBase {
    @BeforeMethod
    public void InitializeClass(){
        browserWindows = homePage.clickOnSectionAlerts_Frame_Windows().clickOnBrowserWindows();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(browserWindows.getPageTitleText(), pageTitle);

    }

    @Test
    public void validateChangeOfTab(){
        browserWindows.clickOnNewTabButton();
        browserWindows.switchToTab();
        Assert.assertEquals(browserWindows.getBrowserWindowsUrlText(),browserWindows.getUrlOfNewTabAndWindow());
        Assert.assertTrue(browserWindows.newTabTextIsVisible());
    }

    @Test
    public void validateNewWindowAppear(){
        browserWindows.clickOnNewWindowButton();
        browserWindows.switchToTab();
        Assert.assertEquals(browserWindows.getBrowserWindowsUrlText(),browserWindows.getUrlOfNewTabAndWindow());
        Assert.assertTrue(browserWindows.newTabTextIsVisible());
    }

    @Parameters("messageOfNewWindow")
    @Test
    public void validateNewWindowMessage(String messageOfNewWindow){
        browserWindows.clickOnNewWindowMessageButton();
        browserWindows.switchToTab();
        Assert.assertEquals(browserWindows.getMessageOfNewWindow(), messageOfNewWindow);
    }

}
