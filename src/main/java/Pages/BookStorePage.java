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


    public BookStorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void scrollToSearchBar() {
        scroll(searchBox);
    }

    public void scrollToRow(int rowIndex){
        waitForChargedElementsOfAWebElementList(bookRow);
        if (bookRow.size() > rowIndex) {
            try {
                waitForVisibleElement(bookRow.get(rowIndex));
                scroll(bookRow.get(rowIndex));
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }



    public void scrollToSixthRow() {
        waitForChargedElementsOfAWebElementList(bookRow);
        if (bookRow.size() != 0){
            try{
                waitForVisibleElement(bookRow.get(5));
                scroll(bookRow.get(5));
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }


    }

    public void scrollToSeventhRow() {
        waitForChargedElementsOfAWebElementList(bookRow);
        if (bookRow.size() != 0){
            try{
                waitForVisibleElement(bookRow.get(6));
                scroll(bookRow.get(6));
            }catch (IndexOutOfBoundsException e){
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
        return getElementTextAccordingToPositionReceived(tableTitles,0);
    }

    public String getSecondTitleTableText() {
        waitForChargedElementsOfAWebElementList(tableTitles);
        return getElementTextAccordingToPositionReceived(tableTitles,1);
    }

    public String getThirdTitleTableText() {
        waitForChargedElementsOfAWebElementList(tableTitles);
        return getElementTextAccordingToPositionReceived(tableTitles,2);
    }

    public String getFourthTitleTableText() {
        waitForChargedElementsOfAWebElementList(tableTitles);
        return getElementTextAccordingToPositionReceived(tableTitles,3);
    }

    public String getTitleOfFirstBookText() {
        scrollToRow(0);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,0);
    }

    public String getAuthorOfFirstBookText() {
        scrollToRow(0);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,0);
    }

    public String getPublisherOfFirstBookText() {
        scrollToRow(0);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,0);
    }

    public String getTitleOfSecondBookText() {
        scrollToRow(1);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,1);
    }

    public String getAuthorOfSecondBookText() {
        scrollToRow(1);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,1);
    }

    public String getPublisherOfSecondBookText() {
        scrollToRow(1);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,1);
    }

    public String getTitleOfThirdBookText() {
        scrollToRow(2);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,2);
    }

    public String getAuthorOfThirdBookText() {
        scrollToRow(2);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,2);
    }

    public String getPublisherOfThirdBookText() {
        scrollToRow(2);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,2);
    }

    public String getTitleOfFourthBookText() {
        scrollToRow(3);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,3);
    }

    public String getAuthorOfFourthBookText() {
        scrollToRow(3);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,3);
    }

    public String getPublisherOfFourthBookText() {
        scrollToRow(3);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,3);
    }

    public String getTitleOfFifthBookText() {
        scrollToRow(4);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,4);
    }

    public String getAuthorOfFifthBookText() {
        scrollToRow(4);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,4);
    }

    public String getPublisherOfFifthBookText() {
        scrollToRow(4);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,4);
    }

    public String getTitleOfSixthBookText() {
        scrollToRow(5);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,5);
    }

    public String getAuthorOfSixthBookText() {
        scrollToRow(5);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,5);
    }

    public String getPublisherOfSixthBookText() {
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,5);
    }

    public String getTitleOfSeventhBookText() {
        scrollToRow(6);
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,6);
    }

    public String getAuthorOfSeventhBookText() {
        scrollToRow(6);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,6);
    }

    public String getPublisherOfSeventhBookText() {
        scrollToRow(6);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,6);
    }

    public String getTitleOfEighthBookText() {
        waitForChargedElementsOfAWebElementList(columnTitle);
        return getElementTextAccordingToPositionReceived(columnTitle,7);
    }

    public String getAuthorOfEighthBookText() {
        scrollToRow(7);
        waitForChargedElementsOfAWebElementList(columnAuthor);
        return getElementTextAccordingToPositionReceived(columnAuthor,7);
    }

    public String getPublisherOfEighthBookText() {
        scrollToRow(7);
        waitForChargedElementsOfAWebElementList(columnPublisher);
        return getElementTextAccordingToPositionReceived(columnPublisher,7);
    }

    public String getBookStoreUrlText(){
        return driver.getCurrentUrl();
    }

    public boolean isVisibleFirstImage() {
        scrollToRow(0);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,0);
    }

    public boolean isVisibleSecondImage() {
        scrollToRow(1);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,1);
    }

    public boolean isVisibleThirdImage() {
        scrollToRow(2);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,2);
    }

    public boolean isVisibleFourthImage() {
        scrollToRow(3);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,3);
    }

    public boolean isVisibleFifthImage() {
        scrollToRow(4);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,4);
    }

    public boolean isVisibleSixthImage() {
        scrollToRow(5);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,5);
    }

    public boolean isVisibleSeventhImage() {
        scrollToRow(6);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,6);
    }

    public boolean isVisibleEighthImage() {
        scrollToRow(6);
        waitForChargedElementsOfAWebElementList(columnImages);
        return isElementVisibleAccordingToPositionReceivedOfList(columnImages,7);
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
            WebElement tryOne = driver.findElement(By.linkText(bookTitle));
            scroll(tryOne);
            clickWithWait(tryOne);
            return new BSIBookPage(driver);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Error on line 719 BookstorePage" + e.getMessage());
            return null;
        }
    }

    public BSLoginPage clickOnLoginTab(){
        scroll(deployed_form_exercise.get(0));
        clickWithWait(deployed_form_exercise.get(0));
        return new BSLoginPage(driver);
    }

    public BSProfilePage clickOnProfile(){
        scroll(deployed_form_exercise.get(2));
        clickWithWait(deployed_form_exercise.get(2));
        return new BSProfilePage(driver);
    }

    public BSAPIPage clickOnBookstoreApi(){
        scroll(deployed_form_exercise.get(3));
        clickWithWait(deployed_form_exercise.get(3));
        return new BSAPIPage(driver);
    }
}