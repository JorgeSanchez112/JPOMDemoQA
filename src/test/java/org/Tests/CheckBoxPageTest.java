package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckBoxPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
      checkBoxPage = homePage.clickOnSectionElements().clickOnCheckBoxSection();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(checkBoxPage.getPageTitleText(),pageTitle);
    }

    @Test
    public void ValidateDesktopIsClicked(){
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInDesktopElements();
        Assert.assertTrue(checkBoxPage.checkBoxDesktopIsClicked());

    }

    @Test
    public void validateDocumentsIsClicked(){
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInWorkspaceElements();
        checkBoxPage.clickInOfficeElements();
        Assert.assertTrue(checkBoxPage.checkDocumentsClicked());
    }

    @Test
    public void validateDownloadsIsClicked(){
        checkBoxPage.clickOnExpandButton();
        checkBoxPage.clickInDownloadElements();
        Assert.assertTrue(checkBoxPage.checkDownloadsClicked());
    }
}
