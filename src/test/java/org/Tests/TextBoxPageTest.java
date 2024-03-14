package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test(dataProvider = "testData")
    public void validateNameAnswerVisibleIsCorrect(Object... data){
        String username = (String) data[0];

        textBoxPage.typeOnUsernameField(username);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextNameAnswer(),USER_NAME_MESSAGE + username);
    }

    @Test(dataProvider = "testData")
    public void validateEmailAnswerVisibleIsCorrect(Object... data){
        String email = (String) data[1];

        textBoxPage.typeOnEmailField(email);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextEmailAnswer(),EMAIL_MESSAGE + email);
    }

    @Test(dataProvider = "testData")
    public void validateAddressAnswerVisibleIsCorrect(Object... data){
        String address = (String) data[2];

        textBoxPage.typeOnAddressField(address);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextAddressAnswer(),ADDRESS_MESSAGE + address);
    }

    @Test(dataProvider = "testData")
    public void validatePermanentAddressAnswerIsCorrect(Object... data){
        String permanentAddress = (String) data[3];

        textBoxPage.typeOnPermanentAddressField(permanentAddress);
        textBoxPage.clickOnSubmitButton();
        Assert.assertEquals(textBoxPage.getTextPermanentAddressAnswer(),PERMANENT_ADDRESS_MESSAGE + permanentAddress);
    }

    @Test(dataProvider = "testData")
    public void validateAnswers(Object... data){
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
    public Object[][] testData() throws IOException {
        String sheetName = "textBox";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}