package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(FormsPageTest.class);

    @BeforeMethod(groups = {"UI"})
    public void initializeClass(){
        logger.info("-------------------Initializing FormsPageTest Class------------------");
        formsPage = homePage.clickOnSectionForms();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateURL(){
        String URL = "https://demoqa.com/forms";

        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(formsPage.getFormsUrlText(), URL);
    }

    @Test(groups = {"UI"})
    public void validateCorrectMenuListText(){
        String MENU_LIST_TEXT = "Practice Form";

        logger.info("-------------------validateCorrectMenuListText-----------------------");
        Assert.assertEquals(formsPage.getMenuListText(), MENU_LIST_TEXT);
    }
}
