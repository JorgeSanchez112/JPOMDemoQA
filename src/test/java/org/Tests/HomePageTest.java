package org.Tests;


import TestComponents.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    private Logger logger = LogManager.getLogger(AccordianPageTest.class);
    private final String URL = "https://demoqa.com/";

    @Test(groups = {"Functional"})
    public void validateURL() {
        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(homePage.getHomePageUrlText(), URL);
    }
}
