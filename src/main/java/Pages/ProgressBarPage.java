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
        clickWithWait(startButton);
    }

    public void clickOnResetButton(){
        clickWithWait(resetButton);
    }

    public void waitForResetButton(){
        waitForVisibleElement(resetButton);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getLabelText(){
        return label.getText();
    }

    public String getPercentText(){
        return progressBar.getText();
    }

}
