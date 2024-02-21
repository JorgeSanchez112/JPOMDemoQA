package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        dynamicProperties = homePage.clickOnSectionElements().clickOnDynamicPropertiesSection();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(dynamicProperties.getPageTitleText(),pageTitle);
    }

    @Test
    public void validateDynamicTextIsVisible(){
        Assert.assertTrue(dynamicProperties.isRandomIdVisible());
    }

    @Test
    public void validateFirstButtonIsEnable(){
        Assert.assertTrue(dynamicProperties.isButtonEnable());
    }

    @Test
    public void validateSecondButtonTextColorChange(){
        Assert.assertEquals(dynamicProperties.getButtonTextColor(), prop.getProperty("RGBARedColor"));
    }

    @Test
    public void validateThirdButtonIsVisible(){
        Assert.assertTrue(dynamicProperties.buttonIsVisible());
    }
}
