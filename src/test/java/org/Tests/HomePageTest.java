package org.Tests;


import TestComponents.config.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    private final Logger logger = LogManager.getLogger(AccordianPageTest.class);

    @Test(groups = {"Functional"})
    public void validateURL() {
        String URL = "https://demoqa.com/";

        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(homePage.getHomePageUrlText(), URL);
    }
}
