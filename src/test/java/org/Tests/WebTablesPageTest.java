package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebTablesPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(AccordianPageTest.class);
    private final String PAGE_TITLE = "Web Tables";
    private final String MESSAGE_NO_ROWS_FOUND = "No rows found";
    private final String SEARCH_BOX = "Kierra";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing WebTablesPageTest Class------------------");
        webTablesPage = homePage.clickOnSectionElements().clickOnWebTablesSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(webTablesPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test
    public void validateSearchBoxResult(){
        logger.info("-------------------validateSearchBoxResult-----------------------");
        webTablesPage.typeOnSearchBox(SEARCH_BOX);
        Assert.assertEquals(webTablesPage.getFirstNameOfFirstRow(),SEARCH_BOX);
    }

    @Test
    public void validateAllRowsEmpty(){
        logger.info("-------------------validateAllRowsEmpty-----------------------");
        webTablesPage.clickOnDeleteThirdRow();
        webTablesPage.clickOnDeleteSecondRow();
        webTablesPage.clickOnDeleteFirstRow();

        Assert.assertEquals(webTablesPage.getTextOfMessageNoRowsFound(), MESSAGE_NO_ROWS_FOUND);
    }

    @Test(dataProvider = "dataTest")
    public void validateCorrectNewRow(Object... data){
        logger.info("-------------------validateCorrectNewRow-----------------------");
        String name = (String) data[0];
        String lastName = (String) data[1];
        String age = (String) data[2];
        String email = (String) data[3];
        String salary = (String) data[4];
        String department = (String) data[5];

        webTablesPage.createRegistrationForm(name, lastName, email, age, salary, department);
        Assert.assertEquals(webTablesPage.getFirstNameOfFourthRow(),name);
        Assert.assertEquals(webTablesPage.getLastNameOfFourthRow(),lastName);
        Assert.assertEquals(webTablesPage.getEmailOfFourthRow(),email);
        Assert.assertEquals(webTablesPage.getAgeOfFourthRow(),age);
        Assert.assertEquals(webTablesPage.getSalaryOfFourthRow(),salary);
        Assert.assertEquals(webTablesPage.getDepartmentOfFourthRow(),department);
    }

    @DataProvider
    private Object[][] dataTest() throws IOException {
        String sheetName = "webTables";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}