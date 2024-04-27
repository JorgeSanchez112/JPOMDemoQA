package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage extends PageBase {
    @FindBy(css = "#framesWrapper > div:nth-child(2)")
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
        return getElementTextWithWait(pageTitle);
    }

    public synchronized String getFrameText(){
        return getElementTextWithWait(text);
    }

    public boolean isUseAdvicesTextVisible(){
        return isElementDisplayedWithWait(useAdvices);
    }
}
