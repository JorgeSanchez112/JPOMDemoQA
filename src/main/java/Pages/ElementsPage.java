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

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public int deployedElementsSize(){
        return deployed_element_exercises.size();
    }

    public TextBoxPage clickOnTextBoxSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        clickWithWait(deployed_element_exercises.get(0));
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickOnCheckBoxSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        clickWithWait(deployed_element_exercises.get(1));
        return new CheckBoxPage(driver);
    }

    public RadioButtonPage clickOnRadioButtonSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        clickWithWait(deployed_element_exercises.get(2));
        return new RadioButtonPage(driver);
    }

    public WebTablesPage clickOnWebTablesSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        scroll(deployed_element_exercises.get(3));
        clickWithWait(deployed_element_exercises.get(3));
        return new WebTablesPage(driver);
    }

    public ButtonsPage clickOnButtonsSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        scroll(deployed_element_exercises.get(4));
        clickWithWait(deployed_element_exercises.get(4));
        return new ButtonsPage(driver);
    }

    public LinksPage clickOnLinksSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        scroll(deployed_element_exercises.get(5));
        clickWithWait(deployed_element_exercises.get(5));
        return new LinksPage(driver);
    }

    public BrokenLinksPage clickOnBrokenLinksImageSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        scroll(deployed_element_exercises.get(6));
        clickWithWait(deployed_element_exercises.get(6));
        return new BrokenLinksPage(driver);
    }

    public UploadDownloadPage clickOnUploadDownloadSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        scroll(deployed_element_exercises.get(7));
        clickWithWait(deployed_element_exercises.get(7));
        return new UploadDownloadPage(driver);
    }

    public DynamicProperties clickOnDynamicPropertiesSection(){
        waitForChargedElementsOfAWebElementList(deployed_element_exercises);
        scroll(deployed_element_exercises.get(8));
        clickWithWait(deployed_element_exercises.get(8));
        return new DynamicProperties(driver);
    }

}