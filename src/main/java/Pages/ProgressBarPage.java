package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public void waitForProgressBarIsFull(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBe(By.id("progressBar"),"100%"));
    }

    public void waitForResetButton(){
        waitForVisibleElement(resetButton);
    }

    public void startProgressBarAndWaitTo100Percent() {
        clickOnStartButton();
        waitForProgressBarIsFull();
    }

    public void startProgressBarTillEndAndRestartBar(){
        clickOnStartButton();
        waitForResetButton();
        clickOnResetButton();
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getLabelText(){
        scroll(label);
        return label.getText();
    }

    public String getPercentText(){
        scroll(progressBar);
        return progressBar.getText();
    }

}