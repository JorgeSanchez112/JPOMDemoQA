package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage extends BasePages {
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

    public void clickOnSmallModalButton(){
        clickWithWait(smallModalButton);
    }

    public void clickOnLargeModalButton(){
        clickWithWait(largeModalButton);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }
    public String getSmallModalText(){
        return smallModalText.getText();
    }

    public String getLargeModalText(){
        return largeModalText.getText();
    }

    public boolean isInstructionsTextVisible(){
        return instructionText.isDisplayed();
    }
    public boolean isCloseSmallModalVisible(){
        return closeSmallModalButton.isDisplayed();
    }

    public boolean isCloseLargeModalVisible(){
        return closeLargeModalButton.isDisplayed();
    }

}
