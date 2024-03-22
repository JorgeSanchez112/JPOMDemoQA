package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderPageTest extends TestBase {
    private final String PAGE_TITLE = "Slider";

    @BeforeMethod
    public void initializeClass(){
        sliderPage = homePage.clickOnSectionWidgets().clickOnSlider();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(sliderPage.getPageTitleText(),PAGE_TITLE);

    }

    @Test
    public void validateRangeInputToMinValue(){
        sliderPage.changeRangeInputToMinValue();
        Assert.assertEquals(sliderPage.getValueTextOfInputRange(),sliderPage.getContainerValueText());
    }

    @Test
    public void validateRangeInputToMaxValue(){
        sliderPage.changeRangeInputToMaxValue();
        Assert.assertEquals(sliderPage.getValueTextOfInputRange(),sliderPage.getContainerValueText());
    }
}
