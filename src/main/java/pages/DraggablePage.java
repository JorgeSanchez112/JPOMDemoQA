package Pages;

import TestComponents.config.PageBase;
import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraggablePage extends PageBase {
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

    private final String LEFT = "left";
    private final String TOP = "top";

    public DraggablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnTabAxisRestricted(){
        scroll(tabAxisRestricted);
        clickWithWait(tabAxisRestricted);
    }

    public void clickOnTabContainerRestricted(){
        scroll(tabContainerRestricted);
        clickWithWait(tabContainerRestricted);
    }

    public void clickOnTabCursorStyle(){
        scroll(tabCursorStyle);
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
        final int VALUE_TO_DEDUCT_WITH = 54;
        final int VALUE_TO_DEDUCT_HEIGHT = 55;
        scroll(topLeftStyleCursor);
        moveElementToCoordinates(topLeftStyleCursor,subtractQuantityToParameter(width,VALUE_TO_DEDUCT_WITH), subtractQuantityToParameter(height,VALUE_TO_DEDUCT_HEIGHT));
    }

    public void moveBottomCursorOfCursorStyle(float width, float height){
        scroll(bottomStyleCursor);
        moveElementToCoordinates(bottomStyleCursor, width, addQuantityToParameter(height,50));
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getSimpleBoxXPosition(){
        return getElementCssValue(simpleBox,LEFT);
    }

    public String getSimpleBoxYPosition(){
        return getElementCssValue(simpleBox,TOP);
    }

    public String getRestrictedXBoxPosition(){
        return getElementCssValue(restrictedXBox,LEFT);
    }

    public String getRestrictedYBoxPosition(){
        return getElementCssValue(restrictedYBox,TOP);
    }

    public String getContainedBoxXPosition(){
        return getElementCssValue(containedBox,LEFT);
    }

    public String getContainedBoxYPosition(){
        return getElementCssValue(containedBox,TOP);
    }

    public String getContainedTextXPosition(){
        return getElementCssValue(containedText,LEFT);
    }

    public String getContainedTextYPosition(){
        return getElementCssValue(containedText,TOP);
    }

    public String getElementOfCenterCursorXPosition(){
        return changeFormatOfStringToReturnTextWithoutValueTypeFloat(getElementCssValue(centerStyleCursor,LEFT));
    }

    public String getElementOfCenterCursorYPosition(){
        return getElementCssValue(centerStyleCursor,TOP);
    }

    public String getElementOfTopCursorXPosition(){
        return changeFormatOfStringToReturnTextWithoutValueTypeFloat(getElementCssValue(topLeftStyleCursor,LEFT));
    }

    public String getElementOfTopCursorYPosition(){
        return getElementCssValue(topLeftStyleCursor,TOP);
    }

    public String getElementOfBottomCursorXPosition(){
        return getElementCssValue(bottomStyleCursor,LEFT);
    }

    public String getElementOfBottomCursorYPosition(){
        return getElementCssValue(bottomStyleCursor,TOP);
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

    public float addQuantityToParameter(float targetParameter,float valueToAdd){
        return targetParameter + valueToAdd;
    }

}
