package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class toolTipsPage extends pageBase {
    @FindBy(tagName = "p")
    private WebElement label;
    @FindBy(id = "toolTipButton")
    private WebElement hoverMeButton;
    @FindBy(id = "toolTipTextField")
    private WebElement hoverMeInput;
    @FindBy(css = "#texToolTopContainer > a")
    private List<WebElement> hoverLink;

    private final String ARIA_DESCRIBEDBY_ATTRIBUTE = "aria-describedby";

    public toolTipsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void moveClickerTOHoverButton(){
        final String CONTENT_ATTRIBUTE_TEXT = "buttonToolTip";

        scroll(hoverMeButton);
        moveClickerToElement(hoverMeButton);
        waitForElementAttributeToContain(hoverMeButton,ARIA_DESCRIBEDBY_ATTRIBUTE,CONTENT_ATTRIBUTE_TEXT);
    }

    public void moveClickerTOHoverInput(){
        final String CONTENT_ATTRIBUTE_TEXT = "buttonToolTip";

        scroll(hoverMeInput);
        moveClickerToElement(hoverMeInput);
        waitForElementAttributeToContain(hoverMeInput,ARIA_DESCRIBEDBY_ATTRIBUTE,CONTENT_ATTRIBUTE_TEXT);

    }

    public void moveClickerTOContraryLink(){
        final String CONTENT_ATTRIBUTE_TEXT = "buttonToolTip";

        scroll(hoverLink.get(0));
        moveClickerToElement(hoverLink.get(0));
        waitForElementAttributeToContain(hoverLink.get(0),ARIA_DESCRIBEDBY_ATTRIBUTE,CONTENT_ATTRIBUTE_TEXT);
    }

    public void moveClickerTOVersionLink(){
        final String CONTENT_ATTRIBUTE_TEXT = "buttonToolTip";

        scroll(hoverLink.get(1));
        moveClickerToElement(hoverLink.get(1));
        waitForElementAttributeToContain(hoverLink.get(1),ARIA_DESCRIBEDBY_ATTRIBUTE,CONTENT_ATTRIBUTE_TEXT);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getLabelText(){
        return getElementTextWithWait(label);
    }

    public String getTextFromButtonHoverAttribute(){
        return getElementAttribute(hoverMeButton,ARIA_DESCRIBEDBY_ATTRIBUTE);
    }

    public String getTextFromInputHoverAttribute(){
        return getElementAttribute(hoverMeInput,ARIA_DESCRIBEDBY_ATTRIBUTE);
    }

    public String getTextFromHoverContraryLinkAttribute(){
        return getElementAttribute(hoverLink.get(0),ARIA_DESCRIBEDBY_ATTRIBUTE);
    }

    public String getTextFromHoverVersionLinkAttribute(){
        return getElementAttribute(hoverLink.get(1),ARIA_DESCRIBEDBY_ATTRIBUTE);
    }
}