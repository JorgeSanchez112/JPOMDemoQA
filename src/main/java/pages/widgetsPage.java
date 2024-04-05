package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class widgetsPage extends pageBase {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_form_exercise;

    public widgetsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getWidgetsUrlText(){
        return driver.getCurrentUrl();
    }

    public int getSizeSections(){
        return deployed_form_exercise.size();
    }

    public accordianPage clickOnAccordian(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(0));
            clickWithWait(deployed_form_exercise.get(0));
            return new accordianPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public autoCompletePage clickOnAutoComplete(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(1));
            clickWithWait(deployed_form_exercise.get(1));
            return new autoCompletePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public datePickerPage clickOnDatePicker(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(2));
            clickWithWait(deployed_form_exercise.get(2));
            return new datePickerPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public sliderPage clickOnSlider(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(3));
            clickWithWait(deployed_form_exercise.get(3));
            return new sliderPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public progressBarPage clickOnProgressBar(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(4));
            clickWithWait(deployed_form_exercise.get(4));
            return new progressBarPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public tabsPage clickOnTabs(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(5));
            clickWithWait(deployed_form_exercise.get(5));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new tabsPage(driver);
    }

    public toolTipsPage clickOnToolTips(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(6));
            clickWithWait(deployed_form_exercise.get(6));
            return new toolTipsPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public menuPage clickOnMenu(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(7));
            clickWithWait(deployed_form_exercise.get(7));
            return new menuPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public selectMenuPage clickOnSelectMenu(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(8));
            clickWithWait(deployed_form_exercise.get(8));
            return new selectMenuPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }
}