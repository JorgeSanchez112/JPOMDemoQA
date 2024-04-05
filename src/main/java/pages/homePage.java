package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class homePage extends pageBase {
    @FindBy (className = "top-card")
    private List<WebElement> sections;

    public homePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getHomePageUrlText(){
        return driver.getCurrentUrl();
    }

    public elementsPage clickOnSectionElements(){
        try{
            waitForChargedElementsOfAWebElementList(sections);
            scroll(sections.get(0));
            clickWithWait(sections.get(0));
            return new elementsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public formsPage clickOnSectionForms(){
        try {
            waitForChargedElementsOfAWebElementList(sections);
            scroll(sections.get(1));
            clickWithWait(sections.get(1));
            return new formsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public alertsFrameWindowsPage clickOnSectionAlerts_Frame_Windows(){
        try{
            waitForChargedElementsOfAWebElementList(sections);
            scroll(sections.get(2));
            clickWithWait(sections.get(2));
            return new alertsFrameWindowsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public widgetsPage clickOnSectionWidgets(){
        try {
            waitForChargedElementsOfAWebElementList(sections);
            scroll(sections.get(3));
            clickWithWait(sections.get(3));
            return new widgetsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public interactionsPage clickOnSectionInteractions(){
        waitForChargedElementsOfAWebElementList(sections);
        try {
            scroll(sections.get(4));
            clickWithWait(sections.get(4));
            return new interactionsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public bookStorePage clickOnSectionBookStoreApplication(){
        waitForChargedElementsOfAWebElementList(sections);
        try{
            scroll(sections.get(5));
            clickWithWait(sections.get(5));
            return new bookStorePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }
}