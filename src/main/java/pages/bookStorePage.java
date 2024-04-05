package pages;

import testComponents.config.pageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class bookStorePage extends pageBase {
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

    public bookStorePage(WebDriver driver) {
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
        return validateResponseCodeIs200inAllAList(columnImages);
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

    public bSIBookPage searchAndClickOnATitle(String bookTitle){
        try {
            try {
                waitForChargedElementsOfAWebElementList(columnTitle);
                WebElement tryOne = driver.findElement(By.linkText(bookTitle));
                scroll(tryOne);
                clickWithWait(tryOne);
                return new bSIBookPage(driver);
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("Error on line 303 BookstorePage" + e.getMessage());
        }
        return null;
    }

    public bSLoginPage clickOnLoginTab(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(ZERO));
            clickWithWait(deployed_form_exercise.get(ZERO));
            return new bSLoginPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public bSProfilePage clickOnProfile(){
        try{
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(TWO));
            clickWithWait(deployed_form_exercise.get(TWO));
            return new bSProfilePage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }

    public bSAPIPage clickOnBookstoreApi(){
        try {
            waitForChargedElementsOfAWebElementList(deployed_form_exercise);
            scroll(deployed_form_exercise.get(THREE));
            clickWithWait(deployed_form_exercise.get(THREE));
            return new bSAPIPage(driver);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }
}