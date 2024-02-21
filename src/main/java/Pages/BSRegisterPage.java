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

    public boolean isTitleVisible(){
        return pageTitle.isDisplayed();
    }

    public boolean isRecaptchaMessageVisible(){
        return messageOfCaptcha.isDisplayed();
    }
    
    public boolean isRecaptchaClicked(){
        return recaptcha.isSelected();
    }
    
    public String getSubtitleText(){
        waitForVisibleElement(subTitle);
        scroll(subTitle);
        return subTitle.getText();
    }

    public String getFirstNameLabelText(){
        waitForVisibleElement(firstNameLabel);
        scroll(firstNameLabel);
        return firstNameLabel.getText();
    }

    public String getLastNameLabelText(){
        waitForVisibleElement(lastNameLabel);
        scroll(lastNameLabel);
        return lastNameLabel.getText();
    }

    public String getUsernameLabelText(){
        return usernameLabel.getText();
    }

    public String getPasswordLabelText(){
        return passwordLabel.getText();
    }

    public String getFirstNameInputBorderColor(){
        waitForElementAttributeToContain(firstNameInput,"border-color","rgb(220, 53, 69)");
        return firstNameInput.getCssValue("border-color");
    }

    public String getLastNameInputBorderColor(){
        waitForElementAttributeToContain(lastNameInput,"border-color","rgb(220, 53, 69)");
        return lastNameInput.getCssValue("border-color");
    }

    public String getUsernameInputBorderColor(){
        waitForElementAttributeToContain(usernameInput,"border-color","rgb(220, 53, 69)");
        return usernameInput.getCssValue("border-color");
    }

    public String getPasswordInputBorderColor(){
        waitForElementAttributeToContain(passwordInput,"border-color","rgb(220, 53, 69)");
        return passwordInput.getCssValue("border-color");
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void typeOnFirstnameInput(String firstname){
        waitForVisibleElement(firstNameInput);
        scroll(firstNameInput);
        firstNameInput.sendKeys(firstname);
    }

    public void typeOnLastNameInput(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void typeOnUsernameInput(String username){
        usernameInput.sendKeys(username);
    }

    public void typeOnPasswordInput(String password){
        passwordInput.sendKeys(password);
    }

    public void clickOnRecaptcha(){
        waitForVisibleElement(registerButton);
        scroll(registerButton);
        driver.switchTo().frame(driver.findElement(By.cssSelector("#g-recaptcha > div > div > iframe")));
        waitForVisibleElement(recaptcha);
        recaptcha.click();
    }

    public void clickOnRegisterButton(){
        waitForVisibleElement(registerButton);
        scroll(registerButton);
        registerButton.click();
    }

    public BSLoginPage clickOnBackToLogin(){
        scroll(loginButton);
        loginButton.click();
        return new BSLoginPage(driver);
    }

}
