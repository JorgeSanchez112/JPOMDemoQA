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
    public void validateYesLabelIsCorrect(String yesRadioButtonMessage){
        Assert.assertEquals(radioButtonPage.getYesLabelText(),yesRadioButtonMessage);
    }

    @Parameters("impressiveRadioButtonMessage")
    @Test
    public void validateImpressiveLabelIsCorrect(String impressiveRadioButtonMessage){
        Assert.assertEquals(radioButtonPage.getImpressiveLabelText(),impressiveRadioButtonMessage);
    }

    @Parameters("thirdLabel")
    @Test
    public void validateNoLabelIsCorrect(String thirdLabel){
        Assert.assertEquals(radioButtonPage.getNoLabelText(),thirdLabel);
    }

    @Parameters("yesRadioButtonMessage")
    @Test
    public void validateYesRadioButton(String yesRadioButtonMessage){
        radioButtonPage.clickOnYesRB();
        Assert.assertEquals(radioButtonPage.response(),yesRadioButtonMessage);
    }

    @Parameters("impressiveRadioButtonMessage")
    @Test
    public void validateImpressiveRadioButton(String impressiveRadioButtonMessage){
        radioButtonPage.clickOnImpressiveRB();
        Assert.assertEquals(radioButtonPage.response(),impressiveRadioButtonMessage);
    }

    @Test
    public void validateDisabledRadioButton(){
        Assert.assertFalse(radioButtonPage.isRadioButtonEnabled());
    }

}