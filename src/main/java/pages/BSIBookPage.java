package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSIBookPage extends PageBase {
    @FindBy(id = "login")
    private WebElement loginButton;
    @FindBy(id = "userName-label")
    private WebElement  userNameLabel;
    @FindBy(css = ".text-right > #userName-value")
    private WebElement userNameValue;
    @FindBy(id = "submit")
    private WebElement logOutButton;
    @FindBy(id = "ISBN-label")
    private WebElement isbnLabel;
    @FindBy(css = "#ISBN-wrapper >* #userName-value")
    private WebElement isbnValue;
    @FindBy(id = "title-label")
    private WebElement titleLabel;
    @FindBy(css = "#title-wrapper >* #userName-value")
    private WebElement titleValue;
    @FindBy(id = "subtitle-label")
    private WebElement subtitleLabel;
    @FindBy(css = "#subtitle-wrapper >* #userName-value")
    private WebElement subtitleValue;
    @FindBy(id = "author-label")
    private WebElement authorLabel;
    @FindBy(css = "#author-wrapper >* #userName-value")
    private WebElement authorValue;
    @FindBy(id = "publisher-label")
    private WebElement publisherLabel;
    @FindBy(css = "#publisher-wrapper >*  #userName-value")
    private WebElement publisherValue;
    @FindBy(id = "pages-label")
    private WebElement pagesLabel;
    @FindBy(css = "#pages-wrapper >* #userName-value")
    private WebElement totalPagesValue;
    @FindBy(id = "description-label")
    private WebElement descriptionLabel;
    @FindBy(css = "#description-wrapper >* #userName-value")
    private WebElement descriptionValue;
    @FindBy(id = "website-label")
    private WebElement websiteLabel;
    @FindBy(css = "#website-wrapper >* #userName-value")
    private WebElement websiteLink;
    @FindBy(css = ".text-left > #addNewRecordButton")
    private WebElement backToBookStoreButton;
    @FindBy(css = ".text-right> #addNewRecordButton")
    private WebElement addToYourCollectionButton;

    public BSIBookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnAddToYourCollectionButton(){
        scroll(addToYourCollectionButton);
        clickWithWait(addToYourCollectionButton);
        acceptAlertWithWait();
    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getUsernameValueText(){
        return getElementTextWithWait(userNameValue);
    }

    public String getIsbnValueText(){
        return getElementTextWithWait(isbnValue);
    }

    public String getTitleValueText(){
        return getElementTextWithWait(titleValue);
    }

    public String getSubTitleValueText(){
        scroll(subtitleValue);
        return getElementTextWithWait(subtitleValue);
    }

    public String getAuthorValueText(){
        scroll(authorValue);
        return getElementTextWithWait(authorValue);
    }

    public String getPublisherValueText(){
        scroll(publisherValue);
        return getElementTextWithWait(publisherValue);
    }

    public String getTotalPagesValueText(){
        return getElementTextWithWait(totalPagesValue);
    }

    public String getDescriptionValueText(){
        return getElementTextWithWait(descriptionValue);
    }

    public synchronized boolean usernameLabelIsVisible(){
        waitForVisibleElement(userNameLabel);
        return isElementDisplayedWithWait(userNameValue);
    }

    public boolean isbnLabelIsVisible(){
        waitForVisibleElement(isbnLabel);
        return isElementDisplayedWithWait(isbnLabel);
    }

    public boolean titleLabelIsVisible(){
        waitForVisibleElement(titleLabel);
        return isElementDisplayedWithWait(titleLabel);
    }

    public boolean subtitleLabelIsVisible(){
        waitForVisibleElement(subtitleLabel);
        scroll(subtitleLabel);
        return isElementDisplayedWithWait(subtitleLabel);
    }

    public boolean authorLabelIsVisible(){
        waitForVisibleElement(authorLabel);
        scroll(authorLabel);
        return isElementDisplayedWithWait(authorLabel);
    }

    public boolean publisherLabelIsVisible(){
        waitForVisibleElement(publisherLabel);
        scroll(publisherLabel);
        return isElementDisplayedWithWait(publisherLabel);
    }

    public boolean pagesLabelIsVisible(){
        waitForVisibleElement(pagesLabel);
        scroll(pagesLabel);
        return isElementDisplayedWithWait(pagesLabel);
    }

    public boolean descriptionLabelIsVisible(){
        waitForVisibleElement(descriptionLabel);
        scroll(descriptionLabel);
        return isElementDisplayedWithWait(descriptionLabel);
    }

    public boolean websiteLabelIsVisible(){
        waitForVisibleElement(websiteLabel);
        scroll(websiteLabel);
        return isElementDisplayedWithWait(websiteLabel);
    }

    public boolean logOutButtonIsVisible(){
        waitForVisibleElement(logOutButton);
        return isElementDisplayedWithWait(logOutButton);
    }

    public boolean websiteValueLinkIsVisible(){
        waitForVisibleElement(websiteLink);
        scroll(websiteLink);
        return isElementDisplayedWithWait(websiteLink);
    }

    public synchronized BSLoginPage clickOnLogin(){
        scroll(loginButton);
        clickWithWait(loginButton);
        return new BSLoginPage(driver);
    }

    public synchronized BSLoginPage clickOnLogOutButton(){
        clickWithWait(logOutButton);
        return new BSLoginPage(driver);
    }

    public synchronized BookStorePage clickOnBackToBookStoreBookButton(){
        scroll(backToBookStoreButton);
        clickWithWait(backToBookStoreButton);
        return new BookStorePage(driver);
    }

    public synchronized BookStorePage addBookAndReturnToBookStore(){
        clickOnAddToYourCollectionButton();
        return clickOnBackToBookStoreBookButton();
    }
}
