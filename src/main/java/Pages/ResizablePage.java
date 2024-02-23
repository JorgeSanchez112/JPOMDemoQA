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

    private int sizeX = 0;
    private int sizeY = 0;

    public ResizablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void resizeBoxRestrictedToMax(int width, int height){
        sizeX = subtractBaseSize(Integer.parseInt(getWidthOfBoxRestricted()),width);
        sizeY = subtractBaseSize(Integer.parseInt(getHeightOfBoxRestricted()),height);
        scroll(resizableBoxRestricted);
        hidePublicity(rightSidePublicity);
        resizeElement(resizeIconOfBoxRestricted, sizeX, sizeY);
    }

    public void resizeFreeBox(int width, int height){
        sizeX = subtractBaseSize(Integer.parseInt(getHeightOfResizeBox()),width);
        sizeY = subtractBaseSize(Integer.parseInt(getWidthOfResizeBox()),height);
        scroll(resizableBox);
        hidePublicity(rightSidePublicity);
        resizeElement(resizeIcon, sizeX, sizeY);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getWidthOfBoxRestricted(){
        return resizableBoxRestricted.getCssValue("width");
    }

    public String getWidthOfResizeBox(){
        return resizableBox.getCssValue("width");
    }

    public String getHeightOfBoxRestricted(){
        return resizableBoxRestricted.getCssValue("height");
    }

    public String getHeightOfResizeBox(){
        return resizableBox.getCssValue("height");
    }

    public int subtractBaseSize(int BaseSize, int value){
        return BaseSize - value;
    }

    public boolean isResizableRestrictedTextVisible(){
        return resizableRestrictedText.isDisplayed();
    }

    public boolean isResizableTextVisible(){
        return resizableText.isDisplayed();
    }
}
