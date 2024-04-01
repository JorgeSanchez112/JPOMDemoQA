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

public class BSLoginPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(BSLoginPageTest.class);
    private final String SUB_TITLE = "Welcome,";
    private final String SUB_SUB_TITLE = "Login in Book Store";
    private final String USERNAME_LABEL= "UserName :";
    private final String PASSWORD_LABEL = "Password :";
    private final String RGB_RED_COLOR = "rgb(220, 53, 69)";
    private final String WRONG_USERNAME = "username1";
    private final String WRONG_PASSWORD = "password";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing BSLoginPageTest Class------------------");
        bsLoginPage = homePage.clickOnSectionBookStoreApplication().clickOnLoginTab();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void isTitleLoginVisible(){
        logger.info("-------------------isTitleLoginVisible-----------------------");
        Assert.assertTrue(bsLoginPage.isTitleVisible());
    }

    @Test
    public void isSubtitleCorrect(){
        logger.info("-------------------isSubtitleCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getSubTitleText(), SUB_TITLE);
    }

    @Test
    public void isSubSubtitleCorrect(){
        logger.info("-------------------isSubSubtitleCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getSubSubTitleText(), SUB_SUB_TITLE);
    }

    @Test
    public void isUsernameLabelCorrect(){
        logger.info("-------------------isUsernameLabelCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getUsernameLabelText(), USERNAME_LABEL);
    }

    @Test
    public void isPasswordLabelCorrect(){
        logger.info("-------------------isPasswordLabelCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getPasswordLabelText(), PASSWORD_LABEL);
    }

    @Test(dataProvider = "dataTest")
    public void isTheUsernameInputContainingTheFilledValue(Object... data){
        logger.info("-------------------isTheUsernameInputContainingTheFilledValue-----------------------");
        String usernameValue = (String) data[0];

        bsLoginPage.typeOnUsernameInput(usernameValue);
        Assert.assertEquals(bsLoginPage.getUsernameInputValue(),usernameValue);
    }

    @Test(dataProvider = "dataTest")
    public void isThePasswordInputContainingTheFilledValue(Object... data){
        logger.info("-------------------isThePasswordInputContainingTheFilledValue-----------------------");
        String passwordValue = (String) data[1];

        bsLoginPage.typeOnPasswordInput(passwordValue);
        Assert.assertEquals(bsLoginPage.getPasswordInputValue(),passwordValue);
    }

    @Test
    public void isActiveRedBorderColorToNotFilledInputs(){
        logger.info("-------------------isActiveRedBorderColorToNotFilledInputs-----------------------");
        bsLoginPage.clickOnLoginButton();
        Assert.assertEquals(bsLoginPage.getUsernameInputBorderColor(),RGB_RED_COLOR);
        Assert.assertEquals(bsLoginPage.getPasswordInputBorderColor(),RGB_RED_COLOR);
    }

    @Test
    public void isShowedCredentialsErrorMessage(){
        logger.info("-------------------isShowedCredentialsErrorMessage-----------------------");
        bsLoginPage.typeOnUsernameInput(WRONG_USERNAME);
        bsLoginPage.typeOnPasswordInput(WRONG_PASSWORD);
        bsLoginPage.clickOnLoginButton();
        Assert.assertTrue(bsLoginPage.isErrorMessageVisible());
    }

    @Test(dataProvider = "dataTest")
    public void isUserLoggedAimedToProfileDashboard(Object... data){
        logger.info("-------------------isUserLoggedAimedToProfileDashboard-----------------------");
        String usernameValue = (String) data[0];
        String passwordValue = (String) data[1];

        Assert.assertTrue(bsLoginPage.userLogin(usernameValue,passwordValue).isTitleVisible());
    }

    @Test
    public void newUserButtonUsDirectedToRegister(){
        logger.info("-------------------newUserButtonUsDirectedToRegister-----------------------");
        Assert.assertNotEquals(bsLoginPage.getCurrentUrl(),bsLoginPage.clickOnNewUserButton().getCurrentUrl());
    }

    @DataProvider
    private Object[][] dataTest() throws IOException {
        String sheetName = "BSLogin";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}
