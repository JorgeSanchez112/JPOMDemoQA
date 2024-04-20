package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class BSProfilePage extends PageBase {
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
        sendKeysToElement(searchBox,text);
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
        acceptAlertWithWait();
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

    public void addBookToTableOfBooksCollection(String bookTitle){
        clickOnGoToBookStoreButton().
                searchAndClickOnATitle(bookTitle).
                addBookAndReturnToBookStore().
                clickOnProfile();
    }

    public void deleteABook(String titleBook){
        if (isTitleInTableOfBooksCollection(titleBook)){
            clickOnIconTrash(titleBook);
            acceptDeleteAccountOrBooks();
            acceptAlertWithWait();
        }else{
            addBookToTableOfBooksCollection(titleBook);
        }
    }

    public void addAllBooksToTableOfBooksCollection(){
        String SPEAKING_JAVASCRIPT_TITLE_BOOK = "Speaking JavaScript";
        addBookToTableOfBooksCollection(SPEAKING_JAVASCRIPT_TITLE_BOOK);
        String YOU_NOT_KNOW_JS_TITLE_BOOK = "You Don't Know JS";
        addBookToTableOfBooksCollection(YOU_NOT_KNOW_JS_TITLE_BOOK);
        String PROGRAMMING_JAVASCRIPT_APPLICATIONS_TITLE_BOOK = "Programming JavaScript Applications";
        addBookToTableOfBooksCollection(PROGRAMMING_JAVASCRIPT_APPLICATIONS_TITLE_BOOK);
        String ELOQUENT_JAVASCRIPT_SECOND_EDITION_TITLE_BOOK = "Eloquent JavaScript, Second Edition";
        addBookToTableOfBooksCollection(ELOQUENT_JAVASCRIPT_SECOND_EDITION_TITLE_BOOK);
        String UNDERSTANDING_ECMASCRIPT_6_TITLE_BOOK = "Understanding ECMAScript 6";
        addBookToTableOfBooksCollection(UNDERSTANDING_ECMASCRIPT_6_TITLE_BOOK);
        String DESIGNING_EVOLVABLE_WEB_APIS_WITH_ASPNET_TITLE_BOOK = "Designing Evolvable Web APIs with ASP.NET";
        addBookToTableOfBooksCollection(DESIGNING_EVOLVABLE_WEB_APIS_WITH_ASPNET_TITLE_BOOK);
    }

    public String getBooksLabelText(){
        waitForVisibleElement(booksLabel);
        return getElementTextWithWait(booksLabel);
    }

    public String getSearchBoxPlaceholderText(){
        waitForVisibleElement(searchBox);
        return getElementAttribute(searchBox,"placeholder");
    }

    public String getUserNameLabelText(){
        waitForVisibleElement(usernameLabel);
        return getElementTextWithWait(usernameLabel);
    }

    public String getUserNameValueText(){
        waitForVisibleElement(usernameValue);
        return getElementTextWithWait(usernameValue);
    }

    public String getTableTitleImageText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        try {
            waitForVisibleElement(tableHeaderTitles.get(0));
            scroll(tableHeaderTitles.get(0));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return getElementTextWithWait(tableHeaderTitles.get(0));
    }

    public String getTableTitleTitleText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(1));
        scroll(tableHeaderTitles.get(1));
        return getElementTextWithWait(tableHeaderTitles.get(1));
    }

    public String getTableTitleAuthorText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(2));
        scroll(tableHeaderTitles.get(2));
        return getElementTextWithWait(tableHeaderTitles.get(2));
    }

    public String getTableTitlePublisherText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(3));
        scroll(tableHeaderTitles.get(3));
        return getElementTextWithWait(tableHeaderTitles.get(3));
    }

    public String getTableTitleActionText(){
        waitForChargedElementsOfAWebElementList(tableHeaderTitles);
        waitForVisibleElement(tableHeaderTitles.get(4));
        scroll(tableHeaderTitles.get(4));
        return getElementTextWithWait(tableHeaderTitles.get(4));
    }

    public String getPageText(){
        waitForVisibleElement(pageTextOfCenterTable);
        scroll(pageTextOfCenterTable);
        return getElementTextWithWait(pageTextOfCenterTable);
    }

    public String getPageNumber(){
        waitForVisibleElement(pageValue);
        return getElementAttribute(pageValue,"value");
    }

    public String getTotalOfPagesText(){
        waitForVisibleElement(totalPagesNumber);
        scroll(totalPagesNumber);
        return getElementTextWithWait(totalPagesNumber);
    }

    public int getPositionOfBookWithTheTitle(String titleBook){
        waitForChargedElementsOfAWebElementList(columnTitles);
        return getPositionOfOneElementInAList(columnTitles,titleBook);
    }

    public boolean isTitleVisible(){
        return isElementDisplayedWithWait(pageTitle);
    }

    public boolean isMessageDoNotLoginShowed(){
        return isElementDisplayedWithWait(doNotLoginMessage);
    }

    public boolean isLinkImageDoesNotBrokeInTableOfBooksCollection(String titleBook) throws IOException {
        waitForChargedElementsOfAWebElementList(columnImages);
        try {
            return validateHTTPS_Response(getElementAttribute(columnImages.get(getPositionOfBookWithTheTitle(titleBook)),"src"));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isTitleInTableOfBooksCollection(String value){
        waitForChargedElementsOfAWebElementList(columnTitles);
        return searchForVisibleElement(columnTitles,value);
    }

    public String getAuthorRegardToTitleBookText(String title){
        waitForChargedElementsOfAWebElementList(columnAuthors);
        return getElementTextWithWait(columnAuthors.get(getPositionOfBookWithTheTitle(title)));
    }

    public String getPublisherRegardToTitleBookText(String title){
        waitForChargedElementsOfAWebElementList(columnPublishers);
        return getElementTextWithWait(columnPublishers.get(getPositionOfBookWithTheTitle(title)));
    }

    public boolean isMessageNoDataVisible(){
        return isElementDisplayedWithWait(messageNoData);
    }

    public boolean isPreviousButtonEnabled(){
        scroll(previousButton);
        return isElementEnabled(previousButton);
    }

    public boolean isNextButtonEnabled(){
        waitForVisibleElement(nextButton);
        scroll(nextButton);
        return isElementEnabled(nextButton);
    }

    public BSLoginPage clickOnLoginLink(){
        clickOnSection(linkRegisterAndLogin,0);
        return new BSLoginPage(driver);
    }

    public synchronized BSRegisterPage clickOnRegisterLink(){
        clickOnSection(linkRegisterAndLogin,1);
        return new BSRegisterPage(driver);
    }

    public synchronized BSLoginPage clickOnLogOutButton(){
        waitForVisibleElement(logOutButton);
        scroll(logOutButton);
        clickWithWait(logOutButton);
        return new BSLoginPage(driver);
    }

    public synchronized BookStorePage clickOnGoToBookStoreButton(){
        waitForVisibleElement(goToBookStoreButton);
        scroll(goToBookStoreButton);
        clickWithWait(goToBookStoreButton);
        return new BookStorePage(driver);
    }

    public synchronized BSLoginPage deleteAccount(){
        clickOnDeleteAccountButton();
        acceptAlertWithWait();
        return new BSLoginPage(driver);
    }
}