package org.Tests;


import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    private final String URL = "https://demoqa.com/";

    @Test
    public void validateURL() {
        Assert.assertEquals(homePage.getHomePageUrlText(), URL);
    }
}
