package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSAPIPage extends BasePages {
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
        return title.isDisplayed();
    }

    public boolean isAccountSubtitleVisible(){
        return accountSubtitle.isDisplayed();
    }

    public boolean isBookstoreSubtitleVisible(){
        return bookStoreSubtitle.isDisplayed();
    }
}
