package org.Tests;

import testComponents.dataDriven.excelReader;
import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class resizablePageTest extends testBase {
    private final Logger logger = LogManager.getLogger(resizablePageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing ResizablePageTest Class------------------");
        resizablePage = homePage.clickOnSectionInteractions().clickOnResizable();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Resizable";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(resizablePage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateResizableRestrictedTextIsVisible(){
        logger.info("-------------------validateResizableRestrictedTextIsVisible-----------------------");
        Assert.assertTrue(resizablePage.isResizableRestrictedTextVisible());
    }

    @Test(groups = {"Functional"})
    public void isResizableRestrictedToMax() {
        String WIDTH_MAX_OF_RESIZABLE_RESTRICTED = "500";
        String HEIGHT_MAX_OF_RESIZABLE_RESTRICTED = "300";

        logger.info("-------------------isResizableRestrictedToMax-----------------------");
        resizablePage.resizeBoxRestrictedToMax(Integer.parseInt(WIDTH_MAX_OF_RESIZABLE_RESTRICTED),Integer.parseInt(HEIGHT_MAX_OF_RESIZABLE_RESTRICTED));
        Assert.assertEquals(resizablePage.getWidthOfBoxRestricted(), WIDTH_MAX_OF_RESIZABLE_RESTRICTED + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfBoxRestricted(), HEIGHT_MAX_OF_RESIZABLE_RESTRICTED + prop.getProperty("pxMeasurer"));
    }

    @Test(groups = {"Functional"})
    public void validateResizableTextIsVisible(){
        logger.info("-------------------validateResizableTextIsVisible-----------------------");
        Assert.assertTrue(resizablePage.isResizableTextVisible());
    }

    @Test(dataProvider = "testData",groups = {"Functional"})
    public void isResizableBox(Object... data) {
        logger.info("-------------------isResizableBox-----------------------");
        String WidthOfResizeBox = (String) data[0];
        String HeightOfResizeBox = (String) data[1];

        resizablePage.resizeFreeBox(Integer.parseInt(WidthOfResizeBox),Integer.parseInt(HeightOfResizeBox));
        Assert.assertEquals(resizablePage.getWidthOfResizeBox(),WidthOfResizeBox + prop.getProperty("pxMeasurer"));
        Assert.assertEquals(resizablePage.getHeightOfResizeBox(),HeightOfResizeBox + prop.getProperty("pxMeasurer"));
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "resizable";
        logger.info("Accessing to: " + sheetName + " data");
        excelReader excelReader = new excelReader();
        return excelReader.readTestData(sheetName);
    }
}