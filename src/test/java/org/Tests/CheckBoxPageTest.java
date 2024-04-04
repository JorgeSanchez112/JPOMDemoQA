package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(CheckBoxPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing CheckBoxPageTest Class------------------");
        checkBoxPage = homePage.clickOnSectionElements().clickOnCheckBoxSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Check Box";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(checkBoxPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"Functional"})
    public void ValidateDesktopIsClicked(){
        logger.info("-------------------ValidateDesktopIsClicked-----------------------");
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInDesktopElements();
        Assert.assertTrue(checkBoxPage.checkBoxDesktopIsClicked());

    }

    @Test(groups = {"Functional"})
    public void validateDocumentsIsClicked(){
        logger.info("-------------------validateDocumentsIsClicked-----------------------");
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInWorkspaceElements();
        checkBoxPage.clickInOfficeElements();
        Assert.assertTrue(checkBoxPage.checkDocumentsClicked());
    }

    @Test(groups = {"Functional"})
    public void validateDownloadsIsClicked(){
        logger.info("-------------------validateDownloadsIsClicked-----------------------");
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInDownloadElements();
        Assert.assertTrue(checkBoxPage.checkDownloadsClicked());
    }
}
