package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SortablePageTest extends TestBase {
    @BeforeMethod //review all this page, I think that could improve it.
    public void initializeClassAndHidePublicity(){
        sortablePage = homePage.clickOnSectionInteractions().clickOnSortable();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(sortablePage.getPageTitleText(),pageTitle);
    }

    @Parameters({"numberOne","numberTwo"})
    @Test
    public void dragFirstElementAndDropItInLastElementOfElementLists(String numberOne, String numberTwo) {
        sortablePage.scrollToLastElementList();
        sortablePage.moveFirstElementListToLastElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsList(), numberTwo);
        Assert.assertEquals(sortablePage.getTextOfSixthElementValueOfElementsList(), numberOne);
    }

    @Parameters({"numberTwo","numberThree"})
    @Test
    public void dragSecondElementAndDropItInPenultimateElementOfElementLists(String numberTwo, String numberThree) {
        sortablePage.scrollToLastElementList();
        sortablePage.moveSecondElementListToPenultimateElement();
        Assert.assertEquals(sortablePage.getTextOfSecondElementValueOfElementsList(), numberThree);
        Assert.assertEquals(sortablePage.getTextOfFifthElementValueOfElementsList(), numberTwo);
    }

    @Parameters({"numberThree","numberFour"})
    @Test
    public void dragThirdElementAndDropItInTheSecondToLastElementOfElementLists(String numberThree, String numberFour) {
        sortablePage.scrollToLastElementList();
        sortablePage.moveTheThirdElementListToTheSecondToLastElement();
        Assert.assertEquals(sortablePage.getTextOfThirdElementValueOfElementsList(), numberFour);
        Assert.assertEquals(sortablePage.getTextOfFourthElementValueOfElementsList(), numberThree);
    }

    @Parameters({"numberOne","numberTwo"})
    @Test
    public void dragFirstElementAndDropItInLastElementOfElementsGrid(String numberOne, String numberTwo) {
        sortablePage.clickOnTabGrid();
        sortablePage.scrollToLastElementGrid();
        sortablePage.moveFirstElementGridToLastElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), numberTwo);
        Assert.assertEquals(sortablePage.getTextOfNinethElementValueOfElementsGrid(), numberOne);
    }

    @Parameters({"numberTwo","numberThree"})
    @Test
    public void dragSecondElementAndDropItInPenultimateElementOfElementsGrid(String numberTwo, String numberThree) {
        sortablePage.clickOnTabGrid();
        sortablePage.scrollToLastElementGrid();
        sortablePage.moveSecondElementGridToPenultimateElement();
        Assert.assertEquals(sortablePage.getTextOfSecondElementValueOfElementsGrid(), numberThree);
        Assert.assertEquals(sortablePage.getTextOfEighthElementValueOfElementsGrid(), numberTwo);
    }

    @Parameters({"numberThree","numberFour"})
    @Test
    public void dragThirdElementAndDropItInTheSecondToLastElementOfElementsGrid(String numberThree, String numberFour) {
        sortablePage.clickOnTabGrid();
        sortablePage.scrollToLastElementGrid();
        sortablePage.moveTheThirdElementGridToTheSecondToLastElement();
        Assert.assertEquals(sortablePage.getTextOfThirdElementValueOfElementsGrid(), numberFour);
        Assert.assertEquals(sortablePage.getTextOfSeventhElementValueOfElementsGrid(), numberThree);
    }

    @Parameters({"numberOne","numberTwo"})
    @Test
    public void dragFirstElementAndDropItInFourthElementOfElementsGrid(String numberOne, String numberTwo) {
        sortablePage.clickOnTabGrid();
        sortablePage.scrollToLastElementGrid();
        sortablePage.moveFirstElementGridToFourthElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), numberTwo);
        Assert.assertEquals(sortablePage.getTextOfFourthElementValueOfElementsGrid(), numberOne);
    }

    @Parameters({"numberOne","numberTwo"})
    @Test
    public void dragFirstElementAndDropItInFifthElementOfElementsGrid(String numberOne, String numberTwo) {
        sortablePage.clickOnTabGrid();
        sortablePage.scrollToLastElementGrid();
        sortablePage.moveFirstElementGridToFifthElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), numberTwo);
        Assert.assertEquals(sortablePage.getTextOfFifthElementValueOfElementsGrid(), numberOne);
    }

    @Parameters({"numberOne","numberTwo"})
    @Test
    public void dragFirstElementAndDropItInSixthElementOfElementsGrid(String numberOne, String numberTwo) {
        sortablePage.clickOnTabGrid();
        sortablePage.scrollToLastElementGrid();
        sortablePage.moveFirstElementGridToSixthElement();
        Assert.assertEquals(sortablePage.getTextOfFirstElementValueOfElementsGrid(), numberTwo);
        Assert.assertEquals(sortablePage.getTextOfSixthElementValueOfElementsGrid(), numberOne);
    }
}
