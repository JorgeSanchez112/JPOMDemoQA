package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsPageTest extends TestBase {
    private final String URL = "https://demoqa.com/forms";
    private final String MENU_LIST_TEXT = "Practice Form";

    @BeforeMethod
    public void initializeClass(){
        formsPage = homePage.clickOnSectionForms();
    }

    @Test
    public void validateURL(){
        Assert.assertEquals(formsPage.getFormsUrlText(),URL);
    }

    @Test
    public void validateCorrectMenuListText(){
        Assert.assertEquals(formsPage.getMenuListText(),MENU_LIST_TEXT);
    }
}
