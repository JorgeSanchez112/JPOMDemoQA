package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UploadDownloadPageTest extends TestBase {
    private final String PAGE_TITLE = "Upload and Download";

    @BeforeMethod
    public void initializeClass(){
        uploadDownloadPage = homePage.clickOnSectionElements().clickOnUploadDownloadSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(uploadDownloadPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateArchiveDownloaded(){
        uploadDownloadPage.clickOnDownloadButton();
        uploadDownloadPage.searchFileInSelectFile();

        Assert.assertEquals(uploadDownloadPage.getFilePathText(), uploadDownloadPage.getNameDownloadedFile());
    }
}