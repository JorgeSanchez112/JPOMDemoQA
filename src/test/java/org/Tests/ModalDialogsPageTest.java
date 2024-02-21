package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ModalDialogsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        modalDialogsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnModalDialogs();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(modalDialogsPage.getPageTitleText(),pageTitle);
    }

    @Test
    public void validateInstructionTextIsVisible(){
        Assert.assertTrue(modalDialogsPage.isInstructionsTextVisible());
    }

    @Parameters("smallModal")
    @Test
    public void validateSmallModalShowed(String smallModal){
        modalDialogsPage.clickOnSmallModalButton();
        Assert.assertEquals(modalDialogsPage.getSmallModalText(), smallModal);
    }

    @Parameters("largeModal")
    @Test
    public void validateLargeModalShowed(String largeModal){
        modalDialogsPage.clickOnLargeModalButton();
        Assert.assertEquals(modalDialogsPage.getLargeModalText(), largeModal);
    }

    @Test
    public void validateCloseButtonIsVisibleInSmallModel(){
        modalDialogsPage.clickOnSmallModalButton();
        Assert.assertTrue(modalDialogsPage.isCloseSmallModalVisible());
    }

    @Test
    public void validateCloseButtonIsVisibleInLargeModel(){
        modalDialogsPage.clickOnLargeModalButton();
        Assert.assertTrue(modalDialogsPage.isCloseLargeModalVisible());
    }
        
}
