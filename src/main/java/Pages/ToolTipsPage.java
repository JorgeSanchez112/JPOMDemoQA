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
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void moveClickerTOHoverButton(){
        scroll(hoverMeButton);
        moveClickerToElement(hoverMeButton);
        waitForAttributeAriaDescribedByEqualToValue(hoverMeButton, "buttonToolTip");
    }

    public void moveClickerTOHoverInput(){
        scroll(hoverMeInput);
        moveClickerToElement(hoverMeInput);
        waitForAttributeAriaDescribedByEqualToValue(hoverMeInput, "textFieldToolTip");

    }

    public void moveClickerTOContraryLink(){
        scroll(hoverLink.get(0));
        moveClickerToElement(hoverLink.get(0));
        waitForAttributeAriaDescribedByEqualToValue(hoverLink.get(0), "contraryTexToolTip");
    }

    public void moveClickerTOVersionLink(){
        scroll(hoverLink.get(1));
        moveClickerToElement(hoverLink.get(1));
        waitForAttributeAriaDescribedByEqualToValue(hoverLink.get(1), "sectionToolTip");
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
