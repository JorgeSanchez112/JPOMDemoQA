package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DatePickerPageTest extends TestBase {
    private final String PAGE_TITLE = "Date Picker";
    private final String FIRST_LABEL  = "Select Date";
    private final String SECOND_LABEL  = "Date And Time";

    @BeforeMethod
    public void initializeClass(){
        datePickerPage = homePage.clickOnSectionWidgets().clickOnDatePicker();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(datePickerPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateCorrectDateLabel(){
        Assert.assertEquals(datePickerPage.getDateLabelText(),FIRST_LABEL);
    }

    @Test
    public void validateCorrectDateTimeLabel(){
        Assert.assertEquals(datePickerPage.getDateTimeLabelText(),SECOND_LABEL);
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
