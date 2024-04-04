package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(css = "#react-select-4-input")
    private WebElement multiSelectDropDownInput;
    @FindBy(css = ".css-1rhbuit-multiValue > .css-12jo7m5")
    private List<WebElement> multiSelectDropDownValues;
    @FindBy(id = "cars")
    private WebElement standardMultiSelect;
    @FindBy(css = "#cars > option")
    private List<WebElement> standardMultiSelectValues;

    public SelectMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void typeInSelectValueDropDown(String value){
        sendKeysToElement(selectValueInput,value);
    }

    public void typeOptionInSelectOneDropDown(String title){
        sendKeysToElement(selectOneInput,title);
    }

    public void typeAndSelectOptionInMultiSelectDropDown(String value){
        sendKeysToElement(multiSelectDropDownInput,value);
        enterActionInMultiSelectDropDown();
    }

    public void enterActionInSelectValueDropDown(){
        pressEnterKey(selectValueInput);
    }

    public void enterActionInSelectOneDropDown(){
        pressEnterKey(selectOneInput);
    }

    public void enterActionInMultiSelectDropDown(){
        pressEnterKey(multiSelectDropDownInput);
    }

    public void selectAllOptionsInMultiSelectDropDown(){
        final String COLOR1 = "Green";
        final String COLOR2 = "Blue";
        final String COLOR3 = "Black";
        final String COLOR4 = "Red";

        typeAndSelectOptionInMultiSelectDropDown(COLOR1);
        typeAndSelectOptionInMultiSelectDropDown(COLOR2);
        typeAndSelectOptionInMultiSelectDropDown(COLOR3);
        typeAndSelectOptionInMultiSelectDropDown(COLOR4);
    }

    public void selectValueOnOldStyleSelectMenu(String color){
        selectOneElementAccordingToText(oldStyleSelectMenu,color);
    }

    public void scrollAndSelectAllValuesOnStandardMultiSelect(){
        for (WebElement element:standardMultiSelectValues) {
            scroll(element);
            selectOneElementAccordingToText(standardMultiSelect,element.getText());
        }
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getValueLabelText(){
        return getElementTextWithWait(valueLabel);
    }

    public String getSelectValueContainerText(){
        return getElementTextWithWait(valueOfSelectValueContainer);
    }

    public String getOneLabelText(){
        return getElementTextWithWait(oneLabel);
    }

    public String getSelectOneContainerText() {
        return getElementTextWithWait(valueOfSelectOneContainer);
    }

    public String getOldStyleSelectLabelText(){
        return getElementTextWithWait(oldStyleSelectLabel);
    }

    public String getSelectValueOnOldStyleSelectMenuText(){
        final String VALUE_ATTRIBUTE = "value";
        return getElementAttribute(oldStyleSelectMenu,VALUE_ATTRIBUTE);//this obtains the value of the selected option that is numeric
    }

    public String RetrieveTextOfSelectedOptionFromOldStyleMenu(){
        waitForChargedElementsOfAWebElementList(optionsOFOldStyleMenu);//assure all element of list are charged
        try{
            WebElement valueOfPosition = optionsOFOldStyleMenu.get(Integer.parseInt(getSelectValueOnOldStyleSelectMenuText()));//the value of the option is according to the position so is first envelope the option in a list for then get the value so get the text.
            return getElementTextWithWait(valueOfPosition);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return optionsOFOldStyleMenu.get(0).getText();
    }

    public String getMultiSelectDropdownLabelText(){
        return getElementTextWithWait(fourthAndFifthLabels.get(0));
    }

    public String getGreenValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return getElementTextWithWait(multiSelectDropDownValues.get(0));
    }

    public String getBlueValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return getElementTextWithWait(multiSelectDropDownValues.get(1));
    }

    public String getBlackValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return getElementTextWithWait(multiSelectDropDownValues.get(2));
    }

    public String getRedValueTextOfMultiplyDropdown(){
        waitForChargedElementsOfAWebElementList(multiSelectDropDownValues);
        return getElementTextWithWait(multiSelectDropDownValues.get(3));
    }

    public String getStandardMultiSelectLabelText(){
        waitForChargedElementsOfAWebElementList(fourthAndFifthLabels);
        return getElementTextWithWait(fourthAndFifthLabels.get(1));
    }

    public boolean wereAllOptionsSelectedOfStandardMultiSelect(){
        int c = 0;
        for (WebElement values: standardMultiSelectValues){
            if (hasElementBeenSelected(values)){
                c++;
            }
        }
        return c == standardMultiSelectValues.size();
    }
}
