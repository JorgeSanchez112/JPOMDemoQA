package org.Tests;

import TestComponents.utilities.dataDriven.ExcelReader;
import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResizablePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(ResizablePageTest.class);
    private final String PX_MEASURER = "px";

    @BeforeMethod(groups = {"UI","Functional"})
    public synchronized void initializeClass(){
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
        Assert.assertEquals(resizablePage.getWidthOfBoxRestricted(), WIDTH_MAX_OF_RESIZABLE_RESTRICTED + PX_MEASURER);
        Assert.assertEquals(resizablePage.getHeightOfBoxRestricted(), HEIGHT_MAX_OF_RESIZABLE_RESTRICTED + PX_MEASURER);
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
        Assert.assertEquals(resizablePage.getWidthOfResizeBox(),WidthOfResizeBox + PX_MEASURER);
        Assert.assertEquals(resizablePage.getHeightOfResizeBox(),HeightOfResizeBox + PX_MEASURER);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "resizable";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}