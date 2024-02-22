package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class BSProfilePage extends BasePages {
    @FindBy(id = "notLoggin-label") //not login
    private WebElement doNotLoginMessage;
    @FindBy(css = "#notLoggin-wrapper >* a")
    private List<WebElement> linkRegisterAndLogin;
    @FindBy(css = ".text-left > #userName-label ") //logged in
    private WebElement booksLabel;
    @FindBy(id = "searchBox")
    private WebElement searchBox;
    @FindBy(css = ".text-right > #userName-label")
    private WebElement usernameLabel;
    @FindBy(id = "userName-value")
    private WebElement usernameValue;
    @FindBy(css = ".text-right.col-sm-12 > #submit")
    private WebElement logOutButton;
    @FindBy(className = "rt-th")
    private List<WebElement> tableHeaderTitles;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(1) > img")
    private List<WebElement> columnImages;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(2)")
    private List<WebElement> columnTitles;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(3)")
    private List<WebElement> columnAuthors;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(4)")
    private List<WebElement> columnPublishers;
    @FindBy(id = "delete-record-undefined")
    private List<WebElement> deleteBookIcon;
    @FindBy(className = "rt-noData")
    private WebElement messageNoData;
    @FindBy(css = ".-previous > button")
    private WebElement previousButton;
    @FindBy(css = ".-center > .-pageInfo")
    private WebElement pageTextOfCenterTable;
    @FindBy(css = ".-pageJump > input[type=number]")
    private WebElement pageValue;
    @FindBy(className = "-totalPages")
    private WebElement totalPagesNumber;
    @FindBy(css = ".-next > button")
    private WebElement nextButton;
    @FindBy(id = "gotoStore")
    private WebElement goToBookStoreButton;
    @FindBy(css = ".text-center > button")
    private WebElement deleteAccountButton;
    @FindBy(css = ".text-right.di > button")
    private WebElement deleteAllBooksButton;
    @FindBy(id = "closeSmallModal-ok")
    private WebElement okButtonOfAlertDeleteAccountAndBooks;
    @FindBy(id = "closeSmallModal-cancel")
    private WebElement cancelButtonOfAlertDeleteAccountAndBooks;

    public BSProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void typeOnSearchBox(String text){
        waitForVisibleElement(searchBox);
        searchBox.sendKeys(text);
    }

    public void clickOnPreviousButton(){
        scroll(previousButton);
        clickWithWait(previousButton);
    }

    public void clickOnNextButton(){
        scroll(nextButton);
        clickWithWait(nextButton);
    }

    public void clickOnDeleteAccountButton(){
        scroll(deleteAccountButton);
        clickWithWait(deleteAccountButton);
    }

    public void tryToDeleteAccount(){
        clickOnDeleteAccountButton();
        cancelDeleteAccountOrBooks();
    }

    public void clickOnDeleteAllBooksButton(){
        scroll(deleteAllBooksButton);
        clickWithWait(deleteAllBooksButton);
    }

    public void tryToDeleteAllBooks(){
        clickOnDeleteAllBooksButton();
        cancelDeleteAccountOrBooks();
    }

    public void deleteAllBooks(){
        clickOnDeleteAllBooksButton();
        acceptDeleteAccountOrBooks();
        acceptAlert();
    }

    public void clickOnIconTrash(String titleBook){
        scroll(deleteBookIcon.get(getPositionOfBookWithTheTitle(titleBook)));
        clickWithWait(deleteBookIcon.get(getPositionOfBookWithTheTitle(titleBook)));
    }


    public void acceptDeleteAccountOrBooks(){
        clickWithWait(okButtonOfAlertDeleteAccountAndBooks);
    }

    public void cancelDeleteAccountOrBooks(){
        clickWithWait(cancelButtonOfAlertDeleteAccountAndBooks);
    }

    public void acceptAlert(){
        waitAlert();
        driver.switchTo().alert().accept();
    }

    public void addBookToTableOfBooksCollection(String bookTitle){
        clickOnGoToBookStoreButton().searchAndClickOnATitle(bookTitle).addBookAndReturnToBookStore().clickOnProfile();
    }

    public void deleteABook(String titleBook){
        if (isTitleInTableOfBooksCollection(titleBook)){
            clickOnIconTrash(titleBook);
            acceptDeleteAccountOrBooks();
            acceptAlert();
        }else{
            addBookToTableOfBooksCollection(titleBook);
            deleteABook(titleBook);//here the method is invoking again.
        }
    }

    public void addAllBooksToTableOfBooksCollection(){
        addBookToTableOfBooksCollection("Speaking JavaScript");
        addBookToTableOfBooksCollection("You Don't Know JS");
        addBookToTableOfBooksCollection("Programming JavaScript Applications");
        addBookToTableOfBooksCollection("Eloquent JavaScript, Second Edition");
        addBookToTableOfBooksCollection("Understanding ECMAScript 6");
        addBookToTableOfBooksCollection("Designing Evolvable Web APIs with ASP.NET");
    }

    public String getBooksLabelText(){
        waitForVisibleElement(booksLabel);
        return booksLabel.getText();
    }

    public String getSearchBoxPlaceholderText(){
        waitForVisibleElement(searchBox);
        return searchBox.getAttribute("placeholder");
    }

    public String getUserNameLabelText(){
        waitForVisibleElement(usernameLabel);
        return usernameLabel.getText();
    }

    public String getUserNameValueText(){
        waitForVisibleElement(usernameValue);
        return usernameValue.getText();
    }

    public String getTableTitleImageText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(0));
        scroll(tableHeaderTitles.get(0));
        return tableHeaderTitles.get(0).getText();
    }

    public String getTableTitleTitleText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(1));
        scroll(tableHeaderTitles.get(1));
        return tableHeaderTitles.get(1).getText();
    }

    public String getTableTitleAuthorText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(2));
        scroll(tableHeaderTitles.get(2));
        return tableHeaderTitles.get(2).getText();
    }

    public String getTableTitlePublisherText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(3));
        scroll(tableHeaderTitles.get(3));
        return tableHeaderTitles.get(3).getText();
    }

    public String getTableTitleActionText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(4));
        scroll(tableHeaderTitles.get(4));
        return tableHeaderTitles.get(4).getText();
    }

    public String getPageText(){
        waitForVisibleElement(pageTextOfCenterTable);
        scroll(pageTextOfCenterTable);
        return pageTextOfCenterTable.getText();
    }

    public String getPageNumber(){
        waitForVisibleElement(pageValue);
        return pageValue.getAttribute("value");
    }

    public String getTotalOfPagesText(){
        waitForVisibleElement(totalPagesNumber);
        scroll(totalPagesNumber);
        return totalPagesNumber.getText();
    }

    public int getPositionOfBookWithTheTitle(String titleBook){
        waitForChargedElementsOfAWebElementList(columnTitles);
        return getPositionOfOneElementInAList(columnTitles,titleBook);
    }

    public boolean isTitleVisible(){
        waitForVisibleElement(pageTitle);
        return pageTitle.isDisplayed();
    }

    public boolean isMessageDoNotLoginShowed(){
        return doNotLoginMessage.isDisplayed();
    }

    public boolean isLinkImageDoesNotBrokeInTableOfBooksCollection(String titleBook) throws IOException {
        waitForChargedElementsOfAWebElementList(columnImages);
        return validateHTTPS_Response(columnImages.get(getPositionOfBookWithTheTitle(titleBook)).getAttribute("src"));
    }

    public boolean isTitleInTableOfBooksCollection(String value){
        waitForChargedElementsOfAWebElementList(columnTitles);
        return searchForVisibleElement(columnTitles,value);
    }

    public String getAuthorRegardToTitleBookText(String title){
        waitForChargedElementsOfAWebElementList(columnAuthors);
        return columnAuthors.get(getPositionOfBookWithTheTitle(title)).getText();
    }

    public String getPublisherRegardToTitleBookText(String title){
        waitForChargedElementsOfAWebElementList(columnPublishers);
        return columnPublishers.get(getPositionOfBookWithTheTitle(title)).getText();
    }

    public boolean isMessageNoDataVisible(){
        try {
            waitForVisibleElement(messageNoData);
            return messageNoData.isDisplayed();
        }catch (TimeoutException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isPreviousButtonEnabled(){
        scroll(previousButton);
        return previousButton.isEnabled();
    }

    public boolean isNextButtonEnabled(){
        waitForVisibleElement(nextButton);
        scroll(nextButton);
        return nextButton.isEnabled();
    }

    public BSLoginPage clickOnLoginLink(){
        waitForChargedElementsOfAWebElementList(linkRegisterAndLogin);
        scroll(linkRegisterAndLogin.get(0));
        clickWithWait(linkRegisterAndLogin.get(0));
        return new BSLoginPage(driver);
    }

    public BSRegisterPage clickOnRegisterLink(){
        waitForChargedElementsOfAWebElementList(linkRegisterAndLogin);
        scroll(linkRegisterAndLogin.get(1));
        clickWithWait(linkRegisterAndLogin.get(1));
        return new BSRegisterPage(driver);
    }

    public BSLoginPage clickOnLogOutButton(){
        waitForVisibleElement(logOutButton);
        scroll(logOutButton);
        clickWithWait(logOutButton);
        return new BSLoginPage(driver);
    }

    public BookStorePage clickOnGoToBookStoreButton(){
        waitForVisibleElement(goToBookStoreButton);
        scroll(goToBookStoreButton);
        clickWithWait(goToBookStoreButton);
        return new BookStorePage(driver);
    }

    public BSLoginPage deleteAccount(){
        clickOnDeleteAccountButton();
        acceptAlert();
        return new BSLoginPage(driver);
    }

}
