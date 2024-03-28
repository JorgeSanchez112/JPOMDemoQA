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
    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing DroppablePageTest Class------------------");
        droppablePage = homePage.clickOnSectionInteractions().clickOnDroppable();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(droppablePage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateSimpleTabIsVisible(){
        logger.info("-------------------validateSimpleTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isSimpleTabVisible());
    }

    @Test
    public void validateAcceptTabIsVisible(){
        logger.info("-------------------validateAcceptTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isAcceptTabVisible());
    }

    @Test
    public void validatePreventTabIsVisible(){
        logger.info("-------------------validatePreventTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isPreventTabVisible());
    }

    @Test
    public void validateRevertTabIsVisible(){
        logger.info("-------------------validateRevertTabIsVisible-----------------------");
        Assert.assertTrue(droppablePage.isRevertTabVisible());
    }

    @Test
    public void isSimpleDraggableDroppedToTarget(){
        logger.info("-------------------isSimpleDraggableDroppedToTarget-----------------------");
        droppablePage.moveSimpleDraggableToTarget();
        Assert.assertTrue(droppablePage.isSimpleDraggableDropped());
    }

    @Test
    public void isAcceptableDraggableDroppedToTarget(){
        logger.info("-------------------isAcceptableDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabAccept();
        droppablePage.moveDraggableAcceptableToTarget();
        Assert.assertTrue(droppablePage.isAcceptDraggableDropped());
    }

    @Test
    public void isNotAcceptableDraggableDroppedToTarget(){
        logger.info("-------------------isNotAcceptableDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabAccept();
        droppablePage.moveDraggableNotAcceptableToTarget();
        Assert.assertFalse(droppablePage.isNotAcceptDraggableDropped());
    }

    @Test
    public void isPreventDraggableDroppedToNotGreedyTarget(){
        logger.info("-------------------isPreventDraggableDroppedToNotGreedyTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToNotGreedyTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToNotGreedyDropped());
    }

    @Test
    public void isPreventDraggableDroppedToNotGreedyInnerTarget(){
        logger.info("-------------------isPreventDraggableDroppedToNotGreedyInnerTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToNotGreedyInnerTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToNotGreedyInnerDropped());
    }

    @Test
    public void isPreventDraggableDroppedToGreedyTarget(){
        logger.info("-------------------isPreventDraggableDroppedToGreedyTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToGreedyTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToGreedyDropped());
    }

    @Test
    public void isPreventDraggableDroppedToGreedyInnerTarget(){
        logger.info("-------------------isPreventDraggableDroppedToGreedyInnerTarget-----------------------");
        droppablePage.clickOnTabPrevent();
        droppablePage.movePreventDraggableToGreedyInnerTarget();
        Assert.assertTrue(droppablePage.isPreventDraggableToGreedyInnerDropped());
    }

    @Test
    public void isRevertDraggableDroppedToTarget(){
        logger.info("-------------------isRevertDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabRevert();
        droppablePage.moveRevertDraggableToTarget();
        Assert.assertTrue(droppablePage.isNotRevertDraggableDropped());
    }

    @Test
    public void isNoRevertDraggableDroppedToTarget(){
        logger.info("-------------------isNoRevertDraggableDroppedToTarget-----------------------");
        droppablePage.clickOnTabRevert();
        droppablePage.moveNoRevertDraggableToTarget();
        Assert.assertTrue(droppablePage.isNotRevertDraggableDropped());
    }
}
