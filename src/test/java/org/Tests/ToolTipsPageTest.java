package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(ToolTipsPageTest.class);
    private final String PAGE_TITLE = "Tool Tips";
    private final String SUB_TITLE = "Practice Tool Tips";
    private final String BUTTON_HOVER = "buttonToolTip";
    private final String INPUT_HOVER = "textFieldToolTip";
    private final String CONTRARY_LINK_HOVER = "contraryTexToolTip";
    private final String VERSION_LINK_HOVER = "sectionToolTip";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing ToolTipsPageTest Class------------------");
        toolTipsPage = homePage.clickOnSectionWidgets().clickOnToolTips();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(toolTipsPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateCorrectLabel(){
        logger.info("-------------------validateCorrectLabel-----------------------");
        Assert.assertEquals(toolTipsPage.getLabelText(),SUB_TITLE);
    }

    @Test
    public void validateButtonHover(){
        logger.info("-------------------validateButtonHover-----------------------");
        toolTipsPage.moveClickerTOHoverButton();
        Assert.assertEquals(toolTipsPage.getTextFromButtonHoverAttribute(),BUTTON_HOVER);
    }

    @Test
    public void validateInputHover(){
        logger.info("-------------------validateInputHover-----------------------");
        toolTipsPage.moveClickerTOHoverInput();
        Assert.assertEquals(toolTipsPage.getTextFromInputHoverAttribute(),INPUT_HOVER);
    }

    @Test
    public void validateContraryLinkHover(){
        logger.info("-------------------validateContraryLinkHover-----------------------");
        toolTipsPage.moveClickerTOContraryLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverContraryLinkAttribute(),CONTRARY_LINK_HOVER);
    }

    @Test
    public void validateVersionLinkHover(){
        logger.info("-------------------validateVersionLinkHover-----------------------");
        toolTipsPage.moveClickerTOVersionLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverVersionLinkAttribute(),VERSION_LINK_HOVER);
    }
}