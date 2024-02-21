package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UploadDownloadPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        uploadDownloadPage = homePage.clickOnSectionElements().clickOnUploadDownloadSection();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(uploadDownloadPage.getPageTitleText(),pageTitle);
    }

    @Test
    public void validateArchiveDownloaded(){
        uploadDownloadPage.clickOnDownloadButton();
        uploadDownloadPage.searchFileInSelectFile();

        Assert.assertEquals(uploadDownloadPage.getFilePathText(), uploadDownloadPage.getNameDownloadedFile());
    }
}
