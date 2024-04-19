package TestComponents.config;

import Pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class TestBase {

    protected Logger logger = LogManager.getLogger(TestBase.class);
    protected static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
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

    @Parameters("browserName")
    @BeforeMethod(groups = {"UI","Smoke","Integration","Functional"})
    public void setUp(String browserName) throws MalformedURLException {
        WebDriver driver = BrowserManager.initialization(browserName);
        setDriver(driver);
        logger.info("Before Test Thread ID: "+Thread.currentThread().getId());
        logger.info("Initializing homePage Class");
        homePage = new HomePage(getDriver());
    }

    @AfterMethod(groups = {"UI","Smoke","Integration","Functional"})
    public void tearDown(){
        try {
            getDriver().quit();
            logger.info("After Test Thread ID: "+Thread.currentThread().getId());
            logger.info("Close Test Case and driver");
            webDriverThreadLocal.remove();
            Thread.sleep(2000);
        } catch (WebDriverException e) {
            logger.error("has happened an error with the tearDown method: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}