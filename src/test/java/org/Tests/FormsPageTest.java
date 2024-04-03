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

    @BeforeMethod(groups = {"UI"})
    public void initializeClass(){
        logger.info("-------------------Initializing FormsPageTest Class------------------");
        formsPage = homePage.clickOnSectionForms();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(formsPage.getFormsUrlText(),URL);
    }

    @Test(groups = {"UI"})
    public void validateCorrectMenuListText(){
        logger.info("-------------------validateCorrectMenuListText-----------------------");
        Assert.assertEquals(formsPage.getMenuListText(),MENU_LIST_TEXT);
    }
}
