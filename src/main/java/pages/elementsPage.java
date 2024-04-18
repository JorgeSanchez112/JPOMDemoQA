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

    public TextBoxPage clickOnTextBoxSection(){
        clickOnSection(deployed_element_exercises,0);
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickOnCheckBoxSection(){
        clickOnSection(deployed_element_exercises,1);
        return new CheckBoxPage(driver);
    }

    public RadioButtonPage clickOnRadioButtonSection(){
        clickOnSection(deployed_element_exercises,2);
        return new RadioButtonPage(driver);
    }

    public WebTablesPage clickOnWebTablesSection(){
        clickOnSection(deployed_element_exercises,3);
        return new WebTablesPage(driver);
    }

    public ButtonsPage clickOnButtonsSection(){
        clickOnSection(deployed_element_exercises,4);
        return new ButtonsPage(driver);
    }

    public LinksPage clickOnLinksSection(){
        clickOnSection(deployed_element_exercises,5);
        return new LinksPage(driver);
    }

    public BrokenLinksPage clickOnBrokenLinksImageSection(){
        clickOnSection(deployed_element_exercises,6);
        return new BrokenLinksPage(driver);
    }

    public UploadDownloadPage clickOnUploadDownloadSection(){
        clickOnSection(deployed_element_exercises,7);
        return new UploadDownloadPage(driver);
    }

    public DynamicPropertiesPage clickOnDynamicPropertiesSection() {
        clickOnSection(deployed_element_exercises, 8);
        return new DynamicPropertiesPage(driver);
    }
}