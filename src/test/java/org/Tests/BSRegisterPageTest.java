package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class BSRegisterPageTest extends TestBase {
    private final String SUB_TITLE = "Register to Book Store";
    private final String FIRST_NAME_LABEL = "First Name :";
    private final String LAST_NAME_LABEL = "Last Name :";
    private final String USER_NAME_LABEL = "UserName :";
    private final String PASSWORD_LABEL = "Password :";
    private final String RGB_RED_COLOR = "rgb(220, 53, 69)";

    @BeforeMethod
    public void initializeClass(){
        bsRegisterPage = homePage.clickOnSectionBookStoreApplication().clickOnLoginTab().clickOnNewUserButton();
    }

    /*@Test
    public void isTitleRegisterVisible(){
        Assert.assertTrue(bsRegisterPage.isTitleVisible());
    }

    @Test
    public void isSubtitleCorrect(){
        Assert.assertEquals(bsRegisterPage.getSubtitleText(), SUB_TITLE);
    }

    @Test
    public void isFirstNameLabelCorrect(){
        Assert.assertEquals(bsRegisterPage.getFirstNameLabelText(),FIRST_NAME_LABEL);
    }

    @Test
    public void isLastNameLabelCorrect(){
        Assert.assertEquals(bsRegisterPage.getLastNameLabelText(), LAST_NAME_LABEL);
    }

    @Test
    public void isUserNameLabelCorrect(){
        Assert.assertEquals(bsRegisterPage.getUsernameLabelText(),USER_NAME_LABEL);
    }

    @Test
    public void isPasswordLabelCorrect(){
        Assert.assertEquals(bsRegisterPage.getPasswordLabelText(),PASSWORD_LABEL);
    }

    @Test(dataProvider = "dataTest")
    public void isShowedMessageOfUncheckedRecaptcha(Object... data){
        String firstNameValue = (String) data[0];
        String lastNameValue = (String) data[1];
        String userNameValue = (String) data[2];
        String passwordValue = (String) data[3];

        bsRegisterPage.fillOutAllFormFields(firstNameValue,lastNameValue,userNameValue,passwordValue);
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertTrue(bsRegisterPage.isRecaptchaMessageVisible());
    }

    @Test
    public void isActiveRedBorderColorToNotFilledFirstNameInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getFirstNameInputBorderColor(),RGB_RED_COLOR);
    }

    @Test
    public void isActiveRedBorderColorToNotFilledLastNameInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getLastNameInputBorderColor(),RGB_RED_COLOR);
    }

    @Test
    public void isActiveRedBorderColorToNotFilledUserNameInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getUsernameInputBorderColor(),RGB_RED_COLOR);
    }

    @Test
    public void isActiveRedBorderColorToNotFilledPasswordInput(){
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getPasswordInputBorderColor(),RGB_RED_COLOR);
    }

    @Test
    public void isRecaptchaChecked(){
        bsRegisterPage.clickOnRecaptcha();
        Assert.assertTrue(bsRegisterPage.isRecaptchaClicked());
    }*/

    @Test(dataProvider = "dataTest",priority = 0)
    public void wasRegisterCompletedSuccessfully(Object... data){
        String firstNameValue = (String) data[0];
        String lastNameValue = (String) data[1];
        String userNameValue = (String) data[2];
        String passwordValue = (String) data[3];

        Assert.assertEquals(bsRegisterPage.registerAnUserAndReturnAlertMessage(firstNameValue,lastNameValue,userNameValue,passwordValue),"User created successfully");
        bsRegisterPage.acceptAlertOfSuccessRegister();
    }

    @Test(dataProvider = "dataTest",priority = 1)
    public void deleteAllCreatedUsers(Object... data){
        String userNameValue = (String) data[2];
        String passwordValue = (String) data[3];

        bsRegisterPage.clickOnBackToLogin().userLogin(userNameValue,passwordValue).deleteAccount();
    }

  /*  @Test
    public void isBackToLoginButtonReturnUsToLogin(){
        Assert.assertNotEquals(bsRegisterPage.getCurrentUrl(), bsRegisterPage.clickOnBackToLogin().getCurrentUrl());
        bsRegisterPage.backToPage();
    }*/

    @DataProvider
    private Object[][] dataTest() throws IOException {
        String sheetName = "BSRegister";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}