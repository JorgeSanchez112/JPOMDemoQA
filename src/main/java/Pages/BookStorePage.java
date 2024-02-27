package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(css = ".rt-tr > .rt-td:nth-child(1)")
    private List<WebElement> columnImages;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(2)")
    private List<WebElement> columnTitle;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(3)")
    private List<WebElement> columnAuthor;
    @FindBy(css = ".rt-tr > .rt-td:nth-child(4)")
    private List<WebElement> columnPublisher;

    final int ZERO = 0;
    final int ONE = 1;
    final int TWO = 2;
    final int THREE = 3;
    final int FOUR = 4;
    final int FIVE = 5;
    final int SIX = 6;
    final int SEVEN = 7;

    public BookStorePage(WebDriver driver) {
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
        searchBox.sendKeys(text);
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

    public String getTitleOfFirstBookText() {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,ZERO);
    }

    public String getAuthorOfFirstBookText() {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,ZERO);
    }

    public String getPublisherOfFirstBookText() {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,ZERO);
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
        return getDriver().getCurrentUrl();
    }

    public boolean isVisibleFirstImage() {
        scrollToRow(ZERO);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,ZERO);
    }

    public boolean isVisibleSecondImage() {
        scrollToRow(ONE);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,ONE);
    }

    public boolean isVisibleThirdImage() {
        scrollToRow(TWO);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,TWO);
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
            WebElement tryOne = getDriver().findElement(By.linkText(bookTitle));
            scroll(tryOne);
            clickWithWait(tryOne);
            return new BSIBookPage(getDriver());
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Error on line 303 BookstorePage" + e.getMessage());
            return null;
        }
    }

    public BSLoginPage clickOnLoginTab(){
        scroll(deployed_form_exercise.get(ZERO));
        clickWithWait(deployed_form_exercise.get(ZERO));
        return new BSLoginPage(getDriver());
    }

    public BSProfilePage clickOnProfile(){
        scroll(deployed_form_exercise.get(TWO));
        clickWithWait(deployed_form_exercise.get(TWO));
        return new BSProfilePage(getDriver());
    }

    public BSAPIPage clickOnBookstoreApi(){
        scroll(deployed_form_exercise.get(3));
        clickWithWait(deployed_form_exercise.get(3));
        return new BSAPIPage(getDriver());
    }
}