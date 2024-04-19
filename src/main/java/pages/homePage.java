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

    public ElementsPage clickOnSectionElements(WebDriver driver1){
        clickOnSection(sections,0);
        return new ElementsPage(driver1);
    }

    public FormsPage clickOnSectionForms(WebDriver driver1){
        clickOnSection(sections,1);
        return new FormsPage(driver1);
    }

    public AlertsFrameWindowsPage clickOnSectionAlerts_Frame_Windows(WebDriver driver1){
        clickOnSection(sections,2);
        return new AlertsFrameWindowsPage(driver1);
    }

    public WidgetsPage clickOnSectionWidgets(WebDriver driver1){
        clickOnSection(sections,3);
        return new WidgetsPage(driver1);
    }

    public InteractionsPage clickOnSectionInteractions(WebDriver driver1){
        clickOnSection(sections,4);
        return new InteractionsPage(driver1);
    }

    public BookStorePage clickOnSectionBookStoreApplication(WebDriver driver1){
        clickOnSection(sections,5);
        return new BookStorePage(driver1);
    }

}