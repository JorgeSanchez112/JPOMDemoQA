package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarPageTest extends TestBase {
    private final String PAGE_TITLE = "Progress Bar";
    private final String FULL_BAR_PERCENTAGE = "100%";
    private final String EMPTY_BAR_PERCENTAGE = "0%";

    @BeforeMethod
    public void initializeClass(){
        progressBarPage = homePage.clickOnSectionWidgets().clickOnProgressBar();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(progressBarPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateCorrectLabelText(){
        Assert.assertEquals(progressBarPage.getLabelText(), PAGE_TITLE);
    }

    @Test
    public void validateProgressBar(){
        progressBarPage.startProgressBarAndWaitTo100Percent();
        Assert.assertEquals(progressBarPage.getPercentText(), FULL_BAR_PERCENTAGE);
    }

    @Test
    public void validateReturnToBasePage(){
        progressBarPage.startProgressBarTillEndAndRestartBar();
        Assert.assertEquals(progressBarPage.getPercentText(), EMPTY_BAR_PERCENTAGE);
    }
}