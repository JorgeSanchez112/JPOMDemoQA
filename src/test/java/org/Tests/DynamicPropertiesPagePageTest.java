package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesPagePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(DynamicPropertiesPagePageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing DynamicPropertiesPagePageTest Class------------------");
        dynamicPropertiesPage = homePage.clickOnSectionElements().clickOnDynamicPropertiesSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = "UI")
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Dynamic Properties";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(dynamicPropertiesPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = "UI")
    public void validateDynamicTextIsVisible(){
        logger.info("-------------------validateDynamicTextIsVisible-----------------------");
        Assert.assertTrue(dynamicPropertiesPage.isRandomIdVisible());
    }

    @Test(groups = "Functional")
    public void validateFirstButtonIsEnable(){
        logger.info("-------------------validateFirstButtonIsEnable-----------------------");
        Assert.assertTrue(dynamicPropertiesPage.isButtonEnable());
    }

    @Test(groups = "UI")
    public void validateSecondButtonTextColorChange(){
        String RGBA_RED_COLOR = "rgba(220, 53, 69, 1)";

        logger.info("-------------------validateSecondButtonTextColorChange-----------------------");
        Assert.assertEquals(dynamicPropertiesPage.getButtonTextColor(), RGBA_RED_COLOR);
    }

    @Test(groups = "UI")
    public void validateThirdButtonIsVisible(){
        logger.info("-------------------validateThirdButtonIsVisible-----------------------");
        Assert.assertTrue(dynamicPropertiesPage.buttonIsVisible());
    }
}