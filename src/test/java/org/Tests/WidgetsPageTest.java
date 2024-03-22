package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WidgetsPageTest extends TestBase {
    private final String URL = "https://demoqa.com/widgets";
    private final int ELEMENTS_LIST_SIZE = 9;

    @BeforeMethod
    public void initializeClass(){
        widgetsPage = homePage.clickOnSectionWidgets();
    }

    @Test
    public void validateURL(){
        Assert.assertEquals(widgetsPage.getWidgetsUrlText(),URL);
    }

    @Test
    public void validateSectionsSize(){
        Assert.assertEquals(widgetsPage.getSizeSections(),ELEMENTS_LIST_SIZE);
    }
}