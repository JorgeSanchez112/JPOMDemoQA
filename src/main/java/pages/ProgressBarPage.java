package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgressBarPage extends PageBase {
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

    public synchronized void clickOnStartButton(){
        scroll(startButton);
        clickWithWait(startButton);
    }

    public void clickOnResetButton(){
        scroll(resetButton);
        clickWithWait(resetButton);
    }

    public synchronized void waitForResetButton(){
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

    public synchronized String getPercentText(){
        return getElementTextWithWait(progressBar);
    }

}
