package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FormsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        formsPage = homePage.clickOnSectionForms();
    }

    @Parameters("uRL")
    @Test
    public void validateURL(String uRL){
        Assert.assertEquals(formsPage.getFormsUrlText(),uRL);
    }

    @Parameters("menuListText")
    @Test
    public void validateCorrectMenuListVisible(String menuListText){
        Assert.assertEquals(formsPage.getMenuListText(),menuListText);
    }

}
