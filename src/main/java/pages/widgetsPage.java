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

    public AccordianPage clickOnAccordian(WebDriver driver1){
        clickOnSection(deployed_form_exercise,0);
        return new AccordianPage(driver1);
    }

    public AutoCompletePage clickOnAutoComplete(WebDriver driver1){
        clickOnSection(deployed_form_exercise,1);
        return new AutoCompletePage(driver1);
    }

    public DatePickerPage clickOnDatePicker(WebDriver driver1){
        clickOnSection(deployed_form_exercise,2);
        return new DatePickerPage(driver1);
    }

    public SliderPage clickOnSlider(WebDriver driver1){
        clickOnSection(deployed_form_exercise,3);
        return new SliderPage(driver1);
    }

    public ProgressBarPage clickOnProgressBar(WebDriver driver1){
        clickOnSection(deployed_form_exercise,4);
        return new ProgressBarPage(driver1);
    }

    public TabsPage clickOnTabs(WebDriver driver1){
        clickOnSection(deployed_form_exercise,5);
        return new TabsPage(driver1);
    }

    public ToolTipsPage clickOnToolTips(WebDriver driver1){
        clickOnSection(deployed_form_exercise,6);
        return new ToolTipsPage(driver1);
    }

    public MenuPage clickOnMenu(WebDriver driver1){
        clickOnSection(deployed_form_exercise,7);
        return new MenuPage(driver1);
    }

    public SelectMenuPage clickOnSelectMenu(WebDriver driver1){
        clickOnSection(deployed_form_exercise,8);
        return new SelectMenuPage(driver1);
    }
}