package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BrokenLinksPageTest extends TestBase {
    private final String PAGE_TITLE = "Broken Links - Images";

    @BeforeMethod
    public void initializeClass(){
        brokenLinksPage = homePage.clickOnSectionElements().clickOnBrokenLinksImageSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(brokenLinksPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateImage() throws IOException {
        Assert.assertTrue(brokenLinksPage.isDisplayedValidImage());
    }

    @Test
    public void validateBrokeImage() throws IOException {
        Assert.assertTrue(brokenLinksPage.isDisplayedBrokenImage());
    }

    @Test
    public void validateLink() throws IOException {
        Assert.assertFalse(brokenLinksPage.isAValidLink());
    }

    @Test
    public void validateBrokenLink() throws IOException {
        Assert.assertFalse(brokenLinksPage.isABrokenLink());
    }
}
