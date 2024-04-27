package org.Tests;

import TestComponents.utilities.dataDriven.ExcelReader;
import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebTablesPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(AccordianPageTest.class);

    @BeforeMethod(groups = {"UI","Smoke"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing WebTablesPageTest Class------------------");
        webTablesPage = homePage.clickOnSectionElements().clickOnWebTablesSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Web Tables";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(webTablesPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"Smoke"})
    public void validateSearchBoxResult(){
        String SEARCH_BOX = "Kierra";

        logger.info("-------------------validateSearchBoxResult-----------------------");
        webTablesPage.typeOnSearchBox(SEARCH_BOX);
        Assert.assertEquals(webTablesPage.getFirstNameOfFirstRow(), SEARCH_BOX);
    }

    @Test(groups = {"Smoke"})
    public void validateAllRowsEmpty(){
        String MESSAGE_NO_ROWS_FOUND = "No rows found";

        logger.info("-------------------validateAllRowsEmpty-----------------------");
        webTablesPage.clickOnDeleteThirdRow();
        webTablesPage.clickOnDeleteSecondRow();
        webTablesPage.clickOnDeleteFirstRow();

        Assert.assertEquals(webTablesPage.getTextOfMessageNoRowsFound(), MESSAGE_NO_ROWS_FOUND);
    }

    @Test(dataProvider = "dataTest",groups = {"Smoke"})
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
    private synchronized Object[][] dataTest() throws IOException {
        String sheetName = "webTables";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}