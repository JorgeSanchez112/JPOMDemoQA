package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppablePageTest extends TestBase {
    private Logger logger = LogManager.getLogger(DroppablePageTest.class);
    private final String PAGE_TITLE = "Droppable";
    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing DroppablePageTest Class------------------");
        droppablePage = homePage.clickOnSectionInteractions().clickOnDroppable();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(droppablePage.getPageTitleText(),PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateSimpleTabIsVisible(){
        logger.info("-------------------validateSimpleTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isSimpleTabVisible());
    }

    @Test(groups = {"UI"})
    public void validateAcceptTabIsVisible(){
        logger.info("-------------------validateAcceptTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isAcceptTabVisible());
    }

    @Test(groups = {"UI"})
    public void validatePreventTabIsVisible(){
        logger.info("-------------------validatePreventTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isPreventTabVisible());
    }

    @Test(groups = {"UI"})
    public void validateRevertTabIsVisible(){
        logger.info("-------------------validateRevertTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isRevertTabVisible());
    }

    @Test(groups = {"Functional"})
    public void isSimpleDraggableDroppedToTarget(){
        logger.info("-------------------isSimpleDraggableDroppedToTarget-----------------------");
        droppablePage.moveSimpleDraggableToTarget();
        Assert.assertTrue(droppablePage.isSimpleDraggableDropped());
    }

    @Test(groups = {"Functional"})
    public void isAcceptableDraggableDroppedToTarget(){
        logger.info("-------------------isAcceptableDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabAccept();
        droppablePage.moveDraggableAcceptableToTarget();
        Assert.assertTrue(droppablePage.isAcceptDraggableDropped());
    }

    @Test(groups = {"Functional"})
    public void isNotAcceptableDraggableDroppedToTarget(){
        logger.info("-------------------isNotAcceptableDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabAccept();
        droppablePage.moveDraggableNotAcceptableToTarget();
        Assert.assertFalse(droppablePage.isNotAcceptDraggableDropped());
    }

    @Test(groups = {"Functional"})
    public void isPreventDraggableDroppedToNotGreedyTarget(){
        logger.info("-------------------isPreventDraggableDroppedToNotGreedyTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToNotGreedyTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToNotGreedyDropped());
    }

    @Test(groups = {"Functional"})
    public void isPreventDraggableDroppedToNotGreedyInnerTarget(){
        logger.info("-------------------isPreventDraggableDroppedToNotGreedyInnerTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToNotGreedyInnerTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToNotGreedyInnerDropped());
    }

    @Test(groups = {"Functional"})
    public void isPreventDraggableDroppedToGreedyTarget(){
        logger.info("-------------------isPreventDraggableDroppedToGreedyTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToGreedyTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToGreedyDropped());
    }

    @Test(groups = {"Functional"})
    public void isPreventDraggableDroppedToGreedyInnerTarget(){
        logger.info("-------------------isPreventDraggableDroppedToGreedyInnerTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToGreedyInnerTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToGreedyInnerDropped());
    }

    @Test(groups = {"Functional"})
    public void isRevertDraggableDroppedToTarget(){
        logger.info("-------------------isRevertDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabRevert();
        droppablePage.moveRevertDraggableToTarget();
        Assert.assertTrue(droppablePage.isNotRevertDraggableDropped());
    }

    @Test(groups = {"Functional"})
    public void isNoRevertDraggableDroppedToTarget(){
        logger.info("-------------------isNoRevertDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabRevert();
        droppablePage.moveNoRevertDraggableToTarget();
        Assert.assertTrue(droppablePage.isNotRevertDraggableDropped());
    }
}
