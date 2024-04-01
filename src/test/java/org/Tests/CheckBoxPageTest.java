package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(CheckBoxPageTest.class);
    private final String PAGE_TITLE = "Check Box";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing CheckBoxPageTest Class------------------");
        checkBoxPage = homePage.clickOnSectionElements().clickOnCheckBoxSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(checkBoxPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void ValidateDesktopIsClicked(){
        logger.info("-------------------ValidateDesktopIsClicked-----------------------");
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInDesktopElements();
        Assert.assertTrue(checkBoxPage.checkBoxDesktopIsClicked());

    }

    @Test
    public void validateDocumentsIsClicked(){
        logger.info("-------------------validateDocumentsIsClicked-----------------------");
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInWorkspaceElements();
        checkBoxPage.clickInOfficeElements();
        Assert.assertTrue(checkBoxPage.checkDocumentsClicked());
    }

    @Test
    public void validateDownloadsIsClicked(){
        logger.info("-------------------validateDownloadsIsClicked-----------------------");
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInDownloadElements();
        Assert.assertTrue(checkBoxPage.checkDownloadsClicked());
    }
}
