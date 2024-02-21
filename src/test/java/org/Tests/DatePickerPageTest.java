package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DatePickerPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        datePickerPage = homePage.clickOnSectionWidgets().clickOnDatePicker();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(datePickerPage.getPageTitleText(),pageTitle);
    }

    @Parameters("firstLabel")
    @Test
    public void validateCorrectDateLabel(String firstLabel){
        Assert.assertEquals(datePickerPage.getDateLabelText(),firstLabel);
    }

    @Parameters("secondLabel")
    @Test
    public void validateCorrectDateTimeLabel(String secondLabel){
        Assert.assertEquals(datePickerPage.getDateTimeLabelText(),secondLabel);
    }

    @Parameters({"month","day","year","dateExpected"})
    @Test
    public void validateDateSelected(String month, String day, String year, String dateExpected){
        datePickerPage.clickOnDateInput();
        datePickerPage.selectDate(month,day,year);
        Assert.assertEquals(datePickerPage.getDateValueText(),dateExpected);
    }

    @Parameters({"month","day","year","time","dateTimeExpected"})
    @Test
    public void validateDateTimeSelected(String month, String day, String year, String time, String dateTimeExpected){
        datePickerPage.clickOnDateAndTimeInput();
        datePickerPage.selectDateAndTime(month,day,year,time);
        Assert.assertEquals(datePickerPage.getDateTimeValueText(),dateTimeExpected);
    }
}
