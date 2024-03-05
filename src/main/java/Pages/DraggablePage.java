package Pages;

import TestComponents.BasePages;
import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraggablePage extends BasePages {
    @FindBy(id = "draggableExample-tab-simple")
    private WebElement tabSimple;
    @FindBy(id = "draggableExample-tab-axisRestriction")
    private WebElement tabAxisRestricted;
    @FindBy(id = "draggableExample-tab-containerRestriction")
    private WebElement tabContainerRestricted;
    @FindBy(id = "draggableExample-tab-cursorStyle")
    private WebElement tabCursorStyle;
    @FindBy(id = "dragBox")
    private WebElement simpleBox;
    @FindBy(id = "restrictedX")
    private WebElement restrictedXBox;
    @FindBy(id = "restrictedY")
    private WebElement restrictedYBox;
    @FindBy(css = "#containmentWrapper > div")
    private WebElement containedBox;
    @FindBy(css = "#draggableExample-tabpane-containerRestriction >* > span")
    private WebElement containedText;
    @FindBy(id = "cursorCenter")
    private WebElement centerStyleCursor;
    @FindBy(id = "cursorTopLeft")
    private WebElement topLeftStyleCursor;
    @FindBy(id = "cursorBottom")
    private WebElement bottomStyleCursor;

    public DraggablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnTabAxisRestricted(){
        clickWithWait(tabAxisRestricted);
    }

    public void clickOnTabContainerRestricted(){
        clickWithWait(tabContainerRestricted);
    }

    public void clickOnTabCursorStyle(){
        clickWithWait(tabCursorStyle);
    }

    public void moveSimpleElement(float width, float height){
        moveElementToCoordinates(simpleBox,width, height);
    }

    public void moveXElement(float width, float height){
        moveElementToCoordinates(restrictedXBox,width, height);
    }

    public void moveYElement(float width, float height){
        moveElementToCoordinates(restrictedYBox,width,height);
    }

    public void moveContainedBox(float width, float height){
        moveElementToCoordinates(containedBox, width, height);
    }

    public void moveContainedText(float width, float height){
        scroll(containedText);
        moveElementToCoordinates(containedText, width,height);
    }

    public void moveCenterCursorOfCursorStyle(float width, float height){
        moveElementToCoordinates(centerStyleCursor, width, height);
    }

    public void moveTopCursorOfCursorStyle(float width, float height){
        scroll(topLeftStyleCursor);
        moveElementToCoordinates(topLeftStyleCursor, width, height);
    }

    public void moveBottomCursorOfCursorStyle(float width, float height){
        scroll(bottomStyleCursor);
        moveElementToCoordinates(bottomStyleCursor, width, height);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getSimpleBoxXPosition(){
        return getElementCssValue(simpleBox,"left");
    }

    public String getSimpleBoxYPosition(){
        return getElementCssValue(simpleBox,"top");
    }

    public String getRestrictedXBoxPosition(){
        return getElementCssValue(restrictedXBox,"left");
    }

    public String getRestrictedYBoxPosition(){
        return getElementCssValue(restrictedYBox,"top");
    }

    public String getContainedBoxXPosition(){
        return getElementCssValue(containedBox,"left");
    }

    public String getContainedBoxYPosition(){
        return getElementCssValue(containedBox,"top");
    }

    public String getContainedTextXPosition(){
        return getElementCssValue(containedText,"left");
    }

    public String getContainedTextYPosition(){
        return getElementCssValue(containedText,"top");
    }

    public String getElementOfCenterCursorXPosition(){
        return getElementCssValue(centerStyleCursor,"left");
    }

    public String getElementOfCenterCursorYPosition(){
        return getElementCssValue(centerStyleCursor,"top");
    }

    public String getElementOfTopCursorXPosition(){
        return getElementCssValue(topLeftStyleCursor,"left");
    }

    public String getElementOfTopCursorYPosition(){
        return getElementCssValue(topLeftStyleCursor,"top");
    }

    public String getElementOfBottomCursorXPosition(){
        return getElementCssValue(bottomStyleCursor,"left");
    }

    public String getElementOfBottomCursorYPosition(){
        return getElementCssValue(bottomStyleCursor,"top");
    }

    public boolean isSimpleTabVisible(){
        return isElementDisplayedWithWait(tabSimple);
    }

    public boolean isAxisTabVisible(){
        return isElementDisplayedWithWait(tabAxisRestricted);
    }

    public boolean isContainerTabVisible(){
        return isElementDisplayedWithWait(tabContainerRestricted);
    }

    public boolean isCursorTabVisible(){
        return isElementDisplayedWithWait(tabCursorStyle);
    }

}
