package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WidgetsPage extends PageBase {
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
        clickOnSection(deployed_form_exercise,0);
        return new AccordianPage(driver);
    }

    public AutoCompletePage clickOnAutoComplete(){
        clickOnSection(deployed_form_exercise,1);
        return new AutoCompletePage(driver);
    }

    public DatePickerPage clickOnDatePicker(){
        clickOnSection(deployed_form_exercise,2);
        return new DatePickerPage(driver);
    }

    public SliderPage clickOnSlider(){
        clickOnSection(deployed_form_exercise,3);
        return new SliderPage(driver);
    }

    public ProgressBarPage clickOnProgressBar(){
        clickOnSection(deployed_form_exercise,4);
        return new ProgressBarPage(driver);
    }

    public TabsPage clickOnTabs(){
        clickOnSection(deployed_form_exercise,5);
        return new TabsPage(driver);
    }

    public ToolTipsPage clickOnToolTips(){
        clickOnSection(deployed_form_exercise,6);
        return new ToolTipsPage(driver);
    }

    public MenuPage clickOnMenu(){
        clickOnSection(deployed_form_exercise,7);
        return new MenuPage(driver);
    }

    public SelectMenuPage clickOnSelectMenu(){
        clickOnSection(deployed_form_exercise,8);
        return new SelectMenuPage(driver);
    }
}