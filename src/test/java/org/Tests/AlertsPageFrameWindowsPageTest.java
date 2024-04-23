package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsPageFrameWindowsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(AlertsPageFrameWindowsPageTest.class);

    @BeforeMethod
    public synchronized void initializeClass(){
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
