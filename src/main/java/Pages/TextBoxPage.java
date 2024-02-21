package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TextBoxPage extends BasePages {
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

    public void typeOnUsernameField(String name){
        fullNameField.sendKeys(name);
    }

    public void typeOnEmailField(String email){
        emailField.sendKeys(email);
    }

    public void typeOnAddressField(String address){
        addressField.sendKeys(address);
    }

    public void typeOnPermanentAddressField(String pAddress){
        permanentAddressField.sendKeys(pAddress);
    }

    public void clickOnSubmitButton(){
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
        return pageTitle.getText();
    }

    public String getTextNameAnswer(){
        scroll(nameTextAnswer);
        return nameTextAnswer.getText();
    }

    public String getTextEmailAnswer(){
        scroll(emailTextAnswer);
        return emailTextAnswer.getText();
    }

    public String getTextAddressAnswer(){
        scroll(addressTextAnswer);
        return addressTextAnswer.getText();
    }

    public String getTextPermanentAddressAnswer(){
        scroll(permanentAddressTextAnswer);
        return permanentAddressTextAnswer.getText();
    }

}
