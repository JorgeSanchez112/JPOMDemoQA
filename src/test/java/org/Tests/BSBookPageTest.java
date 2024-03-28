package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class BSBookPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(BSBookPageTest.class);
    private final String PAGE_TITLE = "Book Store";
    private final String URL_LOGIN = "https://demoqa.com/login";
    private final String URL_BOOKS = "Books :";

    public void initializeClass(String bookTitle){
        try{
            logger.info("-------------------Initializing BSBookPageTest Class------------------");
            bsiBookPage = homePage.clickOnSectionBookStoreApplication().searchAndClickOnATitle(bookTitle);
            logger.info("-------------------Starting Test-----------------------");
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "dataTest")
    public void validateCorrectPageTitle(Object... data){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test(dataProvider = "dataTest")
    public void isUsernameLabelVisible(Object... data){
        logger.info("-------------------isUsernameLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertFalse(bsiBookPage.usernameLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateLoginButton(Object... data){
        logger.info("-------------------validateLoginButton-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.clickOnLogin().getCurrentUrl(),URL_LOGIN);
    }

    @Test(dataProvider = "dataTest")
    public void validateIsbnValueIsCorrect(Object... data){
        logger.info("-------------------validateIsbnValueIsCorrect-----------------------");
        String bookTitle = (String) data[0];
        String isbnValue = (String) data[1];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getIsbnValueText(),isbnValue);
    }

    @Test(dataProvider = "dataTest")
    public void isIsbnLabelVisible(Object... data){
        logger.info("-------------------isIsbnLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.isbnLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateTitleValueIsCorrect(Object... data){
        logger.info("-------------------validateTitleValueIsCorrect-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getTitleValueText(),bookTitle);
    }

    @Test(dataProvider = "dataTest")
    public void isTitleLabelVisible(Object... data){
        logger.info("-------------------isTitleLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.titleLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateSubtitleValueIsCorrect(Object... data){
        logger.info("-------------------validateSubtitleValueIsCorrect-----------------------");
        String bookTitle = (String) data[0];
        String subTitleValue = (String) data[2];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getSubTitleValueText(),subTitleValue);
    }

    @Test(dataProvider = "dataTest")
    public void isSubTitleLabelVisible(Object... data){
        logger.info("-------------------isSubTitleLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.subtitleLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void ValidateAuthorValueIsCorrect(Object... data){
        logger.info("-------------------ValidateAuthorValueIsCorrect-----------------------");
        String bookTitle = (String) data[0];
        String authorValue = (String) data[3];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getAuthorValueText(),authorValue);
    }

    @Test(dataProvider = "dataTest")
    public void isAuthorLabelVisible(Object... data){
        logger.info("-------------------isAuthorLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.authorLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validatePublisherValueIsCorrect(Object... data){
        logger.info("-------------------validatePublisherValueIsCorrect-----------------------");
        String bookTitle = (String) data[0];
        String publisherValue = (String) data[4];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getPublisherValueText(),publisherValue);
    }

    @Test(dataProvider = "dataTest")
    public void isPublisherLabelVisible(Object... data){
        logger.info("-------------------isPublisherLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.publisherLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateTotalPageValueIsCorrect(Object... data){
        logger.info("-------------------validateTotalPageValueIsCorrect-----------------------");
        String bookTitle = (String) data[0];
        String totalPages = (String) data[5];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getTotalPagesValueText(),totalPages);
    }

    @Test(dataProvider = "dataTest")
    public void isTotalPagesLabelVisible(Object... data){
        logger.info("-------------------isTotalPagesLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.pagesLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void validateDescriptionValueIsCorrect(Object... data){
        logger.info("-------------------validateDescriptionValueIsCorrect-----------------------");
        String bookTitle = (String) data[0];
        String descriptionValue = (String) data[6];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.getDescriptionValueText(),descriptionValue);
    }

    @Test(dataProvider = "dataTest")
    public void isDescriptionLabelVisible(Object... data){
        logger.info("-------------------isDescriptionLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.descriptionLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void isWebsiteLabelVisible(Object... data){
        logger.info("-------------------isWebsiteLabelVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.websiteLabelIsVisible());
    }

    @Test(dataProvider = "dataTest")
    public void isWebsiteLinkVisible(Object... data){
        logger.info("-------------------isWebsiteLinkVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertTrue(bsiBookPage.websiteValueLinkIsVisible());
    }

    @Test(dataProvider = "dataTest")//MIRAR
    public void isRedirectHome(Object... data){
        logger.info("-------------------isRedirectHome-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertEquals(bsiBookPage.clickOnBackToBookStoreBookButton().getBookStoreUrlText(),URL_BOOKS);
    }

    @Test(dataProvider = "dataTest")
    public void isNotLogOutButtonVisible(Object... data){
        logger.info("-------------------isNotLogOutButtonVisible-----------------------");
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);

        Assert.assertFalse(bsiBookPage.logOutButtonIsVisible());
    }


    @Test(dataProvider = "dataTest")
    public void validateUserNameValue(Object... data) {
        logger.info("-------------------validateUserNameValue-----------------------");
        String bookTitle = (String) data[0];
        String userName = (String) data[7];
        String password = (String) data[8];
        initializeClass(bookTitle);

        bsiBookPage.clickOnLogin().userLogin(userName,password);
        Assert.assertEquals(bsiBookPage.getUsernameValueText(),userName);
    }

    @Test(dataProvider = "dataTest")
    public void validateLogOutButtonIsFunctional(Object... data) {
        logger.info("-------------------validateLogOutButtonIsFunctional-----------------------");
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
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }

}