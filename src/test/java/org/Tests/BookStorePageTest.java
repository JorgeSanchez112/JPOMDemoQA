package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class BookStorePageTest extends TestBase {
    private final String URL = "https://demoqa.com/books";
    private final int ELEMENTS_LIST_SIZE = 4;
    private final String FIRST_TITLE_TABLE = "Image";
    private final String SECOND_TITLE_TABLE  = "Title";
    private final String THIRD_TITLE_TABLE  = "Author";
    private final String FOURTH_TITLE_TABLE  = "Publisher";
    private final String SEARCH_BAR_PLACEHOLDER = "Type to search";

    @BeforeMethod
    public void initializeClass(){
        bookStorePage = homePage.clickOnSectionBookStoreApplication();
    }

    @Test
    public void validateURL(){
        Assert.assertEquals(bookStorePage.getBookStoreUrlText(),URL);
    }

    @Test
    public void isFirstTitleOfTableCorrect() {
        Assert.assertEquals(bookStorePage.getFirstTitleTableText(), FIRST_TITLE_TABLE);
    }

    @Test
    public void isSecondTitleOfTableCorrect() {
        Assert.assertEquals(bookStorePage.getSecondTitleTableText(),SECOND_TITLE_TABLE);
    }

    @Test
    public void isThirdTitleOfTableCorrect() {
        Assert.assertEquals(bookStorePage.getThirdTitleTableText(),THIRD_TITLE_TABLE);
    }

    @Test
    public void isFourthTitleOfTableCorrect() {
        Assert.assertEquals(bookStorePage.getFourthTitleTableText(),FOURTH_TITLE_TABLE);
    }

    @Test
    public void isFirstBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleFirstImage());
    }

    @Test(dataProvider = "testData")
    public void areBookTitleCorrect(Object... data) {
        String bookTitle = (String) data[0];

        Assert.assertEquals(bookStorePage.getTitleBookText(bookTitle),bookTitle);
    }

    @Test(dataProvider = "testData")
    public void isFirstBookAuthorCorrect(Object... data) {
        String bookTitle = (String) data[0];
        String author = (String) data[1];

        Assert.assertEquals(bookStorePage.getBookAuthorText(bookTitle),author);
    }

    @Test(dataProvider = "testData")
    public void isFirstBookPublisherCorrect(Object... data) {
        String bookTitle = (String) data[0];
        String publisher = (String) data[2];

        Assert.assertEquals(bookStorePage.getBookPublisherText(bookTitle),publisher);
    }

    @Test
    public void validateAllTheBooksImageAreVisible() {
        Assert.assertTrue(bookStorePage.areTheImagesVisible());
    }

    @Test
    public void validateAllTheImagesAreNotBroke() throws IOException {
        Assert.assertTrue(bookStorePage.areNotBrokeLinkImages());
    }

    @Test
    public void isSearchBarPlaceholderCorrect() {
        bookStorePage.scrollToSearchBar();
        Assert.assertEquals(bookStorePage.getSearchBarPlaceholderText(),SEARCH_BAR_PLACEHOLDER);
    }


    @Test(dataProvider = "testData")
    public void isBookSearchedBySearchBar(Object... data) {
        String bookTitle = (String) data[0];
        String searchBar = (String) data[3];

        bookStorePage.scrollToSearchBar();
        bookStorePage.typeOnSearchBar(searchBar);
        Assert.assertTrue(bookStorePage.isBookTitleFound(bookStorePage.getTitleBookText(bookTitle),bookTitle));
    }

    @Test
    public void validateSectionsSize(){
        Assert.assertEquals(bookStorePage.getSizeSections(),ELEMENTS_LIST_SIZE);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "bookStore";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}