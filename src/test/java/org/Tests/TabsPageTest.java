package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TabsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        tabsPage = homePage.clickOnSectionWidgets().clickOnTabs();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(tabsPage.getPageTitleText(),pageTitle);
    }

    @Test
    public void subtitleIsShowed(){
        Assert.assertTrue(tabsPage.isSubTitleDisplayed());
    }

    @Parameters("firstTabTitle")
    @Test
    public void validateCorrectTitleOfFirstTab(String firstTabTitle){
        Assert.assertEquals(tabsPage.getFirstTitleTab(),firstTabTitle);
    }

    @Parameters("secondTabTitle")
    @Test
    public void validateCorrectTitleOfSecondTab(String secondTabTitle){
        Assert.assertEquals(tabsPage.getSecondTitleTab(),secondTabTitle);
    }

    @Parameters("thirdTabTitle")
    @Test
    public void validateCorrectTitleOfThirdTab(String thirdTabTitle){
        Assert.assertEquals(tabsPage.getThirdTitleTab(),thirdTabTitle);
    }

    @Parameters("whatTabText")
    @Test
    public void tabWhatParagraphIsDisplayed(String whatTabText){
        tabsPage.clickOnTabWhat();
        Assert.assertEquals(tabsPage.getParagraphOfWhatText(), whatTabText);
    }

    @Parameters({"firstParagraphOfOriginTabText", "secondParaGraphOfOriginTabText"})
    @Test
    public void tabOriginParagraphIsDisplayed(String firstParagraphOfOriginTabText, String secondParaGraphOfOriginTabText){
        tabsPage.clickOnTabOrigin();
        Assert.assertEquals(tabsPage.getFirstParagraphsOfOriginText(), firstParagraphOfOriginTabText);
        Assert.assertEquals(tabsPage.getSecondParagraphsOfOriginText(),secondParaGraphOfOriginTabText);
    }

    @Parameters("useTabText")
    @Test
    public void tabUseParagraphIsDisplayed(String useTabText){
        tabsPage.clickOnTabUse();
        Assert.assertEquals(tabsPage.getParagraphOfUseText(), useTabText);
    }

    @Test
    public void tabMoreIsDisabled(){
        Assert.assertTrue(tabsPage.isMoreTabEnabled());
    }
}
