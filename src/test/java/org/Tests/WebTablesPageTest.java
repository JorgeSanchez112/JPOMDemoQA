package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebTablesPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        webTablesPage = homePage.clickOnSectionElements().clickOnWebTablesSection();
    }
    //CHANGE ALL
    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(webTablesPage.getPageTitleText(), pageTitle);
    }

    @Parameters("searchBox")
    @Test
    public void validateSearchBoxResult(String searchBox){
        webTablesPage.typeOnSearchBox(searchBox);
        Assert.assertEquals(webTablesPage.getFirstNameOfFirstRow(),searchBox);
    }

    @Parameters("messageNoRowsFound")
    @Test
    public void validateAllRowsEmpty(String messageNoRowsFound){
        webTablesPage.clickOnDeleteThirdRow();
        webTablesPage.clickOnDeleteSecondRow();
        webTablesPage.clickOnDeleteFirstRow();

        Assert.assertEquals(webTablesPage.getTextOfMessageNoRowsFound(), messageNoRowsFound);
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
