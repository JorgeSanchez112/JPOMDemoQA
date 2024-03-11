package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MenuPageTest extends TestBase {
    private final String PAGE_TITLE = "Menu";
    @BeforeMethod
    public void initializeClassAndHideAdvertising(){
        menuPage = homePage.clickOnSectionWidgets().clickOnMenu();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(menuPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateMainItem1IsVisible(){
        Assert.assertTrue(menuPage.isMainItem1Displayed());
    }

    @Test
    public void validateMainItem2IsVisible(){
        Assert.assertTrue(menuPage.isMainItem2Displayed());
    }

    @Test
    public void validateMainItem3IsVisible(){
        Assert.assertTrue(menuPage.isMainItem3Displayed());
    }

    @Test
    public void validateSubItem1IsVisible(){
        menuPage.moveClickerToMainItem2();
        Assert.assertTrue(menuPage.isSubItem1Displayed());
    }

    @Test
    public void validateSubItem2IsVisible(){
        menuPage.moveClickerToMainItem2();
        Assert.assertTrue(menuPage.isSubItem2Displayed());
    }

    @Test
    public void validateSubSubListIsVisible(){
        menuPage.moveClickerToMainItem2();
        Assert.assertTrue(menuPage.isSubSubListDisplayed());
    }

    @Test
    public void validateSubSubItem1IsVisible(){
        menuPage.moveClickerToMainItem2();
        menuPage.moveClickerToSubSubList();
        Assert.assertTrue(menuPage.isSubSubItem1Displayed());
    }

    @Test
    public void validateSubSubItem2IsVisible(){
        menuPage.moveClickerToMainItem2();
        menuPage.moveClickerToSubSubList();
        Assert.assertTrue(menuPage.isSubSubItem2Displayed());
    }
}