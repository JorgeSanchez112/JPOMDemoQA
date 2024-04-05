package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class buttonsPage extends pageBase {
    @FindBy (id = "doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy (id = "rightClickBtn")
    private WebElement rightClickBtn;
    @FindBy (css = "div.mt-4:nth-child(4) > button")
    private WebElement clickMe;
    @FindBy (id = "doubleClickMessage")
    private WebElement doubleClickMessage;
    @FindBy (id = "rightClickMessage")
    private WebElement rightClickMessage;
    @FindBy (id = "dynamicClickMessage")
    private WebElement clickMeMessage;

    public buttonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnDoubleBtn(){
        scroll(doubleClickBtn);
        doubleClick(doubleClickBtn);
    }

    public void clickOnRightBtn(){
        scroll(rightClickBtn);
        waitForClick(rightClickBtn);
        rightClick(rightClickBtn);
    }

    public void clickOnClickMe(){
        scroll(clickMe);
        clickWithWait(clickMe);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getDoubleClickMessageText(){
        scroll(doubleClickMessage);
        return getElementTextWithWait(doubleClickMessage);
    }

    public String getRightClickMessageText(){
        scroll(rightClickMessage);
        return getElementTextWithWait(rightClickMessage);
    }

    public String getClickMeMessageText(){
        scroll(clickMeMessage);
        return getElementTextWithWait(clickMeMessage);
    }

}