package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage extends BasePages {
    @FindBy(id = "tabButton")
    private WebElement newTabButton;
    @FindBy(id = "windowButton")
    private WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessageButton;
    @FindBy(id = "sampleHeading")
    private WebElement textTab;
    @FindBy(tagName = "body")
    private WebElement newMessageText;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnNewTabButton(){
        clickWithWait(newTabButton);
    }

    public void clickOnNewWindowButton(){
        clickWithWait(newWindowButton);
    }

    public void clickOnNewWindowMessageButton(){
        scroll(newWindowMessageButton);
        clickWithWait(newWindowMessageButton);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getMessageOfNewWindow(){
            return getElementTextWithWait(newMessageText);
    }

    public String getBrowserWindowsUrlText(){
        return driver.getCurrentUrl();
    }

    public boolean newTabTextIsVisible(){
        return isElementDisplayedWithWait(textTab);
    }
}