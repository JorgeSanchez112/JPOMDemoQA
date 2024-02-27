package TestComponents;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        webDriverThreadLocal.set(driver);
    }

    public static void quitDriver(){
        WebDriver driver = webDriverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            webDriverThreadLocal.remove();
        }
    }
}
