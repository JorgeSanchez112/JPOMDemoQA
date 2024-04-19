package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InteractionsPage extends PageBase {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_form_exercise;

    public InteractionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getInteractionsUrlText(){
        return driver.getCurrentUrl();
    }

    public int getSizeSections(){
        return deployed_form_exercise.size();
    }

    public SortablePage clickOnSortable(WebDriver driver1){
        clickOnSection(deployed_form_exercise,0);
        return new SortablePage(driver1);
    }

    public SelectablePage clickOnSelectable(WebDriver driver1){
        clickOnSection(deployed_form_exercise,0);
        return new SelectablePage(driver1);
    }

    public ResizablePage clickOnResizable(WebDriver driver1){
        clickOnSection(deployed_form_exercise,0);
        return new ResizablePage(driver1);
    }

    public DroppablePage clickOnDroppable(WebDriver driver1){
        clickOnSection(deployed_form_exercise,0);
        return new DroppablePage(driver1);
    }

    public DraggablePage clickOnDragabble(WebDriver driver1){
        clickOnSection(deployed_form_exercise,0);
        return new DraggablePage(driver1);
    }
}