package org.Tests;

import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsPageFrameWindowsPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(AlertsPageFrameWindowsPageTest.class);
    private final String URL = "https://demoqa.com/alertsWindows";
    private final int ELEMENTS_LIST_SIZE = 5;

    @BeforeMethod(groups = {"Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing AccordianPageTest Class------------------");
        alertsFrameWindowsPage = homePage.clickOnSectionAlerts_Frame_Windows();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = "Functional")
    public void validateURL(){
        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(alertsFrameWindowsPage.getAlertFrameWindowsUrl(),URL);
    }

    @Test(groups = "Functional")
    public void validateSectionsSize(){
        logger.info("-------------------validateSectionsSize-----------------------");
        Assert.assertEquals(alertsFrameWindowsPage.getSizeSections(),ELEMENTS_LIST_SIZE);
    }
}
