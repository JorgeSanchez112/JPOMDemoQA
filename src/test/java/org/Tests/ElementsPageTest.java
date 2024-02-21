package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ElementsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        elementsPage = homePage.clickOnSectionElements();
    }

    @Parameters("uRL")
    @Test
    public void validateURL(String uRL){
        Assert.assertEquals(elementsPage.getElementUrlText(),uRL);
    }

    @Parameters("pageTitle")
    @Test
    public void validatePageTitle(String pageTitle){
        Assert.assertEquals(elementsPage.getPageTitleText(),pageTitle);
    }

    @Parameters("elementsSize")
    @Test
    public void validateSizeElements(int elementsSize){
        Assert.assertEquals(elementsPage.deployedElementsSize(),elementsSize);
    }
}
