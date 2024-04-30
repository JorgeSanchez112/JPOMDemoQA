package TestComponents.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BrowserManager {

    protected Logger logger = LogManager.getLogger(BrowserManager.class);
    public Properties prop;

    public BrowserManager(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MutableCapabilities chooseBrowser(String browserName) {
        if (browserName == null) {
            throw new IllegalArgumentException("browserName cannot be null");
        }

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                return chromeOptions;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                return firefoxOptions;
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                return edgeOptions;
            default:
                throw new IllegalArgumentException("selected browser is not available");
        }
    }

    public WebDriver initialization(String browserName) throws MalformedURLException {
        WebDriver driver = null;
        try {
            driver = (new RemoteWebDriver(new URL(prop.getProperty("urlServer")), chooseBrowser(browserName)));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().deleteAllCookies();
            driver.get(prop.getProperty("url"));
        }catch (SessionNotCreatedException e){
            logger.error("A new session could be able to start",e);
        }catch (TimeoutException e){
            logger.error("Failed to load the page in 60 seconds",e);
        }catch (WebDriverException e){
            logger.error("Error with WebDriver");
        }

        return driver;
    }

}
