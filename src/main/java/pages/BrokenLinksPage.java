package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class BrokenLinksPage extends PageBase {
    @FindBy (css = ".col-md-6 > div:nth-child(2) > img")
    private List<WebElement> images;
    @FindBy (tagName = "a")
    private List<WebElement> links;

    private final String SRC_ATTRIBUTE = "src";
    private final String HREF_ATTRIBUTE = "href";

    public BrokenLinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public boolean isDisplayedValidImage() throws IOException {
        return validateHTTPS_Response(images.get(0).getAttribute(SRC_ATTRIBUTE));
    }

    public boolean isDisplayedBrokenImage() throws IOException {
        return validateHTTPS_Response(images.get(1).getAttribute(SRC_ATTRIBUTE));
    }

    public boolean isAValidLink() throws IOException {
        return validateHTTPS_Response(links.get(2).getAttribute(HREF_ATTRIBUTE));
    }

    public boolean isABrokenLink() throws IOException {
        return validateHTTPS_Response(links.get(3).getAttribute(HREF_ATTRIBUTE));
    }

}
