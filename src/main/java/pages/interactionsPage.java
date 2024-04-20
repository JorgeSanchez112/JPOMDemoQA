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

    public synchronized SortablePage clickOnSortable(){
        clickOnSection(deployed_form_exercise,0);
        return new SortablePage(driver);
    }

    public synchronized SelectablePage clickOnSelectable(){
        clickOnSection(deployed_form_exercise,0);
        return new SelectablePage(driver);
    }

    public synchronized ResizablePage clickOnResizable(){
        clickOnSection(deployed_form_exercise,0);
        return new ResizablePage(driver);
    }

    public synchronized DroppablePage clickOnDroppable(){
        clickOnSection(deployed_form_exercise,0);
        return new DroppablePage(driver);
    }

    public synchronized DraggablePage clickOnDragabble(){
        clickOnSection(deployed_form_exercise,0);
        return new DraggablePage(driver);
    }
}