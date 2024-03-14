package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test(dataProvider = "testData")
    public void validateDateSelected(Object... data){
        String month = (String) data[0];
        String day = (String) data[1];
        String year = (String) data[2];
        String dateExpected = (String) data[4];

        datePickerPage.clickOnDateInput();
        datePickerPage.selectDate(month,day,year);
        Assert.assertEquals(datePickerPage.getDateValueText(),dateExpected);
    }

    @Test(dataProvider = "testData")
    public void validateDateTimeSelected(Object... data){
        String month = (String) data[0];
        String day = (String) data[1];
        String year = (String) data[2];
        String time = (String) data[3];
        String dateTimeExpected = (String) data[5];

        datePickerPage.clickOnDateAndTimeInput();
        datePickerPage.selectDateAndTime(month,day,year,time);
        Assert.assertEquals(datePickerPage.getDateTimeValueText(),dateTimeExpected);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "datePicker";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}
