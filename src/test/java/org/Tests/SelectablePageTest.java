package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectablePageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        selectablePage = homePage.clickOnSectionInteractions().clickOnSelectable();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(selectablePage.getPageTitleText(),pageTitle);

    }
    @Test
    public void validateCrasJustoOdioListElementIsSelectable(){
        selectablePage.clickOnCrasJustoOdioListElement();
        Assert.assertTrue(selectablePage.isCrasJustoOdioListElementSelected());
    }

    @Test
    public void validateDapibusAcFacilisisInListElementIsSelectable(){
        selectablePage.clickOnDapibusAcFacilisisInListElement();
        Assert.assertTrue(selectablePage.isDapibusAcFacilisisInListElementSelected());
    }

    @Test
    public void validateMorbiLeoRisusListElementIsSelectable(){
        selectablePage.clickOnMorbiLeoRisusListElement();
        Assert.assertTrue(selectablePage.isMorbiLeoRisusListElementSelected());
    }

    @Test
    public void validatePortaAcConsecteturAcListElementIsSelectable(){
        selectablePage.clickOnPortaAcConsecteturAcListElement();
        Assert.assertTrue(selectablePage.isPortaAcConsecteturAcListElementSelected());
    }

    @Test
    public void validateOneGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnOneGridElement();
        Assert.assertTrue(selectablePage.isOneGridElementSelected());
    }

    @Test
    public void validateTwoGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnTwoGridElement();
        Assert.assertTrue(selectablePage.isTwoGridElementSelected());
    }

    @Test
    public void validateThreeGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnThreeGridElement();
        Assert.assertTrue(selectablePage.isThreeGridElementSelected());
    }

    @Test
    public void validateFourGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnFourGridElement();
        Assert.assertTrue(selectablePage.isFourGridElementSelected());
    }

    @Test
    public void validateFiveGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnFiveGridElement();
        Assert.assertTrue(selectablePage.isFiveGridElementSelected());
    }

    @Test
    public void validateSixGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnSixGridElement();
        Assert.assertTrue(selectablePage.isSixGridElementSelected());
    }

    @Test
    public void validateSevenGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnSevenGridElement();
        Assert.assertTrue(selectablePage.isSevenGridElementSelected());
    }

    @Test
    public void validateEightGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnEightGridElement();
        Assert.assertTrue(selectablePage.isEightGridElementSelected());
    }

    @Test
    public void validateNineGridElementIsSelectable(){
        selectablePage.clickOnTabGrid();
        selectablePage.clickOnNineGridElement();
        Assert.assertTrue(selectablePage.isNineGridElementSelected());
    }
}
