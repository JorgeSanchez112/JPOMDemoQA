package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ToolTipsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        toolTipsPage = homePage.clickOnSectionWidgets().clickOnToolTips();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(toolTipsPage.getPageTitleText(),pageTitle);
    }

    @Parameters("subTitle")
    @Test
    public void validateCorrectLabel(String subTitle){
        Assert.assertEquals(toolTipsPage.getLabelText(),subTitle);
    }

    @Test
    public void validateButtonHover(){
        toolTipsPage.moveClickerTOHoverButton();
        Assert.assertEquals(toolTipsPage.getTextFromButtonHoverAttribute(), prop.getProperty("buttonHover"));
    }

    @Test
    public void validateInputHover(){
        toolTipsPage.moveClickerTOHoverInput();
        Assert.assertEquals(toolTipsPage.getTextFromInputHoverAttribute(), prop.getProperty("inputHover"));
    }

    @Test
    public void validateContraryLinkHover(){
        toolTipsPage.moveClickerTOContraryLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverContraryLinkAttribute(), prop.getProperty("contraryLinkHover"));
    }

    @Test
    public void validateVersionLinkHover()  {
        toolTipsPage.moveClickerTOVersionLink();
        Assert.assertEquals(toolTipsPage.getTextFromHoverVersionLinkAttribute(), prop.getProperty("versionLinkHover"));
    }
}
