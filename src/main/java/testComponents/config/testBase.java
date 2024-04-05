package testComponents.config;

import pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public class testBase {

    protected static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    protected Logger logger = LogManager.getLogger(testBase.class);
    protected WebDriver driver;
    protected Properties prop;
    protected homePage homePage;
    protected elementsPage elementsPage;
    protected formsPage formsPage;
    protected alertsFrameWindowsPage alertsFrameWindowsPage;
    protected widgetsPage widgetsPage;
    protected interactionsPage interactionsPage;
    protected bookStorePage bookStorePage;
    protected textBoxPage textBoxPage;
    protected checkBoxPage checkBoxPage;
    protected radioButtonPage radioButtonPage;
    protected webTablesPage webTablesPage;
    protected buttonsPage buttonsPage;
    protected linksPage linksPage;
    protected brokenLinksPage brokenLinksPage;
    protected uploadDownloadPage uploadDownloadPage;
    protected dynamicPropertiesPage dynamicPropertiesPage;
    protected practiceFormPage practiceFormPage;
    protected browserWindowsPage browserWindowsPage;
    protected alertsPage alertsPage;
    protected framesPage framesPage;
    protected nestedFramesPage nestedFramesPage;
    protected modalDialogsPage modalDialogsPage;
    protected accordianPage accordianPage;
    protected autoCompletePage autoCompletePage;
    protected datePickerPage datePickerPage;
    protected sliderPage sliderPage;
    protected progressBarPage progressBarPage;
    protected tabsPage tabsPage;
    protected toolTipsPage toolTipsPage;
    protected menuPage menuPage;
    protected selectMenuPage selectMenuPage;
    protected sortablePage sortablePage;
    protected selectablePage selectablePage;
    protected resizablePage resizablePage;
    protected droppablePage droppablePage;
    protected draggablePage draggablePage;
    protected bSLoginPage bsLoginPage;
    protected bSRegisterPage bsRegisterPage;
    protected bSProfilePage bsProfilePage;
    protected bSIBookPage bsiBookPage;
    protected bSAPIPage bsapiPage;

    public testBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver(){
       return webDriverThreadLocal.get();
    }

    public MutableCapabilities chooseBrowser(){
        String browserName = prop.getProperty("browser");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if (browserName == null){
            System.out.println("browser is: " + null);
            return null;
        }

        switch (Objects.requireNonNull(browserName)){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                return chromeOptions.merge(desiredCapabilities);
            case "firefox":
                FirefoxOptions firefoxOptions= new FirefoxOptions();
                return firefoxOptions.merge(desiredCapabilities);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                return edgeOptions.merge(desiredCapabilities);
            default:
                System.out.println("selected browser is not available");
                return null;
        }
    }

    public WebDriver initialization() throws MalformedURLException {
        WebDriver driver = new RemoteWebDriver(new URL(prop.getProperty("urlServer")), chooseBrowser());
        driver.manage().window().maximize();
        try{
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.get(prop.getProperty("url"));
            driver.manage().deleteAllCookies();
        }catch (TimeoutException e){
            e.printStackTrace();
        }

        webDriverThreadLocal.set(driver);// Set the driver in ThreadLocal
        return driver;
    }

    @BeforeMethod(groups = {"UI","Smoke","Integration","Functional"})
    public void setUp() throws MalformedURLException {
        WebDriver driver = getDriver();
        if (driver == null) {
            webDriverThreadLocal.set(initialization());
            driver = getDriver();
        }
        System.out.println(driver);

        homePage = new homePage(driver);
        logger.info("Initializing homePage Class");
        try{
            try {
                logger.info("Hiding publicity: " + prop.getProperty("publicityLocator"));
                homePage.hidePublicity(driver.findElement(By.cssSelector(prop.getProperty("publicityLocator"))));
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    @AfterMethod(groups = {"UI","Smoke","Integration","Functional"})
    public void tearDown(){
        try {
            WebDriver driver = getDriver();
            if (driver != null) {
                logger.info("Close Test Case and driver: " + driver);
                driver.quit();
                webDriverThreadLocal.remove();
            }
        } catch (WebDriverException e) {
            e.getMessage();
        }
    }
}