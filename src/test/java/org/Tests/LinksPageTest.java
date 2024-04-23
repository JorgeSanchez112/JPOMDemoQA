package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LinksPageTest extends TestBase {
    Logger logger = LogManager.getLogger(LinksPageTest.class);
    private final String URL_HOME = "https://demoqa.com/";

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing LinksPageTest Class------------------");
        linksPage = homePage.clickOnSectionElements().clickOnLinksSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectedTitle(){
        String PAGE_TITLE = "Links";
        String title = linksPage.getPageTitleText();

        logger.info("-------------------ValidateCorrectedTitle-----------------------");
        logger.info("Title is: " + title);
        Assert.assertEquals(title, PAGE_TITLE);
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
        String HTTP_201 = "201";

        logger.info("-------------------validateCreatedLinkHTTPMessage-----------------------");
        linksPage.clickOnCreatedLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage, HTTP_201);

    }

    @Test(groups = {"Smoke"})
    public void validateCreatedLinkMessage(){
        String MESSAGE_201 = "Created";

        logger.info("-------------------validateCreatedLinkMessage-----------------------");
        linksPage.clickOnCreatedLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("message is: " + message);
        Assert.assertEquals(message, MESSAGE_201);
    }

    @Test(groups = {"Smoke"})
    public void validateNoContentLinkHTTPMessage() {
        String HTTP_204 = "204";

        logger.info("-------------------validateNoContentLinkHTTPMessage-----------------------");
        linksPage.clickOnNoContentLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage, HTTP_204);
    }

    @Test(groups = {"Smoke"})
    public void validateNoContentLinkMessage(){
        String MESSAGE_204 = "No Content";

        logger.info("-------------------validateNoContentLinkMessage-----------------------");
        linksPage.clickOnNoContentLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message, MESSAGE_204);
    }

    @Test(groups = {"Smoke"})
    public void validateMovedLinkHTTPMessage() {
        String HTTP_301 = "301";

        logger.info("-------------------validateMovedLinkHTTPMessage-----------------------");
        linksPage.clickOnMovedLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage, HTTP_301);
    }

    @Test(groups = {"Smoke"})
    public void validateMovedLinkMessage(){
        String MESSAGE_301 = "Moved Permanently";

        logger.info("-------------------validateMovedLinkMessage-----------------------");
        linksPage.clickOnMovedLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message, MESSAGE_301);
    }

    @Test(groups = {"Smoke"})
    public void validateBadRequestLinkHTTPMessage() {
        String HTTP_400 = "400";

        logger.info("-------------------validateCreatedLinkMessage-----------------------");
        linksPage.clickOnBadRequestLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage, HTTP_400);
    }

    @Test(groups = {"Smoke"})
    public void validateBadRequestLinkMessage(){
        String MESSAGE_400 = "Bad Request";

        logger.info("-------------------validateCreatedLinkMessage-----------------------");
        linksPage.clickOnBadRequestLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message, MESSAGE_400);
    }

    @Test(groups = {"Smoke"})
    public void validateUnauthorizedLinkHTTPMessage() {
        String HTTP_401 = "401";

        logger.info("-------------------validateUnauthorizedLinkHTTPMessage-----------------------");
        linksPage.clickOnUnauthorizedLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage, HTTP_401);
    }

    @Test(groups = {"Smoke"})
    public void validateUnauthorizedLinkMessage(){
        String MESSAGE_401 = "Unauthorized";

        logger.info("-------------------validateUnauthorizedLinkMessage-----------------------");
        linksPage.clickOnUnauthorizedLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message, MESSAGE_401);
    }

    @Test(groups = {"Smoke"})
    public void validateForbiddenLinkHTTPMessage() {
        String HTTP_403 = "403";

        logger.info("-------------------validateForbiddenLinkHTTPMessage-----------------------");
        linksPage.clickOnForbiddenLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage, HTTP_403);
    }

    @Test(groups = {"Smoke"})
    public void validateForbiddenLinkMessage(){
        String MESSAGE_403 = "Forbidden";

        logger.info("-------------------validateForbiddenLinkMessage-----------------------");
        linksPage.clickOnForbiddenLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message, MESSAGE_403);
    }

    @Test(groups = {"Smoke"})
    public void validateNotFoundLinkHTTPMessage() {
        String HTTP_404 = "404";

        logger.info("-------------------validateNotFoundLinkHTTPMessage-----------------------");
        linksPage.clickOnNotFoundLink();
        String hTTPMessage = linksPage.getHttpMessage();
        logger.info("HTTP message is: " + hTTPMessage);
        Assert.assertEquals(hTTPMessage, HTTP_404);
    }

    @Test(groups = {"Smoke"})
    public void validateNotFoundLinkMessage(){
        String MESSAGE_404 = "Not Found";

        logger.info("-------------------validateNotFoundLinkMessage-----------------------");
        linksPage.clickOnNotFoundLink();
        String message = linksPage.getNameLinkMessage();
        logger.info("Message is: " + message);
        Assert.assertEquals(message, MESSAGE_404);
    }
}