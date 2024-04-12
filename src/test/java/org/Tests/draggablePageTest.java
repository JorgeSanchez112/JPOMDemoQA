package org.Tests;

import TestComponents.config.TestBase;
import TestComponents.utilities.dataDriven.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class DraggablePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(DraggablePageTest.class);
    private final String PX_MEASURER = "px";

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing DraggablePageTest Class------------------");
        draggablePage = homePage.clickOnSectionInteractions().clickOnDragabble();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Dragabble";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(draggablePage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateSimpleTabIsVisible(){
        logger.info("-------------------validateSimpleTabIsVisible-----------------------");
        Assert.assertTrue(draggablePage.isSimpleTabVisible());
    }

    @Test(groups = {"UI"})
    public void validateAxisTabIsVisible(){
        logger.info("-------------------validateAxisTabIsVisible-----------------------");
        Assert.assertTrue(draggablePage.isAxisTabVisible());
    }

    @Test(groups = {"UI"})
    public void validateContainerIsVisible(){
        logger.info("-------------------validateContainerIsVisible-----------------------");
        Assert.assertTrue(draggablePage.isContainerTabVisible());
    }

    @Test(groups = {"UI"})
    public void validateCursorTabIsVisible(){
        logger.info("-------------------validateCursorTabIsVisible-----------------------");
        Assert.assertTrue(draggablePage.isCursorTabVisible());
    }

    @Test(groups = {"Functional"},dataProvider = "data")
    public void isElementOfTabSimpleDroppedToCoordinates(Object... data){
        String simpleBoxXPositionExpected = (String) data[0];
        String simpleBoxYPositionExpected = (String) data[1];

        logger.info("-------------------isElementOfTabSimpleDroppedToCoordinates-----------------------");
        draggablePage.moveSimpleElement(Integer.parseInt(simpleBoxXPositionExpected),Integer.parseInt(simpleBoxYPositionExpected));
        Assert.assertEquals(draggablePage.getSimpleBoxXPosition(), simpleBoxXPositionExpected + PX_MEASURER);
        Assert.assertEquals(draggablePage.getSimpleBoxYPosition(), simpleBoxYPositionExpected + PX_MEASURER);
    }

    @Test(groups = {"Functional"})
    public void isElementXOfTabAxisDroppedToCoordinates(Object... data){
        String restrictedXBoxPositionExpected = (String) data[2];

        logger.info("-------------------isElementXOfTabAxisDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabAxisRestricted();
        draggablePage.moveXElement(Integer.parseInt(restrictedXBoxPositionExpected),0);
        Assert.assertEquals(draggablePage.getRestrictedXBoxPosition(), restrictedXBoxPositionExpected + PX_MEASURER);
    }

    @Test(groups = {"Functional"})
    public void isElementYOfTabAxisDroppedToCoordinates(Object... data){
        String restrictedYBoxPositionExpected = (String) data[3];

        logger.info("-------------------isElementYOfTabAxisDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabAxisRestricted();
        draggablePage.moveYElement(0,Integer.parseInt(restrictedYBoxPositionExpected));
        Assert.assertEquals(draggablePage.getRestrictedYBoxPosition(), restrictedYBoxPositionExpected + PX_MEASURER);
    }

    @Parameters({"containedBoxXPositionExpected","containedBoxYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isElementContainedInBoxDroppedToCoordinates(Object... data){
        String containedBoxXPositionExpected = (String) data[4];
        String containedBoxYPositionExpected = (String) data[5];

        logger.info("-------------------isElementContainedInBoxDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabContainerRestricted();
        draggablePage.moveContainedBox(Integer.parseInt(containedBoxXPositionExpected),Integer.parseInt(containedBoxYPositionExpected));
        Assert.assertEquals(draggablePage.getContainedBoxXPosition(), containedBoxXPositionExpected + PX_MEASURER);
        Assert.assertEquals(draggablePage.getContainedBoxYPosition(), containedBoxYPositionExpected + PX_MEASURER);
    }

    @Test(groups = {"Functional"})
    public void isTextContainedInBoxDroppedToCoordinates(Object... data){
        String containedTextXPositionExpected = (String) data[6];
        String containedTextYPositionExpected = (String) data[7];

        logger.info("-------------------isTextContainedInBoxDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabContainerRestricted();
        draggablePage.moveContainedText(Integer.parseInt(containedTextXPositionExpected),Integer.parseInt(containedTextYPositionExpected));
        Assert.assertEquals(draggablePage.getContainedTextXPosition(), containedTextXPositionExpected + PX_MEASURER);
        Assert.assertEquals(draggablePage.getContainedTextYPosition(), containedTextYPositionExpected + PX_MEASURER);
    }

    @Test(groups = {"Functional"})
    public void isCenterCursorElementDroppedToCoordinates(Object... data){
        String elementOfCenterCursorXPositionExpected = (String) data[8];
        String elementOfCenterCursorYPositionExpected = (String) data[9];

        logger.info("-------------------isCenterCursorElementDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveCenterCursorOfCursorStyle(Float.parseFloat(elementOfCenterCursorXPositionExpected),Float.parseFloat(elementOfCenterCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfCenterCursorXPosition(), elementOfCenterCursorXPositionExpected);
        Assert.assertEquals(draggablePage.getElementOfCenterCursorYPosition(), elementOfCenterCursorYPositionExpected);
    }


    @Test(groups = {"Functional"})
    public void isTopCursorElementDroppedToCoordinates(Object... data){
        String elementOfTopCursorXPositionExpected = (String) data[10];
        String elementOfTopCursorYPositionExpected = (String) data[11];

        logger.info("-------------------isTopCursorElementDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveTopCursorOfCursorStyle(Float.parseFloat(elementOfTopCursorXPositionExpected),Float.parseFloat(elementOfTopCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfTopCursorXPosition(), elementOfTopCursorXPositionExpected);
        Assert.assertEquals(draggablePage.getElementOfTopCursorYPosition(), elementOfTopCursorYPositionExpected + PX_MEASURER);
    }

    @Parameters({"elementOfBottomCursorXPositionExpected","elementOfBottomCursorYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isBottomCursorElementDroppedToCoordinates(Object... data){
        String elementOfBottomCursorXPositionExpected = (String) data[12];
        String elementOfBottomCursorYPositionExpected = (String) data[13];

        logger.info("-------------------isBottomCursorElementDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveBottomCursorOfCursorStyle(Integer.parseInt(elementOfBottomCursorXPositionExpected),Integer.parseInt(elementOfBottomCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfBottomCursorXPosition(), elementOfBottomCursorXPositionExpected + PX_MEASURER);
        Assert.assertEquals(draggablePage.getElementOfBottomCursorYPosition(), elementOfBottomCursorYPositionExpected + PX_MEASURER);
    }

    @DataProvider(name = "data")
    private Object[][] testData() throws IOException {
        String sheetName = "draggable";

        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}