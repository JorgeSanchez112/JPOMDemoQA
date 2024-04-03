package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(AccordianPageTest.class);
    private final String PAGE_TITLE = "Menu";
    @BeforeMethod(groups = {"UI"})
    public void initializeClassAndHideAdvertising(){
        logger.info("-------------------Initializing MenuPageTest Class------------------");
        menuPage = homePage.clickOnSectionWidgets().clickOnMenu();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(menuPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateMainItem1IsVisible(){
        logger.info("-------------------validateMainItem1IsVisible-----------------------");
        Assert.assertTrue(menuPage.isMainItem1Displayed());
    }

    @Test(groups = {"UI"})
    public void validateMainItem2IsVisible(){
        logger.info("-------------------validateMainItem2IsVisible-----------------------");
        Assert.assertTrue(menuPage.isMainItem2Displayed());
    }

    @Test(groups = {"UI"})
    public void validateMainItem3IsVisible(){
        logger.info("-------------------validateMainItem3IsVisible-----------------------");
        Assert.assertTrue(menuPage.isMainItem3Displayed());
    }

    @Test(groups = {"UI"})
    public void validateSubItem1IsVisible(){
        logger.info("-------------------validateSubItem1IsVisible-----------------------");
        menuPage.moveClickerToMainItem2();
        Assert.assertTrue(menuPage.isSubItem1Displayed());
    }

    @Test(groups = {"UI"})
    public void validateSubItem2IsVisible(){
        logger.info("-------------------validateSubItem2IsVisible-----------------------");
        menuPage.moveClickerToMainItem2();
        Assert.assertTrue(menuPage.isSubItem2Displayed());
    }

    @Test(groups = {"UI"})
    public void validateSubSubListIsVisible(){
        logger.info("-------------------validateSubSubListIsVisible-----------------------");
        menuPage.moveClickerToMainItem2();
        Assert.assertTrue(menuPage.isSubSubListDisplayed());
    }

    @Test(groups = {"UI"})
    public void validateSubSubItem1IsVisible(){
        logger.info("-------------------validateSubSubItem1IsVisible-----------------------");
        menuPage.moveClickerToMainItem2();
        menuPage.moveClickerToSubSubList();
        Assert.assertTrue(menuPage.isSubSubItem1Displayed());
    }

    @Test(groups = {"UI"})
    public void validateSubSubItem2IsVisible(){
        logger.info("-------------------validateSubSubItem2IsVisible-----------------------");
        menuPage.moveClickerToMainItem2();
        menuPage.moveClickerToSubSubList();
        Assert.assertTrue(menuPage.isSubSubItem2Displayed());
    }
}