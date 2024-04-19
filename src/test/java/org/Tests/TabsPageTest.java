package org.Tests;

import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TabsPageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(TabsPageTest.class);

    @BeforeMethod(groups = {"UI","Functional"})
    public void initializeClass(){
        logger.info("-------------------Initializing TabsPageTest Class------------------");
        tabsPage = homePage.clickOnSectionWidgets(getDriver()).clickOnTabs(getDriver());
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Tabs";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(tabsPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"Functional"})
    public void subtitleIsShowed(){
        logger.info("-------------------subtitleIsShowed-----------------------");
        Assert.assertTrue(tabsPage.isSubTitleDisplayed());
    }

    @Test(groups = {"UI"})
    public void validateCorrectTitleOfFirstTab(){
        String FIRST_TAB_TITLE = "What";

        logger.info("-------------------validateCorrectTitleOfFirstTab-----------------------");
        Assert.assertEquals(tabsPage.getFirstTitleTab(), FIRST_TAB_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectTitleOfSecondTab(){
        String SECOND_TAB_TITLE = "Origin";

        logger.info("-------------------validateCorrectTitleOfSecondTab-----------------------");
        Assert.assertEquals(tabsPage.getSecondTitleTab(), SECOND_TAB_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateCorrectTitleOfThirdTab(){
        String THIRD_TAB_TITLE = "Use";

        logger.info("-------------------validateCorrectTitleOfThirdTab-----------------------");
        Assert.assertEquals(tabsPage.getThirdTitleTab(), THIRD_TAB_TITLE);
    }

    @Test(groups = {"Functional"})
    public void tabWhatParagraphIsDisplayed(){
        String WHAT_TAB_TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        logger.info("-------------------tabWhatParagraphIsDisplayed-----------------------");
        Assert.assertEquals(tabsPage.getParagraphOfWhatText(), WHAT_TAB_TEXT);
    }

    @Test(groups = {"Functional"})
    public void tabOriginParagraphIsDisplayed(){
        String FIRST_PARAGRAPH_ORIGIN_TAB_TEXT = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";

        logger.info("-------------------tabOriginParagraphIsDisplayed-----------------------");
        tabsPage.clickOnTabOrigin();
        Assert.assertEquals(tabsPage.getFirstParagraphsOfOriginText(), FIRST_PARAGRAPH_ORIGIN_TAB_TEXT);

    }

    @Test(groups = {"Functional"})
    public void secondParagraphOfOriginIsDisplayed(){
        String SECOND_PARAGRAPH_OF_ORIGIN_TAB_TEXT = "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.";

        logger.info("-------------------secondParagraphOfOriginIsDisplayed-----------------------");
        tabsPage.clickOnTabOrigin();
        Assert.assertEquals(tabsPage.getSecondParagraphsOfOriginText(), SECOND_PARAGRAPH_OF_ORIGIN_TAB_TEXT);
    }


    @Test(groups = {"Functional"})
    public void tabUseParagraphIsDisplayed(){String USE_TAB_TEXT = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).";

        logger.info("-------------------tabUseParagraphIsDisplayed-----------------------");
        tabsPage.clickOnTabUse();
        Assert.assertEquals(tabsPage.getParagraphOfUseText(), USE_TAB_TEXT);
    }

    @Test(groups = {"Functional"})
    public void tabMoreIsDisabled(){
        logger.info("-------------------tabMoreIsDisabled-----------------------");
        Assert.assertTrue(tabsPage.isMoreTabEnabled());
    }
}
