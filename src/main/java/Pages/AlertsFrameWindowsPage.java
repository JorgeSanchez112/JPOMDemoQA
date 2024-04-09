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

    public BrowserWindowsPage clickOnBrowserWindows(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(0));
            clickWithWait(deployed_form_exercise.get(0));
            return new BrowserWindowsPage(driver);
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public AlertsPage clickOnAlerts(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(1));
            clickWithWait(deployed_form_exercise.get(1));
            return new AlertsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public FramesPage clickOnFrames(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(2));
            clickWithWait(deployed_form_exercise.get(2));
            return new FramesPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public NestedFramesPage clickOnNestedFrames(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(3));
            clickWithWait(deployed_form_exercise.get(3));
            return new NestedFramesPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public ModalDialogsPage clickOnModalDialogs(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(4));
            clickWithWait(deployed_form_exercise.get(4));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new ModalDialogsPage(driver);
    }

}
