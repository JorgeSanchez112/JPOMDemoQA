package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsPageFrameWindowsPageTest extends TestBase {
    private final String URL = "https://demoqa.com/alertsWindows";
    private final int ELEMENTS_LIST_SIZE = 5;

    @BeforeMethod
    public void initializeClass(){
        alertsFrameWindowsPage = homePage.clickOnSectionAlerts_Frame_Windows();
    }

    @Test
    public void validateURL(){
        Assert.assertEquals(alertsFrameWindowsPage.getAlertFrameWindowsUrl(),URL);
    }

    @Test
    public void validateSectionsSize(){
        Assert.assertEquals(alertsFrameWindowsPage.getSizeSections(),ELEMENTS_LIST_SIZE);
    }
}
