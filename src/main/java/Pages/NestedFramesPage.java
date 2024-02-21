package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends BasePages {
    @FindBy(css = "#framesWrapper > div:nth-child(1)")
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
        return pageTitle.getText();
    }

    public String getParentText(){
        return textParent.getText();
    }

    public String getChildText(){
        return textChild.getText();
    }

    public boolean isUseAdvicesVisible(){
        return useAdvices.isDisplayed();
    }
}
