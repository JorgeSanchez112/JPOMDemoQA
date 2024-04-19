package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(ElementsPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing ElementsPageTest Class------------------");
        elementsPage = homePage.clickOnSectionElements(getDriver());
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateURL(){
        String URL = "https://demoqa.com/elements";

        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(elementsPage.getElementUrlText(), URL);
    }

    @Test(groups = {"Functional"})
    public void validateSizeElements(){
        int ELEMENTS_SIZE = 9;

        logger.info("-------------------validateSizeElements-----------------------");
        Assert.assertEquals(elementsPage.deployedElementsSize(), ELEMENTS_SIZE);
    }
}
