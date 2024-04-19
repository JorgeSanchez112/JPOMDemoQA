package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectablePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(SelectablePageTest.class);

    @BeforeMethod(groups = {"UI","Smoke"})
    public void initializeClass(){
        logger.info("-------------------Initializing SelectablePageTest Class------------------");
        selectablePage = homePage.clickOnSectionInteractions(getDriver()).clickOnSelectable(getDriver());
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Selectable";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(selectablePage.getPageTitleText(), PAGE_TITLE);

    }
    @Test(groups = {"Smoke"})
    public void validateCrasJustoOdioListElementIsSelectable(){
        logger.info("-------------------validateCrasJustoOdioListElementIsSelectable-----------------------");
        selectablePage.clickOnCrasJustoOdioListElement();
        Assert.assertTrue(selectablePage.isCrasJustoOdioListElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateDapibusAcFacilisisInListElementIsSelectable(){
        logger.info("-------------------validateDapibusAcFacilisisInListElementIsSelectable-----------------------");
        selectablePage.clickOnDapibusAcFacilisisInListElement();
        Assert.assertTrue(selectablePage.isDapibusAcFacilisisInListElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateMorbiLeoRisusListElementIsSelectable(){
        logger.info("-------------------validateMorbiLeoRisusListElementIsSelectable-----------------------");
        selectablePage.clickOnMorbiLeoRisusListElement();
        Assert.assertTrue(selectablePage.isMorbiLeoRisusListElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validatePortaAcConsecteturAcListElementIsSelectable(){
        logger.info("-------------------validatePortaAcConsecteturAcListElementIsSelectable-----------------------");
        selectablePage.clickOnPortaAcConsecteturAcListElement();
        Assert.assertTrue(selectablePage.isPortaAcConsecteturAcListElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateOneGridElementIsSelectable(){
        logger.info("-------------------validateOneGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnOneGridElement();
        Assert.assertTrue(selectablePage.isOneGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateTwoGridElementIsSelectable(){
        logger.info("-------------------validateTwoGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnTwoGridElement();
        Assert.assertTrue(selectablePage.isTwoGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateThreeGridElementIsSelectable(){
        logger.info("-------------------validateThreeGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnThreeGridElement();
        Assert.assertTrue(selectablePage.isThreeGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateFourGridElementIsSelectable(){
        logger.info("-------------------validateFourGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnFourGridElement();
        Assert.assertTrue(selectablePage.isFourGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateFiveGridElementIsSelectable(){
        logger.info("-------------------validateFiveGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnFiveGridElement();
        Assert.assertTrue(selectablePage.isFiveGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateSixGridElementIsSelectable(){
        logger.info("-------------------validateSixGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnSixGridElement();
        Assert.assertTrue(selectablePage.isSixGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateSevenGridElementIsSelectable(){
        logger.info("-------------------validateSevenGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnSevenGridElement();
        Assert.assertTrue(selectablePage.isSevenGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateEightGridElementIsSelectable(){
        logger.info("-------------------validateEightGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnEightGridElement();
        Assert.assertTrue(selectablePage.isEightGridElementSelected());
    }

    @Test(groups = {"Smoke"})
    public void validateNineGridElementIsSelectable(){
        logger.info("-------------------validateNineGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnNineGridElement();
        Assert.assertTrue(selectablePage.isNineGridElementSelected());
    }
}