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

public class SelectMenuPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(SelectMenuPageTest.class);
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

    @BeforeMethod(groups = {"UI","Smoke"})
    public void initializeClass(){
        logger.info("-------------------Initializing SelectMenuPageTest Class------------------");
        selectMenuPage = homePage.clickOnSectionWidgets().clickOnSelectMenu();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(selectMenuPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectSelectValueLabel(){
        logger.info("-------------------validateCorrectSelectValueLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getValueLabelText(),FIRST_LABEL);
    }

    @Test(dataProvider = "testData0",groups = {"Smoke"})
    public void selectValueByDropdown(Object... data){
        logger.info("-------------------selectValueByDropdown-----------------------");
        String groupOption = (String) data[0];

        selectMenuPage.typeInSelectValueDropDown(groupOption);
        selectMenuPage.enterActionInSelectValueDropDown();
        Assert.assertEquals(selectMenuPage.getSelectValueContainerText(),groupOption);
    }

    @Test(groups = {"UI"})
    public void validateCorrectSelectOneLabel(){
        logger.info("-------------------validateCorrectSelectOneLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getOneLabelText(),SECOND_LABEL);
    }

    @Test(dataProvider = "testData0",groups = {"Smoke"})
    public void selectOneByDropdown(Object... data){
        logger.info("-------------------selectOneByDropdown-----------------------");
        String titleOption = (String) data[1];

        selectMenuPage.typeOptionInSelectOneDropDown(titleOption);
        selectMenuPage.enterActionInSelectOneDropDown();
        Assert.assertEquals(selectMenuPage.getSelectOneContainerText(),titleOption);
    }

    @Test(groups = {"UI"})
    public void validateCorrectOldStyleSelectLabel(){
        logger.info("-------------------validateCorrectOldStyleSelectLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getOldStyleSelectLabelText(),THIRD_LABEL);
    }

    @Test(dataProvider = "testData1",groups = {"Smoke"})
    public void selectValueInOldSelectMenu(Object... data){
        logger.info("-------------------selectValueInOldSelectMenu-----------------------");
        String optionOfColor = (String) data[0];

        selectMenuPage.selectValueOnOldStyleSelectMenu(optionOfColor);
        Assert.assertEquals(selectMenuPage.RetrieveTextOfSelectedOptionFromOldStyleMenu(),optionOfColor);
    }

    @Test(groups = {"UI"})
    public void validateCorrectMultiselectDropdownLabel(){
        logger.info("-------------------validateCorrectMultiselectDropdownLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getMultiSelectDropdownLabelText(),FOURTH_LABEL);

    }

    @Test(groups = "Smoke")
    public void selectMultiplyValuesInDropdown(){
        logger.info("-------------------selectMultiplyValuesInDropdown-----------------------");
        selectMenuPage.selectAllOptionsInMultiSelectDropDown();
        Assert.assertEquals(selectMenuPage.getGreenValueTextOfMultiplyDropdown(),GREEN_COLOR);
        Assert.assertEquals(selectMenuPage.getBlueValueTextOfMultiplyDropdown(),BLUE_COLOR);
        Assert.assertEquals(selectMenuPage.getBlackValueTextOfMultiplyDropdown(),BLACK_COLOR);
        Assert.assertEquals(selectMenuPage.getRedValueTextOfMultiplyDropdown(),RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateCorrectStandardMultiSelectLabel(){
        logger.info("-------------------validateCorrectStandardMultiSelectLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getStandardMultiSelectLabelText(),FIFTH_LABEL);
    }

    @Test(groups = "Smoke")
    public void selectMultiplyValuesOnStandardMultiSelect(){
        logger.info("-------------------selectMultiplyValuesOnStandardMultiSelect-----------------------");
        selectMenuPage.scrollAndSelectAllValuesOnStandardMultiSelect();
        Assert.assertTrue(selectMenuPage.wereAllOptionsSelectedOfStandardMultiSelect());
    }

    @DataProvider(name = "testData0")
    public Object[][] testData0() throws IOException {
        String sheetName = "selectMenu0";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }

    @DataProvider(name = "testData1")
    public Object[][] testDataColors() throws IOException {
        String sheetName = "selectMenu1";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}