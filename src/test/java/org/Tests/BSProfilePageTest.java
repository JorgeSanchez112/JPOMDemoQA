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

public class BSProfilePageTest extends TestBase {
    private Logger logger = LogManager.getLogger(BSProfilePageTest.class);
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

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing BSProfilePageTest Class------------------");
        bsProfilePage = homePage.clickOnSectionBookStoreApplication().clickOnProfile();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void isProfileTitleVisible(){
        logger.info("-------------------isProfileTitleVisible-----------------------");
        Assert.assertTrue(bsProfilePage.isTitleVisible());
    }

    @Test
    public void validateLinkRegisterIsFunctional(){
        logger.info("-------------------validateLinkRegisterIsFunctional-----------------------");
        Assert.assertEquals(bsProfilePage.clickOnRegisterLink().getCurrentUrl(),URL_REGISTER);
    }

    @Test
    public void isMessageDoNotLoginShowed(){
        logger.info("-------------------isMessageDoNotLoginShowed-----------------------");
        Assert.assertTrue(bsProfilePage.isMessageDoNotLoginShowed());
    }

    @Test
    public void isUsernameCorrect() {
        logger.info("-------------------isUsernameCorrect-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),USERNAME);
    }

    @Test
    public void validateCorrectBooksLabelText() {
        logger.info("-------------------validateCorrectBooksLabelText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getBooksLabelText(),BOOKS_LABEL);
    }

    @Test
    public void validateCorrectPlaceHolderInSearchBook() {
        logger.info("-------------------validateCorrectPlaceHolderInSearchBook-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME, PASSWORD);
        Assert.assertEquals(bsProfilePage.getSearchBoxPlaceholderText(), SEARCH_BOX_PLACEHOLDER);
    }

    @Test
    public void validateCorrectUsernameLabelText() {
        logger.info("-------------------validateCorrectUsernameLabelText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getUserNameLabelText(),USERNAME_LABEL);
    }

    @Test
    public void validateLogOutButtonRedirectToLogin() {
        logger.info("-------------------validateLogOutButtonRedirectToLogin-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.clickOnLogOutButton().getCurrentUrl(),URL_LOGIN);
    }

    @Test
    public void validateCorrectImageTitleText() {
        logger.info("-------------------validateCorrectImageTitleText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleImageText(),TABLE_TITLE_IMAGE);
    }

    @Test
    public void validateCorrectTitleOfTitleTableText() {
        logger.info("-------------------validateCorrectTitleOfTitleTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleTitleText(),TABLE_TITLE_TITLE);
    }

    @Test
    public void validateCorrectAuthorTitleOfTableText() {
        logger.info("-------------------validateCorrectAuthorTitleOfTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleAuthorText(),TABLE_TITLE_AUTHOR);
    }

    @Test
    public void validateCorrectPublisherTitleOfTableText() {
        logger.info("-------------------validateCorrectPublisherTitleOfTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitlePublisherText(),TABLE_TITLE_PUBLISHER);
    }

    @Test
    public void validateCorrectActionTitleOfTableText() {
        logger.info("-------------------validateCorrectActionTitleOfTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleActionText(),TABLE_TITLE_ACTION);
    }

    @Test
    public void validateNoDataMessageIsVisible() {
        logger.info("-------------------validateNoDataMessageIsVisible-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Test
    public void validatePreviousButtonIsEnabled() {
        logger.info("-------------------validatePreviousButtonIsEnabled-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertFalse(bsProfilePage.isPreviousButtonEnabled());
    }

    @Test
    public void validateNextButtonIsEnabled() {
        logger.info("-------------------validateNextButtonIsEnabled-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertFalse(bsProfilePage.isNextButtonEnabled());
    }

    @Test(dataProvider = "books")
    public void isBookFoundBySearchBox(Object... data) {
        logger.info("-------------------isBookFoundBySearchBox-----------------------");
        String titleBook = (String) data[0];
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.typeOnSearchBox(titleBook);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test
    public void validateCorrectPageLabelText() {
        logger.info("-------------------validateCorrectPageLabelText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPageText(),PAGE_OF_TABLE);
    }

    @Test
    public void validateCorrectTotalOfPages() {
        logger.info("-------------------validateCorrectTotalOfPages-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTotalOfPagesText(),TOTAL_PAGES_OF_TABLE);
    }

    @Test
    public void wereAllBooksDeleted() {
        logger.info("-------------------wereAllBooksDeleted-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.deleteAllBooks();
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Test
    public void validateGoToBookStoreRedirectToBookStorePage() {
        logger.info("-------------------validateGoToBookStoreRedirectToBookStorePage-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.clickOnGoToBookStoreButton().getBookStoreUrlText(),URL_BOOKS);
    }

    @Test
    public void validateCancelButtonOfDeleteAccountAlertIsFunctional() {
        logger.info("-------------------validateCancelButtonOfDeleteAccountAlertIsFunctional-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.tryToDeleteAccount();
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),USERNAME);
    }

    @Test(dataProvider = "books")
    public void validateCancelButtonOfDeleteBooksAlertIsFunctional(Object... data) {
        logger.info("-------------------validateCancelButtonOfDeleteBooksAlertIsFunctional-----------------------");
        String titleBook = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        bsProfilePage.tryToDeleteAllBooks();
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test(dataProvider = "books")
    public void isAddedABookInTable(Object... data) {
        logger.info("-------------------isAddedABookInTable-----------------------");
        String titleBook = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test
    public void pageNumber() {
        logger.info("-------------------pageNumber-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_BASE);
    }

    @Test(dataProvider = "books")
    public void validateCorrectAuthorRegardToTitleBook(Object... data) {
        logger.info("-------------------validateCorrectAuthorRegardToTitleBook-----------------------");
        String bookTitle = (String) data[0];
        String authorAccordingTitle = (String) data[1];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getAuthorRegardToTitleBookText(bookTitle),authorAccordingTitle);
    }

    @Test(dataProvider = "books")
    public void validateCorrectPublisherRegardToTitleBook(Object... data) {
        logger.info("-------------------validateCorrectPublisherRegardToTitleBook-----------------------");
        String bookTitle = (String) data[0];
        String publisherAccordingTitle = (String) data[2];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPublisherRegardToTitleBookText(bookTitle),publisherAccordingTitle);
    }

    @Test(dataProvider = "books")
    public void isNotImageWithBrokeLink(Object... data) throws IOException {
        logger.info("-------------------isNotImageWithBrokeLink-----------------------");
        String bookTitle = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertTrue(bsProfilePage.isLinkImageDoesNotBrokeInTableOfBooksCollection(bookTitle));
    }

    @Test(dataProvider = "books")
    public void isABookDeleted(Object... data) {
        logger.info("-------------------isABookDeleted-----------------------");
        String bookTitle = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.deleteABook(bookTitle);
        Assert.assertFalse(bsProfilePage.isTitleInTableOfBooksCollection(bookTitle));
    }

    @Test
    public void isShowedDataWithNextButton() {
        logger.info("-------------------isShowedDataWithNextButton-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_EXPECTED);
    }

    @Test
    public void isShowedDataWithPreviousButton() {
        logger.info("-------------------isShowedDataWithPreviousButton-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        bsProfilePage.clickOnPreviousButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_BASE);

    }

    /*
    @Test
    public void validateAccountIsDeleted() {
        bsProfilePage.clickOnLoginLink().userLogin(usernameValue,PASSWORD);
        bsProfilePage.deleteAccount().userLogin(prop.getProperty("BSUsername"),prop.getProperty("BSPassword"));
        Assert.assertTrue(bsProfilePage.isTitleVisible());
    }*/

    @DataProvider
    private Object[][] books() throws IOException {
        String sheetName = "bookStore";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }

}
