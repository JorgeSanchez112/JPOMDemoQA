package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AlertsPageFrameWindowsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        alertsFrameWindowsPage = homePage.clickOnSectionAlerts_Frame_Windows();
    }

    @Parameters("uRl")
    @Test
    public void validateURL(String uRL){
        Assert.assertEquals(alertsFrameWindowsPage.getAlertFrameWindowsUrl(),uRL);
    }

    @Parameters("elementsSize")
    @Test
    public void validateSectionsSize(int elementsSize){
        Assert.assertEquals(alertsFrameWindowsPage.getSizeSections(),elementsSize);
    }
}
