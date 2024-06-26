package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends PageBase {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private WebElement deployed_form_exercise;

    public FormsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getFormsUrlText(){
        return driver.getCurrentUrl();
    }

    public String getMenuListText(){
        return getElementTextWithWait(deployed_form_exercise);
    }

    public synchronized PracticeFormPage clickOnPracticeFormSection(){
        scroll(deployed_form_exercise);
        clickWithWait(deployed_form_exercise);
        return new PracticeFormPage(driver);
    }

}
