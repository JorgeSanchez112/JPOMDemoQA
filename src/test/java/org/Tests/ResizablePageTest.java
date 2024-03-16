package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResizablePageTest extends TestBase {
    private final String PAGE_TITLE = "Resizable";
    private final String WIDTH_MAX_OF_RESIZABLE_RESTRICTED = "500";
    private final String HEIGHT_MAX_OF_RESIZABLE_RESTRICTED = "300";

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

    @Test
    public void isResizableRestrictedToMax() {
        resizablePage.resizeBoxRestrictedToMax(Integer.parseInt(WIDTH_MAX_OF_RESIZABLE_RESTRICTED),Integer.parseInt(HEIGHT_MAX_OF_RESIZABLE_RESTRICTED));
        Assert.assertEquals(resizablePage.getWidthOfBoxRestricted(),WIDTH_MAX_OF_RESIZABLE_RESTRICTED + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfBoxRestricted(),HEIGHT_MAX_OF_RESIZABLE_RESTRICTED + prop.getProperty("pxMeasurer"));
    }

    @Test
    public void validateResizableTextIsVisible(){
        Assert.assertTrue(resizablePage.isResizableTextVisible());
    }

    @Test(dataProvider = "testData")
    public void isResizableBox(Object... data) {
        String WidthOfResizeBox = (String) data[0];
        String HeightOfResizeBox = (String) data[1];

        resizablePage.resizeFreeBox(Integer.parseInt(WidthOfResizeBox),Integer.parseInt(HeightOfResizeBox));
        Assert.assertEquals(resizablePage.getWidthOfResizeBox(),WidthOfResizeBox + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfResizeBox(),HeightOfResizeBox + prop.getProperty("pxMeasurer"));
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "resizable";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}