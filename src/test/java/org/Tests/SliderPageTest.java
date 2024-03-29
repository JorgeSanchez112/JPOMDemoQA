package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(SliderPageTest.class);
    private final String PAGE_TITLE = "Slider";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing SliderPageTest Class------------------");
        sliderPage = homePage.clickOnSectionWidgets().clickOnSlider();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(sliderPage.getPageTitleText(),PAGE_TITLE);

    }

    @Test
    public void validateRangeInputToMinValue(){
        logger.info("-------------------validateRangeInputToMinValue-----------------------");
        sliderPage.changeRangeInputToMinValue();
        Assert.assertEquals(sliderPage.getValueTextOfInputRange(),sliderPage.getContainerValueText());
    }

    @Test
    public void validateRangeInputToMaxValue(){
        logger.info("-------------------validateRangeInputToMaxValue-----------------------");
        sliderPage.changeRangeInputToMaxValue();
        Assert.assertEquals(sliderPage.getValueTextOfInputRange(),sliderPage.getContainerValueText());
    }
}
