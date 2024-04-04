package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InteractionsPage extends BasePages {
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

    public SortablePage clickOnSortable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(0));
            clickWithWait(deployed_form_exercise.get(0));
            return new SortablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public SelectablePage clickOnSelectable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(1));
            clickWithWait(deployed_form_exercise.get(1));
            return new SelectablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public ResizablePage clickOnResizable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(2));
            clickWithWait(deployed_form_exercise.get(2));
            return new ResizablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public DroppablePage clickOnDroppable(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(3));
            clickWithWait(deployed_form_exercise.get(3));
            return new DroppablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public DraggablePage clickOnDragabble(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(4));
            clickWithWait(deployed_form_exercise.get(4));
            return new DraggablePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }
}