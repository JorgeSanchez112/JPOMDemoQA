package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SortablePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(SortablePageTest.class);
    private final String ONE = "One";
    private final String TWO = "Two";
    private final String THREE = "Three";
    private final String FOUR = "Four";

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClassAndHidePublicity(){
        logger.info("-------------------Initializing SortablePageTest Class------------------");
        sortablePage = homePage.clickOnSectionInteractions().clickOnSortable();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Sortable";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(sortablePage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"Functional"})
    public void dragFirstElementAndDropItInLastElementOfElementLists(){
        logger.info("-------------------dragFirstElementAndDropItInLastElementOfElementLists-----------------------");
        sortablePage.moveFirstElementListToLastElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsList(), TWO);
        Assert.assertEquals(sortablePage.getTextOfSixthElementValueOfElementsList(), ONE);
    }

    @Parameters({"numberTwo","numberThree"})
    @Test(groups = {"Functional"})
    public void dragSecondElementAndDropItInPenultimateElementOfElementLists(){
        logger.info("-------------------dragSecondElementAndDropItInPenultimateElementOfElementLists-----------------------");
        sortablePage.moveSecondElementListToPenultimateElement();
        Assert.assertEquals(sortablePage.getTextOfSecondElementValueOfElementsList(), THREE);
        Assert.assertEquals(sortablePage.getTextOfFifthElementValueOfElementsList(), TWO);
    }

    @Test(groups = {"Functional"})
    public void dragThirdElementAndDropItInTheSecondToLastElementOfElementLists(){
        logger.info("-------------------dragThirdElementAndDropItInTheSecondToLastElementOfElementLists-----------------------");
        sortablePage.moveTheThirdElementListToTheSecondToLastElement();
        Assert.assertEquals(sortablePage.getTextOfThirdElementValueOfElementsList(), FOUR);
        Assert.assertEquals(sortablePage.getTextOfFourthElementValueOfElementsList(), THREE);
    }

    @Test(groups = {"Functional"})
    public void dragFirstElementAndDropItInLastElementOfElementsGrid(){
        logger.info("-------------------dragFirstElementAndDropItInLastElementOfElementsGrid-----------------------");
        sortablePage.clickOnTabGrid();
        sortablePage.moveFirstElementGridToLastElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), TWO);
        Assert.assertEquals(sortablePage.getTextOfNinethElementValueOfElementsGrid(), ONE);
    }

    @Test(groups = {"Functional"})
    public void dragSecondElementAndDropItInPenultimateElementOfElementsGrid(){
        logger.info("-------------------dragSecondElementAndDropItInPenultimateElementOfElementsGrid-----------------------");
        sortablePage.clickOnTabGrid();
        sortablePage.moveSecondElementGridToPenultimateElement();
        Assert.assertEquals(sortablePage.getTextOfSecondElementValueOfElementsGrid(), THREE);
        Assert.assertEquals(sortablePage.getTextOfEighthElementValueOfElementsGrid(), TWO);
    }

    @Test(groups = {"Functional"})
    public void dragThirdElementAndDropItInTheSecondToLastElementOfElementsGrid() {
        logger.info("-------------------dragThirdElementAndDropItInTheSecondToLastElementOfElementsGrid-----------------------");
        sortablePage.clickOnTabGrid();
        sortablePage.moveTheThirdElementGridToTheSecondToLastElement();
        Assert.assertEquals(sortablePage.getTextOfThirdElementValueOfElementsGrid(), FOUR);
        Assert.assertEquals(sortablePage.getTextOfSeventhElementValueOfElementsGrid(), THREE);
    }

    @Test(groups = {"Functional"})
    public void dragFirstElementAndDropItInFourthElementOfElementsGrid(){
        logger.info("-------------------dragFirstElementAndDropItInFourthElementOfElementsGrid-----------------------");
        sortablePage.clickOnTabGrid();
        sortablePage.moveFirstElementGridToFourthElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), TWO);
        Assert.assertEquals(sortablePage.getTextOfFourthElementValueOfElementsGrid(), ONE);
    }

    @Test(groups = {"Functional"})
    public void dragFirstElementAndDropItInFifthElementOfElementsGrid(){
        logger.info("-------------------dragFirstElementAndDropItInFifthElementOfElementsGrid-----------------------");
        sortablePage.clickOnTabGrid();
        sortablePage.moveFirstElementGridToFifthElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), TWO);
        Assert.assertEquals(sortablePage.getTextOfFifthElementValueOfElementsGrid(), ONE);
    }

    @Test(groups = {"Functional"})
    public void dragFirstElementAndDropItInSixthElementOfElementsGrid(){
        logger.info("-------------------dragFirstElementAndDropItInSixthElementOfElementsGrid-----------------------");
        sortablePage.clickOnTabGrid();
        sortablePage.moveFirstElementGridToSixthElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), TWO);
        Assert.assertEquals(sortablePage.getTextOfSixthElementValueOfElementsGrid(), ONE);
    }
}
