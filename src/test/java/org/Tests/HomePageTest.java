package org.Tests;


import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Test
    public void validateURL() {
        Assert.assertEquals(homePage.getHomePageUrlText(),"https://demoqa.com/");
    }
}
