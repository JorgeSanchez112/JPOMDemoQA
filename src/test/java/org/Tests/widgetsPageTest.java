package org.Tests;

import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class widgetsPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(widgetsPageTest.class);

    @BeforeMethod(groups = {"Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing WidgetsPageTest Class------------------");
        widgetsPage = homePage.clickOnSectionWidgets();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"Functional"})
    public void validateURL(){
        String URL = "https://demoqa.com/widgets";

        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(widgetsPage.getWidgetsUrlText(), URL);
    }

    @Test(groups = {"Functional"})
    public void validateSectionsSize(){
        int ELEMENTS_LIST_SIZE = 9;

        logger.info("-------------------validateSectionsSize-----------------------");
        Assert.assertEquals(widgetsPage.getSizeSections(), ELEMENTS_LIST_SIZE);
    }
}