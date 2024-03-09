package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends BasePages {
    @FindBy(css = "#framesWrapper > div:nth-child(2)")
    private WebElement useAdvices;
    @FindBy(id = "frame1")
    private WebElement parentFrame;
    @FindBy(tagName = "body")
    private WebElement textParent;
    @FindBy(tagName = "p")
    private WebElement textChild;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void switchToParentFrame(){
        driver.switchTo().frame(parentFrame);
    }

    public void switchToChildFrame(){
        driver.switchTo().frame(0);
    }

    public String getPageTitleText(){
        scroll(pageTitle);
        return getElementTextWithWait(pageTitle);
    }

    public String getParentText(){
        return getElementTextWithWait(textParent);
    }

    public String getChildText(){
        return getElementTextWithWait(textChild);
    }

    public boolean isUseAdvicesVisible(){
        return isElementDisplayedWithWait(useAdvices);
    }
}
