package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ButtonsPageTest extends TestBase {

    @BeforeMethod
    public void initializeClass(){
       buttonsPage = homePage.clickOnSectionElements().clickOnButtonsSection();
    }
    //CHANGE ALL
    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(buttonsPage.getPageTitleText(),pageTitle);
    }

    @Parameters("doubleClickMessage")
    @Test
    public void validateDoubleClickInABtn(String doubleClickMessage){
        buttonsPage.clickOnDoubleBtn();
        Assert.assertEquals(buttonsPage.getDoubleClickMessageText(),doubleClickMessage);
    }

    @Parameters("rightClickMessage")
    @Test
    public void validateRightClickInABtn(String rightClickMessage){
        buttonsPage.clickOnRightBtn();
        Assert.assertEquals(buttonsPage.getRightClickMessageText(),rightClickMessage);
    }

    @Parameters("clickMeMessage")
    @Test
    public void validateClickInABtn(String clickMeMessage){
        buttonsPage.clickOnClickMe();
        Assert.assertEquals(buttonsPage.getClickMeMessageText(),clickMeMessage);
    }

}
