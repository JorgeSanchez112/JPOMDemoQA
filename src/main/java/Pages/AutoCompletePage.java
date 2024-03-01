package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoCompletePage extends BasePages {
    @FindBy(css = "#autoCompleteMultiple > span")
    private WebElement multipleContainerLabel;
    @FindBy(id = "autoCompleteMultipleInput")
    private WebElement multipleContainer;
    @FindBy(className = "auto-complete__multi-value")
    private List<WebElement> valuesOfMultipleContainer;
    @FindBy(css = "#autoCompleteSingle > span")
    private WebElement singleContainerLabel;
    @FindBy(id = "autoCompleteSingleInput")
    private WebElement singleContainer;
    @FindBy(className = "auto-complete__single-value")
    private WebElement valueOfSingleContainer;

    public AutoCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void typeInMultipleContainer(String text){
        sendKeysToElement(multipleContainer,text);
        pressEnterKey(multipleContainer);
    }

    public void typeInSingleContainer(String color){
        sendKeysToElement(singleContainer,color);
        pressEnterKey(singleContainer);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getMultipleContainerLabelText(){
        return getElementTextWithWait(multipleContainerLabel);
    }

    public String getSingleContainerLabelText(){
        return getElementTextWithWait(singleContainerLabel);
    }

    public boolean isTheValueContained(String value){
        for (WebElement valueColors : valuesOfMultipleContainer) {
            if (valueColors.getText().contains(value)){
                return true;
            }
        }
        return false;
    }

    public String getTextOfSingleContainerValue(){
        return getElementTextWithWait(valueOfSingleContainer);
    }
}