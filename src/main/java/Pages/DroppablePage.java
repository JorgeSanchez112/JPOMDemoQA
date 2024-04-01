package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DroppablePage extends BasePages {
    @FindBy(id = "droppableExample-tab-simple")
    private WebElement tabSimple;
    @FindBy(id = "droppableExample-tab-accept")
    private WebElement tabAccept;
    @FindBy(id = "droppableExample-tab-preventPropogation")
    private WebElement tabPreventPropogation;
    @FindBy(id = "droppableExample-tab-revertable")
    private WebElement tabRevert;
    @FindBy(id = "draggable")
    private WebElement draggable;
    @FindBy(id = "droppable")
    private WebElement simpleTarget;
    @FindBy(id = "acceptable")
    private WebElement dragAcceptable;
    @FindBy(id = "notAcceptable")
    private WebElement dragNotAcceptable;
    @FindBy(css = "#droppableExample-tabpane-accept >* #droppable")
    private WebElement acceptTarget;
    @FindBy(id = "dragBox")
    private WebElement dragPrevent;
    @FindBy(id = "notGreedyDropBox")
    private WebElement notGreedyTarget;
    @FindBy(id = "notGreedyInnerDropBox")
    private WebElement notGreedyInnerTarget;
    @FindBy(id = "greedyDropBox")
    private WebElement greedyTarget;
    @FindBy(css = "#greedyDropBox > p")
    private WebElement greedyTargetSubtitle;
    @FindBy(id = "greedyDropBoxInner")
    private WebElement greedyInnerTarget;
    @FindBy(id = "revertable")
    private WebElement dragRevertable;
    @FindBy(id = "notRevertable")
    private WebElement dragNotRevertable;
    @FindBy(css = "#droppableExample-tabpane-revertable >* #droppable")
    private WebElement revertTarget;

    public DroppablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private final String EXPECTED_CLASS = "ui-state-highlight";

    public void clickOnTabAccept(){
        clickWithWait(tabAccept);
    }

    public void clickOnTabPrevent(){
        clickWithWait(tabPreventPropogation);
    }

    public void clickOnTabRevert(){
        clickWithWait(tabRevert);
    }

    public void moveSimpleDraggableToTarget(){
        scroll(draggable);
        waitForVisibleElement(draggable);
        dragDropMoveElementToTarget(draggable,simpleTarget);
    }

    public void moveDraggableAcceptableToTarget(){
        scroll(dragAcceptable);
        waitForVisibleElement(dragAcceptable);
        dragDropMoveElementToTarget(dragAcceptable,acceptTarget);
    }

    public void moveDraggableNotAcceptableToTarget(){
        scroll(dragNotAcceptable);
        waitForVisibleElement(dragNotAcceptable);
        dragDropMoveElementToTarget(dragNotAcceptable,acceptTarget);
    }

    public void movePreventDraggableToNotGreedyTarget(){
        scroll(notGreedyTarget);
        waitForVisibleElement(notGreedyTarget);
        dragDropMoveElementToTarget(dragPrevent,notGreedyTarget);
    }

    public void movePreventDraggableToNotGreedyInnerTarget(){
        scroll(dragPrevent);
        waitForVisibleElement(dragPrevent);
        dragDropMoveElementToTarget(dragPrevent,notGreedyInnerTarget);
    }

    public void movePreventDraggableToGreedyTarget(){
        scroll(greedyTarget);
        waitForVisibleElement(greedyTarget);
        dragDropMoveElementToTarget(dragPrevent,greedyTargetSubtitle);
    }

    public void movePreventDraggableToGreedyInnerTarget(){
        scroll(greedyInnerTarget);
        waitForVisibleElement(greedyInnerTarget);
        dragDropMoveElementToTarget(dragPrevent,greedyInnerTarget);
    }

    public void moveRevertDraggableToTarget(){
        dragDropMoveElementToTarget(dragRevertable,revertTarget);
    }

    public void moveNoRevertDraggableToTarget(){
        scroll(dragNotRevertable);
        dragDropMoveElementToTarget(dragNotRevertable,revertTarget);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public boolean isSimpleTabVisible(){
        return isElementDisplayedWithWait(tabSimple);
    }

    public boolean isAcceptTabVisible(){
        return isElementDisplayedWithWait(tabAccept);
    }

    public boolean isPreventTabVisible(){
        return isElementDisplayedWithWait(tabPreventPropogation);
    }

    public boolean isRevertTabVisible(){
        return isElementDisplayedWithWait(tabRevert);
    }

    public boolean isSimpleDraggableDropped(){
        return doesElementContainExpectedClass(simpleTarget,EXPECTED_CLASS);
    }

    public boolean isAcceptDraggableDropped(){
        return doesElementContainExpectedClass(acceptTarget,EXPECTED_CLASS);
    }

    public boolean isNotAcceptDraggableDropped(){
        return doesElementContainExpectedClass(acceptTarget,EXPECTED_CLASS);
    }

    public boolean isPreventDraggableToNotGreedyDropped(){
        return doesElementContainExpectedClass(notGreedyTarget,EXPECTED_CLASS);
    }

    public boolean isPreventDraggableToNotGreedyInnerDropped(){
        return doesElementContainExpectedClass(notGreedyInnerTarget,EXPECTED_CLASS);
    }

    public boolean isPreventDraggableToGreedyDropped(){
        return doesElementContainExpectedClass(greedyTarget,EXPECTED_CLASS);
    }

    public boolean isPreventDraggableToGreedyInnerDropped(){
        return doesElementContainExpectedClass(greedyInnerTarget,EXPECTED_CLASS);
    }

    public boolean isNotRevertDraggableDropped(){
        return doesElementContainExpectedClass(revertTarget,EXPECTED_CLASS);
    }

}