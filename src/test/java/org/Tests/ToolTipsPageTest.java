package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsPageTest extends TestBase {
    private final String PAGE_TITLE = "Tool Tips";
    private final String SUB_TITLE = "Practice Tool Tips";
    private final String BUTTON_HOVER = "buttonToolTip";
    private final String INPUT_HOVER = "textFieldToolTip";
    private final String CONTRARY_LINK_HOVER = "contraryTexToolTip";
    private final String VERSION_LINK_HOVER = "sectionToolTip";


    @BeforeMethod
    public void initializeClass(){
        toolTipsPage = homePage.clickOnSectionWidgets().clickOnToolTips();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(toolTipsPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateCorrectLabel(){
        Assert.assertEquals(toolTipsPage.getLabelText(),SUB_TITLE);
    }

    @Test
    public void validateButtonHover(){
        toolTipsPage.moveClickerTOHoverButton();
        Assert.assertEquals(toolTipsPage.getTextFromButtonHoverAttribute(),BUTTON_HOVER);
    }

    @Test
    public void validateInputHover(){
        toolTipsPage.moveClickerTOHoverInput();
        Assert.assertEquals(toolTipsPage.getTextFromInputHoverAttribute(),INPUT_HOVER);
    }

    @Test
    public void validateContraryLinkHover(){
        toolTipsPage.moveClickerTOContraryLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverContraryLinkAttribute(),CONTRARY_LINK_HOVER);
    }

    @Test
    public void validateVersionLinkHover()  {
        toolTipsPage.moveClickerTOVersionLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverVersionLinkAttribute(),VERSION_LINK_HOVER);
    }
}