package org.Tests;


import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homePageTest extends testBase {
    private final Logger logger = LogManager.getLogger(accordianPageTest.class);

    @Test(groups = {"Functional"})
    public void validateURL() {
        String URL = "https://demoqa.com/";

        logger.info("-------------------validateURL-----------------------");
        Assert.assertEquals(homePage.getHomePageUrlText(), URL);
    }
}
