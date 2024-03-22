package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertsPageTest extends TestBase {
    private final String PAGE_TITLE = "Alerts";
    private final String ACCEPT_ALERT_MESSAGE = "You selected Ok";
    private final String DISMISS_ALERT_MESSAGE = "You selected Cancel";
    private final String INPUT_ALERT_MESSAGE = "You entered ";

    @BeforeMethod
    public void initializeClass(){
        alertsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnAlerts();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(alertsPage.getPageTitleText(),PAGE_TITLE);
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
        alertsPage.confirmAlert();
    }

    @Test
    public void validateAlertAppear(){
        alertsPage.clickOnSecondButton();
        alertsPage.confirmAlert();
    }

    @Test
    public void validateAcceptAlert(){
        alertsPage.clickOnThirdButton();
        alertsPage.confirmAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(),ACCEPT_ALERT_MESSAGE);
    }

    @Test
    public void validateDismissAlert(){
        alertsPage.clickOnThirdButton();
        alertsPage.cancelAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(),DISMISS_ALERT_MESSAGE);
    }

    @Test(dataProvider = "testData")
    public void validateInputAlert(Object... data){
        String inputAlert = (String) data[0];

        alertsPage.clickOnFourthButton();
        alertsPage.typeInAlert(inputAlert);
        Assert.assertEquals(alertsPage.getInputAlertText(), INPUT_ALERT_MESSAGE + inputAlert);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "alerts";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}