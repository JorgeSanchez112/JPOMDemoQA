package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class elementsPage extends pageBase {
    @FindBy (css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_element_exercises;

    public elementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getElementUrlText(){
        return driver.getCurrentUrl();
    }

    public int deployedElementsSize(){
        return deployed_element_exercises.size();
    }

    public textBoxPage clickOnTextBoxSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(0));
            clickWithWait(deployed_element_exercises.get(0));
            return new textBoxPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Text Box Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public checkBoxPage clickOnCheckBoxSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(1));
            clickWithWait(deployed_element_exercises.get(1));
            return new checkBoxPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Check Box Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public radioButtonPage clickOnRadioButtonSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(2));
            clickWithWait(deployed_element_exercises.get(2));
            return new radioButtonPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Radio Button Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public webTablesPage clickOnWebTablesSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(3));
            clickWithWait(deployed_element_exercises.get(3));
            return new webTablesPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Web Table Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public buttonsPage clickOnButtonsSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(4));
            clickWithWait(deployed_element_exercises.get(4));
            return new buttonsPage(driver);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Buttons Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public linksPage clickOnLinksSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(5));
            clickWithWait(deployed_element_exercises.get(5));
            return new linksPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Links Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public brokenLinksPage clickOnBrokenLinksImageSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(6));
            clickWithWait(deployed_element_exercises.get(6));
            return new brokenLinksPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Broken Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public uploadDownloadPage clickOnUploadDownloadSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(7));
            clickWithWait(deployed_element_exercises.get(7));
            return new uploadDownloadPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Upload and download Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public dynamicPropertiesPage clickOnDynamicPropertiesSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(8));
            clickWithWait(deployed_element_exercises.get(8));
            return new dynamicPropertiesPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Dynamic properties Section has been not found");
            e.printStackTrace();
        }
        return null;
    }
}