package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends PageBase {
    @FindBy (className = "top-card")
    private List<WebElement> sections;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHomePageUrlText(){
        return driver.getCurrentUrl();
    }

    public synchronized ElementsPage clickOnSectionElements(){
        clickOnSection(sections,0);
        return new ElementsPage(driver);
    }

    public synchronized FormsPage clickOnSectionForms(){
        clickOnSection(sections,1);
        return new FormsPage(driver);
    }

    public synchronized AlertsFrameWindowsPage clickOnSectionAlerts_Frame_Windows(){
        clickOnSection(sections,2);
        return new AlertsFrameWindowsPage(driver);
    }

    public synchronized WidgetsPage clickOnSectionWidgets(){
        clickOnSection(sections,3);
        return new WidgetsPage(driver);
    }

    public synchronized InteractionsPage clickOnSectionInteractions(){
        clickOnSection(sections,4);
        return new InteractionsPage(driver);
    }

    public synchronized BookStorePage clickOnSectionBookStoreApplication(){
        clickOnSection(sections,5);
        return new BookStorePage(driver);
    }

}
