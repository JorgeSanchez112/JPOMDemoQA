package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlertsFrameWindowsPage extends BasePages {
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

    public BrowserWindows clickOnBrowserWindows(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(0));
        clickWithWait(deployed_form_exercise.get(0));
        return new BrowserWindows(driver);
    }

    public AlertsPage clickOnAlerts(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(1));
        clickWithWait(deployed_form_exercise.get(1));
        return new AlertsPage(driver);
    }

    public FramesPage clickOnFrames(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(2));
        clickWithWait(deployed_form_exercise.get(2));
        return new FramesPage(driver);
    }

    public NestedFramesPage clickOnNestedFrames(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        try {
            scroll(deployed_form_exercise.get(3));
            clickWithWait(deployed_form_exercise.get(3));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new NestedFramesPage(driver);
    }

    public ModalDialogsPage clickOnModalDialogs(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(4));
        clickWithWait(deployed_form_exercise.get(4));
        return new ModalDialogsPage(driver);
    }

}
