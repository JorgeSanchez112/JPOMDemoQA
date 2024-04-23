package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalDialogsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(ModalDialogsPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public synchronized void initializeClass(){
        logger.info("-------------------Initializing ModalDialogsPageTest Class------------------");
        modalDialogsPage = homePage.clickOnSectionAlerts_Frame_Windows().clickOnModalDialogs();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Modal Dialogs";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(modalDialogsPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateInstructionTextIsVisible(){
        logger.info("-------------------validateInstructionTextIsVisible-----------------------");
        Assert.assertTrue(modalDialogsPage.isInstructionsTextVisible());
    }

    @Test(groups = {"Functional"})
    public void validateSmallModalShowed(){
        String SMALL_MODAL = "This is a small modal. It has very less content";

        logger.info("-------------------validateSmallModalShowed-----------------------");
        modalDialogsPage.clickOnSmallModalButton();
        Assert.assertEquals(modalDialogsPage.getSmallModalText(), SMALL_MODAL);
    }

    @Test(groups = {"Functional"})
    public void validateLargeModalShowed(){
        String LARGE_MODAL = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        logger.info("-------------------validateLargeModalShowed-----------------------");
        modalDialogsPage.clickOnLargeModalButton();
        Assert.assertEquals(modalDialogsPage.getLargeModalText(), LARGE_MODAL);
    }

    @Test(groups = {"UI"})
    public void validateCloseButtonIsVisibleInSmallModel(){
        logger.info("-------------------validateCloseButtonIsVisibleInSmallModel-----------------------");
        modalDialogsPage.clickOnSmallModalButton();
        Assert.assertTrue(modalDialogsPage.isCloseSmallModalVisible());
    }

    @Test(groups = {"UI"})
    public void validateCloseButtonIsVisibleInLargeModel(){
        logger.info("-------------------validateCloseButtonIsVisibleInLargeModel-----------------------");
        modalDialogsPage.clickOnLargeModalButton();
        Assert.assertTrue(modalDialogsPage.isCloseLargeModalVisible());
    }
}
