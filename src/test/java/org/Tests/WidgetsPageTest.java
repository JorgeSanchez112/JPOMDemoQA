package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetsPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(WidgetsPageTest.class);
    private final String URL = "https://demoqa.com/widgets";
    private final int ELEMENTS_LIST_SIZE = 9;

    @BeforeMethod(groups = {"UI","Smoke","Integration"})
    public void initializeClass(){
        logger.info("-------------------Initializing WidgetsPageTest Class------------------");
        widgetsPage = homePage.clickOnSectionWidgets();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(widgetsPage.getWidgetsUrlText(),URL);
    }

    @Test
    public void validateSectionsSize(){
        logger.info("-------------------validateSectionsSize-----------------------");
        Assert.assertEquals(widgetsPage.getSizeSections(),ELEMENTS_LIST_SIZE);
    }
}