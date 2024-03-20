package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSRegisterPage extends BasePages {
    @FindBy(tagName = "h4")
    private WebElement subTitle;
    @FindBy(id = "firstname-label")
    private WebElement firstNameLabel;
    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname-label")
    private WebElement lastNameLabel;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "userName-label")
    private WebElement usernameLabel;
    @FindBy(id = "userName")
    private WebElement usernameInput;
    @FindBy(id = "password-label")
    private WebElement passwordLabel;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "recaptcha-anchor")
    private WebElement recaptcha;
    @FindBy(className = "recaptcha-checkbox-checkmark")
    private WebElement recaptchaValidationIcon;
    @FindBy(id = "name")
    private WebElement messageOfCaptcha;
    @FindBy(id = "register")
    private WebElement registerButton;
    @FindBy(id = "gotologin")
    private WebElement loginButton;

    public BSRegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void typeOnFirstnameInput(String firstname){
        waitForVisibleElement(firstNameInput);
        scroll(firstNameInput);
        sendKeysToElement(firstNameInput,firstname);
    }

    public void typeOnLastNameInput(String lastName){
        sendKeysToElement(lastNameInput,lastName);
    }

    public void typeOnUsernameInput(String username){
        sendKeysToElement(usernameInput,username);
    }

    public void typeOnPasswordInput(String password){
        sendKeysToElement(passwordInput,password);
    }

    public void clickOnRecaptcha(){
        waitForVisibleElement(registerButton);
        scroll(registerButton);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        clickWithWait(recaptcha);
    }

    public void clickOnRegisterButton(){
        waitForVisibleElement(registerButton);
        scroll(registerButton);
        clickWithWait(registerButton);
    }

    public void fillOutAllFormFields(String firstNameValue, String lastNameValue, String userNameValue, String passwordValue){
        typeOnFirstnameInput(firstNameValue);
        typeOnLastNameInput(lastNameValue);
        typeOnUsernameInput(userNameValue);
        typeOnPasswordInput(passwordValue);
    }

    public String registerAnUserAndReturnAlertMessage(String firstNameValue, String lastNameValue, String userNameValue, String passwordValue){
        fillOutAllFormFields(firstNameValue,lastNameValue,userNameValue,passwordValue);
        clickOnRecaptcha();
        driver.switchTo().parentFrame();
        clickOnRegisterButton();
        return driver.switchTo().alert().getText();
    }

    public void acceptAlertOfSuccessRegister(){
        acceptAlertWithWait();
    }

    public String getSubtitleText(){
        scroll(subTitle);
        return getElementTextWithWait(subTitle);
    }

    public String getFirstNameLabelText(){
        scroll(firstNameLabel);
        return getElementTextWithWait(firstNameLabel);
    }

    public String getLastNameLabelText(){
        scroll(lastNameLabel);
        return getElementTextWithWait(lastNameLabel);
    }

    public String getUsernameLabelText(){
        return getElementTextWithWait(usernameLabel);
    }

    public String getPasswordLabelText(){
        return getElementTextWithWait(passwordLabel);
    }

    public String getFirstNameInputBorderColor(){
        waitForElementAttributeToContain(firstNameInput,"border-color","rgb(220, 53, 69)");
        return getElementCssValue(firstNameInput,"border-color");
    }

    public String getLastNameInputBorderColor(){
        waitForElementAttributeToContain(lastNameInput,"border-color","rgb(220, 53, 69)");
        return getElementCssValue(lastNameInput,"border-color");
    }

    public String getUsernameInputBorderColor(){
        waitForElementAttributeToContain(usernameInput,"border-color","rgb(220, 53, 69)");
        return getElementCssValue(usernameInput,"border-color");
    }

    public String getPasswordInputBorderColor(){
        waitForElementAttributeToContain(passwordInput,"border-color","rgb(220, 53, 69)");
        return getElementCssValue(passwordInput,"border-color");
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isTitleVisible(){
        return isElementDisplayedWithWait(pageTitle);
    }

    public boolean isRecaptchaMessageVisible(){
        return isElementDisplayedWithWait(messageOfCaptcha);
    }

    public boolean isRecaptchaClicked(){
        return  isElementDisplayedWithWait(recaptchaValidationIcon);
    }

    public BSLoginPage clickOnBackToLogin(){
        scroll(loginButton);
        clickWithWait(loginButton);
        return new BSLoginPage(driver);
    }

}