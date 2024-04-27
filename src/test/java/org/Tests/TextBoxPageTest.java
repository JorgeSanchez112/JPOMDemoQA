package org.Tests;

import TestComponents.utilities.dataDriven.ExcelReader;
import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TextBoxPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(TextBoxPageTest.class);
    private final String USER_NAME_MESSAGE = "Name:";
    private final String EMAIL_MESSAGE = "Email:";
    private final String ADDRESS_MESSAGE = "Current Address :";
    private final String PERMANENT_ADDRESS_MESSAGE = "Permananet Address :";

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing TextBoxPageTest Class------------------");
        textBoxPage = homePage.clickOnSectionElements().clickOnTextBoxSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void IsCorrectPageTitleText(){
        String PAGE_TITLE = "Text Box";

        logger.info("-------------------IsCorrectPageTitleText-----------------------");
        Assert.assertEquals(textBoxPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(dataProvider = "testData",groups = {"Functional"})
    public void validateNameAnswerVisibleIsCorrect(Object... data){
        logger.info("-------------------validateNameAnswerVisibleIsCorrect-----------------------");
        String username = (String) data[0];

        textBoxPage.typeOnUsernameField(username);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextNameAnswer(),USER_NAME_MESSAGE + username);
    }

    @Test(dataProvider = "testData",groups = "Functional")
    public void validateEmailAnswerVisibleIsCorrect(Object... data){
        logger.info("-------------------validateEmailAnswerVisibleIsCorrect-----------------------");
        String email = (String) data[1];

        textBoxPage.typeOnEmailField(email);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextEmailAnswer(),EMAIL_MESSAGE + email);
    }

    @Test(dataProvider = "testData",groups = "Functional")
    public void validateAddressAnswerVisibleIsCorrect(Object... data){
        logger.info("-------------------validateAddressAnswerVisibleIsCorrect-----------------------");
        String address = (String) data[2];

        textBoxPage.typeOnAddressField(address);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextAddressAnswer(),ADDRESS_MESSAGE + address);
    }

    @Test(dataProvider = "testData",groups = "Functional")
    public void validatePermanentAddressAnswerIsCorrect(Object... data){
        logger.info("-------------------validatePermanentAddressAnswerIsCorrect-----------------------");
        String permanentAddress = (String) data[3];

        textBoxPage.typeOnPermanentAddressField(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextPermanentAddressAnswer(),PERMANENT_ADDRESS_MESSAGE + permanentAddress);
    }

    @Test(dataProvider = "testData",groups = {"Smoke"})
    public void validateAnswers(Object... data){
        logger.info("-------------------validateAnswers-----------------------");
        String username = (String) data[0];
        String email = (String) data[1];
        String address = (String) data[2];
        String permanentAddress = (String) data[3];

        textBoxPage.fillAllFormAndClickOnSubmit(username, email, address, permanentAddress);
        Assert.assertEquals(textBoxPage.getTextNameAnswer(),USER_NAME_MESSAGE + username);
        Assert.assertEquals(textBoxPage.getTextEmailAnswer(),EMAIL_MESSAGE + email);
        Assert.assertEquals(textBoxPage.getTextAddressAnswer(),ADDRESS_MESSAGE + address);
        Assert.assertEquals(textBoxPage.getTextPermanentAddressAnswer(),PERMANENT_ADDRESS_MESSAGE + permanentAddress);
    }

    @DataProvider(name = "testData")
    public synchronized Object[][] testData() throws IOException {
        String sheetName = "textBox";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}