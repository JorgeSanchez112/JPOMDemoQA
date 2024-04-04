package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePages {
    @FindBy (className = "top-card")
    private List<WebElement> sections;

    public HomePage() {
        PageFactory.initElements(getDriver(),this);
    }

    public String getHomePageUrlText(){
        return getDriver().getCurrentUrl();
    }

    public ElementsPage clickOnSectionElements(){
        waitForChargedElementsOfAWebElementList(sections);
        try {
            scroll(sections.get(0));
            clickWithWait(sections.get(0));
            return new ElementsPage(getDriver());
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new ElementsPage(getDriver());
    }

    public FormsPage clickOnSectionForms(){
        waitForChargedElementsOfAWebElementList(sections);
        try {
            scroll(sections.get(1));
            clickWithWait(sections.get(1));
            return new FormsPage(getDriver());
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new FormsPage(getDriver());
    }

    public AlertsFrameWindowsPage clickOnSectionAlerts_Frame_Windows(){
        try {
            waitForChargedElementsOfAWebElementList(sections);
            scroll(sections.get(2));
            clickWithWait(sections.get(2));
            return new AlertsFrameWindowsPage(getDriver());
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new AlertsFrameWindowsPage(getDriver());
    }

    public WidgetsPage clickOnSectionWidgets(){
        waitForChargedElementsOfAWebElementList(sections);
        try {
            scroll(sections.get(3));
            clickWithWait(sections.get(3));
            return new WidgetsPage(getDriver());
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new WidgetsPage(getDriver());
    }

    public InteractionsPage clickOnSectionInteractions(){
        waitForChargedElementsOfAWebElementList(sections);
        try {
            scroll(sections.get(4));
            clickWithWait(sections.get(4));
            return new InteractionsPage(getDriver());
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new InteractionsPage(getDriver());
    }

    public BookStorePage clickOnSectionBookStoreApplication(){
        waitForChargedElementsOfAWebElementList(sections);
        try {
            scroll(sections.get(5));
            clickWithWait(sections.get(5));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new BookStorePage(getDriver());
    }

}
