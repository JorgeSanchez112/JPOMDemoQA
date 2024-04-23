package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class AlertsFrameWindowsPage extends PageBase {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_form_exercise;

    public AlertsFrameWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getSizeSections(){
        return deployed_form_exercise.size();
    }

    public String getAlertFrameWindowsUrl(){
        return driver.getCurrentUrl();
    }

    public synchronized BrowserWindowsPage clickOnBrowserWindows(){
        clickOnSection(deployed_form_exercise,0);
        return new BrowserWindowsPage(driver);
    }

    public synchronized AlertsPage clickOnAlerts(){
        clickOnSection(deployed_form_exercise,1);
        return new AlertsPage(driver);
    }

    public synchronized FramesPage clickOnFrames(){
        clickOnSection(deployed_form_exercise,2);
        return new FramesPage(driver);
    }

    public synchronized NestedFramesPage clickOnNestedFrames(){
        clickOnSection(deployed_form_exercise,3);
        return new NestedFramesPage(driver);
    }

    public synchronized ModalDialogsPage clickOnModalDialogs(){
        clickOnSection(deployed_form_exercise,4);
        return new ModalDialogsPage(driver);
    }

}
