package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(ToolTipsPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing ToolTipsPageTest Class------------------");
        toolTipsPage = homePage.clickOnSectionWidgets().clickOnToolTips();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Tool Tips";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(toolTipsPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectLabel(){
        String SUB_TITLE = "Practice Tool Tips";

        logger.info("-------------------validateCorrectLabel-----------------------");
        Assert.assertEquals(toolTipsPage.getLabelText(), SUB_TITLE);
    }

    @Test(groups = "Functional")
    public void validateButtonHover(){
        String BUTTON_HOVER = "buttonToolTip";

        logger.info("-------------------validateButtonHover-----------------------");
        toolTipsPage.moveClickerTOHoverButton();
        Assert.assertEquals(toolTipsPage.getTextFromButtonHoverAttribute(), BUTTON_HOVER);
    }

    @Test(groups = "Functional")
    public void validateInputHover(){
        String INPUT_HOVER = "textFieldToolTip";

        logger.info("-------------------validateInputHover-----------------------");
        toolTipsPage.moveClickerTOHoverInput();
        Assert.assertEquals(toolTipsPage.getTextFromInputHoverAttribute(), INPUT_HOVER);
    }

    @Test(groups = "Functional")
    public void validateContraryLinkHover(){
        String CONTRARY_LINK_HOVER = "contraryTexToolTip";

        logger.info("-------------------validateContraryLinkHover-----------------------");
        toolTipsPage.moveClickerTOContraryLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverContraryLinkAttribute(), CONTRARY_LINK_HOVER);
    }

    @Test(groups = "Functional")
    public void validateVersionLinkHover(){
        String VERSION_LINK_HOVER = "sectionToolTip";

        logger.info("-------------------validateVersionLinkHover-----------------------");
        toolTipsPage.moveClickerTOVersionLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverVersionLinkAttribute(), VERSION_LINK_HOVER);
    }
}