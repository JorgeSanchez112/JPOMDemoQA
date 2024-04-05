package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class alertsFrameWindowsPage extends pageBase {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_form_exercise;

    public alertsFrameWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getSizeSections(){
        return deployed_form_exercise.size();
    }

    public String getAlertFrameWindowsUrl(){
        return driver.getCurrentUrl();
    }

    public browserWindowsPage clickOnBrowserWindows(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(0));
            clickWithWait(deployed_form_exercise.get(0));
            return new browserWindowsPage(driver);
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public alertsPage clickOnAlerts(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(1));
            clickWithWait(deployed_form_exercise.get(1));
            return new alertsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public framesPage clickOnFrames(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(2));
            clickWithWait(deployed_form_exercise.get(2));
            return new framesPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public nestedFramesPage clickOnNestedFrames(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(3));
            clickWithWait(deployed_form_exercise.get(3));
            return new nestedFramesPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public modalDialogsPage clickOnModalDialogs(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(4));
            clickWithWait(deployed_form_exercise.get(4));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new modalDialogsPage(driver);
    }

}
