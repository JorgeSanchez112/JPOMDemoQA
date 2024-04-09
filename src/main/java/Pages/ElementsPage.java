package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends PageBase {
    @FindBy (css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_element_exercises;

    protected ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getElementUrlText(){
        return driver.getCurrentUrl();
    }

    public int deployedElementsSize(){
        return deployed_element_exercises.size();
    }

    public TextBoxPage clickOnTextBoxSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(0));
            clickWithWait(deployed_element_exercises.get(0));
            return new TextBoxPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Text Box Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public CheckBoxPage clickOnCheckBoxSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(1));
            clickWithWait(deployed_element_exercises.get(1));
            return new CheckBoxPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Check Box Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public RadioButtonPage clickOnRadioButtonSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(2));
            clickWithWait(deployed_element_exercises.get(2));
            return new RadioButtonPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Radio Button Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public WebTablesPage clickOnWebTablesSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(3));
            clickWithWait(deployed_element_exercises.get(3));
            return new WebTablesPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Web Table Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public ButtonsPage clickOnButtonsSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(4));
            clickWithWait(deployed_element_exercises.get(4));
            return new ButtonsPage(driver);
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Buttons Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public LinksPage clickOnLinksSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(5));
            clickWithWait(deployed_element_exercises.get(5));
            return new LinksPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Links Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public BrokenLinksPage clickOnBrokenLinksImageSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(6));
            clickWithWait(deployed_element_exercises.get(6));
            return new BrokenLinksPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Broken Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public UploadDownloadPage clickOnUploadDownloadSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(7));
            clickWithWait(deployed_element_exercises.get(7));
            return new UploadDownloadPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Upload and download Section has been not found");
            e.printStackTrace();
        }
        return null;
    }

    public DynamicPropertiesPage clickOnDynamicPropertiesSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(8));
            clickWithWait(deployed_element_exercises.get(8));
            return new DynamicPropertiesPage(driver);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Dynamic properties Section has been not found");
            e.printStackTrace();
        }
        return null;
    }
}