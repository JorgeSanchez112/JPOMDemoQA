package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public class BSLoginPage extends PageBase {
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

    private final String VALUE_ATTRIBUTE = "value";
    private final String BORDER_COLOR_ATTRIBUTE = "border-color";
    private final String RGB_RED_COLOR = "rgb(220, 53, 69)";

    public BSLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public synchronized void typeOnUsernameInput(String name){
        waitForVisibleElement(usernameInput);
        scroll(usernameInput);
        sendKeysToElement(usernameInput,name);
    }

    public synchronized void typeOnPasswordInput(String password){
        waitForVisibleElement(passwordInput);
        scroll(passwordInput);
        sendKeysToElement(passwordInput,password);
    }

    public synchronized void clickOnLoginButton(){
        scroll(loginButton);
        clickWithWait(loginButton);
    }

    public String getSubTitleText(){
        return getElementTextWithWait(subtitle);
    }

    public String getSubSubTitleText(){
        return getElementTextWithWait(subSubtitle);
    }

    public String getUsernameLabelText() {
        return getElementTextWithWait(usernameLabel);
    }

    public String getUsernameInputValue(){
        return getElementAttribute(usernameInput,VALUE_ATTRIBUTE);
    }

    public String getPasswordLabelText(){
        return getElementTextWithWait(passwordLabel);
    }

    public String getPasswordInputValue(){
        return getElementAttribute(passwordInput,VALUE_ATTRIBUTE);
    }

    public String getUsernameInputBorderColor(){
        waitForElementAttributeToContain(usernameInput,BORDER_COLOR_ATTRIBUTE,RGB_RED_COLOR);
        return getElementCssValue(usernameInput,BORDER_COLOR_ATTRIBUTE);
    }

    public String getPasswordInputBorderColor(){
        waitForElementAttributeToContain(usernameInput,BORDER_COLOR_ATTRIBUTE,RGB_RED_COLOR);
        return getElementCssValue(passwordInput,BORDER_COLOR_ATTRIBUTE);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isTitleVisible(){
        return isElementDisplayedWithWait(pageTitle);
    }

    public boolean isErrorMessageVisible(){
        waitForVisibleElement(errorCredentialsMessage);
        return isElementDisplayedWithWait(errorCredentialsMessage);
    }

    public synchronized BSRegisterPage clickOnNewUserButton(){
        scroll(newUserButton);
        clickWithWait(newUserButton);
        return new BSRegisterPage(driver);
    }

    public synchronized BSProfilePage userLogin(String username,String password){
        waitWithFluentForTitleLoginVisible();
        typeOnUsernameInput(username);
        typeOnPasswordInput(password);
        clickOnLoginButton();
        return new BSProfilePage(driver);
    }

    public synchronized void waitWithFluentForTitleLoginVisible(){
        try {
            FluentWait wait = new FluentWait(driver);
            wait.withTimeout(Duration.ofSeconds(10));
            wait.pollingEvery(Duration.ofMillis(250));
            wait.until(ExpectedConditions.visibilityOf(pageTitle));
        }catch (NoSuchSessionException e){
            e.printStackTrace();
        }

    }
}
