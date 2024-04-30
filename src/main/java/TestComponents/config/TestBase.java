package TestComponents.config;

import Pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.util.Properties;

public class TestBase extends BrowserManager{

    protected Logger logger = LogManager.getLogger(TestBase.class);
    private final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    public static Properties prop;

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

    public void hideFooterAd(WebDriver driver){
        try{
            try {
                logger.info("Hiding publicity: " + prop.getProperty("publicityLocator"));
                homePage.hidePublicity(driver.findElement(By.cssSelector(prop.getProperty("publicityLocator"))));
            }catch (TimeoutException e){
                logger.error("Failed to hide the publicity in 10 seconds");
            }catch (NullPointerException e){
                logger.error("driver is null",e);
            }
        }catch (NoSuchElementException e){
            logger.error("Element was no found");
        }
    }


    public void setDriver(WebDriver driver){
        webDriverThreadLocal.set(driver);
    }

    public WebDriver getDriver(){
        return webDriverThreadLocal.get();
    }

    @Parameters("browserName")
    @BeforeMethod(groups = {"UI","Smoke","Integration","Functional"})
    public void setUp(String browserName) throws MalformedURLException {
        WebDriver driver = null;
        try {
            driver = initialization(browserName);
            setDriver(driver);
            logger.info("Before Test Thread ID: " + Thread.currentThread().getId());
            logger.info("Initializing homePage Class");
            homePage = new HomePage(getDriver());
            hideFooterAd(getDriver());
        } catch (Exception e) {
            logger.error("Error initializing WebDriver: " + e.getMessage());
            if (driver != null) {
                driver.quit();
            }
            throw e;
        }
    }

    @AfterMethod(groups = {"UI","Smoke","Integration","Functional"})
    public synchronized void tearDown(){
        try {
            getDriver().quit();
            logger.info("After Test Thread ID: "+Thread.currentThread().getId());
            logger.info("Close Test Case and driver");
            webDriverThreadLocal.remove();
        } catch (WebDriverException e) {
            logger.error("has happened an error with the tearDown method: " + e);
        }catch (NullPointerException e){
            logger.error("" + e);
        }
    }
}