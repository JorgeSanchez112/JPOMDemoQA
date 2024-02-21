package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BSIBookPage extends BasePages {
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

    public void acceptAlertMessage(){
        driver.switchTo().alert().accept();
    }

    public void clickOnAddToYourCollectionButton(){
        scroll(addToYourCollectionButton);
        clickWithWait(addToYourCollectionButton);
        waitAlert();
        acceptAlertMessage();
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getUsernameValueText(){
        waitForVisibleElement(userNameValue);
        return userNameValue.getText();
    }

    public String getIsbnValueText(){
        waitForVisibleElement(isbnValue);
        return isbnValue.getText();
    }

    public String getTitleValueText(){
        waitForVisibleElement(titleValue);
        return titleValue.getText();
    }

    public String getSubTitleValueText(){
        waitForVisibleElement(subtitleValue);
        scroll(subtitleValue);
        return subtitleValue.getText();
    }

    public String getAuthorValueText(){
        waitForVisibleElement(authorValue);
        scroll(authorValue);
        return authorValue.getText();
    }

    public String getPublisherValueText(){
        waitForVisibleElement(publisherValue);
        scroll(publisherValue);
        return publisherValue.getText();
    }

    public String getTotalPagesValueText(){
        return totalPagesValue.getText();
    }

    public String getDescriptionValueText(){
        return descriptionValue.getText();
    }

    public boolean usernameLabelIsVisible(){
        waitForVisibleElement(userNameLabel);
        try{
            return userNameLabel.isDisplayed();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isbnLabelIsVisible(){
        waitForVisibleElement(isbnLabel);
        return isbnLabel.isDisplayed();
    }

    public boolean titleLabelIsVisible(){
        waitForVisibleElement(titleLabel);
        return titleLabel.isDisplayed();
    }

    public boolean subtitleLabelIsVisible(){
        waitForVisibleElement(subtitleLabel);
        scroll(subtitleLabel);
        return subtitleLabel.isDisplayed();
    }

    public boolean authorLabelIsVisible(){
        waitForVisibleElement(authorLabel);
        scroll(authorLabel);
        return authorLabel.isDisplayed();
    }

    public boolean publisherLabelIsVisible(){
        waitForVisibleElement(publisherLabel);
        scroll(publisherLabel);
        return publisherLabel.isDisplayed();
    }

    public boolean pagesLabelIsVisible(){
        waitForVisibleElement(pagesLabel);
        scroll(pagesLabel);
        return pagesLabel.isDisplayed();
    }

    public boolean descriptionLabelIsVisible(){
        waitForVisibleElement(descriptionLabel);
        scroll(descriptionLabel);
        return descriptionLabel.isDisplayed();
    }

    public boolean websiteLabelIsVisible(){
        waitForVisibleElement(websiteLabel);
        scroll(websiteLabel);
        return websiteLabel.isDisplayed();
    }

    public boolean logOutButtonIsVisible(){
        waitForVisibleElement(logOutButton);
        try {
            return logOutButton.isDisplayed();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean websiteValueLinkIsVisible(){
        waitForVisibleElement(websiteLink);
        scroll(websiteLink);
        return websiteLink.isDisplayed();
    }

    public BSLoginPage clickOnLogin(){
        scroll(loginButton);
        clickWithWait(loginButton);
        return new BSLoginPage(driver);
    }

    public BSLoginPage clickOnLogOutButton(){
        clickWithWait(logOutButton);
        return new BSLoginPage(driver);
    }

    public BookStorePage clickOnBackToBookStoreBookButton(){
        scroll(backToBookStoreButton);
        clickWithWait(backToBookStoreButton);
        return new BookStorePage(driver);
    }

    public BookStorePage addBookAndReturnToBookStore(){
        clickOnAddToYourCollectionButton();
        return clickOnBackToBookStoreBookButton();
    }

}
