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

    @Parameters("expectedValue")
    @Test
    public void selectValueByDropdown(String expectedValue){ //need change, I need find a way where I can choose an option just write the value.
        selectMenuPage.clickOnSelectValueContainer();
        selectMenuPage.downOneOptionInSelectValueDropDown();
        selectMenuPage.enterActionInSelectValueDropDown();
        Assert.assertEquals(selectMenuPage.getSelectValueContainerText()," option Group 1, option 2, selected.\n" +
                "Group 1, option 2");
    }

    @Parameters("secondLabel")
    @Test
    public void validateCorrectSelectOneLabel(String secondLabel){
        Assert.assertEquals(selectMenuPage.getOneLabelText(),secondLabel);
    }

    @Parameters("expectedOne")
    @Test
    public void selectOneByDropdown(String expectedOne){
        selectMenuPage.clickOnSelectOneContainer();
        selectMenuPage.downOneOptionInSelectOneDropDown();
        selectMenuPage.enterActionInSelectOneDropDown();
        Assert.assertEquals(selectMenuPage.getSelectOneContainerText(), " option Mr., selected.\n" +
                "Mr.");
    }

    @Parameters("thirdLabel")
    @Test
    public void validateCorrectOldStyleSelectLabel(String thirdLabel){
        Assert.assertEquals(selectMenuPage.getOldStyleSelectLabelText(),thirdLabel);
    }

    @Parameters("expectedOldValue")
    @Test //this need a change
    public void selectValueInOldSelectMenu(String expectedOldValue){
        selectMenuPage.selectValueOnOldStyleSelectMenu();
        Assert.assertEquals(selectMenuPage.getSelectValueOnOldStyleSelectMenuText(),"6");
    }

    @Parameters("fourthLabel")
    @Test
    public void validateCorrectMultiselectDropdownLabel(String fourthLabel){
        Assert.assertEquals(selectMenuPage.getMultiSelectDropdownLabelText(),fourthLabel);

    }

    @Parameters({"firstExpectedMultiValue","secondExpectedMultiValue","thirdExpectedMultiValue","fourthExpectedMultiValue"})
    @Test
    public void selectMultiplyValuesInDropdown(String firstExpectedMultiValue, String secondExpectedMultiValue, String thirdExpectedMultiValue, String fourthExpectedMultiValue){ //need changes
        selectMenuPage.clickOnMultiSelectDropdownContainer();
        selectMenuPage.downOneOptionInMultiSelectDropDown();
        selectMenuPage.enterActionInMultiSelectDropDown();
        selectMenuPage.enterActionInMultiSelectDropDown();
        selectMenuPage.enterActionInMultiSelectDropDown();
        selectMenuPage.enterActionInMultiSelectDropDown();
        Assert.assertEquals(selectMenuPage.getGreenValueTextOfMultiplyDropdown(),"Green");
        Assert.assertEquals(selectMenuPage.getBlueValueTextOfMultiplyDropdown(),"Blue");
        Assert.assertEquals(selectMenuPage.getBlackValueTextOfMultiplyDropdown(),"Black");
        Assert.assertEquals(selectMenuPage.getRedValueTextOfMultiplyDropdown(),"Red");
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
