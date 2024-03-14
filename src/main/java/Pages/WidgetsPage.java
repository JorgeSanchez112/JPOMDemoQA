package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WidgetsPage extends BasePages {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_form_exercise;

    public WidgetsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getWidgetsUrlText(){
        return driver.getCurrentUrl();
    }

    public int getSizeSections(){
        return deployed_form_exercise.size();
    }

    public AccordianPage clickOnAccordian(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(0));
            clickWithWait(deployed_form_exercise.get(0));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        return new AccordianPage(driver);
    }

    public AutoCompletePage clickOnAutoComplete(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(1));
            clickWithWait(deployed_form_exercise.get(1));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new AutoCompletePage(driver);
    }

    public DatePickerPage clickOnDatePicker(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(2));
            clickWithWait(deployed_form_exercise.get(2));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new DatePickerPage(driver);
    }

    public SliderPage clickOnSlider(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(3));
            clickWithWait(deployed_form_exercise.get(3));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new SliderPage(driver);
    }

    public ProgressBarPage clickOnProgressBar(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(4));
            clickWithWait(deployed_form_exercise.get(4));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new ProgressBarPage(driver);
    }

    public TabsPage clickOnTabs(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(5));
            clickWithWait(deployed_form_exercise.get(5));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new TabsPage(driver);
    }

    public ToolTipsPage clickOnToolTips(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(6));
            clickWithWait(deployed_form_exercise.get(6));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new ToolTipsPage(driver);
    }

    public MenuPage clickOnMenu(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(7));
            clickWithWait(deployed_form_exercise.get(7));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new MenuPage(driver);
    }

    public SelectMenuPage clickOnSelectMenu(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(8));
            clickWithWait(deployed_form_exercise.get(8));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new SelectMenuPage(driver);
    }
}