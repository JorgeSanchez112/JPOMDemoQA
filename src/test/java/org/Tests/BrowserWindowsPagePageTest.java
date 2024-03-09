package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BrowserWindowsPagePageTest extends TestBase {
    private final String PAGE_TITLE = "Browser Windows";
    private final String URL_SAMPLE_PAGE = "https://demoqa.com/sample";
    private final String MESSAGE_NEW_WINDOW = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

    @BeforeMethod
    public void InitializeClass(){
        browserWindowsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnBrowserWindows();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(browserWindowsPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test
    public void validateChangeOfTab(){
        browserWindowsPage.clickOnNewTabButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getBrowserWindowsUrlText(), URL_SAMPLE_PAGE);
        Assert.assertTrue(browserWindowsPage.newTabTextIsVisible());
    }

    @Test
    public void validateNewWindowAppear(){
        browserWindowsPage.clickOnNewWindowButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getBrowserWindowsUrlText(), URL_SAMPLE_PAGE);
        Assert.assertTrue(browserWindowsPage.newTabTextIsVisible());
    }

    @Test
    public void validateNewWindowMessage(){
        browserWindowsPage.clickOnNewWindowMessageButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getMessageOfNewWindow(), MESSAGE_NEW_WINDOW);
    }
}