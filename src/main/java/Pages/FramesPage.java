package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends BasePages {
    @FindBy(css = "#framesWrapper > div:nth-child(1)")
    private WebElement useAdvices;
    @FindBy(id = "frame1")
    private WebElement bigFrame;
    @FindBy(id = "frame2")
    private WebElement shortFrame;
    @FindBy(id = "sampleHeading")
    private WebElement text;

    public FramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void switchToBigFrame(){
        driver.switchTo().frame(bigFrame);
    }

    public void switchToShortFrame(){
        driver.switchTo().frame(shortFrame);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public boolean validateTextFrames(){
        return text.getText().contains("This is a sample page");
    }

    public boolean isUseAdvicesTextVisible(){
        return useAdvices.isDisplayed();
    }
}
