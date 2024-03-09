package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicPropertiesPageTest extends TestBase {
    private final String PAGE_TITLE = "Dynamic Properties";

    @BeforeMethod
    public void initializeClass(){
        dynamicProperties = homePage.clickOnSectionElements().clickOnDynamicPropertiesSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(dynamicProperties.getPageTitleText(),PAGE_TITLE);
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
