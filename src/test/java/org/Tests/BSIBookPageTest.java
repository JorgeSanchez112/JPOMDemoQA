package org.Tests;

import TestComponents.TestBase;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BSIBookPageTest extends TestBase {

    @Parameters("bookTitle")
    @BeforeMethod
    public void initializeClass(String bookTitle){
        try{
            bsiBookPage = homePage.clickOnSectionBookStoreApplication().searchAndClickOnATitle(bookTitle);
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(bsiBookPage.getPageTitleText(),pageTitle);
    }

    @Test
    public void isUsernameLabelVisible(){
        Assert.assertFalse(bsiBookPage.usernameLabelIsVisible());
    }

    @Parameters("uRLLogin")
    @Test
    public void validateLoginButton(String uRLLogin){
        Assert.assertEquals(bsiBookPage.clickOnLogin().getCurrentUrl(),uRLLogin);
    }

    @Parameters("isbnValue")
    @Test
    public void validateIsbnValueIsCorrect(String isbnValue){
        Assert.assertEquals(bsiBookPage.getIsbnValueText(),isbnValue);
    }

    @Test
    public void isIsbnLabelVisible(){
        Assert.assertTrue(bsiBookPage.isbnLabelIsVisible());
    }

    @Parameters("bookTitle")
    @Test
    public void validateTitleValueIsCorrect(String bookTitle){
        Assert.assertEquals(bsiBookPage.getTitleValueText(),bookTitle);
    }

    @Test
    public void isTitleLabelVisible(){
        Assert.assertTrue(bsiBookPage.titleLabelIsVisible());
    }

    @Parameters("subTitleValue")
    @Test
    public void validateSubtitleValueIsCorrect(String subTitleValue){
        Assert.assertEquals(bsiBookPage.getSubTitleValueText(),subTitleValue);
    }

    @Test
    public void isSubTitleLabelVisible(){
        Assert.assertTrue(bsiBookPage.subtitleLabelIsVisible());
    }

    @Parameters("authorValue")
    @Test
    public void ValidateAuthorValueIsCorrect(String authorValue){
        Assert.assertEquals(bsiBookPage.getAuthorValueText(),authorValue);
    }

    @Test
    public void isAuthorLabelVisible(){
        Assert.assertTrue(bsiBookPage.authorLabelIsVisible());
    }

    @Parameters("publisherValue")
    @Test
    public void validatePublisherValueIsCorrect(String publisherValue){
        Assert.assertEquals(bsiBookPage.getPublisherValueText(),publisherValue);
    }

    @Test
    public void isPublisherLabelVisible(){
        Assert.assertTrue(bsiBookPage.publisherLabelIsVisible());
    }

    @Parameters("totalPages")
    @Test
    public void validateTotalPageValueIsCorrect(String totalPages){
        Assert.assertEquals(bsiBookPage.getTotalPagesValueText(),totalPages);
    }

    @Test
    public void isTotalPagesLabelVisible(){
        Assert.assertTrue(bsiBookPage.pagesLabelIsVisible());
    }

    @Parameters("descriptionValue")
    @Test
    public void validateDescriptionValueIsCorrect(String descriptionValue){
        Assert.assertEquals(bsiBookPage.getDescriptionValueText(),descriptionValue);
    }

    @Test
    public void isDescriptionLabelVisible(){
        Assert.assertTrue(bsiBookPage.descriptionLabelIsVisible());
    }

    @Test
    public void isWebsiteLabelVisible(){
        Assert.assertTrue(bsiBookPage.websiteLabelIsVisible());
    }

    @Test
    public void isWebsiteLinkVisible(){
        Assert.assertTrue(bsiBookPage.websiteValueLinkIsVisible());
    }

    @Parameters("uRLBooks")
    @Test
    public void isRedirectHome(String uRLBooks){
        Assert.assertEquals(bsiBookPage.clickOnBackToBookStoreBookButton().getBookStoreUrlText(),uRLBooks);
    }

    @Test
    public void isNotLogOutButtonVisible(){
        Assert.assertFalse(bsiBookPage.logOutButtonIsVisible());
    }

    @Parameters({"userName","password"})
    @Test
    public void validateUserNameValue(String userName, String password) throws InterruptedException {
        bsiBookPage.clickOnLogin().userLogin(userName,password);
        Assert.assertEquals(bsiBookPage.getUsernameValueText(),userName);
    }

    @Parameters({"userName","password","uRLLogin"})
    @Test
    public void validateLogOutButtonIsFunctional(String userName, String password, String uRLLogin) throws InterruptedException {
        bsiBookPage.clickOnLogin().userLogin(userName,password);
        Assert.assertEquals(bsiBookPage.clickOnLogOutButton().getCurrentUrl(),uRLLogin);
    }

}
