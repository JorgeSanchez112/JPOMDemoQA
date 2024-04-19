package org.Tests;

import TestComponents.utilities.dataDriven.ExcelReader;
import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class BSBookPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(BSBookPageTest.class);
    private final String URL_LOGIN = "https://demoqa.com/login";

    public void initializeClass(String bookTitle){
        try{
            logger.info("-------------------Initializing BSBookPageTest Class------------------");
            bsiBookPage = homePage.clickOnSectionBookStoreApplication(getDriver()).searchAndClickOnATitle(bookTitle,getDriver());
            logger.info("-------------------Starting Test-----------------------");
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI","Functional","Smoke"})
    public void validateCorrectPageTitle(Object... data){
        String PAGE_TITLE = "Book Store";

        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(bsiBookPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isUsernameLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isUsernameLabelVisible-----------------------");
        Assert.assertFalse(bsiBookPage.usernameLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","Functional"})
    public void validateLoginButton(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------validateLoginButton-----------------------");
        Assert.assertEquals(bsiBookPage.clickOnLogin().getCurrentUrl(),URL_LOGIN);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void validateIsbnValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String isbnValue = (String) data[1];
        initializeClass(bookTitle);
        logger.info("-------------------validateIsbnValueIsCorrect-----------------------");
        Assert.assertEquals(bsiBookPage.getIsbnValueText(),isbnValue);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isIsbnLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isIsbnLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.isbnLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void validateTitleValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------validateTitleValueIsCorrect-----------------------");
        Assert.assertEquals(bsiBookPage.getTitleValueText(),bookTitle);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isTitleLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isTitleLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.titleLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void validateSubtitleValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String subTitleValue = (String) data[2];
        initializeClass(bookTitle);
        logger.info("-------------------validateSubtitleValueIsCorrect-----------------------");
        Assert.assertEquals(bsiBookPage.getSubTitleValueText(),subTitleValue);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isSubTitleLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isSubTitleLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.subtitleLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void ValidateAuthorValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String authorValue = (String) data[3];
        initializeClass(bookTitle);
        logger.info("-------------------ValidateAuthorValueIsCorrect-----------------------");
        Assert.assertEquals(bsiBookPage.getAuthorValueText(),authorValue);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isAuthorLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isAuthorLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.authorLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void validatePublisherValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String publisherValue = (String) data[4];
        initializeClass(bookTitle);
        logger.info("-------------------validatePublisherValueIsCorrect-----------------------");
        Assert.assertEquals(bsiBookPage.getPublisherValueText(),publisherValue);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isPublisherLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isPublisherLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.publisherLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void validateTotalPageValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String totalPages = (String) data[5];
        initializeClass(bookTitle);
        logger.info("-------------------validateTotalPageValueIsCorrect-----------------------");
        Assert.assertEquals(bsiBookPage.getTotalPagesValueText(),totalPages);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isTotalPagesLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isTotalPagesLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.pagesLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void validateDescriptionValueIsCorrect(Object... data){
        String bookTitle = (String) data[0];
        String descriptionValue = (String) data[6];
        initializeClass(bookTitle);
        logger.info("-------------------validateDescriptionValueIsCorrect-----------------------");
        Assert.assertEquals(bsiBookPage.getDescriptionValueText(),descriptionValue);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isDescriptionLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isDescriptionLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.descriptionLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isWebsiteLabelVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isWebsiteLabelVisible-----------------------");
        Assert.assertTrue(bsiBookPage.websiteLabelIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isWebsiteLinkVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isWebsiteLinkVisible-----------------------");
        Assert.assertTrue(bsiBookPage.websiteValueLinkIsVisible());
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","Functional"})
    public void isRedirectHome(Object... data){
        String URL_BOOKS = "Books :";

        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isRedirectHome-----------------------");
        Assert.assertEquals(bsiBookPage.clickOnBackToBookStoreBookButton().getBookStoreUrlText(), URL_BOOKS);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","UI"})
    public void isNotLogOutButtonVisible(Object... data){
        String bookTitle = (String) data[0];
        initializeClass(bookTitle);
        logger.info("-------------------isNotLogOutButtonVisible-----------------------");
        Assert.assertFalse(bsiBookPage.logOutButtonIsVisible());
    }


    @Test(dataProvider = "dataTest",groups = {"Integration","UI","Smoke"})
    public void validateUserNameValue(Object... data) {
        String bookTitle = (String) data[0];
        String userName = (String) data[7];
        String password = (String) data[8];
        initializeClass(bookTitle);
        logger.info("-------------------validateUserNameValue-----------------------");
        bsiBookPage.clickOnLogin().userLogin(userName,password,getDriver());
        bsiBookPage.usernameLabelIsVisible();
        Assert.assertEquals(bsiBookPage.getUsernameValueText(),userName);
    }

    @Test(dataProvider = "dataTest",groups = {"Integration","Functional"})
    public void validateLogOutButtonIsFunctional(Object... data) {
        String bookTitle = (String) data[0];
        String userName = (String) data[7];
        String password = (String) data[8];
        initializeClass(bookTitle);
        logger.info("-------------------validateLogOutButtonIsFunctional-----------------------");
        bsiBookPage.clickOnLogin().userLogin(userName,password,getDriver());
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