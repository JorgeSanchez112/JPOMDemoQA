package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ToolTipsPage extends BasePages {
    @FindBy(tagName = "p")
    private WebElement label;
    @FindBy(id = "toolTipButton")
    private WebElement hoverMeButton;
    @FindBy(id = "toolTipTextField")
    private WebElement hoverMeInput;
    @FindBy(css = "#texToolTopContainer > a")
    private List<WebElement> hoverLink;

    public ToolTipsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    private final String ARIA_DESCRIBEDBY_ATTRIBUTE = "aria-describedby";

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
        return pageTitle.getText();
    }

    public String getLabelText(){
        return label.getText();
    }

    public String getTextFromButtonHoverAttribute(){
        return hoverMeButton.getAttribute("aria-describedby");
    }

    public String getTextFromInputHoverAttribute(){
        return hoverMeInput.getAttribute("aria-describedby");
    }

    public String getTextFromHoverContraryLinkAttribute(){
        return hoverLink.get(0).getAttribute("aria-describedby");
    }

    public String getTextFromHoverVersionLinkAttribute(){
        return hoverLink.get(1).getAttribute("aria-describedby");
    }

}
