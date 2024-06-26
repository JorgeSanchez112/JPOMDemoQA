package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends PageBase {
    @FindBy(id = "userName")
    private WebElement fullNameField;
    @FindBy(id = "userEmail")
    private WebElement emailField;
    @FindBy(id = "currentAddress")
    private WebElement addressField;
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy (id = "name")
    private WebElement nameTextAnswer;
    @FindBy (id = "email")
    private WebElement emailTextAnswer;
    @FindBy (css = "#currentAddress.mb-1")
    private WebElement addressTextAnswer;
    @FindBy (css = "#permanentAddress.mb-1")
    private WebElement permanentAddressTextAnswer;

    public TextBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public synchronized void typeOnUsernameField(String name){
        sendKeysToElement(fullNameField,name);
    }

    public synchronized void typeOnEmailField(String email){
        sendKeysToElement(emailField,email);
    }

    public synchronized void typeOnAddressField(String address){
        sendKeysToElement(addressField,address);
    }

    public synchronized void typeOnPermanentAddressField(String pAddress){
        sendKeysToElement(permanentAddressField,pAddress);
    }

    public synchronized void clickOnSubmitButton(){
        scroll(submitButton);
        clickWithWait(submitButton);
    }

    public void fillAllFormAndClickOnSubmit(String name, String email, String address, String pAddress){
        typeOnUsernameField(name);
        typeOnEmailField(email);
        typeOnAddressField(address);
        typeOnPermanentAddressField(pAddress);
        clickOnSubmitButton();
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public synchronized String getTextNameAnswer(){
        scroll(nameTextAnswer);
        return getElementTextWithWait(nameTextAnswer);
    }

    public synchronized String getTextEmailAnswer(){
        scroll(emailTextAnswer);
        return getElementTextWithWait(emailTextAnswer);
    }

    public synchronized String getTextAddressAnswer(){
        scroll(addressTextAnswer);
        return getElementTextWithWait(addressTextAnswer);
    }

    public synchronized String getTextPermanentAddressAnswer(){
        scroll(permanentAddressTextAnswer);
        return getElementTextWithWait(permanentAddressTextAnswer);
    }

}
