package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxPageTest extends TestBase {
    private final String PAGE_TITLE = "Text Box";
    private final String USER_NAME_MESSAGE = "Name:";
    private final String EMAIL_MESSAGE = "Email:";
    private final String ADDRESS_MESSAGE = "Current Address :";
    private final String PERMANENT_ADDRESS_MESSAGE = "Permananet Address :";

    @BeforeMethod
    public void initializeClass(){
       textBoxPage = homePage.clickOnSectionElements().clickOnTextBoxSection();
    }

    @Test
    public void IsCorrectPageTitleText(){
        Assert.assertEquals(textBoxPage.getPageTitleText(),PAGE_TITLE);
    }

    @Parameters({"username"})
    @Test
    public void validateNameAnswerVisibleIsCorrect(String username){
        textBoxPage.typeOnUsernameField(username);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextNameAnswer(),USER_NAME_MESSAGE + username);
    }

    @Parameters({"email"})
    @Test
    public void validateEmailAnswerVisibleIsCorrect(String email){
        textBoxPage.typeOnEmailField(email);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextEmailAnswer(),EMAIL_MESSAGE + email);
    }

    @Parameters({"address"})
    @Test
    public void validateAddressAnswerVisibleIsCorrect(String address){
        textBoxPage.typeOnAddressField(address);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextAddressAnswer(),ADDRESS_MESSAGE + address);
    }

    @Parameters({"permanentAddress"})
    @Test
    public void validatePermanentAddressAnswerIsCorrect(String permanentAddress){
        textBoxPage.typeOnPermanentAddressField(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextPermanentAddressAnswer(),PERMANENT_ADDRESS_MESSAGE + permanentAddress);
    }

    @Parameters({"username", "email", "address", "permanentAddress"})
    @Test
    public void validateAnswers(String username, String email, String address, String permanentAddress){
        textBoxPage.fillAllFormAndClickOnSubmit(username, email, address, permanentAddress);
        Assert.assertEquals(textBoxPage.getTextNameAnswer(),USER_NAME_MESSAGE + username);
        Assert.assertEquals(textBoxPage.getTextEmailAnswer(),EMAIL_MESSAGE + email);
        Assert.assertEquals(textBoxPage.getTextAddressAnswer(),ADDRESS_MESSAGE + address);
        Assert.assertEquals(textBoxPage.getTextPermanentAddressAnswer(),PERMANENT_ADDRESS_MESSAGE + permanentAddress);
    }
}