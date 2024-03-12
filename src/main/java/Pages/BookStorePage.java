package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class BookStorePage extends BasePages {
    @FindBy(css = ".collapse.show > .menu-list > *")
    private List<WebElement> deployed_form_exercise;
    @FindBy(id = "searchBox")
    private WebElement searchBox;
    @FindBy(css = ".-header >* > .rt-th")
    private List<WebElement> tableTitles;
    @FindBy(className = "rt-tr-group")
    private List<WebElement> bookRow;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(1) > img")
    private List<WebElement> columnImages;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(2)")
    private List<WebElement> columnTitle;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(3)")
    private List<WebElement> columnAuthor;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(4)")
    private List<WebElement> columnPublisher;

    private final int ZERO = 0;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int SIX = 6;
    private final int SEVEN = 7;

    public BookStorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void scrollToSearchBar() {
        scroll(searchBox);
    }

    public void scrollToRow(int rowIndex){
        waitForChargedElementsOfAWebElementList(bookRow);
        if (bookRow.size() >= rowIndex) {
            try {
                waitForVisibleElement(bookRow.get(rowIndex));
                scroll(bookRow.get(rowIndex));
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public void typeOnSearchBar(String text){
        sendKeysToElement(searchBox,text);
    }

    public String getSearchBarPlaceholderText(){
        return searchBox.getAttribute("placeholder");
    }

    public String getFirstTitleTableText() {
        waitForChargedElementsOfAWebElementList(tableTitles);
        return getElementTextAccordingToPositionReceived(tableTitles,ZERO);
    }

    public String getSecondTitleTableText() {
        waitForChargedElementsOfAWebElementList(tableTitles);
        return getElementTextAccordingToPositionReceived(tableTitles,ONE);
    }

    public String getThirdTitleTableText() {
        waitForChargedElementsOfAWebElementList(tableTitles);
        return getElementTextAccordingToPositionReceived(tableTitles,TWO);
    }

    public String getFourthTitleTableText() {
        waitForChargedElementsOfAWebElementList(tableTitles);
        return getElementTextAccordingToPositionReceived(tableTitles,THREE);
    }

    public String getTitleBookText(String title) {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,getPositionOfOneElementInAList(columnTitle,title));
    }

    public String getBookAuthorText(String title) {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,getPositionOfOneElementInAList(columnTitle,title));// First searches for the book title and then returns the respective author
    }

    public String getBookPublisherText(String title) {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,getPositionOfOneElementInAList(columnTitle,title));
    }

    public String getTitleOfSecondBookText() {
        scrollToRow(ONE);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,ONE);
    }

    public String getAuthorOfSecondBookText() {
        scrollToRow(ONE);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,ONE);
    }

    public String getPublisherOfSecondBookText() {
        scrollToRow(ONE);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,ONE);
    }

    public String getTitleOfThirdBookText() {
        scrollToRow(TWO);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,TWO);
    }

    public String getAuthorOfThirdBookText() {
        scrollToRow(TWO);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,TWO);
    }

    public String getPublisherOfThirdBookText() {
        scrollToRow(TWO);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,TWO);
    }

    public String getTitleOfFourthBookText() {
        scrollToRow(THREE);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,THREE);
    }

    public String getAuthorOfFourthBookText() {
        scrollToRow(THREE);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,THREE);
    }

    public String getPublisherOfFourthBookText() {
        scrollToRow(THREE);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,THREE);
    }

    public String getTitleOfFifthBookText() {
        scrollToRow(FOUR);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,FOUR);
    }

    public String getAuthorOfFifthBookText() {
        scrollToRow(FOUR);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,FOUR);
    }

    public String getPublisherOfFifthBookText() {
        scrollToRow(FOUR);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,FOUR);
    }

    public String getTitleOfSixthBookText() {
        scrollToRow(FIVE);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,FIVE);
    }

    public String getAuthorOfSixthBookText() {
        scrollToRow(FIVE);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,FIVE);
    }

    public String getPublisherOfSixthBookText() {
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,FIVE);
    }

    public String getTitleOfSeventhBookText() {
        scrollToRow(SIX);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,SIX);
    }

    public String getAuthorOfSeventhBookText() {
        scrollToRow(SIX);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,SIX);
    }

    public String getPublisherOfSeventhBookText() {
        scrollToRow(SIX);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,SIX);
    }

    public String getTitleOfEighthBookText() {
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,SEVEN);
    }

    public String getAuthorOfEighthBookText() {
        scrollToRow(SEVEN);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,SEVEN);
    }

    public String getPublisherOfEighthBookText() {
        scrollToRow(SEVEN);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,SEVEN);
    }

    public String getBookStoreUrlText(){
        return driver.getCurrentUrl();
    }

    public boolean isVisibleFirstImage() {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,ZERO);
    }

    public boolean areTheImagesVisible() {
        scrollToRow(ONE);
        waitForChargedElementsOfAWebElementList(columnImages);
        return validateAllListItemsAreVisible(columnImages);
    }

    public boolean areNotBrokeLinkImages() throws IOException {
        scrollToRow(ONE);
        waitForChargedElementsOfAWebElementList(columnImages);
        return validateResponseCodeIs200inAList(columnImages);
    }

    public boolean isVisibleFourthImage() {
        scrollToRow(THREE);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,THREE);
    }

    public boolean isVisibleFifthImage() {
        scrollToRow(FOUR);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,FOUR);
    }

    public boolean isVisibleSixthImage() {
        scrollToRow(FIVE);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,FIVE);
    }

    public boolean isVisibleSeventhImage() {
        scrollToRow(SIX);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,SIX);
    }

    public boolean isVisibleEighthImage() {
        scrollToRow(SIX);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,SEVEN);
    }

    public boolean isBookTitleFound(String bookTitle, String textExpected){
        String regex = ".*"+textExpected+".*";
        if (bookTitle.matches(regex)){
            return true;
        }else {
            System.out.println("book doesn't exist");
            return false;
        }
    }

    public int getSizeSections(){
        return deployed_form_exercise.size();
    }

    public BSIBookPage searchAndClickOnATitle(String bookTitle){
        waitForChargedElementsOfAWebElementList(columnTitle);
        try {
            try {
                WebElement tryOne = driver.findElement(By.linkText(bookTitle));
                scroll(tryOne);
                clickWithWait(tryOne);
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Error on line 303 BookstorePage" + e.getMessage());
        }
        return new BSIBookPage(driver);
    }

    public BSLoginPage clickOnLoginTab(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        try{
            scroll(deployed_form_exercise.get(ZERO));
            clickWithWait(deployed_form_exercise.get(ZERO));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new BSLoginPage(driver);
    }

    public BSProfilePage clickOnProfile(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        try{
            scroll(deployed_form_exercise.get(TWO));
            clickWithWait(deployed_form_exercise.get(TWO));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new BSProfilePage(driver);
    }

    public BSAPIPage clickOnBookstoreApi(){
        waitForChargedElementsOfAWebElementList(deployed_form_exercise);
        try {
            scroll(deployed_form_exercise.get(THREE));
            clickWithWait(deployed_form_exercise.get(THREE));
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return new BSAPIPage(driver);
    }
}