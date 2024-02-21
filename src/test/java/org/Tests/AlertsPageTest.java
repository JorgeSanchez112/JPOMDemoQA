package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AlertsPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        alertsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnAlerts();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(alertsPage.getPageTitleText(),pageTitle);
    }

    @Test
    public void validateFirstLabelIsVisible(){
        Assert.assertTrue(alertsPage.isFirstLabelVisible());
    }

    @Test
    public void validateSecondLabelIsVisible(){
        Assert.assertTrue(alertsPage.isSecondLabelVisible());
    }

    @Test
    public void validateThirdLabelIsVisible(){
        Assert.assertTrue(alertsPage.isThirdLabelVisible());
    }

    @Test
    public void validateFourthLabelIsVisible(){
        Assert.assertTrue(alertsPage.isFourthLabelVisible());
    }

    @Test
    public void validateAlert(){
        alertsPage.clickOnFirstButton();
        alertsPage.acceptAlert();
    }

    @Test
    public void validateAlertAppear(){
        alertsPage.clickOnSecondButton();
        alertsPage.acceptAlert();
    }

    @Parameters("acceptAlertMessage")
    @Test
    public void validateAcceptAlert(String acceptAlertMessage){
        alertsPage.clickOnThirdButton();
        alertsPage.acceptAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(),acceptAlertMessage);
    }

    @Parameters("dismissAlertMessage")
    @Test
    public void validateDismissAlert(String dismissAlertMessage){
        alertsPage.clickOnThirdButton();
        alertsPage.dismissAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(),dismissAlertMessage);
    }

    @Parameters({"inputAlert","inputAlertMessage"})
    @Test
    public void validateInputAlert(String inputAlert, String inputAlertMessage){
        alertsPage.clickOnFourthButton();
        alertsPage.typeInAlert(inputAlert);
        Assert.assertEquals(alertsPage.getInputAlertText(), inputAlertMessage + inputAlert);
    }
}
