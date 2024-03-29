package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlertsPageTest extends TestBase {
    private Logger logger = LogManager.getLogger(AlertsPageTest.class);
    private final String PAGE_TITLE = "Alerts";
    private final String ACCEPT_ALERT_MESSAGE = "You selected Ok";
    private final String DISMISS_ALERT_MESSAGE = "You selected Cancel";
    private final String INPUT_ALERT_MESSAGE = "You entered ";

    @BeforeMethod
    public void initializeClass(){
        logger.info("-------------------Initializing AlertsPageTest Class------------------");
        alertsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnAlerts();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test
    public void validateCorrectPageTitle(){
        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(alertsPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateFirstLabelIsVisible(){
        logger.info("-------------------validateFirstLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isFirstLabelVisible());
    }

    @Test
    public void validateSecondLabelIsVisible(){
        logger.info("-------------------validateSecondLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isSecondLabelVisible());
    }

    @Test
    public void validateThirdLabelIsVisible(){
        logger.info("-------------------validateThirdLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isThirdLabelVisible());
    }

    @Test
    public void validateFourthLabelIsVisible(){
        logger.info("-------------------validateFourthLabelIsVisible-----------------------");
        Assert.assertTrue(alertsPage.isFourthLabelVisible());
    }

    @Test
    public void validateAlert(){
        logger.info("-------------------validateAlert-----------------------");
        alertsPage.clickOnFirstButton();
        alertsPage.confirmAlert();
    }

    @Test
    public void validateAlertAppear(){
        logger.info("-------------------validateAlertAppear-----------------------");
        alertsPage.clickOnSecondButton();
        alertsPage.confirmAlert();
    }

    @Test
    public void validateAcceptAlert(){
        logger.info("-------------------validateAcceptAlert-----------------------");
        alertsPage.clickOnThirdButton();
        alertsPage.confirmAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(),ACCEPT_ALERT_MESSAGE);
    }

    @Test
    public void validateDismissAlert(){
        logger.info("-------------------validateDismissAlert-----------------------");
        alertsPage.clickOnThirdButton();
        alertsPage.cancelAlert();
        Assert.assertEquals(alertsPage.getConfirmResultText(),DISMISS_ALERT_MESSAGE);
    }

    @Test(dataProvider = "testData")
    public void validateInputAlert(Object... data){
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