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

    public ElementsPage clickOnSectionElements(){
        clickOnSection(sections,0);
        return new ElementsPage(driver);
    }

    public FormsPage clickOnSectionForms(){
        clickOnSection(sections,1);
        return new FormsPage(driver);
    }

    public AlertsFrameWindowsPage clickOnSectionAlerts_Frame_Windows(){
        clickOnSection(sections,2);
        return new AlertsFrameWindowsPage(driver);
    }

    public WidgetsPage clickOnSectionWidgets(){
        clickOnSection(sections,3);
        return new WidgetsPage(driver);
    }

    public InteractionsPage clickOnSectionInteractions(){
        clickOnSection(sections,4);
        return new InteractionsPage(driver);
    }

    public BookStorePage clickOnSectionBookStoreApplication(){
        clickOnSection(sections,5);
        return new BookStorePage(driver);
    }
}