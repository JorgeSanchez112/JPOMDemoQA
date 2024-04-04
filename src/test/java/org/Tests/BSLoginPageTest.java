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
    private final Logger logger = LogManager.getLogger(BSLoginPageTest.class);

    @BeforeMethod(groups = {"UI","Smoke","Integration","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing BSLoginPageTest Class------------------");
        bsLoginPage = homePage.clickOnSectionBookStoreApplication().clickOnLoginTab();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void isTitleLoginVisible(){
        logger.info("-------------------isTitleLoginVisible-----------------------");
        Assert.assertTrue(bsLoginPage.isTitleVisible());
    }

    @Test(groups = {"UI"})
    public void isSubtitleCorrect(){
        String SUB_TITLE = "Welcome,";

        logger.info("-------------------isSubtitleCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getSubTitleText(), SUB_TITLE);
    }

    @Test(groups = {"UI"})
    public void isSubSubtitleCorrect(){
        String SUB_SUB_TITLE = "Login in Book Store";

        logger.info("-------------------isSubSubtitleCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getSubSubTitleText(), SUB_SUB_TITLE);
    }

    @Test(groups = {"UI"})
    public void isUsernameLabelCorrect(){
        String USERNAME_LABEL = "UserName :";

        logger.info("-------------------isUsernameLabelCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getUsernameLabelText(), USERNAME_LABEL);
    }

    @Test(groups = {"UI"})
    public void isPasswordLabelCorrect(){
        String PASSWORD_LABEL = "Password :";

        logger.info("-------------------isPasswordLabelCorrect-----------------------");
        Assert.assertEquals(bsLoginPage.getPasswordLabelText(), PASSWORD_LABEL);
    }

    @Test(dataProvider = "dataTest",groups = {"Functional"})
    public void isTheUsernameInputContainingTheFilledValue(Object... data){
        logger.info("-------------------isTheUsernameInputContainingTheFilledValue-----------------------");
        String usernameValue = (String) data[0];

        bsLoginPage.typeOnUsernameInput(usernameValue);
        Assert.assertEquals(bsLoginPage.getUsernameInputValue(),usernameValue);
    }

    @Test(dataProvider = "dataTest",groups = {"Functional"})
    public void isThePasswordInputContainingTheFilledValue(Object... data){
        logger.info("-------------------isThePasswordInputContainingTheFilledValue-----------------------");
        String passwordValue = (String) data[1];

        bsLoginPage.typeOnPasswordInput(passwordValue);
        Assert.assertEquals(bsLoginPage.getPasswordInputValue(),passwordValue);
    }

    @Test(groups = {"UI","Functional"})
    public void isActiveRedBorderColorToNotFilledInputs(){
        String RGB_RED_COLOR = "rgb(220, 53, 69)";

        logger.info("-------------------isActiveRedBorderColorToNotFilledInputs-----------------------");
        bsLoginPage.clickOnLoginButton();
        Assert.assertEquals(bsLoginPage.getUsernameInputBorderColor(), RGB_RED_COLOR);
        Assert.assertEquals(bsLoginPage.getPasswordInputBorderColor(), RGB_RED_COLOR);
    }

    @Test(groups = {"Functional","Smoke"})
    public void isShowedCredentialsErrorMessage(){
        String WRONG_USERNAME = "username1";
        String WRONG_PASSWORD = "password";

        logger.info("-------------------isShowedCredentialsErrorMessage-----------------------");
        bsLoginPage.typeOnUsernameInput(WRONG_USERNAME);
        bsLoginPage.typeOnPasswordInput(WRONG_PASSWORD);
        bsLoginPage.clickOnLoginButton();
        Assert.assertTrue(bsLoginPage.isErrorMessageVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","Smoke","Functional"})
    public void isUserLoggedAimedToProfileDashboard(Object... data){
        logger.info("-------------------isUserLoggedAimedToProfileDashboard-----------------------");
        String usernameValue = (String) data[0];
        String passwordValue = (String) data[1];

        Assert.assertTrue(bsLoginPage.userLogin(usernameValue,passwordValue).isTitleVisible());
    }

    @Test(groups = {"Functional"})
    public void newUserButtonIsDirectedToRegister(){
        logger.info("-------------------newUserButtonIsDirectedToRegister-----------------------");
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
