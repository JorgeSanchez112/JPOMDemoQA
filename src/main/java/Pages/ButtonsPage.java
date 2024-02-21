package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ButtonsPage extends BasePages {
    @FindBy (id = "doubleClickBtn")
    private WebElement doubleClickBtn;
    @FindBy (id = "rightClickBtn")
    private WebElement rightClickBtn;
    @FindBy (css = "div.mt-4:nth-child(3) > button")
    private WebElement clickMe;
    @FindBy (id = "doubleClickMessage")
    private WebElement doubleClickMessage;
    @FindBy (id = "rightClickMessage")
    private WebElement rightClickMessage;
    @FindBy (id = "dynamicClickMessage")
    private WebElement clickMeMessage;

    public ButtonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnDoubleBtn(){
        doubleClick(doubleClickBtn);
    }

    public void clickOnRightBtn(){
        rightClick(rightClickBtn);
    }

    public void clickOnClickMe(){
        clickWithWait(clickMe);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getDoubleClickMessageText(){
        return doubleClickMessage.getText();
    }

    public String getRightClickMessageText(){
        return rightClickMessage.getText();
    }

    public String getClickMeMessageText(){
        return clickMeMessage.getText();
    }

}
