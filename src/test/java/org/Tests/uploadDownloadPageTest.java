package org.Tests;

import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class uploadDownloadPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(uploadDownloadPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing UploadDownloadPageTest Class------------------");
        uploadDownloadPage = homePage.clickOnSectionElements().clickOnUploadDownloadSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Upload and Download";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(uploadDownloadPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"Functional"})
    public void validateArchiveDownloaded(){
        logger.info("-------------------validateArchiveDownloaded-----------------------");
        uploadDownloadPage.clickOnDownloadButton();
        uploadDownloadPage.searchFileInSelectFile();
        Assert.assertEquals(uploadDownloadPage.getFilePathText(), uploadDownloadPage.getNameDownloadedFile());
    }
}