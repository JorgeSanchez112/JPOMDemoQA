package org.Tests;


import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    @Parameters("uRL")
    @Test
    public void validateURL(String uRL) {
        Assert.assertEquals(homePage.getHomePageUrlText(),uRL);
    }
}
