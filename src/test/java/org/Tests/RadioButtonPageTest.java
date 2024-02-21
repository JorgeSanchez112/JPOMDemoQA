package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadioButtonPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        radioButtonPage = homePage.clickOnSectionElements().clickOnRadioButtonSection();
    }
    //CHANGE ALL
    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(radioButtonPage.getPageTitleText(), pageTitle);
    }

    @Test
    public void validateSubtitleIsVisible(){
        Assert.assertTrue(radioButtonPage.isSubtitleVisible());
    }

    @Parameters("yesRadioButtonMessage")
    @Test
    public void validateYesRadioButton(String yesRadioButtonMessage){
        radioButtonPage.clickOnYesRB();
        Assert.assertEquals(radioButtonPage.response(),yesRadioButtonMessage);
    }

    @Parameters("ImpressiveRadioButtonMessage")
    @Test
    public void validateImpressiveRadioButton(String ImpressiveRadioButtonMessage){
        radioButtonPage.clickOnImpressiveRB();
        Assert.assertEquals(radioButtonPage.response(),ImpressiveRadioButtonMessage);
    }

    @Test
    public void validateDisabledRadioButton(){
        Assert.assertFalse(radioButtonPage.isRadioButtonEnabled());
    }

}
