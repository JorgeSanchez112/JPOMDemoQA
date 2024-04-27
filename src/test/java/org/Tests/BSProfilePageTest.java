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

public class BSProfilePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(BSProfilePageTest.class);
    private final String PAGE_NUMBER_BASE = "1";
    private final String USERNAME = "lola12";
    private final String PASSWORD = "P@ssw0rd";

    @BeforeMethod(groups = {"UI","Smoke","Integration","Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing BSProfilePageTest Class------------------");
        bsProfilePage = homePage.clickOnSectionBookStoreApplication().clickOnProfile();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void isProfileTitleVisible(){
        logger.info("-------------------isProfileTitleVisible-----------------------");
        Assert.assertTrue(bsProfilePage.isTitleVisible());
    }

    @Test(groups = {"Functional"})
    public void validateLinkRegisterIsFunctional(){
        String URL_REGISTER = "https://demoqa.com/register";

        logger.info("-------------------validateLinkRegisterIsFunctional-----------------------");
        Assert.assertEquals(bsProfilePage.clickOnRegisterLink().getCurrentUrl(), URL_REGISTER);
    }

    @Test(groups = {"Functional"})
    public void isMessageDoNotLoginShowed(){
        logger.info("-------------------isMessageDoNotLoginShowed-----------------------");
        Assert.assertTrue(bsProfilePage.isMessageDoNotLoginShowed());
    }

    @Test(groups = {"Integration","UI"})
    public void isUsernameCorrect() {
        logger.info("-------------------isUsernameCorrect-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),USERNAME);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectBooksLabelText() {
        String BOOKS_LABEL = "https://demoqa.com/books";

        logger.info("-------------------validateCorrectBooksLabelText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getBooksLabelText(), BOOKS_LABEL);
    }

    @Test(groups = {"Integration","Functional"})
    public void validateCorrectPlaceHolderInSearchBook() {
        String SEARCH_BOX_PLACEHOLDER = "Type to search";

        logger.info("-------------------validateCorrectPlaceHolderInSearchBook-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME, PASSWORD);
        Assert.assertEquals(bsProfilePage.getSearchBoxPlaceholderText(), SEARCH_BOX_PLACEHOLDER);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectUsernameLabelText() {
        String USERNAME_LABEL = "User Name :";

        logger.info("-------------------validateCorrectUsernameLabelText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getUserNameLabelText(), USERNAME_LABEL);
    }

    @Test(groups = {"Integration","Functional"})
    public void validateLogOutButtonRedirectToLogin() {
        String URL_LOGIN = "https://demoqa.com/login";

        logger.info("-------------------validateLogOutButtonRedirectToLogin-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.clickOnLogOutButton().getCurrentUrl(), URL_LOGIN);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectImageTitleText() {
        String TABLE_TITLE_IMAGE = "Image";

        logger.info("-------------------validateCorrectImageTitleText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleImageText(), TABLE_TITLE_IMAGE);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectTitleOfTitleTableText() {
        String TABLE_TITLE_TITLE = "Title";

        logger.info("-------------------validateCorrectTitleOfTitleTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleTitleText(), TABLE_TITLE_TITLE);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectAuthorTitleOfTableText() {
        String TABLE_TITLE_AUTHOR = "Author";

        logger.info("-------------------validateCorrectAuthorTitleOfTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleAuthorText(), TABLE_TITLE_AUTHOR);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectPublisherTitleOfTableText() {
        String TABLE_TITLE_PUBLISHER = "Publisher";

        logger.info("-------------------validateCorrectPublisherTitleOfTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitlePublisherText(), TABLE_TITLE_PUBLISHER);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectActionTitleOfTableText() {
        String TABLE_TITLE_ACTION = "Action";

        logger.info("-------------------validateCorrectActionTitleOfTableText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTableTitleActionText(), TABLE_TITLE_ACTION);
    }

    @Test(groups = {"Integration","UI"})
    public void validateNoDataMessageIsVisible() {
        logger.info("-------------------validateNoDataMessageIsVisible-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Test(groups = {"Integration","Functional"})
    public void validatePreviousButtonIsEnabled() {
        logger.info("-------------------validatePreviousButtonIsEnabled-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertFalse(bsProfilePage.isPreviousButtonEnabled());
    }

    @Test(groups = {"Integration","Functional"})
    public void validateNextButtonIsEnabled() {
        logger.info("-------------------validateNextButtonIsEnabled-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertFalse(bsProfilePage.isNextButtonEnabled());
    }

    @Test(dataProvider = "books",groups = {"Integration","Functional","Smoke"})
    public void isBookFoundBySearchBox(Object... data) {
        logger.info("-------------------isBookFoundBySearchBox-----------------------");
        String titleBook = (String) data[0];
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.typeOnSearchBox(titleBook);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectPageLabelText() {
        String PAGE_OF_TABLE = "Page of 1";

        logger.info("-------------------validateCorrectPageLabelText-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPageText(), PAGE_OF_TABLE);
    }

    @Test(groups = {"Integration","UI"})
    public void validateCorrectTotalOfPages() {
        String TOTAL_PAGES_OF_TABLE = "1";

        logger.info("-------------------validateCorrectTotalOfPages-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getTotalOfPagesText(), TOTAL_PAGES_OF_TABLE);
    }

    @Test(groups = {"Integration","Functional","Smoke"})
    public void wereAllBooksDeleted() {
        logger.info("-------------------wereAllBooksDeleted-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.deleteAllBooks();
        Assert.assertTrue(bsProfilePage.isMessageNoDataVisible());
    }

    @Test(groups = {"Integration","Functional","Smoke"})
    public void validateGoToBookStoreRedirectToBookStorePage() {
        String URL_BOOKS = "https://demoqa.com/books";

        logger.info("-------------------validateGoToBookStoreRedirectToBookStorePage-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.clickOnGoToBookStoreButton().getBookStoreUrlText(), URL_BOOKS);
    }

    @Test(groups = {"Integration","Smoke","Functional"})
    public void validateCancelButtonOfDeleteAccountAlertIsFunctional() {
        logger.info("-------------------validateCancelButtonOfDeleteAccountAlertIsFunctional-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.tryToDeleteAccount();
        Assert.assertEquals(bsProfilePage.getUserNameValueText(),USERNAME);
    }

    @Test(dataProvider = "books",groups = {"Integration","Smoke","Functional"})
    public void validateCancelButtonOfDeleteBooksAlertIsFunctional(Object... data) {
        logger.info("-------------------validateCancelButtonOfDeleteBooksAlertIsFunctional-----------------------");
        String titleBook = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        bsProfilePage.tryToDeleteAllBooks();
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test(dataProvider = "books",groups = {"Integration","Smoke"})
    public void isAddedABookInTable(Object... data) {
        logger.info("-------------------isAddedABookInTable-----------------------");
        String titleBook = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addBookToTableOfBooksCollection(titleBook);
        Assert.assertTrue(bsProfilePage.isTitleInTableOfBooksCollection(titleBook));
    }

    @Test(groups = {"Integration","UI"})
    public void pageNumber() {
        logger.info("-------------------pageNumber-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_BASE);
    }

    @Test(dataProvider = "books",groups = {"Integration","UI"})
    public void validateCorrectAuthorRegardToTitleBook(Object... data) {
        logger.info("-------------------validateCorrectAuthorRegardToTitleBook-----------------------");
        String bookTitle = (String) data[0];
        String authorAccordingTitle = (String) data[1];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getAuthorRegardToTitleBookText(bookTitle),authorAccordingTitle);
    }

    @Test(dataProvider = "books",groups = {"Integration","UI"})
    public void validateCorrectPublisherRegardToTitleBook(Object... data) {
        logger.info("-------------------validateCorrectPublisherRegardToTitleBook-----------------------");
        String bookTitle = (String) data[0];
        String publisherAccordingTitle = (String) data[2];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertEquals(bsProfilePage.getPublisherRegardToTitleBookText(bookTitle),publisherAccordingTitle);
    }

    @Test(dataProvider = "books",groups = {"Integration","Functional"})
    public void isNotImageWithBrokeLink(Object... data) throws IOException {
        logger.info("-------------------isNotImageWithBrokeLink-----------------------");
        String bookTitle = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        Assert.assertTrue(bsProfilePage.isLinkImageDoesNotBrokeInTableOfBooksCollection(bookTitle));
    }

    @Test(dataProvider = "books",groups = {"Integration","Smoke"})
    public void isABookDeleted(Object... data) {
        logger.info("-------------------isABookDeleted-----------------------");
        String bookTitle = (String) data[0];

        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.deleteABook(bookTitle);
        Assert.assertFalse(bsProfilePage.isTitleInTableOfBooksCollection(bookTitle));
    }

    @Test(groups = {"Integration","Functional"})
    public void isShowedDataWithNextButton() {
        String PAGE_NUMBER_EXPECTED = "2";

        logger.info("-------------------isShowedDataWithNextButton-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(), PAGE_NUMBER_EXPECTED);
    }

    @Test(groups = {"Integration","Functional"})
    public void isShowedDataWithPreviousButton() {
        logger.info("-------------------isShowedDataWithPreviousButton-----------------------");
        bsProfilePage.clickOnLoginLink().userLogin(USERNAME,PASSWORD);
        bsProfilePage.addAllBooksToTableOfBooksCollection();
        bsProfilePage.clickOnNextButton();
        bsProfilePage.clickOnPreviousButton();
        Assert.assertEquals(bsProfilePage.getPageNumber(),PAGE_NUMBER_BASE);
    }

    @DataProvider
    private synchronized Object[][] books() throws IOException {
        String sheetName = "bookStore";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }

}
