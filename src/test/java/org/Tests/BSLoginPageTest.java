package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BSLoginPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        bsLoginPage = homePage.clickOnSectionBookStoreApplication().clickOnLoginTab();
    }

    @Test
    public void isTitleLoginVisible(){
        Assert.assertTrue(bsLoginPage.isTitleVisible());
    }

    @Parameters("subTitle")
    @Test
    public void isSubtitleCorrect(String subTitle){
        Assert.assertEquals(bsLoginPage.getSubTitleText(), subTitle);
    }

    @Parameters("subSubTitle")
    @Test
    public void isSubSubtitleCorrect(String subSubTitle){
        Assert.assertEquals(bsLoginPage.getSubSubTitleText(), subSubTitle);
    }

    @Parameters("usernameLabel")
    @Test
    public void isUsernameLabelCorrect(String usernameLabel){
        Assert.assertEquals(bsLoginPage.getUsernameLabelText(), usernameLabel);
    }

    @Parameters("passwordLabel")
    @Test
    public void isPasswordLabelCorrect(String passwordLabel){
        Assert.assertEquals(bsLoginPage.getPasswordLabelText(),passwordLabel);
    }

    @Parameters("usernameValue")
    @Test
    public void isTheUsernameInputContainingTheFilledValue(String usernameValue){
        bsLoginPage.typeOnUsernameInput(usernameValue);
        Assert.assertEquals(bsLoginPage.getUsernameInputValue(),usernameValue);
    }

    @Parameters("passwordValue")
    @Test
    public void isThePasswordInputContainingTheFilledValue(String passwordValue){
        bsLoginPage.typeOnPasswordInput(passwordValue);
        Assert.assertEquals(bsLoginPage.getPasswordInputValue(),passwordValue);
    }

    @Test
    public void isActiveRedBorderColorToNotFilledInputs(){
        bsLoginPage.clickOnLoginButton();
        Assert.assertEquals(bsLoginPage.getUsernameInputBorderColor(), prop.getProperty("RGBRedColor"));
        Assert.assertEquals(bsLoginPage.getPasswordInputBorderColor(), prop.getProperty("RGBRedColor"));
    }

    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void isShowedCredentialsErrorMessage(String usernameValue, String passwordValue){
        bsLoginPage.typeOnUsernameInput(usernameValue);
        bsLoginPage.typeOnPasswordInput(passwordValue);
        bsLoginPage.clickOnLoginButton();
        Assert.assertTrue(bsLoginPage.isErrorMessageVisible());
    }

    @Test
    public void newUserButtonUsDirectedToRegister(){
        Assert.assertNotEquals(bsLoginPage.getCurrentUrl(), bsLoginPage.clickOnNewUserButton().getCurrentUrl());
    }
}
