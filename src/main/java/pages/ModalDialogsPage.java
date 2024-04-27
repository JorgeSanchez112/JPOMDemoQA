package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage extends PageBase {
    @FindBy(css = "#modalWrapper >* > div")
    private WebElement instructionText;
    @FindBy(id = "showSmallModal")
    private WebElement smallModalButton;
    @FindBy(id = "showLargeModal")
    private WebElement largeModalButton;
    @FindBy(css = ".modal-body")
    private WebElement smallModalText;
    @FindBy(id = "closeSmallModal")
    private WebElement closeSmallModalButton;
    @FindBy(tagName = "p")
    private WebElement largeModalText;
    @FindBy(id = "closeLargeModal")
    private WebElement closeLargeModalButton;

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public synchronized void clickOnSmallModalButton(){
        scroll(smallModalButton);
        clickWithWait(smallModalButton);
    }

    public synchronized void clickOnLargeModalButton(){
        scroll(largeModalButton);
        clickWithWait(largeModalButton);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }
    public String getSmallModalText(){
        return getElementTextWithWait(smallModalText);
    }

    public String getLargeModalText(){
        return getElementTextWithWait(largeModalText);
    }

    public boolean isInstructionsTextVisible(){
        return isElementDisplayedWithWait(instructionText);
    }
    public boolean isCloseSmallModalVisible(){
        return isElementDisplayedWithWait(closeSmallModalButton);
    }

    public boolean isCloseLargeModalVisible(){
        return isElementDisplayedWithWait(closeLargeModalButton);
    }
}
