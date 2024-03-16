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

    private final float WIDTH_BASE_OF_RESIZABLE_FREE = 200;
    private final float HEIGHT_BASE_OF_RESIZABLE_FREE = 200;

    public ResizablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void resizeBoxRestrictedToMax(int width, int height){
        scroll(resizableBoxRestricted);
        hidePublicity(rightSidePublicity);
        resizeElement(resizeIconOfBoxRestricted, width, height);
    }

    public void resizeFreeBox(float width, float height){
        scroll(resizableBox);
        hidePublicity(rightSidePublicity);
        resizeElement(resizeIcon, (int) (subtractQuantityToParameter(width,WIDTH_BASE_OF_RESIZABLE_FREE)), (int) subtractQuantityToParameter(height,HEIGHT_BASE_OF_RESIZABLE_FREE));
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
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

    public boolean isResizableRestrictedTextVisible(){
        return isElementDisplayedWithWait(resizableRestrictedText);
    }

    public boolean isResizableTextVisible(){
        return isElementDisplayedWithWait(resizableText);
    }
}
