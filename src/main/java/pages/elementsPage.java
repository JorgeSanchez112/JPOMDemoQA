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

    public TextBoxPage clickOnTextBoxSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,0);
        return new TextBoxPage(driver1);
    }

    public CheckBoxPage clickOnCheckBoxSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,1);
        return new CheckBoxPage(driver1);
    }

    public RadioButtonPage clickOnRadioButtonSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,2);
        return new RadioButtonPage(driver1);
    }

    public WebTablesPage clickOnWebTablesSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,3);
        return new WebTablesPage(driver1);
    }

    public ButtonsPage clickOnButtonsSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,4);
        return new ButtonsPage(driver1);
    }

    public LinksPage clickOnLinksSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,5);
        return new LinksPage(driver1);
    }

    public BrokenLinksPage clickOnBrokenLinksImageSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,6);
        return new BrokenLinksPage(driver1);
    }

    public UploadDownloadPage clickOnUploadDownloadSection(WebDriver driver1){
        clickOnSection(deployed_element_exercises,7);
        return new UploadDownloadPage(driver1);
    }

    public DynamicPropertiesPage clickOnDynamicPropertiesSection(WebDriver driver1) {
        clickOnSection(deployed_element_exercises, 8);
        return new DynamicPropertiesPage(driver1);
    }
}