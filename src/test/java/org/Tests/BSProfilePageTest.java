package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class BSProfilePageTest extends TestBase {
    private final String URL_REGISTER = "https://demoqa.com/register";
    private final String URL_LOGIN = "https://demoqa.com/login";
    private final String URL_BOOKS = "https://demoqa.com/books";
    private final String BOOKS_LABEL= "https://demoqa.com/books";
    private final String SEARCH_BOX_PLACEHOLDER = "Type to search";
    private final String USERNAME_LABEL = "User Name :";
    private final String TABLE_TITLE_IMAGE = "Image";
    private final String TABLE_TITLE_TITLE = "Title";
    private final String TABLE_TITLE_AUTHOR = "Author";
    private final String TABLE_TITLE_PUBLISHER = "Publisher";
    private final String TABLE_TITLE_ACTION = "Action";
    private final String PAGE_OF_TABLE = "Page of 1";
    private final String TOTAL_PAGES_OF_TABLE = "1";
    private final String PAGE_NUMBER_BASE = "1";
    private final String PAGE_NUMBER_EXPECTED = "2";
    private final String USERNAME = "lola12";
    private final String PASSWORD = "P@ssw0rd";


    @BeforeMethod
    public void initializeClass(){
        bsProfilePage = homePage.clickOnSectionBookStoreApplication().clickOnProfile();
    }

    @Test
    public void isProfileTitleVisible(){
        Assert.assertTrue(bsProfilePage.isTitleVisible());
    }

    @Test
    public void validateLinkRegisterIsFunctional(){
        Assert.assertEquals(bsProfilePage.clickOnRegisterLink().getCurrentUrl(),URL_REGISTER);
    }

    @Test
    public void isMessageDoNotLoginShowed(){
        Assert.assertTrue(bsProfilePage.isMessageDoNotLoginShowed());
    }

    @Test
    public void isUsernameCorrect() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),USERNAME);
    }

    @Test
    public void validateCorrectBooksLabelText() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getBooksLabelText(),BOOKS_LABEL);
    }

    @Test
    public void validateCorrectPlaceHolderInSearchBook() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME, PASSWORD);
        Assert.assertEquals(bsProfilePage.getSearchBoxPlaceholderText(), SEARCH_BOX_PLACEHOLDER);
    }

    @Test
    public void validateCorrectUsernameLabelText() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getUserNameLabelText(),USERNAME_LABEL);
    }

    @Test
    public void validateLogOutButtonRedirectToLogin() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.clickOnLogOutButton().getCurrentUrl(),URL_LOGIN);
    }

    @Test
    public void validateCorrectImageTitleText() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleImageText(),TABLE_TITLE_IMAGE);
    }

    @Test
    public void validateCorrectTitleOfTitleTableText() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleTitleText(),TABLE_TITLE_TITLE);
    }

    @Test
    public void validateCorrectAuthorTitleOfTableText() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleAuthorText(),TABLE_TITLE_AUTHOR);
    }

    @Test
    public void validateCorrectPublisherTitleOfTableText() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitlePublisherText(),TABLE_TITLE_PUBLISHER);
    }

    @Test
    public void validateCorrectActionTitleOfTableText() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleActionText(),TABLE_TITLE_ACTION);
    }

    @Test
    public void validateNoDataMessageIsVisible() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Test
    public void validatePreviousButtonIsEnabled() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertFalse(bsProfilePage.isPreviousButtonEnabled());
    }

    @Test
    public void validateNextButtonIsEnabled() {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertFalse(bsProfilePage.isNextButtonEnabled());
    }

    @Test(dataProvider = "books")
    public void isBookFoundBySearchBox(Object... data) {
        String titleBook = (String) data[0];
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.typeOnSearchBox(titleBook);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test
    public void validateCorrectPageLabelText(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPageText(),PAGE_OF_TABLE);
    }

    @Test
    public void validateCorrectTotalOfPages(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTotalOfPagesText(),TOTAL_PAGES_OF_TABLE);
    }

    @Test
    public void wereAllBooksDeleted(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.deleteAllBooks();
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Test
    public void validateGoToBookStoreRedirectToBookStorePage(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.clickOnGoToBookStoreButton().getBookStoreUrlText(),URL_BOOKS);
    }

    @Test
    public void validateCancelButtonOfDeleteAccountAlertIsFunctional(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.tryToDeleteAccount();
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),USERNAME);
    }

    @Test(dataProvider = "books")
    public void validateCancelButtonOfDeleteBooksAlertIsFunctional(Object... data) {
        String titleBook = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        bsProfilePage.tryToDeleteAllBooks();
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Parameters({"usernameValue","PASSWORD","titleBook"})
    @Test(dataProvider = "books")
    public void isAddedABookInTable(Object... data) {
        String titleBook = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test
    public void pageNumber(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_BASE);
    }

    @Test(dataProvider = "books")
    public void validateCorrectAuthorRegardToTitleBook(Object... data) {
        String bookTitle = (String) data[0];
        String authorAccordingTitle = (String) data[1];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getAuthorRegardToTitleBookText(bookTitle),authorAccordingTitle);
    }

    @Test(dataProvider = "books")
    public void validateCorrectPublisherRegardToTitleBook(Object... data) {
        String bookTitle = (String) data[0];
        String publisherAccordingTitle = (String) data[2];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPublisherRegardToTitleBookText(bookTitle),publisherAccordingTitle);
    }

    @Test(dataProvider = "books")
    public void isNotImageWithBrokeLink(Object... data) throws IOException {
        String bookTitle = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertTrue(bsProfilePage.isLinkImageDoesNotBrokeInTableOfBooksCollection(bookTitle));
    }

    @Test(dataProvider = "books")
    public void isABookDeleted(Object... data) {
        String bookTitle = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.deleteABook(bookTitle);
        Assert.assertFalse(bsProfilePage.isTitleInTableOfBooksCollection(bookTitle));
    }

    @Test
    public void isShowedDataWithNextButton(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_EXPECTED);
    }

    @Test
    public void isShowedDataWithPreviousButton(String USERNAME, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        bsProfilePage.clickOnPreviousButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_BASE);

    }

    /*
    @Test
    public void validateAccountIsDeleted(String usernameValue, String PASSWORD) {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,PASSWORD);
        bsProfilePage.deleteAccount().userLogin(prop.getProperty("BSUsername"),prop.getProperty("BSPassword"));
        Assert.assertTrue(bsProfilePage.isTitleVisible());
    }*/

    @DataProvider
    private Object[][] books() throws IOException {
        String sheetName = "bookStore";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }

}
