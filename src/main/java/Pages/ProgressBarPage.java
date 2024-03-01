package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends BasePages {
    @FindBy(className = "mb-3")
    private WebElement label;
    @FindBy(id = "progressBar")
    private WebElement progressBar;
    @FindBy(id = "startStopButton")
    private WebElement startButton;
    @FindBy(id = "resetButton")
    private WebElement resetButton;

    public ProgressBarPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnStartButton(){
        scroll(startButton);
        clickWithWait(startButton);
    }

    public void clickOnResetButton(){
        scroll(resetButton);
        clickWithWait(resetButton);
    }

    public void waitForResetButton(){
        waitForVisibleElement(resetButton);
    }

    public void startProgressBarAndWaitTo100Percent()   {
        clickOnStartButton();
        waitForResetButton();
    }

    public void startProgressBarTillEndAndRestartBar(){
        clickOnStartButton();
        waitForResetButton();
        clickOnResetButton();
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getLabelText(){
        return getElementTextWithWait(label);
    }

    public String getPercentText(){
        return getElementTextWithWait(progressBar);
    }

}