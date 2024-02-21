package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.Alert;
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

    public void acceptAlert(){
        waitAlert();
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        waitAlert();
        driver.switchTo().alert().dismiss();
    }

    public void typeInAlert(String text){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getConfirmResultText(){
        return confirmAlertButtonResult.getText();
    }

    public String getInputAlertText(){
        return inputAlertButtonText.getText();
    }

    public boolean isFirstLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return labels.get(0).isDisplayed();
    }

    public boolean isSecondLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return labels.get(1).isDisplayed();
    }

    public boolean isThirdLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return labels.get(2).isDisplayed();
    }

    public boolean isFourthLabelVisible(){
        waitForChargedElementsOfAWebElementList(labels);
        return labels.get(3).isDisplayed();
    }

}
