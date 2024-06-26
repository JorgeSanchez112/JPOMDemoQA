package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectablePage extends PageBase {
    @FindBy(id = "demo-tab-grid")
    private WebElement tabGrid;
    @FindBy(css = ".mt-2.list-group-item")
    private List<WebElement> elementsList;
    @FindBy(css = "#gridContainer >* li.list-group-item")
    private List<WebElement> elementsGrid;

    private final String EXPECTED_CLASS = "active";

    public SelectablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public synchronized void clickOnTabGrid(){
        scroll(tabGrid);
        clickWithWait(tabGrid);
    }

    public void clickOnCrasJustoOdioListElement(){
        waitForChargedElementsOfAWebElementList(elementsList);
        scroll(elementsList.get(0));
        clickWithWait(elementsList.get(0));
    }

    public void clickOnDapibusAcFacilisisInListElement(){
        waitForChargedElementsOfAWebElementList(elementsList);
        scroll(elementsList.get(1));
        clickWithWait(elementsList.get(1));
    }

    public void clickOnMorbiLeoRisusListElement(){
        waitForChargedElementsOfAWebElementList(elementsList);
        scroll(elementsList.get(2));
        clickWithWait(elementsList.get(2));
    }

    public void clickOnPortaAcConsecteturAcListElement(){
        waitForChargedElementsOfAWebElementList(elementsList);
        scroll(elementsList.get(3));
        clickWithWait(elementsList.get(3));
    }

    public void clickOnOneGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(0));
        clickWithWait(elementsGrid.get(0));
    }

    public void clickOnTwoGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(1));
        clickWithWait(elementsGrid.get(1));
    }

    public void clickOnThreeGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(2));
        clickWithWait(elementsGrid.get(2));
    }

    public void clickOnFourGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(3));
        clickWithWait(elementsGrid.get(3));
    }

    public void clickOnFiveGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(4));
        clickWithWait(elementsGrid.get(4));
    }

    public void clickOnSixGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(5));
        clickWithWait(elementsGrid.get(5));
    }

    public void clickOnSevenGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(6));
        clickWithWait(elementsGrid.get(6));
    }

    public void clickOnEightGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(7));
        clickWithWait(elementsGrid.get(7));
    }

    public void clickOnNineGridElement(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        scroll(elementsGrid.get(8));
        clickWithWait(elementsGrid.get(8));
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public boolean isCrasJustoOdioListElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return doesElementContainExpectedClass(elementsList.get(0),EXPECTED_CLASS);
    }

    public boolean isDapibusAcFacilisisInListElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return doesElementContainExpectedClass(elementsList.get(1),EXPECTED_CLASS);
    }

    public boolean isMorbiLeoRisusListElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return doesElementContainExpectedClass(elementsList.get(2),EXPECTED_CLASS);
    }

    public boolean isPortaAcConsecteturAcListElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return doesElementContainExpectedClass(elementsList.get(3),EXPECTED_CLASS);
    }

    public boolean isOneGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsList);
        return doesElementContainExpectedClass(elementsGrid.get(0),EXPECTED_CLASS);
    }

    public boolean isTwoGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(1),EXPECTED_CLASS);
    }

    public boolean isThreeGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(2),EXPECTED_CLASS);
    }

    public boolean isFourGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(3),EXPECTED_CLASS);
    }

    public boolean isFiveGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(4),EXPECTED_CLASS);
    }

    public boolean isSixGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(5),EXPECTED_CLASS);
    }

    public boolean isSevenGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(6),EXPECTED_CLASS);
    }

    public boolean isEightGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(7),EXPECTED_CLASS);
    }

    public boolean isNineGridElementSelected(){
        waitForChargedElementsOfAWebElementList(elementsGrid);
        return doesElementContainExpectedClass(elementsGrid.get(8),EXPECTED_CLASS);
    }
}
