package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BasePages {
    @FindBy(linkText = "Home")
    private WebElement  linkToHomePage;
    @FindBy(css = "#linkWrapper > P:nth-child(3) > a")
    private WebElement secondLinkToHomePage;
    @FindBy(id = "created")
    private WebElement http201;
    @FindBy(linkText = "No Content")
    private WebElement http204;
    @FindBy(linkText = "Moved")
    private WebElement http301;
    @FindBy(linkText = "Bad Request")
    private WebElement http400;
    @FindBy(linkText = "Unauthorized")
    private WebElement http401;
    @FindBy(linkText = "Forbidden")
    private WebElement http403;
    @FindBy(linkText = "Not Found")
    private WebElement http404;
    @FindBy(css = "#linkResponse > b:nth-child(1)")
    private WebElement httpMessage;
    @FindBy(css = "#linkResponse > b:nth-child(2)")
    private WebElement linkMessage;

    public LinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    final String HREF_ATTRIBUTE = "href";

    public void clickOnCreatedLink(){
        scroll(http201);
        clickWithWait(http201);
    }

    public void clickOnNoContentLink(){
        scroll(http204);
        clickWithWait(http204);
    }

    public void clickOnMovedLink(){
        scroll(http301);
        clickWithWait(http301);
    }

    public void clickOnBadRequestLink(){
        scroll(http400);
        clickWithWait(http400);
    }

    public void clickOnUnauthorizedLink(){
        scroll(http401);
        clickWithWait(http401);
    }

    public void clickOnForbiddenLink(){
        scroll(http403);
        clickWithWait(http403);
    }

    public void clickOnNotFoundLink(){
        scroll(http404);
        clickWithWait(http404);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getHrefOfHomeLink(){
        return getElementAttribute(linkToHomePage,HREF_ATTRIBUTE);
    }

    public String getHrefOfHomeETgEzLink(){
        scroll(secondLinkToHomePage);
        return getElementAttribute(secondLinkToHomePage,HREF_ATTRIBUTE);
    }

    public String getHttpMessage() {
        scroll(httpMessage);
        return getElementTextWithWait(httpMessage);
    }

    public String getNameLinkMessage(){
        scroll(linkMessage);
        return getElementTextWithWait(linkMessage);
    }
}