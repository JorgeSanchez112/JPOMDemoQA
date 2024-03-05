package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DraggablePageTest extends TestBase {
    @BeforeMethod //change all the way of tests, those can be used more dinamycally.
    public void initializeClass(){
        draggablePage = homePage.clickOnSectionInteractions().clickOnDragabble();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(draggablePage.getPageTitleText(),pageTitle);
    }

    @Test
    public void validateSimpleTabIsVisible(){
        Assert.assertTrue(draggablePage.isSimpleTabVisible());
    }

    @Test
    public void validateAxisTabIsVisible(){
        Assert.assertTrue(draggablePage.isAxisTabVisible());
    }

    @Test
    public void validateContainerIsVisible(){
        Assert.assertTrue(draggablePage.isContainerTabVisible());
    }

    @Test
    public void validateCursorTabIsVisible(){
        Assert.assertTrue(draggablePage.isCursorTabVisible());
    }

    @Parameters({"simpleBoxXPositionExpected","simpleBoxYPositionExpected"})
    @Test
    public void isElementOfTabSimpleDroppedToCoordinates(String simpleBoxXPositionExpected, String simpleBoxYPositionExpected){
        draggablePage.moveSimpleElement(Integer.parseInt(simpleBoxXPositionExpected),Integer.parseInt(simpleBoxYPositionExpected));
        Assert.assertEquals(draggablePage.getSimpleBoxXPosition(), simpleBoxXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getSimpleBoxYPosition(), simpleBoxYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters("restrictedXBoxPositionExpected")
    @Test
    public void isElementXOfTabAxisDroppedToCoordinates(String restrictedXBoxPositionExpected){
        draggablePage.clickOnTabAxisRestricted();
        draggablePage.moveXElement(Integer.parseInt(restrictedXBoxPositionExpected),0);
        Assert.assertEquals(draggablePage.getRestrictedXBoxPosition(), restrictedXBoxPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters("restrictedYBoxPositionExpected")
    @Test
    public void isElementYOfTabAxisDroppedToCoordinates(String restrictedYBoxPositionExpected){
        draggablePage.clickOnTabAxisRestricted();
        draggablePage.moveYElement(0,Integer.parseInt(restrictedYBoxPositionExpected));
        Assert.assertEquals(draggablePage.getRestrictedYBoxPosition(), restrictedYBoxPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"containedBoxXPositionExpected","containedBoxYPositionExpected"})
    @Test
    public void isElementContainedInBoxDroppedToCoordinates(String containedBoxXPositionExpected, String containedBoxYPositionExpected){
        draggablePage.clickOnTabContainerRestricted();
        draggablePage.moveContainedBox(Integer.parseInt(containedBoxXPositionExpected),Integer.parseInt(containedBoxYPositionExpected));
        Assert.assertEquals(draggablePage.getContainedBoxXPosition(), containedBoxXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getContainedBoxYPosition(), containedBoxYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"containedTextXPositionExpected","containedTextYPositionExpected"})
    @Test
    public void isTextContainedInBoxDroppedToCoordinates(String containedTextXPositionExpected, String containedTextYPositionExpected ){
        draggablePage.clickOnTabContainerRestricted();
        draggablePage.moveContainedText(Integer.parseInt(containedTextXPositionExpected),Integer.parseInt(containedTextYPositionExpected));
        Assert.assertEquals(draggablePage.getContainedTextXPosition(), containedTextXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getContainedTextYPosition(), containedTextYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"elementOfCenterCursorXPositionExpected","elementOfCenterCursorYPositionExpected"})
    @Test
    public void isCenterCursorElementDroppedToCoordinates(String elementOfCenterCursorXPositionExpected, String elementOfCenterCursorYPositionExpected){
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveCenterCursorOfCursorStyle(Integer.parseInt(elementOfCenterCursorXPositionExpected),Integer.parseInt(elementOfCenterCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfCenterCursorXPosition(), elementOfCenterCursorXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getElementOfCenterCursorYPosition(), elementOfCenterCursorYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"elementOfTopCursorXPositionExpected","elementOfTopCursorYPositionExpected"})
    @Test
    public void isTopCursorElementDroppedToCoordinates(String elementOfTopCursorXPositionExpected, String elementOfTopCursorYPositionExpected){
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveTopCursorOfCursorStyle(Integer.parseInt(elementOfTopCursorXPositionExpected),Integer.parseInt(elementOfTopCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfTopCursorXPosition(), elementOfTopCursorXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getElementOfTopCursorYPosition(), elementOfTopCursorYPositionExpected + prop.getProperty("pxMeasurer"));
    }

    @Parameters({"elementOfBottomCursorXPositionExpected","elementOfBottomCursorYPositionExpected"})
    @Test
    public void isBottomCursorElementDroppedToCoordinates(String elementOfBottomCursorXPositionExpected, String elementOfBottomCursorYPositionExpected){
        draggablePage.clickOnTabCursorStyle();
        draggablePage.moveBottomCursorOfCursorStyle(Integer.parseInt(elementOfBottomCursorXPositionExpected),Integer.parseInt(elementOfBottomCursorYPositionExpected));
        Assert.assertEquals(draggablePage.getElementOfBottomCursorXPosition(), elementOfBottomCursorXPositionExpected + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(draggablePage.getElementOfBottomCursorYPosition(), "-50" + prop.getProperty("pxMeasurer"));
    }
}