package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadDownloadPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(UploadDownloadPageTest.class);
    private final String PAGE_TITLE = "Upload and Download";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing UploadDownloadPageTest Class------------------");
        uploadDownloadPage = homePage.clickOnSectionElements().clickOnUploadDownloadSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(uploadDownloadPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateArchiveDownloaded(){
        logger.info("-------------------validateArchiveDownloaded-----------------------");
        uploadDownloadPage.clickOnDownloadButton();
        uploadDownloadPage.searchFileInSelectFile();
        Assert.assertEquals(uploadDownloadPage.getFilePathText(), uploadDownloadPage.getNameDownloadedFile());
    }
}