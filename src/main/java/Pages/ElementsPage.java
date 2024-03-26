package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends BasePages {
    @FindBy (css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_element_exercises;

    public ElementsPage(WebDriver driver) {
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
        }catch (IndexOutOfBoundsException e){
            System.out.println("Text Box Section has been not found");
            e.printStackTrace();
        }
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickOnCheckBoxSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(1));
            clickWithWait(deployed_element_exercises.get(1));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Check Box Section has been not found");
            e.printStackTrace();
        }
        return new CheckBoxPage(driver);
    }

    public RadioButtonPage clickOnRadioButtonSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(2));
            clickWithWait(deployed_element_exercises.get(2));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Radio Button Section has been not found");
            e.printStackTrace();
        }
        return new RadioButtonPage(driver);
    }

    public WebTablesPage clickOnWebTablesSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(3));
            clickWithWait(deployed_element_exercises.get(3));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Web Table Section has been not found");
            e.printStackTrace();
        }
        return new WebTablesPage(driver);
    }

    public ButtonsPage clickOnButtonsSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(4));
            clickWithWait(deployed_element_exercises.get(4));
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Buttons Section has been not found");
            e.printStackTrace();
        }
        return new ButtonsPage(driver);
    }

    public LinksPage clickOnLinksSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(5));
            clickWithWait(deployed_element_exercises.get(5));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Links Section has been not found");
            e.printStackTrace();
        }
        return new LinksPage(driver);
    }

    public BrokenLinksPage clickOnBrokenLinksImageSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(6));
            clickWithWait(deployed_element_exercises.get(6));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Broken Section has been not found");
            e.printStackTrace();
        }
        return new BrokenLinksPage(driver);
    }

    public UploadDownloadPage clickOnUploadDownloadSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(7));
            clickWithWait(deployed_element_exercises.get(7));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Upload and download Section has been not found");
            e.printStackTrace();
        }
        return new UploadDownloadPage(driver);
    }

    public DynamicPropertiesPage clickOnDynamicPropertiesSection(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_element_exercises);
            scroll(deployed_element_exercises.get(8));
            clickWithWait(deployed_element_exercises.get(8));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Dynamic properties Section has been not found");
            e.printStackTrace();
        }
        return new DynamicPropertiesPage(driver);
    }

}