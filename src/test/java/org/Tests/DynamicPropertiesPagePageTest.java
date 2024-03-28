package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesPagePageTest extends TestBase {
    private Logger logger = LogManager.getLogger(DynamicPropertiesPagePageTest.class);
    private final String PAGE_TITLE = "Dynamic Properties";
    private final String RGBA_RED_COLOR = "rgba(220, 53, 69, 1)";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing DynamicPropertiesPagePageTest Class------------------");
        dynamicPropertiesPage = homePage.clickOnSectionElements().clickOnDynamicPropertiesSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(dynamicPropertiesPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateDynamicTextIsVisible(){
        logger.info("-------------------validateDynamicTextIsVisible-----------------------");
        Assert.assertTrue(dynamicPropertiesPage.isRandomIdVisible());
    }

    @Test
    public void validateFirstButtonIsEnable(){
        logger.info("-------------------validateFirstButtonIsEnable-----------------------");
        Assert.assertTrue(dynamicPropertiesPage.isButtonEnable());
    }

    @Test
    public void validateSecondButtonTextColorChange(){
        logger.info("-------------------validateSecondButtonTextColorChange-----------------------");
        Assert.assertEquals(dynamicPropertiesPage.getButtonTextColor(), RGBA_RED_COLOR);
    }

    @Test
    public void validateThirdButtonIsVisible(){
        logger.info("-------------------validateThirdButtonIsVisible-----------------------");
        Assert.assertTrue(dynamicPropertiesPage.buttonIsVisible());
    }
}