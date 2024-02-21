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
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(0));
        clickWithWait(deployed_form_exercise.get(0));
        return new AccordianPage(driver);
    }

    public AutoCompletePage clickOnAutoComplete(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(1));
        clickWithWait(deployed_form_exercise.get(1));
        return new AutoCompletePage(driver);
    }

    public DatePickerPage clickOnDatePicker(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(2));
        clickWithWait(deployed_form_exercise.get(2));
        return new DatePickerPage(driver);
    }

    public SliderPage clickOnSlider(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(3));
        clickWithWait(deployed_form_exercise.get(3));
        return new SliderPage(driver);
    }

    public ProgressBarPage clickOnProgressBar(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(4));
        clickWithWait(deployed_form_exercise.get(4));
        return new ProgressBarPage(driver);
    }

    public TabsPage clickOnTabs(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(5));
        clickWithWait(deployed_form_exercise.get(5));
        return new TabsPage(driver);
    }

    public ToolTipsPage clickOnToolTips(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(6));
        clickWithWait(deployed_form_exercise.get(6));
        return new ToolTipsPage(driver);
    }

    public MenuPage clickOnMenu(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(7));
        clickWithWait(deployed_form_exercise.get(7));
        return new MenuPage(driver);
    }

    public SelectMenuPage clickOnSelectMenu(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        scroll(deployed_form_exercise.get(8));
        clickWithWait(deployed_form_exercise.get(8));
        return new SelectMenuPage(driver);
    }

}
