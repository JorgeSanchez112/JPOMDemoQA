package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LinksPageTest extends TestBase {
    Logger logger = LogManager.getLogger(LinksPageTest.class);
    private final String PAGE_TITLE = "Links";
    private final String URL_HOME = "https://demoqa.com/";
    private final String HTTP_201 = "201";
    private final String HTTP_204 = "204";
    private final String HTTP_301 = "301";
    private final String HTTP_400 = "400";
    private final String HTTP_401 = "401";
    private final String HTTP_403 = "403";
    private final String HTTP_404 = "404";
    private final String MESSAGE_201 = "Created";
    private final String MESSAGE_204 = "No Content";
    private final String MESSAGE_301 = "Moved Permanently";
    private final String MESSAGE_400 = "Bad Request";
    private final String MESSAGE_401 = "Unauthorized";
    private final String MESSAGE_403 = "Forbidden";
    private final String MESSAGE_404 = "Not Found";

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing LinksPageTest Class------------------");
        linksPage = homePage.clickOnSectionElements().clickOnLinksSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectedTitle(){
        logger.info("-------------------ValidateCorrectedTitle-----------------------");
        String title = linksPage.getPageTitleText();
        logger.info("Title is: " + title);
        Assert.assertEquals(title,PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateHomeLink() {
        logger.info("-------------------ValidateHomeLink-----------------------");
        String homeLink = linksPage.getHrefOfHomeLink();
        logger.info("home Link is: " + homeLink);
        Assert.assertEquals(homeLink,URL_HOME);
    }

    @Test(groups = {"Functional"})
    public void validateHomeETgEzLink() {
        logger.info("-------------------ValidateHomeETgEzLink-----------------------");
        String homeETgEzLink = linksPage.getHrefOfHomeETgEzLink();
        logger.info("home ETgEz Link is: " + homeETgEzLink);
        Assert.assertEquals(homeETgEzLink,URL_HOME);
    }

    @Test(groups = {"Functional"})
    public void validateCreatedLinkHTTPMessage(){
        logger.info("-------------------validateCreatedLinkHTTPMessage-----------------------");
        linksPage.clickOnCreatedLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage,HTTP_201);

    }

    @Test(groups = {"Smoke"})
    public void validateCreatedLinkMessage(){
        logger.info("-------------------validateCreatedLinkMessage-----------------------");
        linksPage.clickOnCreatedLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("message is: " + message);
        Assert.assertEquals(message,MESSAGE_201);
    }

    @Test(groups = {"Smoke"})
    public void validateNoContentLinkHTTPMessage() {
        logger.info("-------------------validateNoContentLinkHTTPMessage-----------------------");
        linksPage.clickOnNoContentLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage,HTTP_204);
    }

    @Test(groups = {"Smoke"})
    public void validateNoContentLinkMessage(){
        logger.info("-------------------validateNoContentLinkMessage-----------------------");
        linksPage.clickOnNoContentLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message,MESSAGE_204);
    }

    @Test(groups = {"Smoke"})
    public void validateMovedLinkHTTPMessage() {
        logger.info("-------------------validateMovedLinkHTTPMessage-----------------------");
        linksPage.clickOnMovedLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage,HTTP_301);
    }

    @Test(groups = {"Smoke"})
    public void validateMovedLinkMessage(){
        logger.info("-------------------validateMovedLinkMessage-----------------------");
        linksPage.clickOnMovedLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message,MESSAGE_301);
    }

    @Test(groups = {"Smoke"})
    public void validateBadRequestLinkHTTPMessage() {
        logger.info("-------------------validateCreatedLinkMessage-----------------------");
        linksPage.clickOnBadRequestLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage,HTTP_400);
    }

    @Test(groups = {"Smoke"})
    public void validateBadRequestLinkMessage(){
        logger.info("-------------------validateCreatedLinkMessage-----------------------");
        linksPage.clickOnBadRequestLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message,MESSAGE_400);
    }

    @Test(groups = {"Smoke"})
    public void validateUnauthorizedLinkHTTPMessage() {
        logger.info("-------------------validateUnauthorizedLinkHTTPMessage-----------------------");
        linksPage.clickOnUnauthorizedLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage,HTTP_401);
    }

    @Test(groups = {"Smoke"})
    public void validateUnauthorizedLinkMessage(){
        logger.info("-------------------validateUnauthorizedLinkMessage-----------------------");
        linksPage.clickOnUnauthorizedLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message,MESSAGE_401);
    }

    @Test(groups = {"Smoke"})
    public void validateForbiddenLinkHTTPMessage() {
        logger.info("-------------------validateForbiddenLinkHTTPMessage-----------------------");
        linksPage.clickOnForbiddenLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage,HTTP_403);
    }

    @Test(groups = {"Smoke"})
    public void validateForbiddenLinkMessage(){
        logger.info("-------------------validateForbiddenLinkMessage-----------------------");
        linksPage.clickOnForbiddenLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message,MESSAGE_403);
    }

    @Test(groups = {"Smoke"})
    public void validateNotFoundLinkHTTPMessage() {
        logger.info("-------------------validateNotFoundLinkHTTPMessage-----------------------");
        linksPage.clickOnNotFoundLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage,HTTP_404);
    }

    @Test(groups = {"Smoke"})
    public void validateNotFoundLinkMessage(){
        logger.info("-------------------validateNotFoundLinkMessage-----------------------");
        linksPage.clickOnNotFoundLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message,MESSAGE_404);
    }
}