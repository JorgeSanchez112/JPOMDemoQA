package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectMenuPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        selectMenuPage = homePage.clickOnSectionWidgets().clickOnSelectMenu();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(selectMenuPage.getPageTitleText(),pageTitle);
    }

    @Parameters("firstLabel")
    @Test
    public void validateCorrectSelectValueLabel(String firstLabel){
        Assert.assertEquals(selectMenuPage.getValueLabelText(),firstLabel);
    }

    @Parameters("typeOption")
    @Test
    public void selectValueByDropdown(String typeOption){ //this could stay in a file of Data-Driven testing
        selectMenuPage.typeInSelectValueDropDown(typeOption);
        selectMenuPage.enterActionInSelectValueDropDown();
        Assert.assertEquals(selectMenuPage.getSelectValueContainerText(),typeOption);
    }

    @Parameters("secondLabel")
    @Test
    public void validateCorrectSelectOneLabel(String secondLabel){
        Assert.assertEquals(selectMenuPage.getOneLabelText(),secondLabel);
    }

    @Parameters("expectedOne")
    @Test
    public void selectOneByDropdown(String expectedOne){
        selectMenuPage.typeOptionInSelectOneDropDown(expectedOne);
        selectMenuPage.enterActionInSelectOneDropDown();
        Assert.assertEquals(selectMenuPage.getSelectOneContainerText(),expectedOne);
    }

    @Parameters("thirdLabel")
    @Test
    public void validateCorrectOldStyleSelectLabel(String thirdLabel){
        Assert.assertEquals(selectMenuPage.getOldStyleSelectLabelText(),thirdLabel);
    }

    @Parameters("optionOfColor")
    @Test //this need a change
    public void selectValueInOldSelectMenu(String optionOfColor){
        selectMenuPage.selectValueOnOldStyleSelectMenu(optionOfColor);
        Assert.assertEquals(selectMenuPage.RetrieveTextofSelectedOptionFromOldStyleMenu(),optionOfColor);
    }

    @Parameters("fourthLabel")
    @Test
    public void validateCorrectMultiselectDropdownLabel(String fourthLabel){
        Assert.assertEquals(selectMenuPage.getMultiSelectDropdownLabelText(),fourthLabel);

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

    @Parameters("fifthLabel")
    @Test
    public void validateCorrectStandardMultiSelectLabel(String fifthLabel){
        Assert.assertEquals(selectMenuPage.getStandardMultiSelectLabelText(),fifthLabel);
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