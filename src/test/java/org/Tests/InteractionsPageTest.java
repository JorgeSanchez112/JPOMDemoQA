package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionsPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(AccordianPageTest.class);
    private final String URL = "https://demoqa.com/interaction";
    private final int ELEMENTS_LIST_SIZE = 5;

    @BeforeMethod
    public void initializeClass(){
        interactionsPage = homePage.clickOnSectionInteractions();
    }

    @Test
    public void validateURL(){
        Assert.assertEquals(interactionsPage.getInteractionsUrlText(),URL);
    }

    @Test
    public void validateSectionsSize(){
        Assert.assertEquals(interactionsPage.getSizeSections(),ELEMENTS_LIST_SIZE);
    }
}
