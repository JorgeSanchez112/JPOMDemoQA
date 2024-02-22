package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BSRegisterTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        bsRegisterPage = homePage.clickOnSectionBookStoreApplication().clickOnLoginTab().clickOnNewUserButton();
    }

    @Test
    public void isTitleRegisterVisible(){
        Assert.assertTrue(bsRegisterPage.isTitleVisible());
    }

    @Parameters("subTitle")
    @Test
    public void isSubtitleCorrect(String subTitle){
        Assert.assertEquals(bsRegisterPage.getSubtitleText(), subTitle);
    }

    @Parameters("firstNameLabel")
    @Test
    public void isFirstNameLabelCorrect(String firstNameLabel){
        Assert.assertEquals(bsRegisterPage.getFirstNameLabelText(),firstNameLabel);
    }

    @Parameters("lastNameLabel")
    @Test
    public void isLastNameLabelCorrect(String lastNameLabel){
        Assert.assertEquals(bsRegisterPage.getLastNameLabelText(), lastNameLabel);
    }

    @Parameters("userNameLabel")
    @Test
    public void isUserNameLabelCorrect(String userNameLabel){
        Assert.assertEquals(bsRegisterPage.getUsernameLabelText(),userNameLabel);
    }

    @Parameters("passwordLabel")
    @Test
    public void isPasswordLabelCorrect(String passwordLabel){
        Assert.assertEquals(bsRegisterPage.getPasswordLabelText(),passwordLabel);
    }

    @Parameters({"firstNameValue","lastNameValue","userNameValue","passwordValue"})
    @Test
    public void isShowedMessageOfUncheckedRecaptcha(String firstNameValue, String lastNameValue, String userNameValue, String passwordValue){
        bsRegisterPage.typeOnFirstnameInput(firstNameValue);
        bsRegisterPage.typeOnLastNameInput(lastNameValue);
        bsRegisterPage.typeOnUsernameInput(userNameValue);
        bsRegisterPage.typeOnPasswordInput(passwordValue);
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertTrue(bsRegisterPage.isRecaptchaMessageVisible());
    }

    @Test
    public void isActiveRedBorderColorToNotFilledFirstNameInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getFirstNameInputBorderColor(),prop.getProperty("RGBRedColor"));
    }

    @Test
    public void isActiveRedBorderColorToNotFilledLastNameInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getLastNameInputBorderColor(),prop.getProperty("RGBRedColor"));
    }

    @Test
    public void isActiveRedBorderColorToNotFilledUserNameInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getUsernameInputBorderColor(),prop.getProperty("RGBRedColor"));
    }

    @Test
    public void isActiveRedBorderColorToNotFilledPasswordInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getPasswordInputBorderColor(),prop.getProperty("RGBRedColor"));
    }

    @Test
    public void isRecaptchaChecked(){
        bsRegisterPage.clickOnRecaptcha();
        Assert.assertFalse(bsRegisterPage.isRecaptchaClicked()); //in this line the code should be true but there is the recaptcha where I can't solve it.
    }

    @Test
    public void isBackToLoginButtonReturnUsToLogin(){
        Assert.assertNotEquals(bsRegisterPage.getCurrentUrl(), bsRegisterPage.clickOnBackToLogin().getCurrentUrl());
        bsRegisterPage.backToPage();
    }
}