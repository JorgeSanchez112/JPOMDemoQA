package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookStorePageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        bookStorePage = homePage.clickOnSectionBookStoreApplication();
    }

    @Parameters("uRL")
    @Test
    public void validateURL(String uRL){
        Assert.assertEquals(bookStorePage.getBookStoreUrlText(),uRL);
    }

    @Parameters("firstTitleTable")
    @Test
    public void isFirstTitleOfTableCorrect(String firstTitleTable) {
        Assert.assertEquals(bookStorePage.getFirstTitleTableText(), firstTitleTable);
    }

    @Parameters("secondTitleTable")
    @Test
    public void isSecondTitleOfTableCorrect(String secondTitleTable) {
        Assert.assertEquals(bookStorePage.getSecondTitleTableText(),secondTitleTable);
    }

    @Parameters("thirdTitleTable")
    @Test
    public void isThirdTitleOfTableCorrect(String thirdTitleTable) {
        Assert.assertEquals(bookStorePage.getThirdTitleTableText(),thirdTitleTable);
    }

    @Parameters("fourthTitleTable")
    @Test
    public void isFourthTitleOfTableCorrect(String fourthTitleTable) {
        Assert.assertEquals(bookStorePage.getFourthTitleTableText(),fourthTitleTable);
    }

    @Test
    public void isFirstBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleFirstImage());
    }

    @Parameters("titleOfFirstBook")
    @Test
    public void isFirstBookTitleCorrect(String titleOfFirstBook) {
        Assert.assertEquals(bookStorePage.getTitleOfFirstBookText(),titleOfFirstBook);
    }

    @Parameters("authorOfGitPocketGuideBook")
    @Test
    public void isFirstBookAuthorCorrect(String authorOfGitPocketGuideBook) {
        Assert.assertEquals(bookStorePage.getAuthorOfFirstBookText(),authorOfGitPocketGuideBook);
    }

    @Parameters("publisherOfBooks")
    @Test
    public void isFirstBookPublisherCorrect(String publisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfFirstBookText(),publisherOfBooks);
    }

    @Test
    public void isSecondBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleSecondImage());
    }

    @Parameters("titleOfSecondBook")
    @Test
    public void isSecondBookTitleCorrect(String titleOfSecondBook) {
        Assert.assertEquals(bookStorePage.getTitleOfSecondBookText(),titleOfSecondBook);
    }

    @Parameters("authorOfLearningJavaScriptDesignPatternsBook")
    @Test
    public void isSecondBookAuthorCorrect(String authorOfLearningJavaScriptDesignPatternsBook){
        Assert.assertEquals(bookStorePage.getAuthorOfSecondBookText(),authorOfLearningJavaScriptDesignPatternsBook);
    }

    @Parameters("publisherOfBooks")
    @Test
    public void isSecondBookPublisherCorrect(String publisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfSecondBookText(),publisherOfBooks);
    }

    @Test
    public void isThirdBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleThirdImage());
    }

    @Parameters("titleOfThirdBook")
    @Test
    public void isThirdBookTitleCorrect(String titleOfThirdBook) {
        Assert.assertEquals(bookStorePage.getTitleOfThirdBookText(),titleOfThirdBook);
    }

    @Parameters("authorOfDesigningEvolvableWebAPIswithASPNETBook")
    @Test
    public void isThirdBookAuthorCorrect(String authorOfDesigningEvolvableWebAPIswithASPNETBook) {
        Assert.assertEquals(bookStorePage.getAuthorOfThirdBookText(),authorOfDesigningEvolvableWebAPIswithASPNETBook);
    }

    @Parameters("publisherOfBooks")
    @Test
    public void isThirdBookPublisherCorrect(String publisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfThirdBookText(),publisherOfBooks);
    }

    @Test
    public void isFourthBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleFourthImage());
    }

    @Parameters("titleOfFourthBook")
    @Test
    public void isFourthBookTitleCorrect(String titleOfFourthBook) {
        Assert.assertEquals(bookStorePage.getTitleOfFourthBookText(),titleOfFourthBook);
    }

    @Parameters("authorOfSpeakingJavaScriptBook")
    @Test
    public void isFourthBookAuthorCorrect(String authorOfSpeakingJavaScriptBook) {
        Assert.assertEquals(bookStorePage.getAuthorOfFourthBookText(),authorOfSpeakingJavaScriptBook);
    }

    @Parameters("publisherOfBooks")
    @Test
    public void isFourthBookPublisherCorrect(String publisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfFourthBookText(),publisherOfBooks);
    }

    @Test
    public void isFifthBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleFifthImage());
    }

    @Parameters("titleOfFifthBook")
    @Test
    public void isFifthBookTitleCorrect(String titleOfFifthBook) {
        Assert.assertEquals(bookStorePage.getTitleOfFifthBookText(),titleOfFifthBook);
    }

    @Parameters("authorOfYouDontKnowJSBook")
    @Test
    public void isFifthBookAuthorCorrect(String authorOfYouDontKnowJSBook) {
        Assert.assertEquals(bookStorePage.getAuthorOfFifthBookText(),authorOfYouDontKnowJSBook);
    }

    @Parameters("publisherOfBooks")
    @Test
    public void isFifthBookPublisherCorrect(String publisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfFifthBookText(),publisherOfBooks);
    }

    @Test
    public void isSixthBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleSixthImage());
    }

    @Parameters("titleOfSixthBook")
    @Test
    public void isSixthBookTitleCorrect(String titleOfSixthBook) {
        Assert.assertEquals(bookStorePage.getTitleOfSixthBookText(),titleOfSixthBook);
    }

    @Parameters("authorOfProgrammingJavaScriptApplicationsBook")
    @Test
    public void isSixthBookAuthorCorrect(String authorOfProgrammingJavaScriptApplicationsBook) {
        Assert.assertEquals(bookStorePage.getAuthorOfSixthBookText(),authorOfProgrammingJavaScriptApplicationsBook);
    }

    @Parameters("publisherOfBooks")
    @Test
    public void isSixthBookPublisherCorrect(String publisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfSixthBookText(),publisherOfBooks);
    }

    @Test
    public void isSeventhBookImageVisible() {
        Assert.assertTrue(bookStorePage.isVisibleSeventhImage());
    }

    @Parameters("titleOfSeventhBook")
    @Test
    public void isSeventhBookTitleCorrect(String titleOfSeventhBook) {
        Assert.assertEquals(bookStorePage.getTitleOfSeventhBookText(),titleOfSeventhBook);
    }

    @Parameters("authorOfEloquentJavaScriptSecondEditionBook")
    @Test
    public void isSeventhBookAuthorCorrect(String authorOfEloquentJavaScriptSecondEditionBook) {
        Assert.assertEquals(bookStorePage.getAuthorOfSeventhBookText(),authorOfEloquentJavaScriptSecondEditionBook);
    }

    @Parameters("SecondPublisherOfBooks")
    @Test
    public void isSeventhBookPublisherCorrect(String SecondPublisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfSeventhBookText(),SecondPublisherOfBooks);
    }

    @Test
    public void isEighthBookImageVisible() {
        bookStorePage.scrollToSeventhRow();
        Assert.assertTrue(bookStorePage.isVisibleEighthImage());
    }

    @Parameters("titleOfEighthBook")
    @Test
    public void isEighthBookTitleCorrect(String titleOfEighthBook) {
        Assert.assertEquals(bookStorePage.getTitleOfEighthBookText(),titleOfEighthBook);
    }

    @Parameters("authorOfUnderstandingECMAScript6Book")
    @Test
    public void isEighthBookAuthorCorrect(String authorOfUnderstandingECMAScript6Book) {
        Assert.assertEquals(bookStorePage.getAuthorOfEighthBookText(),authorOfUnderstandingECMAScript6Book);
    }

    @Parameters("SecondPublisherOfBooks")
    @Test
    public void isEighthBookPublisherCorrect(String SecondPublisherOfBooks) {
        Assert.assertEquals(bookStorePage.getPublisherOfEighthBookText(),SecondPublisherOfBooks);
    }

    @Parameters("searchBarPlaceholder")
    @Test
    public void isSearchBarPlaceholderCorrect(String searchBarPlaceholder) {
        bookStorePage.scrollToSearchBar();
        Assert.assertEquals(bookStorePage.getSearchBarPlaceholderText(),searchBarPlaceholder);
    }

    @Parameters({"searchBar","titleExpected"})
    @Test
    public void isBookSearchedBySearchBar(String searchBar, String titleExpected) {
        bookStorePage.scrollToSearchBar();
        bookStorePage.typeOnSearchBar(searchBar);
        Assert.assertTrue(bookStorePage.isBookTitleFound(bookStorePage.getTitleOfFirstBookText(),titleExpected));
    }

    @Parameters("elementsSize")
    @Test
    public void validateSectionsSize(int elementsSize){
        Assert.assertEquals(bookStorePage.getSizeSections(),elementsSize);
    }
}
