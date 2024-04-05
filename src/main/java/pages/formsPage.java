package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class formsPage extends pageBase {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private WebElement deployed_form_exercise;

    public formsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getFormsUrlText(){
        return driver.getCurrentUrl();
    }

    public String getMenuListText(){
        return getElementTextWithWait(deployed_form_exercise);
    }

    public practiceFormPage clickOnPracticeFormSection(){
        scroll(deployed_form_exercise);
        clickWithWait(deployed_form_exercise);
        return new practiceFormPage(driver);
    }

}
