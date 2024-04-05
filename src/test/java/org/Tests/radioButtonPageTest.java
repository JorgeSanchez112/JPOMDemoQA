package org.Tests;

import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class radioButtonPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(radioButtonPageTest.class);
    private final String YES_RADIO_BUTTON = "Yes";
    private final String IMPRESSIVE_RADIO_BUTTON = "Impressive";

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing RadioButtonPageTest Class------------------");
        radioButtonPage = homePage.clickOnSectionElements().clickOnRadioButtonSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Radio Button";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(radioButtonPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateSubtitleIsVisible(){
        logger.info("-------------------validateSubtitleIsVisible-----------------------");
        Assert.assertTrue(radioButtonPage.isSubtitleVisible());
    }

    @Test(groups = {"UI"})
    public void validateYesLabelIsCorrect(){
        logger.info("-------------------validateYesLabelIsCorrect-----------------------");
        Assert.assertEquals(radioButtonPage.getYesLabelText(),YES_RADIO_BUTTON);
    }

    @Test(groups = {"UI"})
    public void validateImpressiveLabelIsCorrect(){
        logger.info("-------------------validateImpressiveLabelIsCorrect-----------------------");
        Assert.assertEquals(radioButtonPage.getImpressiveLabelText(),IMPRESSIVE_RADIO_BUTTON);
    }

    @Test(groups = {"UI"})
    public void validateNoLabelIsCorrect(){
        String NO_RADIO_BUTTON = "No";

        logger.info("-------------------validateNoLabelIsCorrect-----------------------");
        Assert.assertEquals(radioButtonPage.getNoLabelText(), NO_RADIO_BUTTON);
    }

    @Test(groups = {"UI"})
    public void validateYesRadioButton(){
        logger.info("-------------------validateYesRadioButton-----------------------");
        radioButtonPage.clickOnYesRB();
        Assert.assertEquals(radioButtonPage.response(),YES_RADIO_BUTTON);
    }

    @Test(groups = {"UI"})
    public void validateImpressiveRadioButton(){
        logger.info("-------------------validateImpressiveRadioButton-----------------------");
        radioButtonPage.clickOnImpressiveRB();
        Assert.assertEquals(radioButtonPage.response(),IMPRESSIVE_RADIO_BUTTON);
    }

    @Test(groups = {"Functional"})
    public void validateDisabledRadioButton(){
        logger.info("-------------------validateDisabledRadioButton-----------------------");
        Assert.assertFalse(radioButtonPage.isRadioButtonEnabled());
    }

}