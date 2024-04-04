package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BrowserWindowsPagePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(BrowserWindowsPagePageTest.class);
    private final String URL_SAMPLE_PAGE = "https://demoqa.com/sample";

    @BeforeMethod(groups = {"UI","Smoke"})
    public void InitializeClass(){
        logger.info("-------------------Initializing BrowserWindowsPagePageTest Class------------------");
        browserWindowsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnBrowserWindows();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Browser Windows";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(browserWindowsPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"Smoke"})
    public void validateChangeOfTab(){
        logger.info("-------------------validateChangeOfTab-----------------------");
        browserWindowsPage.clickOnNewTabButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getBrowserWindowsUrlText(), URL_SAMPLE_PAGE);
        Assert.assertTrue(browserWindowsPage.newTabTextIsVisible());
    }

    @Test(groups = {"Smoke"})
    public void validateNewWindowAppear(){
        logger.info("-------------------validateNewWindowAppear-----------------------");
        browserWindowsPage.clickOnNewWindowButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getBrowserWindowsUrlText(), URL_SAMPLE_PAGE);
        Assert.assertTrue(browserWindowsPage.newTabTextIsVisible());
    }

    @Test(groups = {"Smoke"})
    public void validateNewWindowMessage(){
        String MESSAGE_NEW_WINDOW = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

        logger.info("-------------------validateNewWindowMessage-----------------------");
        browserWindowsPage.clickOnNewWindowMessageButton();
        browserWindowsPage.switchToTab();
        Assert.assertEquals(browserWindowsPage.getMessageOfNewWindow(), MESSAGE_NEW_WINDOW);
    }
}