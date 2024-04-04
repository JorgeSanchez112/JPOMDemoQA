package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DraggablePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(DraggablePageTest.class);

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

    @Parameters({"simpleBoxXPositionExpected","simpleBoxYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isElementOfTabSimpleDroppedToCoordinates(String simpleBoxXPositionExpected, String simpleBoxYPositionExpected){
        logger.info("-------------------isElementOfTabSimpleDroppedToCoordinates-----------------------");
        draggablePage.moveSimpleElement(Integer.parseInt(simpleBoxXPositionExpected),Integer.parseInt(simpleBoxYPositionExpected));
        Assert.assertEquals(draggablePage.getSimpleBoxXPosition(), simpleBoxXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getSimpleBoxYPosition(), simpleBoxYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters("restrictedXBoxPositionExpected")
    @Test(groups = {"Functional"})
    public void isElementXOfTabAxisDroppedToCoordinates(String restrictedXBoxPositionExpected){
        logger.info("-------------------isElementXOfTabAxisDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabAxisRestricted();
        draggablePage.moveXElement(Integer.parseInt(restrictedXBoxPositionExpected),0);
        Assert.assertEquals(draggablePage.getRestrictedXBoxPosition(), restrictedXBoxPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters("restrictedYBoxPositionExpected")
    @Test(groups = {"Functional"})
    public void isElementYOfTabAxisDroppedToCoordinates(String restrictedYBoxPositionExpected){
        logger.info("-------------------isElementYOfTabAxisDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabAxisRestricted();
        draggablePage.moveYElement(0,Integer.parseInt(restrictedYBoxPositionExpected));
        Assert.assertEquals(draggablePage.getRestrictedYBoxPosition(), restrictedYBoxPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"containedBoxXPositionExpected","containedBoxYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isElementContainedInBoxDroppedToCoordinates(String containedBoxXPositionExpected, String containedBoxYPositionExpected){
        logger.info("-------------------isElementContainedInBoxDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabContainerRestricted();
        draggablePage.moveContainedBox(Integer.parseInt(containedBoxXPositionExpected),Integer.parseInt(containedBoxYPositionExpected));
        Assert.assertEquals(draggablePage.getContainedBoxXPosition(), containedBoxXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getContainedBoxYPosition(), containedBoxYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"containedTextXPositionExpected","containedTextYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isTextContainedInBoxDroppedToCoordinates(String containedTextXPositionExpected, String containedTextYPositionExpected ){
        logger.info("-------------------isTextContainedInBoxDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabContainerRestricted();
        draggablePage.moveContainedText(Integer.parseInt(containedTextXPositionExpected),Integer.parseInt(containedTextYPositionExpected));
        Assert.assertEquals(draggablePage.getContainedTextXPosition(), containedTextXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getContainedTextYPosition(), containedTextYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"elementOfCenterCursorXPositionExpected","elementOfCenterCursorYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isCenterCursorElementDroppedToCoordinates(String elementOfCenterCursorXPositionExpected, String elementOfCenterCursorYPositionExpected){
        logger.info("-------------------isCenterCursorElementDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveCenterCursorOfCursorStyle(Float.parseFloat(elementOfCenterCursorXPositionExpected),Float.parseFloat(elementOfCenterCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfCenterCursorXPosition(), elementOfCenterCursorXPositionExpected);
        Assert.assertEquals(draggablePage.getElementOfCenterCursorYPosition(), elementOfCenterCursorYPositionExpected);
    }


    @Parameters({"elementOfTopCursorXPositionExpected","elementOfTopCursorYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isTopCursorElementDroppedToCoordinates(String elementOfTopCursorXPositionExpected, String elementOfTopCursorYPositionExpected){
        logger.info("-------------------isTopCursorElementDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveTopCursorOfCursorStyle(Float.parseFloat(elementOfTopCursorXPositionExpected),Float.parseFloat(elementOfTopCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfTopCursorXPosition(), elementOfTopCursorXPositionExpected);
        Assert.assertEquals(draggablePage.getElementOfTopCursorYPosition(), elementOfTopCursorYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"elementOfBottomCursorXPositionExpected","elementOfBottomCursorYPositionExpected"})
    @Test(groups = {"Functional"})
    public void isBottomCursorElementDroppedToCoordinates(String elementOfBottomCursorXPositionExpected, String elementOfBottomCursorYPositionExpected){
        logger.info("-------------------isBottomCursorElementDroppedToCoordinates-----------------------");
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveBottomCursorOfCursorStyle(Integer.parseInt(elementOfBottomCursorXPositionExpected),Integer.parseInt(elementOfBottomCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfBottomCursorXPosition(), elementOfBottomCursorXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getElementOfBottomCursorYPosition(), elementOfBottomCursorYPositionExpected + prop.getProperty("pxMeasurer"));
    }
}