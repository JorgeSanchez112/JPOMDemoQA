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

public class BookStorePageTest extends TestBase {
    private Logger logger = LogManager.getLogger(BookStorePageTest.class);
    private final String URL = "https://demoqa.com/books";
    private final int ELEMENTS_LIST_SIZE = 4;
    private final String FIRST_TITLE_TABLE = "Image";
    private final String SECOND_TITLE_TABLE  = "Title";
    private final String THIRD_TITLE_TABLE  = "Author";
    private final String FOURTH_TITLE_TABLE  = "Publisher";
    private final String SEARCH_BAR_PLACEHOLDER = "Type to search";

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing BookStorePageTest Class------------------");
        bookStorePage = homePage.clickOnSectionBookStoreApplication();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(bookStorePage.getBookStoreUrlText(),URL);
    }

    @Test
    public void isFirstTitleOfTableCorrect() {
        logger.info("-------------------isFirstTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getFirstTitleTableText(), FIRST_TITLE_TABLE);
    }

    @Test
    public void isSecondTitleOfTableCorrect() {
        logger.info("-------------------isSecondTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getSecondTitleTableText(),SECOND_TITLE_TABLE);
    }

    @Test
    public void isThirdTitleOfTableCorrect() {
        logger.info("-------------------isThirdTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getThirdTitleTableText(),THIRD_TITLE_TABLE);
    }

    @Test
    public void isFourthTitleOfTableCorrect() {
        logger.info("-------------------isFourthTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getFourthTitleTableText(),FOURTH_TITLE_TABLE);
    }

    @Test
    public void isFirstBookImageVisible() {
        logger.info("-------------------isFirstBookImageVisible-----------------------");
        Assert.assertTrue(bookStorePage.isVisibleFirstImage());
    }

    @Test(dataProvider = "testData")
    public void areBookTitleCorrect(Object... data) {
        logger.info("-------------------areBookTitleCorrect-----------------------");
        String bookTitle = (String) data[0];

        Assert.assertEquals(bookStorePage.getTitleBookText(bookTitle),bookTitle);
    }

    @Test(dataProvider = "testData")
    public void isFirstBookAuthorCorrect(Object... data) {
        logger.info("-------------------isFirstBookAuthorCorrect-----------------------");
        String bookTitle = (String) data[0];
        String author = (String) data[1];

        Assert.assertEquals(bookStorePage.getBookAuthorText(bookTitle),author);
    }

    @Test(dataProvider = "testData")
    public void isFirstBookPublisherCorrect(Object... data) {
        logger.info("-------------------isFirstBookPublisherCorrect-----------------------");
        String bookTitle = (String) data[0];
        String publisher = (String) data[2];

        Assert.assertEquals(bookStorePage.getBookPublisherText(bookTitle),publisher);
    }

    @Test
    public void validateAllTheBooksImageAreVisible() {
        logger.info("-------------------validateAllTheBooksImageAreVisible-----------------------");
        Assert.assertTrue(bookStorePage.areTheImagesVisible());
    }

    @Test
    public void validateAllTheImagesAreNotBroke() throws IOException {
        logger.info("-------------------validateAllTheImagesAreNotBroke-----------------------");
        Assert.assertTrue(bookStorePage.areNotBrokeLinkImages());
    }

    @Test
    public void isSearchBarPlaceholderCorrect() {
        logger.info("-------------------isSearchBarPlaceholderCorrect-----------------------");
        bookStorePage.scrollToSearchBar();
        Assert.assertEquals(bookStorePage.getSearchBarPlaceholderText(),SEARCH_BAR_PLACEHOLDER);
    }


    @Test(dataProvider = "testData")
    public void isBookSearchedBySearchBar(Object... data) {
        logger.info("-------------------isBookSearchedBySearchBar-----------------------");
        String bookTitle = (String) data[0];
        String searchBar = (String) data[3];

        bookStorePage.scrollToSearchBar();
        bookStorePage.typeOnSearchBar(searchBar);
        Assert.assertTrue(bookStorePage.isBookTitleFound(bookStorePage.getTitleBookText(bookTitle),bookTitle));
    }

    @Test
    public void validateSectionsSize(){
        logger.info("-------------------validateSectionsSize-----------------------");
        Assert.assertEquals(bookStorePage.getSizeSections(),ELEMENTS_LIST_SIZE);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "bookStore";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}