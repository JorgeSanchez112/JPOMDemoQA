package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(ButtonsPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing ButtonsPageTest Class------------------");
        buttonsPage = homePage.clickOnSectionElements().clickOnButtonsSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Buttons";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(buttonsPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"Functional"})
    public void validateDoubleClickInABtn(){
        String DOUBLE_CLICK_MESSAGE = "You have done a double click";

        logger.info("-------------------validateDoubleClickInABtn-----------------------");
        buttonsPage.clickOnDoubleBtn();
        Assert.assertEquals(buttonsPage.getDoubleClickMessageText(), DOUBLE_CLICK_MESSAGE);
    }

    @Test(groups = {"Functional"})
    public void validateRightClickInABtn(){
        String RIGHT_CLICK_MESSAGE = "You have done a right click";

        logger.info("-------------------validateRightClickInABtn-----------------------");
        buttonsPage.clickOnRightBtn();
        Assert.assertEquals(buttonsPage.getRightClickMessageText(), RIGHT_CLICK_MESSAGE);
    }

    @Test(groups = {"Functional"})
    public void validateClickInABtn(){
        String RADIO_BUTTON = "You have done a dynamic click";

        logger.info("-------------------validateClickInABtn-----------------------");
        buttonsPage.clickOnClickMe();
        Assert.assertEquals(buttonsPage.getClickMeMessageText(), RADIO_BUTTON);
    }
}