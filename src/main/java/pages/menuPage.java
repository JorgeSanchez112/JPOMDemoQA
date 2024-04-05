package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class menuPage extends pageBase {
    @FindBy(css = "#nav > li > a")
    private List<WebElement> mainMenus;
    @FindBy(css = "a ~ ul > li > a")
    private List<WebElement> subMenus;

    public menuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void moveClickerToMainItem2(){
        waitForChargedElementsOfAWebElementList(mainMenus);
        scroll(mainMenus.get(1));
        moveClickerToElement(mainMenus.get(1));
    }

    public void moveClickerToSubSubList(){
        waitForChargedElementsOfAWebElementList(subMenus);
        moveClickerToElement(subMenus.get(2));
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public boolean isMainItem1Displayed(){
        waitForChargedElementsOfAWebElementList(mainMenus);
        return isElementDisplayedWithWait(mainMenus.get(0));
    }

    public boolean isMainItem2Displayed(){
        waitForChargedElementsOfAWebElementList(mainMenus);
        return isElementDisplayedWithWait(mainMenus.get(1));
    }

    public boolean isMainItem3Displayed(){
        waitForChargedElementsOfAWebElementList(mainMenus);
        return isElementDisplayedWithWait(mainMenus.get(2));
    }

    public boolean isSubItem1Displayed(){
        waitForChargedElementsOfAWebElementList(subMenus);
        return isElementDisplayedWithWait(subMenus.get(0));
    }

    public boolean isSubItem2Displayed(){
        waitForChargedElementsOfAWebElementList(subMenus);
        return isElementDisplayedWithWait(subMenus.get(1));
    }

    public boolean isSubSubListDisplayed(){
        waitForChargedElementsOfAWebElementList(subMenus);
        return isElementDisplayedWithWait(subMenus.get(2));
    }

    public boolean isSubSubItem1Displayed(){
        waitForChargedElementsOfAWebElementList(subMenus);
        return isElementDisplayedWithWait(subMenus.get(3));
    }

    public boolean isSubSubItem2Displayed(){
        waitForChargedElementsOfAWebElementList(subMenus);
        return isElementDisplayedWithWait(subMenus.get(4));
    }

}
