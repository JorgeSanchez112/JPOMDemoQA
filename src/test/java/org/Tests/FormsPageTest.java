package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(FormsPageTest.class);
    private final String URL = "https://demoqa.com/forms";
    private final String MENU_LIST_TEXT = "Practice Form";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing FormsPageTest Class------------------");
        formsPage = homePage.clickOnSectionForms();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(formsPage.getFormsUrlText(),URL);
    }

    @Test
    public void validateCorrectMenuListText(){
        logger.info("-------------------validateCorrectMenuListText-----------------------");
        Assert.assertEquals(formsPage.getMenuListText(),MENU_LIST_TEXT);
    }
}
