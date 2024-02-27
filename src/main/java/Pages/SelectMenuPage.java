package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePages {
    @FindBy(css = "#selectMenuContainer > div:nth-child(2) > div")
    private WebElement valueLabel;
    @FindBy(className = "css-1uccc91-singleValue")
    private WebElement valueOfSelectValueContainer;
    @FindBy(id = "react-select-2-input")
    private WebElement selectValueInput;
    @FindBy(css = "#selectMenuContainer > div:nth-child(4) > div")
    private WebElement oneLabel;
    @FindBy(id = "selectOne")
    private WebElement selectOneContainer;
    @FindBy(css = "#selectOne >* .css-1uccc91-singleValue")
    private WebElement valueOfSelectOneContainer;
    @FindBy(id = "react-select-3-input")
    private WebElement selectOneInput;
    @FindBy(css = "#selectMenuContainer > div:nth-child(6) > div")
    private WebElement oldStyleSelectLabel;
    @FindBy(id = "oldSelectMenu")
    private WebElement oldStyleSelectMenu;
    @FindBy(css = "#oldSelectMenu >*")
    private List<WebElement> optionsOFOldStyleMenu;
    @FindBy(css = ".col-md-6.col-sm-12 > p")
    private List<WebElement> fourthAndFifthLabels;
    @FindBy(css = "#selectMenuContainer > .row:nth-child(8) >*  .css-2b097c-container")
    private WebElement multiSelectDropDownContainer;
    @FindBy(css = "#react-select-4-input")
    private WebElement multiSelectDropDownInput;
    @FindBy(css = ".css-1rhbuit-multiValue > .css-12jo7m5")
    private List<WebElement> multiSelectDropDownValues;
    @FindBy(id = "cars")
    private WebElement standardMultiSelect;
    @FindBy(css = "#cars > option")
    private List<WebElement> standardMultiSelectValues;

    public SelectMenuPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void clickOnSelectOneContainer(){
        scroll(selectOneContainer);
        clickWithWait(selectOneContainer);
    }

    public void clickOnMultiSelectDropdownContainer(){
        scroll(multiSelectDropDownContainer);
        clickWithWait(multiSelectDropDownContainer);
    }

    public void typeInSelectValueDropDown(String value){
        selectValueInput.sendKeys(value);
    }

    public void typeOptionInSelectOneDropDown(String title){
        selectOneInput.sendKeys(title);
    }

    public void typeAndSelectOptionInMultiSelectDropDown(String value){
        multiSelectDropDownInput.sendKeys(value);
        enterActionInMultiSelectDropDown();
    }

    public void enterActionInSelectValueDropDown(){
        selectValueInput.sendKeys(Keys.ENTER);
    }

    public void enterActionInSelectOneDropDown(){
        selectOneInput.sendKeys(Keys.ENTER);
    }

    public void enterActionInMultiSelectDropDown(){
        multiSelectDropDownInput.sendKeys(Keys.ENTER);
    }

    public void selectAllOptionsInMultiSelectDropDown(){
        typeAndSelectOptionInMultiSelectDropDown("Green");
        typeAndSelectOptionInMultiSelectDropDown("Blue");
        typeAndSelectOptionInMultiSelectDropDown("Black");
        typeAndSelectOptionInMultiSelectDropDown("Red");
    }

    public void selectValueOnOldStyleSelectMenu(String color){
        selectOneElementAccordingToText(oldStyleSelectMenu,color);
    }

    public void scrollAndSelectValueOnStandardMultiSelect(String value){
        selectOneElementAccordingToText(standardMultiSelect,value);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getValueLabelText(){
        return valueLabel.getText();
    }

    public String getSelectValueContainerText(){
        return valueOfSelectValueContainer.getText();
    }

    public String getOneLabelText(){
        return oneLabel.getText();
    }

    public String getSelectOneContainerText() {
        return valueOfSelectOneContainer.getText();
    }

    public String getOldStyleSelectLabelText(){
        return oldStyleSelectLabel.getText();
    }

    public String getSelectValueOnOldStyleSelectMenuText(){
        return oldStyleSelectMenu.getAttribute("value");//this obtains the value of the selected option that is numeryc
    }

    public String RetrieveTextofSelectedOptionFromOldStyleMenu(){
        waitForChargedElementsOfAWebElementList(optionsOFOldStyleMenu);//assure all element of list are charged
        WebElement positionOfValue = optionsOFOldStyleMenu.get(Integer.parseInt(getSelectValueOnOldStyleSelectMenuText()));//the value of the option is according to the position so is first envelope the option in a list for then get the value so get the text.
        return positionOfValue.getText();
    }

    public String getMultiSelectDropdownLabelText(){
        return fourthAndFifthLabels.get(0).getText();
    }

    public String getGreenValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return multiSelectDropDownValues.get(0).getText();
    }

    public String getBlueValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return multiSelectDropDownValues.get(1).getText();
    }

    public String getBlackValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return multiSelectDropDownValues.get(2).getText();
    }

    public String getRedValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return multiSelectDropDownValues.get(3).getText();
    }

    public String getStandardMultiSelectLabelText(){
        return fourthAndFifthLabels.get(1).getText();
    }

    public boolean isVolvoSelectedOfStandardMultiSelect(){
        return standardMultiSelectValues.get(0).isSelected();
    }

    public boolean isSaabSelectedOfStandardMultiSelect(){
        return standardMultiSelectValues.get(1).isSelected();
    }

    public boolean isOpelSelectedOfStandardMultiSelect(){
        return standardMultiSelectValues.get(2).isSelected();
    }

    public boolean isAudiSelectedOfStandardMultiSelect(){
        return standardMultiSelectValues.get(3).isSelected();
    }

}
