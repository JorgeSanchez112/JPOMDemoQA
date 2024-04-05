package org.Tests;

import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alertsPageFrameWindowsPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(alertsPageFrameWindowsPageTest.class);

    @BeforeMethod(groups = {"Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing AccordianPageTest Class------------------");
        alertsFrameWindowsPage = homePage.clickOnSectionAlerts_Frame_Windows();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = "Functional")
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        String URL = "https://demoqa.com/alertsWindows";
        Assert.assertEquals(alertsFrameWindowsPage.getAlertFrameWindowsUrl(), URL);
    }

    @Test(groups = "Functional")
    public void validateSectionsSize(){
        logger.info("-------------------validateSectionsSize-----------------------");
        int ELEMENTS_LIST_SIZE = 5;
        Assert.assertEquals(alertsFrameWindowsPage.getSizeSections(), ELEMENTS_LIST_SIZE);
    }
}
