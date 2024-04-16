package org.Tests;

import TestComponents.config.TestBase;
import TestComponents.utilities.dataDriven.ExcelReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(AlertsPageTest.class);

    @BeforeMethod(groups = {"UI","Smoke","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing AlertsPageTest Class------------------");
        alertsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnAlerts();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"Functional"})
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        String PAGE_TITLE = "Alerts";
        Assert.assertEquals(alertsPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateFirstLabelIsVisible(){
        logger.info("-------------------validateFirstLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isFirstLabelVisible());
    }

    @Test(groups = {"UI"})
    public void validateSecondLabelIsVisible(){
        logger.info("-------------------validateSecondLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isSecondLabelVisible());
    }

    @Test(groups = {"UI"})
    public void validateThirdLabelIsVisible(){
        logger.info("-------------------validateThirdLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isThirdLabelVisible());
    }

    @Test(groups = {"UI"})
    public void validateFourthLabelIsVisible(){
        logger.info("-------------------validateFourthLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isFourthLabelVisible());
    }

    @Test(groups = {"Functional"})
    public void validateAlert(){
        logger.info("-------------------validateAlert-----------------------");
        alertsPage.clickOnFirstButton();
        alertsPage.confirmAlert();
    }

    @Test(groups = {"Functional"})
    public void validateAlertAppear(){
        logger.info("-------------------validateAlertAppear-----------------------");
        alertsPage.clickOnSecondButton();
        alertsPage.confirmAlert();
    }

    @Test(groups = {"Functional"})
    public void validateAcceptAlert(){
        String ACCEPT_ALERT_MESSAGE = "You selected Ok";

        logger.info("-------------------validateAcceptAlert-----------------------");
        alertsPage.clickOnThirdButton();
        alertsPage.confirmAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(), ACCEPT_ALERT_MESSAGE);
    }

    @Test(groups = {"Functional"})
    public void validateDismissAlert(){
        String DISMISS_ALERT_MESSAGE = "You selected Cancel";

        logger.info("-------------------validateDismissAlert-----------------------");
        alertsPage.clickOnThirdButton();
        alertsPage.cancelAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(), DISMISS_ALERT_MESSAGE);
    }

    @Test(dataProvider = "testData",groups = {"Smoke","Functional"})
    public void validateInputAlert(Object... data){
        String INPUT_ALERT_MESSAGE = "You entered ";

        logger.info("-------------------validateInputAlert-----------------------");
        String inputAlert = (String) data[0];

        alertsPage.clickOnFourthButton();
        alertsPage.typeInAlert(inputAlert);
        Assert.assertEquals(alertsPage.getInputAlertText(), INPUT_ALERT_MESSAGE + inputAlert);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "alerts";
        logger.info("Accessing to: " + sheetName + " data");
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}