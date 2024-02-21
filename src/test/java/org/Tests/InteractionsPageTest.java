package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InteractionsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        interactionsPage = homePage.clickOnSectionInteractions();
    }

    @Parameters("uRL")
    @Test
    public void validateURL(String uRL){
        Assert.assertEquals(interactionsPage.getInteractionsUrlText(),uRL);
    }

    @Parameters("elementsSize")
    @Test
    public void validateSectionsSize(int elementsSize){
        Assert.assertEquals(interactionsPage.getSizeSections(),elementsSize);
    }
}
