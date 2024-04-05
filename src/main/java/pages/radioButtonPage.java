package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class radioButtonPage extends pageBase {
    @FindBy(className = "mb-3")
    private WebElement subtitle;
    @FindBy (css = "label[for='yesRadio']")
    private WebElement yesRadioButton;
    @FindBy (css = "label[for='impressiveRadio']")
    private WebElement impressiveRadioButton;
    @FindBy (id = "noRadio")
    private WebElement disabledRadioButton;
    @FindBy (css = "label[for='noRadio']")
    private WebElement noRadioButtonLabel;
    @FindBy (css = "p.mt-3 >span")
    private WebElement responseText;

    public radioButtonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnYesRB(){
        scroll(yesRadioButton);
        clickWithWait(yesRadioButton);
    }

    public void clickOnImpressiveRB(){
        scroll(impressiveRadioButton);
        clickWithWait(impressiveRadioButton);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getYesLabelText(){
        return getElementTextWithWait(yesRadioButton);
    }

    public String getImpressiveLabelText(){
        return getElementTextWithWait(impressiveRadioButton);
    }

    public String getNoLabelText(){
        return getElementTextWithWait(noRadioButtonLabel);
    }

    public String response(){
        return getElementTextWithWait(responseText);
    }

    public boolean isSubtitleVisible(){
        return isElementDisplayedWithWait(subtitle);
    }

    public boolean isRadioButtonEnabled(){
        return disabledRadioButton.isEnabled();
    }
}