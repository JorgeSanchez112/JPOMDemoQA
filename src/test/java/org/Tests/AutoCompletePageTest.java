package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AutoCompletePageTest extends TestBase {
    private final String PAGE_TITLE = "Auto Complete";
    private final String FIRST_LABEL  = "Type multiple color names";
    private final String SECOND_LABEL  = "Type single color name";

    @BeforeMethod
    public void initializeClass(){
        autoCompletePage = homePage.clickOnSectionWidgets().clickOnAutoComplete();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(autoCompletePage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateCorrectMultipleContainerLabel(){
        Assert.assertEquals(autoCompletePage.getMultipleContainerLabelText(),FIRST_LABEL);
    }

    @Test
    public void validateCorrectSingleContainerLabel(){
        Assert.assertEquals(autoCompletePage.getSingleContainerLabelText(),SECOND_LABEL);
    }

    @Test(dataProvider = "testData")
    public void validateColorNamesInMultipleContainer(Object... data){
        String firstColor = (String) data[1];
        String secondColor = (String) data[2];

        autoCompletePage.typeInMultipleContainer(firstColor);
        autoCompletePage.typeInMultipleContainer(secondColor);
        Assert.assertTrue(autoCompletePage.isTheValueContained(firstColor));
        Assert.assertTrue(autoCompletePage.isTheValueContained(secondColor));
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
