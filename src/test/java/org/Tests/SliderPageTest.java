package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(SliderPageTest.class);

    @BeforeMethod(groups = {"UI","Smoke"})
    public void initializeClass(){
        logger.info("-------------------Initializing SliderPageTest Class------------------");
        sliderPage = homePage.clickOnSectionWidgets(getDriver()).clickOnSlider(getDriver());
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Slider";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(sliderPage.getPageTitleText(), PAGE_TITLE);

    }

    @Test(groups = {"Smoke"})
    public void validateRangeInputToMinValue(){
        logger.info("-------------------validateRangeInputToMinValue-----------------------");
        sliderPage.changeRangeInputToMinValue();
        Assert.assertEquals(sliderPage.getValueTextOfInputRange(),sliderPage.getContainerValueText());
    }

    @Test(groups = {"Smoke"})
    public void validateRangeInputToMaxValue(){
        logger.info("-------------------validateRangeInputToMaxValue-----------------------");
        sliderPage.changeRangeInputToMaxValue();
        Assert.assertEquals(sliderPage.getValueTextOfInputRange(),sliderPage.getContainerValueText());
    }
}
