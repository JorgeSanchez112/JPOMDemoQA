package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WidgetsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        widgetsPage = homePage.clickOnSectionWidgets();
    }

    @Parameters("uRL")
    @Test
    public void validateURL(String uRL){
        Assert.assertEquals(widgetsPage.getWidgetsUrlText(),uRL);
    }

    @Parameters("elementsSize")
    @Test
    public void validateSectionsSize(int elementsSize){
        Assert.assertEquals(widgetsPage.getSizeSections(),elementsSize);
    }
}
