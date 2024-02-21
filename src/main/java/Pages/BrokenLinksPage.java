package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class BrokenLinksPage extends BasePages {
    @FindBy (css = ".col-md-6 > div:nth-child(2) > img")
    private List<WebElement> images;
    @FindBy (tagName = "a")
    private List<WebElement> links;

    public BrokenLinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public boolean isDisplayedValidImage() throws IOException {
        return validateHTTPS_Response(images.get(0).getAttribute("src"));
    }

    public boolean isDisplayedBrokenImage() throws IOException {
        return validateHTTPS_Response(images.get(1).getAttribute("src"));
    }

    public boolean isAValidLink() throws IOException {
        return validateHTTPS_Response(links.get(2).getAttribute("href"));
    }

    public boolean isABrokenLink() throws IOException {
        return validateHTTPS_Response(links.get(3).getAttribute("href"));
    }

}
