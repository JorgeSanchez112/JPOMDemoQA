package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ResizablePageTest extends TestBase {
    private final String PAGE_TITLE = "Resizable";

    @BeforeMethod
    public void initializeClass(){
        resizablePage = homePage.clickOnSectionInteractions().clickOnResizable();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(resizablePage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateResizableRestrictedTextIsVisible(){
        Assert.assertTrue(resizablePage.isResizableRestrictedTextVisible());
    }

    @Parameters({"WidthOfBoxRestricted","HeightOfBoxRestricted"})
    @Test
    public void isResizableRestrictedToMax(String WidthOfBoxRestricted, String HeightOfBoxRestricted) {
        System.out.println(WidthOfBoxRestricted + HeightOfBoxRestricted);
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
        System.out.println(WidthOfResizeBox + HeightOfResizeBox);
        resizablePage.resizeFreeBox(Integer.parseInt(WidthOfResizeBox),Integer.parseInt(HeightOfResizeBox));
        Assert.assertEquals(resizablePage.getWidthOfResizeBox(),WidthOfResizeBox + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfResizeBox(),HeightOfResizeBox + prop.getProperty("pxMeasurer"));
    }
}