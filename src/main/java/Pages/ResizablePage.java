package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResizablePage extends BasePages {
    @FindBy(id = "resizableBoxWithRestriction")
    private WebElement resizableBoxRestricted;
    @FindBy(css = "#resizableBoxWithRestriction > .text")
    private WebElement resizableRestrictedText;
    @FindBy(css = "#resizableBoxWithRestriction > .react-resizable-handle")
    private WebElement resizeIconOfBoxRestricted;
    @FindBy(id = "resizable")
    private WebElement resizableBox;
    @FindBy(css = "#resizable > .text")
    private WebElement resizableText;
    @FindBy(css = "#resizable > .react-resizable-handle")
    private WebElement resizeIcon;

    public ResizablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void resizeBoxRestrictedToMax() throws InterruptedException {
        scroll(resizableBoxRestricted);
        Thread.sleep(1000);
        resizeElement(resizeIconOfBoxRestricted, 300, 100);
    }

    public void resizeBoxTo500() throws InterruptedException {
        scroll(resizableBox);
        Thread.sleep(1000);
        resizeElement(resizeIcon, 300, 100);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getWeightOfBoxRestricted(){
        return resizableBoxRestricted.getCssValue("width");
    }

    public String getWeightOfResizeBox(){
        return resizableBox.getCssValue("width");
    }

    public String getHeightOfBoxRestricted(){
        return resizableBoxRestricted.getCssValue("height");
    }

    public String getHeightOfResizeBox(){
        return resizableBox.getCssValue("height");
    }

    public boolean isResizableRestrictedTextVisible(){
        return resizableRestrictedText.isDisplayed();
    }

    public boolean isResizableTextVisible(){
        return resizableText.isDisplayed();
    }
}
