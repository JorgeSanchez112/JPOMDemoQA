package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SortablePage extends BasePages {
    @FindBy(id = "demo-tab-grid")
    private WebElement tabGrid;
    @FindBy(css = "#demo-tabpane-list >* .list-group-item-action")
    private List<WebElement> elementsList;
    @FindBy(css = "#demo-tabpane-grid >* .list-group-item-action")
    private List<WebElement> elementsGrid;

    public SortablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnTabGrid(){
        clickWithWait(tabGrid);
    }

    public void moveFirstElementListToLastElement(){
        waitForChargedElementsOfAWebElementList(elementsList);
        dragDropMoveElementToTarget(elementsList.get(0), elementsList.get(5));
    }

    public void moveSecondElementListToPenultimateElement(){
        waitForChargedElementsOfAWebElementList(elementsList);
        dragDropMoveElementToTarget(elementsList.get(1), elementsList.get(4));
    }

    public void moveTheThirdElementListToTheSecondToLastElement(){
        waitForChargedElementsOfAWebElementList(elementsList);
        dragDropMoveElementToTarget(elementsList.get(2), elementsList.get(3));
    }

    public void moveFirstElementGridToLastElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        dragDropMoveElementToTarget(elementsGrid.get(0), elementsGrid.get(8));
    }

    public void moveFirstElementGridToFourthElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        dragDropMoveElementToTarget(elementsGrid.get(0), elementsGrid.get(3));
    }

    public void moveFirstElementGridToFifthElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        dragDropMoveElementToTarget(elementsGrid.get(0), elementsGrid.get(4));
    }

    public void moveFirstElementGridToSixthElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        dragDropMoveElementToTarget(elementsGrid.get(0), elementsGrid.get(5));
    }

    public void moveSecondElementGridToPenultimateElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        dragDropMoveElementToTarget(elementsGrid.get(1), elementsGrid.get(7));
    }

    public void moveTheThirdElementGridToTheSecondToLastElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        dragDropMoveElementToTarget(elementsGrid.get(2), elementsGrid.get(6));
    }

    public void scrollToLastElementList(){
        scroll(elementsList.get(5));
    }

    public void scrollToLastElementGrid(){
        scroll(elementsGrid.get(8));
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getTextOfFirstElementValueOfElementsList(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return elementsList.get(0).getText();
    }

    public String getTextOfSecondElementValueOfElementsList(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return elementsList.get(1).getText();
    }

    public String getTextOfThirdElementValueOfElementsList(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return elementsList.get(2).getText();
    }

    public String getTextOfFourthElementValueOfElementsList(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return elementsList.get(3).getText();
    }

    public String getTextOfFifthElementValueOfElementsList(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return elementsList.get(4).getText();
    }

    public String getTextOfSixthElementValueOfElementsList(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return elementsList.get(5).getText();
    }

    public String getTextOfFirstElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(0).getText();
    }

    public String getTextOfSecondElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(1).getText();
    }

    public String getTextOfThirdElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(2).getText();
    }

    public String getTextOfFourthElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(3).getText();
    }

    public String getTextOfFifthElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(4).getText();
    }

    public String getTextOfSixthElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(5).getText();
    }

    public String getTextOfSeventhElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(6).getText();
    }

    public String getTextOfEighthElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(7).getText();
    }

    public String getTextOfNinethElementValueOfElementsGrid(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return elementsGrid.get(8).getText();
    }

}
