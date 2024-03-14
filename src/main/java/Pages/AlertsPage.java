package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertsPage extends BasePages {
    @FindBy(className = "mr-3")
    private List<WebElement> labels;
    @FindBy(id = "alertButton")
    private WebElement alertButton;
    @FindBy(id = "timerAlertButton")
    private WebElement afterFiveSecButton;
    @FindBy(id = "confirmButton")
    private WebElement confirmAlertButton;
    @FindBy(id = "promtButton")
    private WebElement inputAlertButton;
    @FindBy(id = "confirmResult")
    private WebElement confirmAlertButtonResult;
    @FindBy(id = "promptResult")
    private WebElement inputAlertButtonText;

    public AlertsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnFirstButton(){
        clickWithWait(alertButton);
    }

    public void clickOnSecondButton(){
        clickWithWait(afterFiveSecButton);
    }

    public void clickOnThirdButton(){
        scroll(confirmAlertButton);
        clickWithWait(confirmAlertButton);
    }

    public void clickOnFourthButton(){
        scroll(inputAlertButton);
        clickWithWait(inputAlertButton);
    }

    public void confirmAlert(){
        acceptAlertWithWait();
    }

    public void cancelAlert(){
        dismissAlertWithWait();
    }

    public void typeInAlert(String text){
        try{
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            confirmAlert();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getConfirmResultText(){
        return getElementTextWithWait(confirmAlertButtonResult);
    }

    public String getInputAlertText(){
        return getElementTextWithWait(inputAlertButtonText);
    }

    public boolean isFirstLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return isElementDisplayedWithWait(labels.get(0));
    }

    public boolean isSecondLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return isElementDisplayedWithWait(labels.get(1));
    }

    public boolean isThirdLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return isElementDisplayedWithWait(labels.get(2));
    }

    public boolean isFourthLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return isElementDisplayedWithWait(labels.get(3));
    }
}