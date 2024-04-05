package org.Tests;

import testComponents.dataDriven.excelReader;
import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class datePickerPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(datePickerPageTest.class);

    @BeforeMethod(groups = {"UI","Smoke"})
    public void initializeClass(){
        logger.info("-------------------Initializing DatePickerPageTest Class------------------");
        datePickerPage = homePage.clickOnSectionWidgets().clickOnDatePicker();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Date Picker";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(datePickerPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectDateLabel(){
        String FIRST_LABEL = "Select Date";

        logger.info("-------------------validateCorrectDateLabel-----------------------");
        Assert.assertEquals(datePickerPage.getDateLabelText(), FIRST_LABEL);
    }

    @Test(groups = {"UI"})
    public void validateCorrectDateTimeLabel(){
        String SECOND_LABEL = "Date And Time";

        logger.info("-------------------validateCorrectDateTimeLabel-----------------------");
        Assert.assertEquals(datePickerPage.getDateTimeLabelText(), SECOND_LABEL);
    }

    @Test(dataProvider = "testData",groups = {"Smoke"})
    public void validateDateSelected(Object... data){
        logger.info("-------------------validateDateSelected-----------------------");
        String month = (String) data[0];
        String day = (String) data[1];
        String year = (String) data[2];
        String dateExpected = (String) data[4];

        datePickerPage.clickOnDateInput();
        datePickerPage.selectDate(month,day,year);
        Assert.assertEquals(datePickerPage.getDateValueText(),dateExpected);
    }

    @Test(dataProvider = "testData",groups = {"Smoke"})
    public void validateDateTimeSelected(Object... data){
        logger.info("-------------------validateDateTimeSelected-----------------------");
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
        logger.info("Accessing to: " + sheetName + " data");
        excelReader excelReader = new excelReader();
        return excelReader.readTestData(sheetName);
    }
}
