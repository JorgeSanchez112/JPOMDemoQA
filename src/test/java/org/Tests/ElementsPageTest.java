package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(ElementsPageTest.class);
    private final String URL = "https://demoqa.com/elements";
    private final int ELEMENTS_SIZE = 9;

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing ElementsPageTest Class------------------");
        elementsPage = homePage.clickOnSectionElements();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(elementsPage.getElementUrlText(),URL);
    }

    @Test
    public void validateSizeElements(){
        logger.info("-------------------validateSizeElements-----------------------");
        Assert.assertEquals(elementsPage.deployedElementsSize(),ELEMENTS_SIZE);
    }
}
