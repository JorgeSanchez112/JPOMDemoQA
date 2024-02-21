package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextBoxPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
       textBoxPage = homePage.clickOnSectionElements().clickOnTextBoxSection();
    }

    @Parameters("pageTitle")
    @Test
    public void IsCorrectPageTitleText(String pageTitle){
        Assert.assertEquals(textBoxPage.getPageTitleText(),pageTitle);
    }

    @Parameters({"username","userNameMessage"})
    @Test
    public void validateNameAnswerVisibleIsCorrect(String username, String userNameMessage){
        textBoxPage.typeOnUsernameField(username);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextNameAnswer(),userNameMessage + username);
    }

    @Parameters({"email","emailMessage"})
    @Test
    public void validateEmailAnswerVisibleIsCorrect(String email, String emailMessage){
        textBoxPage.typeOnEmailField(email);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextEmailAnswer(),emailMessage + email);
    }

    @Parameters({"address","addressMessage"})
    @Test
    public void validateAddressAnswerVisibleIsCorrect(String address, String addressMessage){
        textBoxPage.typeOnAddressField(address);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextAddressAnswer(),addressMessage + address);
    }

    @Parameters({"permanentAddress","permanentAddressMessage"})
    @Test
    public void validatePermanentAddressAnswerIsCorrect(String permanentAddress, String permanentAddressMessage){
        textBoxPage.typeOnPermanentAddressField(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextPermanentAddressAnswer(),permanentAddressMessage + permanentAddress);
    }

    @Parameters({"username", "email", "address", "permanentAddress", "userNameMessage", "emailMessage", "addressMessage", "permanentAddressMessage"})
    @Test
    public void validateAnswers(String username, String email, String address, String permanentAddress, String userNameMessage, String emailMessage, String addressMessage, String permanentAddressMessage){
        textBoxPage.fillAllFormAndClickOnSubmit(username, email, address, permanentAddress);
        Assert.assertEquals(textBoxPage.getTextNameAnswer(),userNameMessage + username);
        Assert.assertEquals(textBoxPage.getTextEmailAnswer(),emailMessage + email);
        Assert.assertEquals(textBoxPage.getTextAddressAnswer(),addressMessage + address);
        Assert.assertEquals(textBoxPage.getTextPermanentAddressAnswer(),permanentAddressMessage + permanentAddress);
    }
}
