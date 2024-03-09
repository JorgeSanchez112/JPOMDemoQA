package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadioButtonPageTest extends TestBase {
    private final String PAGE_TITLE = "Radio Button";
    private final String YES_RADIO_BUTTON = "Yes";
    private final String IMPRESSIVE_RADIO_BUTTON = "Impressive";
    private final String NO_RADIO_BUTTON = "No";

    @BeforeMethod
    public void initializeClass(){
        radioButtonPage = homePage.clickOnSectionElements().clickOnRadioButtonSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(radioButtonPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test
    public void validateSubtitleIsVisible(){
        Assert.assertTrue(radioButtonPage.isSubtitleVisible());
    }

    @Test
    public void validateYesLabelIsCorrect(){
        Assert.assertEquals(radioButtonPage.getYesLabelText(),YES_RADIO_BUTTON);
    }

    @Test
    public void validateImpressiveLabelIsCorrect(){
        Assert.assertEquals(radioButtonPage.getImpressiveLabelText(),IMPRESSIVE_RADIO_BUTTON);
    }

    @Test
    public void validateNoLabelIsCorrect(){
        Assert.assertEquals(radioButtonPage.getNoLabelText(),NO_RADIO_BUTTON);
    }

    @Test
    public void validateYesRadioButton(){
        radioButtonPage.clickOnYesRB();
        Assert.assertEquals(radioButtonPage.response(),YES_RADIO_BUTTON);
    }

    @Test
    public void validateImpressiveRadioButton(){
        radioButtonPage.clickOnImpressiveRB();
        Assert.assertEquals(radioButtonPage.response(),IMPRESSIVE_RADIO_BUTTON);
    }

    @Test
    public void validateDisabledRadioButton(){
        Assert.assertFalse(radioButtonPage.isRadioButtonEnabled());
    }

}