package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindows extends BasePages {
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

    public BrowserWindows(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    final String URLOFNEWTAB = "https://demoqa.com/sample";


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
        return pageTitle.getText();
    }

    public String getMessageOfNewWindow(){
            waitForVisibleElement(newMessageText);
            return newMessageText.getText();
    }

    public String getBrowserWindowsUrlText(){
        return driver.getCurrentUrl();
    }

    public String getUrlOfNewTabAndWindow(){
        return URLOFNEWTAB;
    }

    public boolean newTabTextIsVisible(){
        return textTab.isDisplayed();
    }

}
