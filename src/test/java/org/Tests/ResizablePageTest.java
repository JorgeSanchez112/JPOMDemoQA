package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ResizablePageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        resizablePage = homePage.clickOnSectionInteractions().clickOnResizable();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(resizablePage.getPageTitleText(),pageTitle);
    }

    @Test
    public void validateResizableRestrictedTextIsVisible(){
        Assert.assertTrue(resizablePage.isResizableRestrictedTextVisible());
    }

    @Parameters({"WidthOfBoxRestricted","HeightOfBoxRestricted"})
    @Test
    public void isResizableRestrictedToMax(String WidthOfBoxRestricted, String HeightOfBoxRestricted) {
        resizablePage.resizeBoxRestrictedToMax(Integer.parseInt(WidthOfBoxRestricted),Integer.parseInt(HeightOfBoxRestricted));
        Assert.assertEquals(resizablePage.getWidthOfBoxRestricted(),WidthOfBoxRestricted + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfBoxRestricted(),HeightOfBoxRestricted + prop.getProperty("pxMeasurer"));
    }

    @Test
    public void validateResizableTextIsVisible(){
        Assert.assertTrue(resizablePage.isResizableTextVisible());
    }

    @Parameters({"WidthOfResizeBox","HeightOfResizeBox"})
    @Test
    public void isResizableBoxTo500px(String WidthOfResizeBox, String HeightOfResizeBox) {
        resizablePage.resizeFreeBox(Integer.parseInt(WidthOfResizeBox),Integer.parseInt(HeightOfResizeBox));
        Assert.assertEquals(resizablePage.getWidthOfResizeBox(),WidthOfResizeBox + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfResizeBox(),HeightOfResizeBox + prop.getProperty("pxMeasurer"));
    }
}