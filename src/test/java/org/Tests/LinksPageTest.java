package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinksPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
       linksPage = homePage.clickOnSectionElements().clickOnLinksSection();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectedTitle(String pageTitle){
        Assert.assertEquals(linksPage.getPageTitleText(),pageTitle);
    }

    @Parameters("uRLHome")
    @Test
    public void validateHomeLink(String uRLHome) {
        Assert.assertEquals(linksPage.getHrefOfHomeLink(),uRLHome);
    }

    @Parameters("uRLHome")
    @Test
    public void validateHomeETgEzLink(String uRLHome) {
        Assert.assertEquals(linksPage.getHrefOfHomeETgEzLink(),uRLHome);
    }

    @Parameters({"hTTPTwoZeroOne","messageTwoZeroOne"})
    @Test
    public void validateCreatedLink(String hTTPTwoZeroOne, String messageTwoZeroOne) {
        linksPage.clickOnCreatedLink();
        Assert.assertEquals(linksPage.getHttpMessage(),hTTPTwoZeroOne);
        Assert.assertEquals(linksPage.getNameLinkMessage(),messageTwoZeroOne);
    }

    @Parameters({"hTTPTwoZeroFour","messageTwoZeroFour"})
    @Test
    public void validateNoContentLink(String hTTPTwoZeroFour, String messageTwoZeroFour) {
        linksPage.clickOnNoContentLink();
        Assert.assertEquals(linksPage.getHttpMessage(),hTTPTwoZeroFour);
        Assert.assertEquals(linksPage.getNameLinkMessage(),messageTwoZeroFour);
    }

    @Parameters({"hTTPThreeZeroOne","messageThreeZeroOne"})
    @Test
    public void validateMovedLink(String hTTPThreeZeroOne, String messageThreeZeroOne) {
        linksPage.clickOnMovedLink();
        Assert.assertEquals(linksPage.getHttpMessage(),hTTPThreeZeroOne);
        Assert.assertEquals(linksPage.getNameLinkMessage(),messageThreeZeroOne);
    }

    @Parameters({"hTTPFourHundred","messageFourHundred"})
    @Test
    public void validateBadRequestLink(String hTTPFourHundred, String messageFourHundred) {
        linksPage.clickOnBadRequestLink();
        Assert.assertEquals(linksPage.getHttpMessage(),hTTPFourHundred);
        Assert.assertEquals(linksPage.getNameLinkMessage(),messageFourHundred);
    }

    @Parameters({"hTTPFourZeroOne","messageFourZeroOne"})
    @Test
    public void validateUnauthorizedLink(String hTTPFourZeroOne, String messageFourZeroOne) {
        linksPage.clickOnUnauthorizedLink();
        Assert.assertEquals(linksPage.getHttpMessage(),hTTPFourZeroOne);
        Assert.assertEquals(linksPage.getNameLinkMessage(),messageFourZeroOne);
    }

    @Parameters({"hTTPFourZeroThree","messageFourZeroThree"})
    @Test
    public void validateForbiddenLink(String hTTPFourZeroThree, String messageFourZeroThree) {
        linksPage.clickOnForbiddenLink();
        Assert.assertEquals(linksPage.getHttpMessage(),hTTPFourZeroThree);
        Assert.assertEquals(linksPage.getNameLinkMessage(),messageFourZeroThree);
    }

    @Parameters({"hTPPFourZeroFour","messageFourZeroFour"})
    @Test
    public void validateNotFoundLink(String hTPPFourZeroFour, String messageFourZeroFour) {
        linksPage.clickOnNotFoundLink();
        Assert.assertEquals(linksPage.getHttpMessage(),hTPPFourZeroFour);
        Assert.assertEquals(linksPage.getNameLinkMessage(),messageFourZeroFour);
    }
}