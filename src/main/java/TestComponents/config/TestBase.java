package TestComponents.config;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
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

public class TestBase {

    protected static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    protected Logger logger = LogManager.getLogger(TestBase.class);
    protected Properties prop;
    protected HomePage homePage;
    protected ElementsPage elementsPage;
    protected FormsPage formsPage;
    protected AlertsFrameWindowsPage alertsFrameWindowsPage;
    protected WidgetsPage widgetsPage;
    protected InteractionsPage interactionsPage;
    protected BookStorePage bookStorePage;
    protected TextBoxPage textBoxPage;
    protected CheckBoxPage checkBoxPage;
    protected RadioButtonPage radioButtonPage;
    protected WebTablesPage webTablesPage;
    protected ButtonsPage buttonsPage;
    protected LinksPage linksPage;
    protected BrokenLinksPage brokenLinksPage;
    protected UploadDownloadPage uploadDownloadPage;
    protected DynamicPropertiesPage dynamicPropertiesPage;
    protected PracticeFormPage practiceFormPage;
    protected BrowserWindowsPage browserWindowsPage;
    protected AlertsPage alertsPage;
    protected FramesPage framesPage;
    protected NestedFramesPage nestedFramesPage;
    protected ModalDialogsPage modalDialogsPage;
    protected AccordianPage accordianPage;
    protected AutoCompletePage autoCompletePage;
    protected DatePickerPage datePickerPage;
    protected SliderPage sliderPage;
    protected ProgressBarPage progressBarPage;
    protected TabsPage tabsPage;
    protected ToolTipsPage toolTipsPage;
    protected MenuPage menuPage;
    protected SelectMenuPage selectMenuPage;
    protected SortablePage sortablePage;
    protected SelectablePage selectablePage;
    protected ResizablePage resizablePage;
    protected DroppablePage droppablePage;
    protected DraggablePage draggablePage;
    protected BSLoginPage bsLoginPage;
    protected BSRegisterPage bsRegisterPage;
    protected BSProfilePage bsProfilePage;
    protected BSIBookPage bsiBookPage;
    protected BSAPIPage bsapiPage;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hideFooterAd(WebDriver driver){
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

    public void setDriver(WebDriver driver){
        webDriverThreadLocal.set(driver);
    }

    public WebDriver getDriver(){
        return webDriverThreadLocal.get();
    }


    public MutableCapabilities chooseBrowser(String browserName){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        switch (Objects.requireNonNull(browserName).toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                return chromeOptions.merge(desiredCapabilities);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions= new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                return firefoxOptions.merge(desiredCapabilities);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                return edgeOptions.merge(desiredCapabilities);
            default:
                System.out.println("selected browser is not available");
                return null;
        }
    }

    public WebDriver initialization(String browserName) throws MalformedURLException {
        WebDriver driver = (new RemoteWebDriver(new URL(prop.getProperty("urlServer")), chooseBrowser(browserName)));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

        setDriver(driver);
        return driver;
    }

    @Parameters("browserName")
    @BeforeMethod(groups = {"UI","Smoke","Integration","Functional"})
    public void setUp(String browserName) throws MalformedURLException {
        WebDriver driver = getDriver();
        if (driver == null) {
            driver = initialization(browserName);
            setDriver(driver);
        }
        homePage = new HomePage(driver);
        logger.info("Initializing homePage Class");
        hideFooterAd(driver);
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