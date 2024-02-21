package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProgressBarPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        progressBarPage = homePage.clickOnSectionWidgets().clickOnProgressBar();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(progressBarPage.getPageTitleText(),pageTitle);
    }

    @Parameters("firstLabel")
    @Test
    public void validateCorrectLabelText(String firstLabel){
        Assert.assertEquals(progressBarPage.getLabelText(), firstLabel);
    }

    @Parameters("fullBarPercentage")
    @Test
    public void validateProgressBar(String fullBarPercentage){
        progressBarPage.clickOnStartButton();
        progressBarPage.waitForResetButton();
        Assert.assertEquals(progressBarPage.getPercentText(), fullBarPercentage);
    }

    @Parameters("emptyBarPercentage")
    @Test
    public void validateReturnToBasePage(String emptyBarPercentage){
        progressBarPage.clickOnStartButton();
        progressBarPage.waitForResetButton();
        progressBarPage.clickOnResetButton();
        Assert.assertEquals(progressBarPage.getPercentText(), emptyBarPercentage);
    }
}
