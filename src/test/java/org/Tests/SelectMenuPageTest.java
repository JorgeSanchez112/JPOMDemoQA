package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

    @Parameters("typeOption")
    @Test
    public void selectValueByDropdown(String typeOption){ //this could stay in a file of Data-Driven testing
        selectMenuPage.typeInSelectValueDropDown(typeOption);
        selectMenuPage.enterActionInSelectValueDropDown();
        Assert.assertEquals(selectMenuPage.getSelectValueContainerText(),typeOption);
    }

    @Test
    public void validateCorrectSelectOneLabel(){
        Assert.assertEquals(selectMenuPage.getOneLabelText(),SECOND_LABEL);
    }

    @Parameters("expectedOne")
    @Test
    public void selectOneByDropdown(String expectedOne){
        selectMenuPage.typeOptionInSelectOneDropDown(expectedOne);
        selectMenuPage.enterActionInSelectOneDropDown();
        Assert.assertEquals(selectMenuPage.getSelectOneContainerText(),expectedOne);
    }

    @Test
    public void validateCorrectOldStyleSelectLabel(){
        Assert.assertEquals(selectMenuPage.getOldStyleSelectLabelText(),THIRD_LABEL);
    }

    @Parameters("optionOfColor")
    @Test //this need a change
    public void selectValueInOldSelectMenu(String optionOfColor){
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
}