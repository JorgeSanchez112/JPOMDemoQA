package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(InteractionsPageTest.class);

    @BeforeMethod(groups = {"Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing FramesPageTest Class------------------");
        interactionsPage = homePage.clickOnSectionInteractions();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"Functional"})
    public void validateURL(){
        String URL = "https://demoqa.com/interaction";

        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(interactionsPage.getInteractionsUrlText(), URL);
    }

    @Test(groups = {"Functional"})
    public void validateSectionsSize(){
        int ELEMENTS_LIST_SIZE = 5;
        
        logger.info("-------------------validateSizeElements-----------------------");
        Assert.assertEquals(interactionsPage.getSizeSections(), ELEMENTS_LIST_SIZE);
    }
}
