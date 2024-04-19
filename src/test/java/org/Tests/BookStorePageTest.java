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

public class BookStorePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(BookStorePageTest.class);

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing BookStorePageTest Class------------------");
        bookStorePage = homePage.clickOnSectionBookStoreApplication(getDriver());
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"Functional"})
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        String URL = "https://demoqa.com/books";
        Assert.assertEquals(bookStorePage.getBookStoreUrlText(), URL);
    }

    @Test(groups = {"UI"})
    public void isFirstTitleOfTableCorrect() {
        String FIRST_TITLE_TABLE = "Image";

        logger.info("-------------------isFirstTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getFirstTitleTableText(), FIRST_TITLE_TABLE);
    }

    @Test(groups = {"UI"})
    public void isSecondTitleOfTableCorrect() {
        String SECOND_TITLE_TABLE = "Title";

        logger.info("-------------------isSecondTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getSecondTitleTableText(), SECOND_TITLE_TABLE);
    }

    @Test(groups = {"UI"})
    public void isThirdTitleOfTableCorrect() {
        String THIRD_TITLE_TABLE = "Author";

        logger.info("-------------------isThirdTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getThirdTitleTableText(), THIRD_TITLE_TABLE);
    }

    @Test(groups = {"UI"})
    public void isFourthTitleOfTableCorrect() {
        String FOURTH_TITLE_TABLE = "Publisher";

        logger.info("-------------------isFourthTitleOfTableCorrect-----------------------");
        Assert.assertEquals(bookStorePage.getFourthTitleTableText(), FOURTH_TITLE_TABLE);
    }

    @Test(groups = {"UI"})
    public void isFirstBookImageVisible() {
        logger.info("-------------------isFirstBookImageVisible-----------------------");
        Assert.assertTrue(bookStorePage.isVisibleFirstImage());
    }

    @Test(dataProvider = "testData",groups = {"UI"})
    public void areBookTitleCorrect(Object... data) {
        logger.info("-------------------areBookTitleCorrect-----------------------");
        String bookTitle = (String) data[0];

        Assert.assertEquals(bookStorePage.getTitleBookText(bookTitle),bookTitle);
    }

    @Test(dataProvider = "testData",groups = {"UI"})
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

    @Test(groups = {"UI"})
    public void validateAllTheBooksImageAreVisible() {
        logger.info("-------------------validateAllTheBooksImageAreVisible-----------------------");
        Assert.assertTrue(bookStorePage.areTheImagesVisible());
    }

    @Test(groups = {"Smoke"})
    public void validateAllTheImagesAreNotBroke() throws IOException {
        logger.info("-------------------validateAllTheImagesAreNotBroke-----------------------");
        Assert.assertTrue(bookStorePage.areNotBrokeLinkImages());
    }

    @Test(groups = {"UI"})
    public void isSearchBarPlaceholderCorrect() {
        String SEARCH_BAR_PLACEHOLDER = "Type to search";

        logger.info("-------------------isSearchBarPlaceholderCorrect-----------------------");
        bookStorePage.scrollToSearchBar();
        Assert.assertEquals(bookStorePage.getSearchBarPlaceholderText(), SEARCH_BAR_PLACEHOLDER);
    }


    @Test(dataProvider = "testData",groups = {"Smoke","Functional"})
    public void isBookSearchedBySearchBar(Object... data) {
        logger.info("-------------------isBookSearchedBySearchBar-----------------------");
        String bookTitle = (String) data[0];
        String searchBar = (String) data[3];

        bookStorePage.scrollToSearchBar();
        bookStorePage.typeOnSearchBar(searchBar);
        Assert.assertTrue(bookStorePage.isBookTitleFound(bookStorePage.getTitleBookText(bookTitle),bookTitle));
    }

    @Test(groups = {"UI"})
    public void validateSectionsSize(){
        int ELEMENTS_LIST_SIZE = 4;

        logger.info("-------------------validateSectionsSize-----------------------");
        Assert.assertEquals(bookStorePage.getSizeSections(), ELEMENTS_LIST_SIZE);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "bookStore";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}