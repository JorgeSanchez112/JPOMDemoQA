package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(RadioButtonPageTest.class);
    private final String PAGE_TITLE = "Radio Button";
    private final String YES_RADIO_BUTTON = "Yes";
    private final String IMPRESSIVE_RADIO_BUTTON = "Impressive";
    private final String NO_RADIO_BUTTON = "No";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing RadioButtonPageTest Class------------------");
        radioButtonPage = homePage.clickOnSectionElements().clickOnRadioButtonSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(radioButtonPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test
    public void validateSubtitleIsVisible(){
        logger.info("-------------------validateSubtitleIsVisible-----------------------");
        Assert.assertTrue(radioButtonPage.isSubtitleVisible());
    }

    @Test
    public void validateYesLabelIsCorrect(){
        logger.info("-------------------validateYesLabelIsCorrect-----------------------");
        Assert.assertEquals(radioButtonPage.getYesLabelText(),YES_RADIO_BUTTON);
    }

    @Test
    public void validateImpressiveLabelIsCorrect(){
        logger.info("-------------------validateImpressiveLabelIsCorrect-----------------------");
        Assert.assertEquals(radioButtonPage.getImpressiveLabelText(),IMPRESSIVE_RADIO_BUTTON);
    }

    @Test
    public void validateNoLabelIsCorrect(){
        logger.info("-------------------validateNoLabelIsCorrect-----------------------");
        Assert.assertEquals(radioButtonPage.getNoLabelText(),NO_RADIO_BUTTON);
    }

    @Test
    public void validateYesRadioButton(){
        logger.info("-------------------validateYesRadioButton-----------------------");
        radioButtonPage.clickOnYesRB();
        Assert.assertEquals(radioButtonPage.response(),YES_RADIO_BUTTON);
    }

    @Test
    public void validateImpressiveRadioButton(){
        logger.info("-------------------validateImpressiveRadioButton-----------------------");
        radioButtonPage.clickOnImpressiveRB();
        Assert.assertEquals(radioButtonPage.response(),IMPRESSIVE_RADIO_BUTTON);
    }

    @Test
    public void validateDisabledRadioButton(){
        logger.info("-------------------validateDisabledRadioButton-----------------------");
        Assert.assertFalse(radioButtonPage.isRadioButtonEnabled());
    }

}