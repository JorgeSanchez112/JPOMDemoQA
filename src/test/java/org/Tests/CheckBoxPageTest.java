package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckBoxPageTest extends TestBase {
    private final String PAGE_TITLE = "Check Box";

    @BeforeMethod
    public void initializeClass(){
      checkBoxPage = homePage.clickOnSectionElements().clickOnCheckBoxSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(checkBoxPage.getPageTitleText(),PAGE_TITLE);
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
