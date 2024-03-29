package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TabsPage extends BasePages {
    @FindBy(className = "mb-3")
    private WebElement subTitle;
    @FindBy(id = "demo-tab-what")
    private WebElement tabWhat;
    @FindBy(id = "demo-tabpane-what")
    private WebElement paragraphOfWhat;
    @FindBy(id = "demo-tab-origin")
    private WebElement tabOrigin;
    @FindBy(css = "#demo-tabpane-origin > p")
    private List<WebElement> paragraphsOfOrigin;
    @FindBy(id = "demo-tab-use")
    private WebElement tabUse;
    @FindBy(id = "demo-tabpane-use")
    private WebElement paragraphOfUse;
    @FindBy(id = "demo-tab-more")
    private WebElement tabMore;

    public TabsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnTabOrigin(){
        scroll(tabOrigin);
        clickWithWait(tabOrigin);
    }

    public void clickOnTabUse(){
        scroll(tabUse);
        clickWithWait(tabUse);
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getFirstTitleTab(){
        return getElementTextWithWait(tabWhat);
    }

    public String getSecondTitleTab(){
        return getElementTextWithWait(tabOrigin);
    }

    public String getThirdTitleTab(){
        return getElementTextWithWait(tabUse);
    }

    public String getParagraphOfWhatText(){
        return getElementTextWithWait(paragraphOfWhat);
    }

    public String getFirstParagraphsOfOriginText(){
        return getElementTextWithWait(paragraphsOfOrigin.get(0));
    }

    public String getSecondParagraphsOfOriginText(){
        return getElementTextWithWait(paragraphsOfOrigin.get(1));
    }

    public String getParagraphOfUseText(){
        return getElementTextWithWait(paragraphOfUse);
    }

    public boolean isMoreTabEnabled(){
        return isElementEnabled(tabMore);
    }

    public boolean isSubTitleDisplayed(){
        return isElementDisplayedWithWait(subTitle);
    }
}
