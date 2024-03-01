package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class BSProfileTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        bsProfilePage = homePage.clickOnSectionBookStoreApplication().clickOnProfile();
    }

    @Test
    public void isProfileTitleVisible(){
        Assert.assertTrue(bsProfilePage.isTitleVisible());
    }

    @Parameters("uRLRegister")
    @Test
    public void validateLinkRegisterIsFunctional(String uRLRegister){
        Assert.assertEquals(bsProfilePage.clickOnRegisterLink().getCurrentUrl(),uRLRegister);
    }

    @Test
    public void isMessageDoNotLoginShowed(){
        Assert.assertTrue(bsProfilePage.isMessageDoNotLoginShowed());
    }

    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void isUserNameValueCorrect(String usernameValue, String passwordValue) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),usernameValue);
    }

    @Parameters({"usernameValue","passwordValue","booksLabel"})
    @Test
    public void validateCorrectBooksLabelText(String usernameValue, String passwordValue, String booksLabel) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getBooksLabelText(),booksLabel);
    }

    @Parameters({"usernameValue","passwordValue","searchBoxPlaceholder"})
    @Test
    public void validateCorrectPlaceHolderInSearchBook(String usernameValue, String passwordValue, String searchBoxPlaceholder) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue, passwordValue);
        Assert.assertEquals(bsProfilePage.getSearchBoxPlaceholderText(), searchBoxPlaceholder);
    }

    @Parameters({"usernameValue","passwordValue","usernameLabel"})
    @Test
    public void validateCorrectUsernameLabelText(String usernameValue, String passwordValue, String usernameLabel) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getUserNameLabelText(),usernameLabel);
    }

    @Parameters({"usernameValue","passwordValue","uRLLogin"})
    @Test
    public void validateLogOutButtonRedirectToLogin(String usernameValue, String passwordValue, String uRLLogin) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.clickOnLogOutButton().getCurrentUrl(),uRLLogin);
    }

    @Parameters({"usernameValue","passwordValue","tableTitleImage"})
    @Test
    public void validateCorrectImageTitleText(String usernameValue, String passwordValue, String tableTitleImage) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getTableTitleImageText(),tableTitleImage);
    }

    @Parameters({"usernameValue","passwordValue","tableTitleTitle"})
    @Test
    public void validateCorrectTitleOfTitleTableText(String usernameValue, String passwordValue, String tableTitleTitle) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getTableTitleTitleText(),tableTitleTitle);
    }

    @Parameters({"usernameValue","passwordValue","tableTitleAuthor"})
    @Test
    public void validateCorrectAuthorTitleOfTableText(String usernameValue, String passwordValue, String tableTitleAuthor) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getTableTitleAuthorText(),tableTitleAuthor);
    }

    @Parameters({"usernameValue","passwordValue","tableTitlePublisher"})
    @Test
    public void validateCorrectPublisherTitleOfTableText(String usernameValue, String passwordValue, String tableTitlePublisher) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getTableTitlePublisherText(),tableTitlePublisher);
    }

    @Parameters({"usernameValue","passwordValue","tableTitleAction"})
    @Test
    public void validateCorrectActionTitleOfTableText(String usernameValue, String passwordValue, String tableTitleAction) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getTableTitleActionText(),tableTitleAction);
    }

    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void validateNoDataMessageIsVisible(String usernameValue, String passwordValue) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void validatePreviousButtonIsEnabled(String usernameValue, String passwordValue) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertFalse(bsProfilePage.isPreviousButtonEnabled());
    }

    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void validateNextButtonIsEnabled(String usernameValue, String passwordValue) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertFalse(bsProfilePage.isNextButtonEnabled());
    }

    @Parameters({"usernameValue","passwordValue","searchBoxValue","bookTitleExpected"})
    @Test
    public void isBookFoundBySearchBox(String usernameValue, String passwordValue, String searchBoxValue, String bookTitleExpected) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.typeOnSearchBox(searchBoxValue);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(bookTitleExpected));
    }

    @Parameters({"usernameValue","passwordValue","pageOfTable"})
    @Test
    public void validateCorrectPageLabelText(String usernameValue, String passwordValue, String pageOfTable) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getPageText(),pageOfTable);
    }

    @Parameters({"usernameValue","passwordValue","totalPagesOfTable"})
    @Test
    public void validateCorrectTotalOfPages(String usernameValue, String passwordValue, String totalPagesOfTable) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getTotalOfPagesText(),totalPagesOfTable);
    }

    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void wereAllBooksDeleted(String usernameValue, String passwordValue) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.deleteAllBooks();
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Parameters({"usernameValue","passwordValue","uRLBooks"})
    @Test
    public void validateGoToBookStoreRedirectToBookStorePage(String usernameValue, String passwordValue, String uRLBooks) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.clickOnGoToBookStoreButton().getBookStoreUrlText(),uRLBooks);
    }

    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void validateCancelButtonOfDeleteAccountAlertIsFunctional(String usernameValue, String passwordValue) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.tryToDeleteAccount();
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),usernameValue);
    }

    @Parameters({"usernameValue","passwordValue","titleBook"})
    @Test
    public void validateCancelButtonOfDeleteBooksAlertIsFunctional(String usernameValue, String passwordValue, String titleBook) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        bsProfilePage.tryToDeleteAllBooks();
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Parameters({"usernameValue","passwordValue","titleBook"})
    @Test
    public void IsAddedABookInTable(String usernameValue, String passwordValue, String titleBook) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Parameters({"usernameValue","passwordValue","pageNumberBase"})
    @Test
    public void pageNumber(String usernameValue, String passwordValue, String pageNumberBase) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getPageNumber(),pageNumberBase);
    }

    @Parameters({"usernameValue","passwordValue","bookTitleExpected","authorAccordingTitle"})
    @Test
    public void validateCorrectAuthorRegardToTitleBook(String usernameValue, String passwordValue, String bookTitle, String authorAccordingTitle) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getAuthorRegardToTitleBookText(bookTitle),authorAccordingTitle);
    }

    @Parameters({"usernameValue","passwordValue","bookTitleExpected","publisherAccordingTitle"})
    @Test
    public void validateCorrectPublisherRegardToTitleBook(String usernameValue, String passwordValue, String bookTitle, String publisherAccordingTitle) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertEquals(bsProfilePage.getPublisherRegardToTitleBookText(bookTitle),publisherAccordingTitle);
    }

    @Parameters({"usernameValue","passwordValue","bookTitleExpected"})
    @Test
    public void isNotImageWithBrokeLink(String usernameValue, String passwordValue, String bookTitle) throws IOException {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        Assert.assertTrue(bsProfilePage.isLinkImageDoesNotBrokeInTableOfBooksCollection(bookTitle));
    }

    @Parameters({"usernameValue","passwordValue","bookTitleExpected"})
    @Test
    public void isABookDeleted(String usernameValue, String passwordValue, String bookTitle) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.deleteABook(bookTitle);
        Assert.assertFalse(bsProfilePage.isTitleInTableOfBooksCollection(bookTitle));
    }

    @Parameters({"usernameValue","passwordValue","pageNumberExpected"})
    @Test
    public void isShowedDataWithNextButton(String usernameValue, String passwordValue, String pageNumberExpected) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(),pageNumberExpected);
    }

    @Parameters({"usernameValue","passwordValue","pageNumberBase"})
    @Test
    public void isShowedDataWithPreviousButton(String usernameValue, String passwordValue, String pageNumberBase) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        bsProfilePage.clickOnPreviousButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(),pageNumberBase);

    }

    /*
    @Parameters({"usernameValue","passwordValue"})
    @Test
    public void validateAccountIsDeleted(String usernameValue, String passwordValue) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,passwordValue);
        bsProfilePage.deleteAccount().userLogin(prop.getProperty("BSUsername"),prop.getProperty("BSPassword"));
        Assert.assertTrue(bsProfilePage.isTitleVisible());
    }*/

}
