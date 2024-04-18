package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertiesPage extends PageBase {
    @FindBy(css = "div.col-md-6 > div > p")
    private WebElement randomIdText;
    @FindBy(id = "enableAfter")
    private WebElement willEnableButton;
    @FindBy(id = "colorChange")
    private WebElement colorChangeButton;
    @FindBy(id = "visibleAfter")
    private WebElement visibleAfterButton;

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isRandomIdVisible(){
        return isElementDisplayedWithWait(randomIdText);
    }

    public boolean isButtonEnable() {
        waitForClick(willEnableButton);
        return isElementEnabled(willEnableButton);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getButtonTextColor(){
        final String COLOR_ATTRIBUTE = "color";
        final String RGBA_RED_COLOR = "rgba(220, 53, 69, 1)";

        waitForElementAttributeToContain(colorChangeButton,COLOR_ATTRIBUTE,RGBA_RED_COLOR);
        return getElementCssValue(colorChangeButton,COLOR_ATTRIBUTE);
    }

    public boolean buttonIsVisible(){
        waitForVisibleElement(visibleAfterButton);
        return isElementDisplayedWithWait(visibleAfterButton);
    }

}
