package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectablePageTest extends TestBase {
    private Logger logger = LogManager.getLogger(SelectablePageTest.class);
    private final String PAGE_TITLE = "Selectable";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing SelectablePageTest Class------------------");
        selectablePage = homePage.clickOnSectionInteractions().clickOnSelectable();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(selectablePage.getPageTitleText(),PAGE_TITLE);

    }
    @Test
    public void validateCrasJustoOdioListElementIsSelectable(){
        logger.info("-------------------validateCrasJustoOdioListElementIsSelectable-----------------------");
        selectablePage.clickOnCrasJustoOdioListElement();
        Assert.assertTrue(selectablePage.isCrasJustoOdioListElementSelected());
    }

    @Test
    public void validateDapibusAcFacilisisInListElementIsSelectable(){
        logger.info("-------------------validateDapibusAcFacilisisInListElementIsSelectable-----------------------");
        selectablePage.clickOnDapibusAcFacilisisInListElement();
        Assert.assertTrue(selectablePage.isDapibusAcFacilisisInListElementSelected());
    }

    @Test
    public void validateMorbiLeoRisusListElementIsSelectable(){
        logger.info("-------------------validateMorbiLeoRisusListElementIsSelectable-----------------------");
        selectablePage.clickOnMorbiLeoRisusListElement();
        Assert.assertTrue(selectablePage.isMorbiLeoRisusListElementSelected());
    }

    @Test
    public void validatePortaAcConsecteturAcListElementIsSelectable(){
        logger.info("-------------------validatePortaAcConsecteturAcListElementIsSelectable-----------------------");
        selectablePage.clickOnPortaAcConsecteturAcListElement();
        Assert.assertTrue(selectablePage.isPortaAcConsecteturAcListElementSelected());
    }

    @Test
    public void validateOneGridElementIsSelectable(){
        logger.info("-------------------validateOneGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnOneGridElement();
        Assert.assertTrue(selectablePage.isOneGridElementSelected());
    }

    @Test
    public void validateTwoGridElementIsSelectable(){
        logger.info("-------------------validateTwoGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnTwoGridElement();
        Assert.assertTrue(selectablePage.isTwoGridElementSelected());
    }

    @Test
    public void validateThreeGridElementIsSelectable(){
        logger.info("-------------------validateThreeGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnThreeGridElement();
        Assert.assertTrue(selectablePage.isThreeGridElementSelected());
    }

    @Test
    public void validateFourGridElementIsSelectable(){
        logger.info("-------------------validateFourGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnFourGridElement();
        Assert.assertTrue(selectablePage.isFourGridElementSelected());
    }

    @Test
    public void validateFiveGridElementIsSelectable(){
        logger.info("-------------------validateFiveGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnFiveGridElement();
        Assert.assertTrue(selectablePage.isFiveGridElementSelected());
    }

    @Test
    public void validateSixGridElementIsSelectable(){
        logger.info("-------------------validateSixGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnSixGridElement();
        Assert.assertTrue(selectablePage.isSixGridElementSelected());
    }

    @Test
    public void validateSevenGridElementIsSelectable(){
        logger.info("-------------------validateSevenGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnSevenGridElement();
        Assert.assertTrue(selectablePage.isSevenGridElementSelected());
    }

    @Test
    public void validateEightGridElementIsSelectable(){
        logger.info("-------------------validateEightGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnEightGridElement();
        Assert.assertTrue(selectablePage.isEightGridElementSelected());
    }

    @Test
    public void validateNineGridElementIsSelectable(){
        logger.info("-------------------validateNineGridElementIsSelectable-----------------------");
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnNineGridElement();
        Assert.assertTrue(selectablePage.isNineGridElementSelected());
    }
}