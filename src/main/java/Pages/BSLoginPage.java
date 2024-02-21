package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSLoginPage extends BasePages {
    @FindBy(tagName = "h2")
    private WebElement subtitle;
    @FindBy(tagName = "h5")
    private WebElement subSubtitle;
    @FindBy(id = "userName-label")
    private WebElement usernameLabel;
    @FindBy(id = "userName")
    private WebElement usernameInput;
    @FindBy(id = "password-label")
    private WebElement passwordLabel;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login")
    private WebElement loginButton;
    @FindBy(id = "newUser")
    private WebElement newUserButton;
    @FindBy(id = "name")
    private WebElement errorCredentialsMessage;
    @FindBy(css = "#adplus-anchor > div")
    private WebElement advertisement;

    public BSLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void typeOnUsernameInput(String name){
        waitForVisibleElement(usernameInput);
        scroll(usernameInput);
        sendKeysToElement(usernameInput,name);
    }

    public void typeOnPasswordInput(String password){
        waitForVisibleElement(passwordInput);
        scroll(passwordInput);
        sendKeysToElement(passwordInput,password);
    }

    public void clickOnLoginButton(){
        scroll(loginButton);
        clickWithWait(loginButton);
    }

    public String getSubTitleText(){
        return subtitle.getText();
    }

    public String getSubSubTitleText(){
        return subSubtitle.getText();
    }

    public String getUsernameLabelText(){
        return usernameLabel.getText();
    }

    public String getUsernameInputValue(){
        return usernameInput.getAttribute("value");
    }

    public String getPasswordLabelText(){
        return passwordLabel.getText();
    }

    public String getPasswordInputValue(){
        return passwordInput.getAttribute("value");
    }

    public String getUsernameInputBorderColor(){
        waitForElementAttributeToContain(usernameInput,"border-color","rgb(220, 53, 69)");
        return usernameInput.getCssValue("border-color");
    }

    public String getPasswordInputBorderColor(){
        return passwordInput.getCssValue("border-color");
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isTitleVisible(){
        return pageTitle.isDisplayed();
    }

    public boolean isErrorMessageVisible(){
        waitForVisibleElement(errorCredentialsMessage);
        return errorCredentialsMessage.isDisplayed();
    }

    public BSRegisterPage clickOnNewUserButton(){
        scroll(newUserButton);
        clickWithWait(newUserButton);
        return new BSRegisterPage(driver);
    }

    public void userLogin(String username,String password) throws InterruptedException {
        hidePublicity(advertisement);
        Thread.sleep(2000);
        typeOnUsernameInput(username);
        typeOnPasswordInput(password);
        clickOnLoginButton();
    }

}
