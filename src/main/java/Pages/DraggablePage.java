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

    public void moveSimpleElement(int width, int height){
        moveElementToCoordinates(simpleBox,width, height);
    }

    public void moveXElement(int width, int height){
        moveElementToCoordinates(restrictedXBox,width, height);
    }

    public void moveYElement(int width, int height){
        moveElementToCoordinates(restrictedYBox,width,height);
    }

    public void moveContainedBox(int width, int height){
        moveElementToCoordinates(containedBox, width, height);
    }

    public void moveContainedText(int width, int height){
        scroll(containedText);
        moveElementToCoordinates(containedText, width,height);
    }

    public void moveCenterCursorOfCursorStyle(int width, int height){
        moveElementToCoordinates(centerStyleCursor, width, height);
    }

    public void moveTopCursorOfCursorStyle(int width, int height){
        scroll(topLeftStyleCursor);
        moveElementToCoordinates(topLeftStyleCursor, width, height);
    }

    public void moveBottomCursorOfCursorStyle(int width, int height){
        scroll(bottomStyleCursor);
        moveElementToCoordinates(bottomStyleCursor, width, height);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getSimpleBoxXPosition(){
        return simpleBox.getCssValue("left");
    }

    public String getSimpleBoxYPosition(){
        return simpleBox.getCssValue("top");
    }

    public String getRestrictedXBoxPosition(){
        return restrictedXBox.getCssValue("left");
    }

    public String getRestrictedYBoxPosition(){
        return restrictedYBox.getCssValue("top");
    }

    public String getContainedBoxXPosition(){
        return containedBox.getCssValue("left");
    }

    public String getContainedBoxYPosition(){
        return containedBox.getCssValue("top");
    }

    public String getContainedTextXPosition(){
        return containedText.getCssValue("left");
    }

    public String getContainedTextYPosition(){
        return containedText.getCssValue("top");
    }

    public String getElementOfCenterCursorXPosition(){
        return centerStyleCursor.getCssValue("left");
    }

    public String getElementOfCenterCursorYPosition(){
        return centerStyleCursor.getCssValue("top");
    }

    public String getElementOfTopCursorXPosition(){
        return topLeftStyleCursor.getCssValue("left");
    }

    public String getElementOfTopCursorYPosition(){
        return topLeftStyleCursor.getCssValue("top");
    }

    public String getElementOfBottomCursorXPosition(){
        return bottomStyleCursor.getCssValue("left");
    }

    public String getElementOfBottomCursorYPosition(){
        return bottomStyleCursor.getCssValue("top");
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
