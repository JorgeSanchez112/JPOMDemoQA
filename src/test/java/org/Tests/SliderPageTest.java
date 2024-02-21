package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SliderPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        sliderPage = homePage.clickOnSectionWidgets().clickOnSlider();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(sliderPage.getPageTitleText(),pageTitle);

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
