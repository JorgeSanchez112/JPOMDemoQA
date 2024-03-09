package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsPageTest extends TestBase {
    private final String PAGE_TITLE = "Buttons";
    private final String DOUBLE_CLICK_MESSAGE = "You have done a double click";
    private final String RIGHT_CLICK_MESSAGE = "You have done a right click";
    private final String RADIO_BUTTON = "You have done a dynamic click";

    @BeforeMethod
    public void initializeClass(){
       buttonsPage = homePage.clickOnSectionElements().clickOnButtonsSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(buttonsPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateDoubleClickInABtn(){
        buttonsPage.clickOnDoubleBtn();
        Assert.assertEquals(buttonsPage.getDoubleClickMessageText(),DOUBLE_CLICK_MESSAGE);
    }

    @Test
    public void validateRightClickInABtn(){
        buttonsPage.clickOnRightBtn();
        Assert.assertEquals(buttonsPage.getRightClickMessageText(),RIGHT_CLICK_MESSAGE);
    }

    @Test
    public void validateClickInABtn(){
        buttonsPage.clickOnClickMe();
        Assert.assertEquals(buttonsPage.getClickMeMessageText(),RADIO_BUTTON);
    }
}