package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CheckBoxPage extends PageBase {
    @FindBy(className = "rct-option-expand-all")
    private WebElement expandTree;
    @FindBy(css = ".rct-node-expanded > ol > li > span > label")
    private List<WebElement> listOfCheckboxes;
    @FindBy(css = ".rct-node-expanded >* input[type='checkbox']")
    private List<WebElement> listMainCheckbox;
    @FindBy(id = "#tree-node-desktop")
    private WebElement test;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnExpandButton(){
        scroll(expandTree);
        clickWithWait(expandTree);
    }

    public void clickOnNotes(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(1));
        clickWithWait(listOfCheckboxes.get(1));
    }

    public void clickOnCommand(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(2));
        clickWithWait(listOfCheckboxes.get(2));
    }

    public void clickInDesktopElements(){
        clickOnNotes();
        clickOnCommand();
    }

    public void clickOnReact(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(5));
        clickWithWait(listOfCheckboxes.get(5));
    }

    public void clickOnAngular(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(6));
        clickWithWait(listOfCheckboxes.get(6));
    }

    public void clickOnVeu(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(7));
        clickWithWait(listOfCheckboxes.get(7));
    }

    public void clickInWorkspaceElements(){
        clickOnReact();
        clickOnAngular();
        clickOnVeu();
    }

    public void clickOnPublic(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(9));
        clickWithWait(listOfCheckboxes.get(9));
    }

    public void clickOnPrivate(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(10));
        clickWithWait(listOfCheckboxes.get(10));
    }

    public void clickOnClassified(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(11));
        clickWithWait(listOfCheckboxes.get(11));
    }

    public void clickOnGeneral(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(12));
        clickWithWait(listOfCheckboxes.get(12));
    }

    public void clickInOfficeElements(){
        clickOnPublic();
        clickOnPrivate();
        clickOnClassified();
        clickOnGeneral();
    }

    public void clickOnWordFile(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(14));
        clickWithWait(listOfCheckboxes.get(14));
    }

    public void clickOnExcelFile(){
        waitForChargedElementsOfAWebElementList(listOfCheckboxes);
        scroll(listOfCheckboxes.get(15));
        clickWithWait(listOfCheckboxes.get(15));
    }

    public void clickInDownloadElements(){
        clickOnWordFile();
        clickOnExcelFile();
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public boolean checkBoxDesktopIsClicked(){
        return hasElementBeenSelected(listMainCheckbox.get(1));
    }

    public boolean checkDocumentsClicked(){
        return hasElementBeenSelected(listMainCheckbox.get(4));
    }

    public boolean checkDownloadsClicked(){
        return hasElementBeenSelected(listMainCheckbox.get(14));
    }
}
