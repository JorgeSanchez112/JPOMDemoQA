package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class interactionsPage extends pageBase {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_form_exercise;

    public interactionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getInteractionsUrlText(){
        return driver.getCurrentUrl();
    }

    public int getSizeSections(){
        return deployed_form_exercise.size();
    }

    public sortablePage clickOnSortable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(0));
            clickWithWait(deployed_form_exercise.get(0));
            return new sortablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public selectablePage clickOnSelectable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(1));
            clickWithWait(deployed_form_exercise.get(1));
            return new selectablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public resizablePage clickOnResizable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(2));
            clickWithWait(deployed_form_exercise.get(2));
            return new resizablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public droppablePage clickOnDroppable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(3));
            clickWithWait(deployed_form_exercise.get(3));
            return new droppablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public draggablePage clickOnDragabble(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(4));
            clickWithWait(deployed_form_exercise.get(4));
            return new draggablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }
}