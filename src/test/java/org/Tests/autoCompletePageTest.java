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

public class autoCompletePageTest extends testBase {
    private final Logger logger = LogManager.getLogger(autoCompletePageTest.class);

    @BeforeMethod(groups = {"UI","Smoke"})
    public void initializeClass(){
        logger.info("-------------------Initializing AutoCompletePageTest Class------------------");
        autoCompletePage = homePage.clickOnSectionWidgets().clickOnAutoComplete();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Auto Complete";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(autoCompletePage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectMultipleContainerLabel(){
        String FIRST_LABEL = "Type multiple color names";

        logger.info("-------------------validateCorrectMultipleContainerLabel-----------------------");
        Assert.assertEquals(autoCompletePage.getMultipleContainerLabelText(), FIRST_LABEL);
    }

    @Test(groups = {"UI"})
    public void validateCorrectSingleContainerLabel(){
        String SECOND_LABEL = "Type single color name";

        logger.info("-------------------validateCorrectSingleContainerLabel-----------------------");
        Assert.assertEquals(autoCompletePage.getSingleContainerLabelText(), SECOND_LABEL);
    }

    @Test(dataProvider = "testData",groups = {"Smoke"})
    public void validateColorNamesInMultipleContainer(Object... data){
        logger.info("-------------------validateColorNamesInMultipleContainer-----------------------");
        String firstColor = (String) data[1];
        String secondColor = (String) data[2];

        autoCompletePage.typeInMultipleContainer(firstColor);
        autoCompletePage.typeInMultipleContainer(secondColor);
        Assert.assertTrue(autoCompletePage.isTheValueContained(firstColor));
        Assert.assertTrue(autoCompletePage.isTheValueContained(secondColor));
    }
    @Test(dataProvider = "testData",groups = {"Smoke"})
    public void validateColorNameInSingleContainer(Object... data){
        logger.info("-------------------validateColorNameInSingleContainer-----------------------");
        autoCompletePage.typeInSingleContainer((String) data[0]);
        Assert.assertEquals(autoCompletePage.getTextOfSingleContainerValue(), (String) data[1]);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "autoComplete";
        logger.info("Accessing to: " + sheetName + " data");
        excelReader excelReader = new excelReader();
        return excelReader.readTestData(sheetName);
    }
}
