package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoCompletePageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        autoCompletePage = homePage.clickOnSectionWidgets().clickOnAutoComplete();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(autoCompletePage.getPageTitleText(),pageTitle);
    }

    @Parameters("firstLabel")
    @Test
    public void validateCorrectMultipleContainerLabel(String firstLabel){
        Assert.assertEquals(autoCompletePage.getMultipleContainerLabelText(),firstLabel);
    }

    @Parameters("secondLabel")
    @Test
    public void validateCorrectSingleContainerLabel(String secondLabel){
        Assert.assertEquals(autoCompletePage.getSingleContainerLabelText(),secondLabel);
    }

    @Parameters({"firstColor","secondColor","firstColorExpected","secondColorExpected"})
    @Test
    public void validateColorNamesInMultipleContainer(String firstColor, String secondColor, String firstColorExpected, String secondColorExpected){
        autoCompletePage.typeInMultipleContainer(firstColor);
        autoCompletePage.typeInMultipleContainer(secondColor);
        Assert.assertTrue(autoCompletePage.isTheValueContained(firstColorExpected));
        Assert.assertTrue(autoCompletePage.isTheValueContained(secondColorExpected));
    }

    @Test(dataProvider = "testData")
    public void validateColorNameInSingleContainer(Object... data){
        autoCompletePage.typeInSingleContainer((String) data[0]);
        Assert.assertEquals(autoCompletePage.getTextOfSingleContainerValue(), (String) data[1]);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "autoComplete";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}
