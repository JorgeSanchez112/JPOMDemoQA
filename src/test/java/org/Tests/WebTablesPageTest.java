package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTablesPageTest extends TestBase {
    private final String PAGE_TITLE = "Web Tables";
    private final String MESSAGE_NO_ROWS_FOUND = "No rows found";

    @BeforeMethod
    public void initializeClass(){
        webTablesPage = homePage.clickOnSectionElements().clickOnWebTablesSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(webTablesPage.getPageTitleText(), PAGE_TITLE);
    }

    @Parameters("searchBox")
    @Test
    public void validateSearchBoxResult(String searchBox){
        webTablesPage.typeOnSearchBox(searchBox);
        Assert.assertEquals(webTablesPage.getFirstNameOfFirstRow(),searchBox);
    }

    @Test
    public void validateAllRowsEmpty(){
        webTablesPage.clickOnDeleteThirdRow();
        webTablesPage.clickOnDeleteSecondRow();
        webTablesPage.clickOnDeleteFirstRow();

        Assert.assertEquals(webTablesPage.getTextOfMessageNoRowsFound(), MESSAGE_NO_ROWS_FOUND);
    }

    @Parameters({"name","lastName","email","age","salary","department"})
    @Test
    public void validateCorrectNewRow(String name, String lastName, String email, String age, String salary, String department){
        webTablesPage.createRegistrationForm(name, lastName, email, age, salary, department);

        Assert.assertEquals(webTablesPage.getFirstNameOfFourthRow(),name);
        Assert.assertEquals(webTablesPage.getLastNameOfFourthRow(),lastName);
        Assert.assertEquals(webTablesPage.getEmailOfFourthRow(),email);
        Assert.assertEquals(webTablesPage.getAgeOfFourthRow(),age);
        Assert.assertEquals(webTablesPage.getSalaryOfFourthRow(),salary);
        Assert.assertEquals(webTablesPage.getDepartmentOfFourthRow(),department);
    }
}