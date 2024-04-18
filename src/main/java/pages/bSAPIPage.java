package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSAPIPage extends PageBase {
    @FindBy(className = "title")
    WebElement title;
    @FindBy(id = "operations-tag-Account")
    WebElement accountSubtitle;
    @FindBy(id = "operations-tag-BookStore")
    WebElement bookStoreSubtitle;

    public BSAPIPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isTitleVisible(){
        waitForVisibleElement(title);
        return isElementDisplayedWithWait(title);
    }

    public boolean isAccountSubtitleVisible(){
        return isElementDisplayedWithWait(accountSubtitle);
    }

    public boolean isBookstoreSubtitleVisible(){
        waitForVisibleElement(bookStoreSubtitle);
        return isElementDisplayedWithWait(bookStoreSubtitle);
    }
}