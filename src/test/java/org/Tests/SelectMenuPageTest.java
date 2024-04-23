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

public class SelectMenuPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(SelectMenuPageTest.class);

    @BeforeMethod(groups = {"UI","Smoke"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing SelectMenuPageTest Class------------------");
        selectMenuPage = homePage.clickOnSectionWidgets().clickOnSelectMenu();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Select Menu";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(selectMenuPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectSelectValueLabel(){
        String FIRST_LABEL = "Select Value";

        logger.info("-------------------validateCorrectSelectValueLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getValueLabelText(), FIRST_LABEL);
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
        String SECOND_LABEL = "Select One";

        logger.info("-------------------validateCorrectSelectOneLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getOneLabelText(), SECOND_LABEL);
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
        String THIRD_LABEL = "Old Style Select Menu";

        logger.info("-------------------validateCorrectOldStyleSelectLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getOldStyleSelectLabelText(), THIRD_LABEL);
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
        String FOURTH_LABEL = "Multiselect drop down";

        logger.info("-------------------validateCorrectMultiselectDropdownLabel-----------------------");
        Assert.assertEquals(selectMenuPage.getMultiSelectDropdownLabelText(), FOURTH_LABEL);

    }

    @Test(groups = "Smoke")
    public void selectMultiplyValuesInDropdown(){


        logger.info("-------------------selectMultiplyValuesInDropdown-----------------------");
        selectMenuPage.selectAllOptionsInMultiSelectDropDown();
        Assert.assertTrue(selectMenuPage.ValidateThatAllOptionsOfMultipleDropdownWereSelected());
    }

    @Test(groups = {"UI"})
    public void validateCorrectStandardMultiSelectLabel(){
        logger.info("-------------------validateCorrectStandardMultiSelectLabel-----------------------");
        String FIFTH_LABEL = "Standard multi select";
        Assert.assertEquals(selectMenuPage.getStandardMultiSelectLabelText(), FIFTH_LABEL);
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