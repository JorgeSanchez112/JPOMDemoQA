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

    @Parameters({"WeightOfBoxRestricted","HeightOfBoxRestricted"})
    @Test
    public void isResizableRestrictedToMax(String WeightOfBoxRestricted, String HeightOfBoxRestricted) throws InterruptedException {
        resizablePage.resizeBoxRestrictedToMax((Integer.parseInt(WeightOfBoxRestricted) - 200),(Integer.parseInt(HeightOfBoxRestricted) - 200));
        Assert.assertEquals(resizablePage.getWeightOfBoxRestricted(),WeightOfBoxRestricted + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfBoxRestricted(),HeightOfBoxRestricted + prop.getProperty("pxMeasurer"));
    }

    @Test
    public void validateResizableTextIsVisible(){
        Assert.assertTrue(resizablePage.isResizableTextVisible());
    }

    @Parameters({"WeightOfResizeBox","HeightOfResizeBox"})
    @Test
    public void isResizableBoxTo500px(String WeightOfResizeBox, String HeightOfResizeBox) throws InterruptedException {
        resizablePage.resizeBoxTo500((Integer.parseInt(WeightOfResizeBox) - 200),(Integer.parseInt(HeightOfResizeBox) - 200));
        Assert.assertEquals(resizablePage.getWeightOfResizeBox(),WeightOfResizeBox + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfResizeBox(),HeightOfResizeBox + prop.getProperty("pxMeasurer"));
    }
}