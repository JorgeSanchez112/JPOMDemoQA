package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage extends PageBase {
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

    public synchronized void clickOnNewTabButton(){
        clickWithWait(newTabButton);
    }

    public synchronized void clickOnNewWindowButton(){
        clickWithWait(newWindowButton);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public synchronized String getBrowserWindowsUrlText(){
        return driver.getCurrentUrl();
    }

    public synchronized boolean newTabTextIsVisible(){
        return isElementDisplayedWithWait(textTab);
    }
}
