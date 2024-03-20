package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class BSIBookPageTest extends TestBase {
    private final String PAGE_TITLE = "Book Store";
    private final String URL_LOGIN = "https://demoqa.com/login";
    private final String URL_BOOKS = "Books :";

    public void initializeClass(String bookTitle){
        try{
            bsiBookPage = homePage.clickOnSectionBookStoreApplication().searchAndClickOnATitle(bookTitle);
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "dataTest")
    public void validateCorrectPageTitle(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test(dataProvider = "dataTest")
    public void isUsernameLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertFalse(bsiBookPage.usernameLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateLoginButton(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.clickOnLogin().getCurrentUrl(),URL_LOGIN);
    }

    @Test(dataProvider = "dataTest")
    public void validateIsbnValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String isbnValue = (String) data[1];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getIsbnValueText(),isbnValue);
    }

    @Test(dataProvider = "dataTest")
    public void isIsbnLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.isbnLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateTitleValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getTitleValueText(),bookTitle);
    }

    @Test(dataProvider = "dataTest")
    public void isTitleLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.titleLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateSubtitleValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String subTitleValue = (String) data[2];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getSubTitleValueText(),subTitleValue);
    }

    @Test(dataProvider = "dataTest")
    public void isSubTitleLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.subtitleLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void ValidateAuthorValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String authorValue = (String) data[3];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getAuthorValueText(),authorValue);
    }

    @Test(dataProvider = "dataTest")
    public void isAuthorLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.authorLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validatePublisherValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String publisherValue = (String) data[4];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getPublisherValueText(),publisherValue);
    }

    @Test(dataProvider = "dataTest")
    public void isPublisherLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.publisherLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateTotalPageValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String totalPages = (String) data[5];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getTotalPagesValueText(),totalPages);
    }

    @Test(dataProvider = "dataTest")
    public void isTotalPagesLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.pagesLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateDescriptionValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String descriptionValue = (String) data[6];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getDescriptionValueText(),descriptionValue);
    }

    @Test(dataProvider = "dataTest")
    public void isDescriptionLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.descriptionLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void isWebsiteLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.websiteLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void isWebsiteLinkVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.websiteValueLinkIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void isRedirectHome(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.clickOnBackToBookStoreBookButton().getBookStoreUrlText(),URL_BOOKS);
    }

    @Test(dataProvider = "dataTest")
    public void isNotLogOutButtonVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertFalse(bsiBookPage.logOutButtonIsVisible());
    }


    @Test(dataProvider = "dataTest")
    public void validateUserNameValue(Object... data) {
        String bookTitle = (String) data[0];
        String userName = (String) data[7];
        String password = (String) data[8];
        initializeClass(bookTitle);

        bsiBookPage.clickOnLogin().userLogin(userName,password);
        Assert.assertEquals(bsiBookPage.getUsernameValueText(),userName);
    }

    @Test(dataProvider = "dataTest")
    public void validateLogOutButtonIsFunctional(Object... data) {
        String bookTitle = (String) data[0];
        String userName = (String) data[7];
        String password = (String) data[8];
        initializeClass(bookTitle);

        bsiBookPage.clickOnLogin().userLogin(userName,password);
        Assert.assertEquals(bsiBookPage.clickOnLogOutButton().getCurrentUrl(),URL_LOGIN);
    }

    @DataProvider(name = "dataTest")
    Object[][] testData() throws IOException {
        String sheetName = "BSBookPage";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }

}
