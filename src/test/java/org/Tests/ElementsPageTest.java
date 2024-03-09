package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ElementsPageTest extends TestBase {
    private final String URL = "https://demoqa.com/elements";
    private final int ELEMENTS_SIZE = 9;

    @BeforeMethod
    public void initializeClass(){
        elementsPage = homePage.clickOnSectionElements();
    }

    @Test
    public void validateURL(){
        Assert.assertEquals(elementsPage.getElementUrlText(),URL);
    }

    @Test
    public void validateSizeElements(){
        Assert.assertEquals(elementsPage.deployedElementsSize(),ELEMENTS_SIZE);
    }
}
