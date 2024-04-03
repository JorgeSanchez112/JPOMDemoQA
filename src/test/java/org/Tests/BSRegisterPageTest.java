package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class BSRegisterPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(BSRegisterPageTest.class);
    private final String SUB_TITLE = "Register to Book Store";
    private final String FIRST_NAME_LABEL = "First Name :";
    private final String LAST_NAME_LABEL = "Last Name :";
    private final String USER_NAME_LABEL = "UserName :";
    private final String PASSWORD_LABEL = "Password :";
    private final String RGB_RED_COLOR = "rgb(220, 53, 69)";

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing BSRegisterPageTest Class------------------");
        bsRegisterPage = homePage.clickOnSectionBookStoreApplication().clickOnLoginTab().clickOnNewUserButton();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void isTitleRegisterVisible(){
        logger.info("-------------------isTitleRegisterVisible-----------------------");
        Assert.assertTrue(bsRegisterPage.isTitleVisible());
    }

    @Test(groups = {"UI"})
    public void isSubtitleCorrect(){
        logger.info("-------------------isSubtitleCorrect-----------------------");
        Assert.assertEquals(bsRegisterPage.getSubtitleText(), SUB_TITLE);
    }

    @Test(groups = {"UI"})
    public void isFirstNameLabelCorrect(){
        logger.info("-------------------isFirstNameLabelCorrect-----------------------");
        Assert.assertEquals(bsRegisterPage.getFirstNameLabelText(),FIRST_NAME_LABEL);
    }

    @Test(groups = {"UI"})
    public void isLastNameLabelCorrect(){
        logger.info("-------------------isLastNameLabelCorrect-----------------------");
        Assert.assertEquals(bsRegisterPage.getLastNameLabelText(), LAST_NAME_LABEL);
    }

    @Test(groups = {"UI"})
    public void isUserNameLabelCorrect(){
        logger.info("-------------------isUserNameLabelCorrect-----------------------");
        Assert.assertEquals(bsRegisterPage.getUsernameLabelText(),USER_NAME_LABEL);
    }

    @Test(groups = {"UI"})
    public void isPasswordLabelCorrect(){
        logger.info("-------------------isPasswordLabelCorrect-----------------------");
        Assert.assertEquals(bsRegisterPage.getPasswordLabelText(),PASSWORD_LABEL);
    }

    @Test(dataProvider = "dataTest",groups = {"Functional"})
    public void isShowedMessageOfUncheckedRecaptcha(Object... data){
        logger.info("-------------------isShowedMessageOfUncheckedRecaptcha-----------------------");
        String firstNameValue = (String) data[0];
        String lastNameValue = (String) data[1];
        String userNameValue = (String) data[2];
        String passwordValue = (String) data[3];

        bsRegisterPage.fillOutAllFormFields(firstNameValue,lastNameValue,userNameValue,passwordValue);
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertTrue(bsRegisterPage.isRecaptchaMessageVisible());
    }

    @Test(groups = {"UI"})
    public void isActiveRedBorderColorToNotFilledFirstNameInput(){
        logger.info("-------------------isActiveRedBorderColorToNotFilledFirstNameInput-----------------------");
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getFirstNameInputBorderColor(),RGB_RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void isActiveRedBorderColorToNotFilledLastNameInput(){
        logger.info("-------------------isActiveRedBorderColorToNotFilledLastNameInput-----------------------");
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getLastNameInputBorderColor(),RGB_RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void isActiveRedBorderColorToNotFilledUserNameInput(){
        logger.info("-------------------isActiveRedBorderColorToNotFilledUserNameInput-----------------------");
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getUsernameInputBorderColor(),RGB_RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void isActiveRedBorderColorToNotFilledPasswordInput(){
        logger.info("-------------------isActiveRedBorderColorToNotFilledPasswordInput-----------------------");
        bsRegisterPage.clickOnRegisterButton();
        Assert.assertEquals(bsRegisterPage.getPasswordInputBorderColor(),RGB_RED_COLOR);
    }

    @Test(groups = {"Functional"})
    public void isRecaptchaChecked(){
        logger.info("-------------------isRecaptchaChecked-----------------------");
        bsRegisterPage.clickOnRecaptcha();
        Assert.assertTrue(bsRegisterPage.isRecaptchaClicked());
    }

    @Test(dataProvider = "dataTest",groups = {"Smoke"})
    public void wasRegisterCompletedSuccessfully(Object... data)//This Test often could fail due to a captcha that there is in the register page that I couldn't solve to automatize without a low percentage to fail.
    {
        logger.info("-------------------wasRegisterCompletedSuccessfully-----------------------");
        String firstNameValue = (String) data[0];
        String lastNameValue = (String) data[1];
        String userNameValue = (String) data[2];
        String passwordValue = (String) data[3];

        Assert.assertEquals(bsRegisterPage.registerAnUserAndReturnAlertMessage(firstNameValue,lastNameValue,userNameValue,passwordValue),"User created successfully");
        bsRegisterPage.acceptAlertOfSuccessRegister();
    }

    @Test(dataProvider = "dataTest",groups = {"Smoke"})
    public void deleteCreatedUsers(Object... data){//This is a method created to try to delete all the users Created to can reuse the same info that it's contain in an Excel to achieve Data Driven Testing(DDT)
        logger.info("-------------------deleteCreatedUsers-----------------------");
        String userNameValue = (String) data[2];
        String passwordValue = (String) data[3];

        bsRegisterPage.clickOnBackToLogin().userLogin(userNameValue,passwordValue).deleteAccount();
    }

    @Test(groups = {"Smoke","Functional"})
    public void isBackToLoginButtonRedirectUsToLogin(){
        logger.info("-------------------isBackToLoginButtonRedirectUsToLogin-----------------------");
        Assert.assertNotEquals(bsRegisterPage.getCurrentUrl(), bsRegisterPage.clickOnBackToLogin().getCurrentUrl());
    }

    @DataProvider
    private Object[][] dataTest() throws IOException {
        String sheetName = "BSRegister";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}