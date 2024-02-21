package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage extends BasePages {
    @FindBy(className = "mb-3")
    private WebElement subtitle;
    @FindBy (css = "label[for='yesRadio']")
    private WebElement yesRadioButton;
    @FindBy (css = "label[for='impressiveRadio']")
    private WebElement impressiveRadioButton;
    @FindBy (id = "noRadio")
    private WebElement disabledRadioButton;
    @FindBy (css = "p.mt-3 >span")
    private WebElement responseText;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnYesRB(){
        clickWithWait(yesRadioButton);
    }

    public void clickOnImpressiveRB(){
        clickWithWait(impressiveRadioButton);
    }

    public boolean isSubtitleVisible(){
        return subtitle.isDisplayed();
    }
    public boolean isRadioButtonEnabled(){
        return disabledRadioButton.isEnabled();
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String response(){
        return responseText.getText();
    }

}
