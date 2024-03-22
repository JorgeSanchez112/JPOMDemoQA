package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectMenuPageTest extends TestBase {
    private final String PAGE_TITLE = "Select Menu";
    private final String FIRST_LABEL = "Select Value";
    private final String SECOND_LABEL = "Select One";
    private final String THIRD_LABEL = "Old Style Select Menu";
    private final String FOURTH_LABEL = "Multiselect drop down";
    private final String FIFTH_LABEL = "Standard multi select";
    private final String GREEN_COLOR = "Green";
    private final String BLUE_COLOR = "Blue";
    private final String BLACK_COLOR = "Black";
    private final String RED_COLOR = "Red";

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

    @Test(dataProvider = "testData0")
    public void selectValueByDropdown(Object... data){
        String groupOption = (String) data[0];

        selectMenuPage.typeInSelectValueDropDown(groupOption);
        selectMenuPage.enterActionInSelectValueDropDown();
        Assert.assertEquals(selectMenuPage.getSelectValueContainerText(),groupOption);
    }

    @Test
    public void validateCorrectSelectOneLabel(){
        Assert.assertEquals(selectMenuPage.getOneLabelText(),SECOND_LABEL);
    }

    @Test(dataProvider = "testData0")
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

    @Test(dataProvider = "testData1")
    public void selectValueInOldSelectMenu(Object... data){
        String optionOfColor = (String) data[0];

        selectMenuPage.selectValueOnOldStyleSelectMenu(optionOfColor);
        Assert.assertEquals(selectMenuPage.RetrieveTextOfSelectedOptionFromOldStyleMenu(),optionOfColor);
    }

    @Test
    public void validateCorrectMultiselectDropdownLabel(){
        Assert.assertEquals(selectMenuPage.getMultiSelectDropdownLabelText(),FOURTH_LABEL);

    }

    @Test
    public void selectMultiplyValuesInDropdown(){
        selectMenuPage.selectAllOptionsInMultiSelectDropDown();
        Assert.assertEquals(selectMenuPage.getGreenValueTextOfMultiplyDropdown(),GREEN_COLOR);
        Assert.assertEquals(selectMenuPage.getBlueValueTextOfMultiplyDropdown(),BLUE_COLOR);
        Assert.assertEquals(selectMenuPage.getBlackValueTextOfMultiplyDropdown(),BLACK_COLOR);
        Assert.assertEquals(selectMenuPage.getRedValueTextOfMultiplyDropdown(),RED_COLOR);
    }

    @Test
    public void validateCorrectStandardMultiSelectLabel(){
        Assert.assertEquals(selectMenuPage.getStandardMultiSelectLabelText(),FIFTH_LABEL);
    }

    @Test
    public void selectMultiplyValuesOnStandardMultiSelect(){
        selectMenuPage.scrollAndSelectAllValuesOnStandardMultiSelect();
        Assert.assertTrue(selectMenuPage.wereAllOptionsSelectedOfStandardMultiSelect());

        Assert.assertTrue(selectMenuPage.isVolvoSelectedOfStandardMultiSelect());
        Assert.assertTrue(selectMenuPage.isSaabSelectedOfStandardMultiSelect());
        Assert.assertTrue(selectMenuPage.isOpelSelectedOfStandardMultiSelect());
        Assert.assertTrue(selectMenuPage.isAudiSelectedOfStandardMultiSelect());
    }

    @DataProvider(name = "testData0")
    public Object[][] testData0() throws IOException {
        String sheetName = "selectMenu0";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }

    @DataProvider(name = "testData1")
    public Object[][] testDataColors() throws IOException {
        String sheetName = "selectMenu1";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}