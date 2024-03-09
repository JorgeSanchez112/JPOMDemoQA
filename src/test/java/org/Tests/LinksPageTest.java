package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinksPageTest extends TestBase {
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

    @BeforeMethod
    public void initializeClass(){
       linksPage = homePage.clickOnSectionElements().clickOnLinksSection();
    }

    @Test
    public void validateCorrectedTitle(){
        Assert.assertEquals(linksPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateHomeLink() {
        Assert.assertEquals(linksPage.getHrefOfHomeLink(),URL_HOME);
    }

    @Test
    public void validateHomeETgEzLink() {
        Assert.assertEquals(linksPage.getHrefOfHomeETgEzLink(),URL_HOME);
    }

    @Test
    public void validateCreatedLink() {
        linksPage.clickOnCreatedLink();
        Assert.assertEquals(linksPage.getHttpMessage(),HTTP_201);
        Assert.assertEquals(linksPage.getNameLinkMessage(),MESSAGE_201);
    }

    @Test
    public void validateNoContentLink() {
        linksPage.clickOnNoContentLink();
        Assert.assertEquals(linksPage.getHttpMessage(),HTTP_204);
        Assert.assertEquals(linksPage.getNameLinkMessage(),MESSAGE_204);
    }

    @Test
    public void validateMovedLink() {
        linksPage.clickOnMovedLink();
        Assert.assertEquals(linksPage.getHttpMessage(),HTTP_301);
        Assert.assertEquals(linksPage.getNameLinkMessage(),MESSAGE_301);
    }

    @Test
    public void validateBadRequestLink() {
        linksPage.clickOnBadRequestLink();
        Assert.assertEquals(linksPage.getHttpMessage(),HTTP_400);
        Assert.assertEquals(linksPage.getNameLinkMessage(),MESSAGE_400);
    }

    @Test
    public void validateUnauthorizedLink() {
        linksPage.clickOnUnauthorizedLink();
        Assert.assertEquals(linksPage.getHttpMessage(),HTTP_401);
        Assert.assertEquals(linksPage.getNameLinkMessage(),MESSAGE_401);
    }

    @Test
    public void validateForbiddenLink() {
        linksPage.clickOnForbiddenLink();
        Assert.assertEquals(linksPage.getHttpMessage(),HTTP_403);
        Assert.assertEquals(linksPage.getNameLinkMessage(),MESSAGE_403);
    }

    @Test
    public void validateNotFoundLink() {
        linksPage.clickOnNotFoundLink();
        Assert.assertEquals(linksPage.getHttpMessage(),HTTP_404);
        Assert.assertEquals(linksPage.getNameLinkMessage(),MESSAGE_404);
    }
}