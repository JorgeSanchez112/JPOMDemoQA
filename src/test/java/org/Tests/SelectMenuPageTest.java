package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectMenuPageTest extends TestBase {
    private final String PAGE_TITLE = "Select Menu";
    private final String FIRST_LABEL = "Select Value";
    private final String SECOND_LABEL = "Select One";
    private final String THIRD_LABEL = "Old Style Select Menu";
    private final String FOURTH_LABEL = "Multiselect drop down";
    private final String FIFTH_LABEL = "Standard multi select";

    @BeforeMethod
    public void initializeClass(){
        selectMenuPage = homePage.clickOnSectionWidgets().clickOnSelectMenu();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(selectMenuPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateCorrectSelectValueLabel(){
        Assert.assertEquals(selectMenuPage.getValueLabelText(),FIRST_LABEL);
    }

    @Test(dataProvider = "testData")
    public void selectValueByDropdown(Object... data){ //this could stay in a file of Data-Driven testing
        String groupOption = (String) data[0];

        selectMenuPage.typeInSelectValueDropDown(groupOption);
        selectMenuPage.enterActionInSelectValueDropDown();
        Assert.assertEquals(selectMenuPage.getSelectValueContainerText(),groupOption);
    }

    @Test
    public void validateCorrectSelectOneLabel(){
        Assert.assertEquals(selectMenuPage.getOneLabelText(),SECOND_LABEL);
    }

    @Test(dataProvider = "testData")
    public void selectOneByDropdown(Object... data){
        String titleOption = (String) data[1];

        selectMenuPage.typeOptionInSelectOneDropDown(titleOption);
        selectMenuPage.enterActionInSelectOneDropDown();
        Assert.assertEquals(selectMenuPage.getSelectOneContainerText(),titleOption);
    }

    @Test
    public void validateCorrectOldStyleSelectLabel(){
        Assert.assertEquals(selectMenuPage.getOldStyleSelectLabelText(),THIRD_LABEL);
    }

    @Test(dataProvider = "testData") //this need a change
    public void selectValueInOldSelectMenu(Object... data){
        String optionOfColor = (String) data[2];

        selectMenuPage.selectValueOnOldStyleSelectMenu(optionOfColor);
        Assert.assertEquals(selectMenuPage.RetrieveTextOfSelectedOptionFromOldStyleMenu(),optionOfColor);
    }

    @Test
    public void validateCorrectMultiselectDropdownLabel(){
        Assert.assertEquals(selectMenuPage.getMultiSelectDropdownLabelText(),FOURTH_LABEL);

    }

    @Parameters({"firstExpectedMultiValue","secondExpectedMultiValue","thirdExpectedMultiValue","fourthExpectedMultiValue"})
    @Test
    public void selectMultiplyValuesInDropdown(String firstExpectedMultiValue, String secondExpectedMultiValue, String thirdExpectedMultiValue, String fourthExpectedMultiValue){
        selectMenuPage.selectAllOptionsInMultiSelectDropDown();
        Assert.assertEquals(selectMenuPage.getGreenValueTextOfMultiplyDropdown(),firstExpectedMultiValue);
        Assert.assertEquals(selectMenuPage.getBlueValueTextOfMultiplyDropdown(),secondExpectedMultiValue);
        Assert.assertEquals(selectMenuPage.getBlackValueTextOfMultiplyDropdown(),thirdExpectedMultiValue);
        Assert.assertEquals(selectMenuPage.getRedValueTextOfMultiplyDropdown(),fourthExpectedMultiValue);
    }

    @Test
    public void validateCorrectStandardMultiSelectLabel(){
        Assert.assertEquals(selectMenuPage.getStandardMultiSelectLabelText(),FIFTH_LABEL);
    }

    @Parameters({"selectFirstValueOnStandardMultiSelect","selectSecondValueOnStandardMultiSelect","selectThirdValueOnStandardMultiSelect","selectFourthValueOnStandardMultiSelect"})
    @Test
    public void selectMultiplyValuesOnStandardMultiSelect(String selectFirstValueOnStandardMultiSelect, String selectSecondValueOnStandardMultiSelect, String selectThirdValueOnStandardMultiSelect, String selectFourthValueOnStandardMultiSelect){
        selectMenuPage.scrollAndSelectValueOnStandardMultiSelect(selectFirstValueOnStandardMultiSelect);
        selectMenuPage.scrollAndSelectValueOnStandardMultiSelect(selectSecondValueOnStandardMultiSelect);
        selectMenuPage.scrollAndSelectValueOnStandardMultiSelect(selectThirdValueOnStandardMultiSelect);
        selectMenuPage.scrollAndSelectValueOnStandardMultiSelect(selectFourthValueOnStandardMultiSelect);
        Assert.assertTrue(selectMenuPage.isVolvoSelectedOfStandardMultiSelect());
        Assert.assertTrue(selectMenuPage.isSaabSelectedOfStandardMultiSelect());
        Assert.assertTrue(selectMenuPage.isOpelSelectedOfStandardMultiSelect());
        Assert.assertTrue(selectMenuPage.isAudiSelectedOfStandardMultiSelect());
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "selectMenu";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}