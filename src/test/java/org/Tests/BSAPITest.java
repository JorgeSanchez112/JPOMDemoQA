package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BSAPITest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        bsapiPage = homePage.clickOnSectionBookStoreApplication().clickOnBookstoreApi();
    }

    @Test
    public void isBookStoreAPITitleVisible(){
        Assert.assertTrue(bsapiPage.isTitleVisible());
    }

    @Test
    public void isAccountSubtitleVisible(){
        Assert.assertTrue(bsapiPage.isAccountSubtitleVisible());
    }

    @Test
    public void isBookstoreSubtitleVisible(){
        Assert.assertTrue(bsapiPage.isBookstoreSubtitleVisible());
    }
}
