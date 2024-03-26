package TestComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePages {
    private static final Logger logger = LogManager.getLogger();

    @FindBy(className = "text-center")
    protected WebElement pageTitle;
    @FindBy(id = "RightSide_Advertisement")
    protected WebElement rightSidePublicity;
    protected WebDriver driver ;

    public BasePages(WebDriver driver) {
        this.driver = driver;
    }

    private final String MESSAGE_TO_NO_ALERT_PRESENT_EXCEPTION = "NoAlertPresentException: No alert present to accept";
    private final String MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION = "NoSuchElementException: Element can not be found";
    private final String MESSAGE_TO_WEB_DRIVER_EXCEPTION = "WebDriverException: An unexpected error occurred while interacting with the WebDriver. This could be due to various reasons such as network issues, browser compatibility issues, or invalid WebDriver configurations.";
    private final String MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION = "IndexOutOfBoundsException: The operation encountered an IndexOutOfBoundsException, indicating an attempt to access or manipulate an element at an invalid index position within a collection or array.";
    private final String MESSAGE_NUMBER_FORMAT_EXCEPTION = "NumberFormatException: Method expects a string representation of a numeric value, but the provided string is not formatted as a valid number.";
    private final String MESSAGE_ELEMENT_NOT_INTERACTABLE_EXCEPTION = "ElementNotInteractableException: Possible causes include elements being hidden, disabled, overlapped by other elements, or located outside the viewport.";
    private final String MESSAGE_MOVE_TARGET_OUT_OF_BOUNDS_EXCEPTION = "MoveTargetOutOfBoundsException: MoveTargetOutOfBoundsException occurred, indicating that the target element cannot be moved to the specified coordinates.";
    private final String MESSAGE_TO_TIME_OUT_EXCEPTION = "TimeOutException: The presence of a web element or the completion of an action, does not occur within the specified time frame.";

    public void acceptAlertWithWait(){
        waitAlert();
        try {
            driver.switchTo().alert().accept();
        }catch (NoAlertPresentException e){
            handleException(MESSAGE_TO_NO_ALERT_PRESENT_EXCEPTION, e);
        }
    }

    public void dismissAlertWithWait(){
        waitAlert();
        try{
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            handleException(MESSAGE_TO_NO_ALERT_PRESENT_EXCEPTION,e);
        }
    }

    public void pressEnterKey(WebElement driver){
        driver.sendKeys(Keys.ENTER);
    }

    public void scroll(WebElement element){
        try{
            try {
                try{
                    waitForVisibleElement(element);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                }catch (NoSuchElementException e){
                    handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
                }
            }catch (IndexOutOfBoundsException e){
                handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    public void hidePublicity(WebElement element){
        waitForVisibleElement(element);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", element);
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    public void sendKeysToElement(WebElement input,String text){
        try {
            input.sendKeys(text);
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    public void waitForClick(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    public void waitForElementAttributeToContain(WebElement element, String attribute, String expectedValue) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.attributeContains(element, attribute, expectedValue));
        } catch (TimeoutException e) {
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
    }

    public void waitForEnableElement(WebElement element){
        try {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(element));
            }catch (TimeoutException e){
                handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
            }
        }catch (NoSuchElementException e){
            handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
        }
    }

    public void waitForVisibleElement(WebElement element){
        try{
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(element));
            }catch (NoSuchElementException e){
                handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
            }
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
    }

    public void selectOneElementAccordingToText(WebElement options,String elementText){
        Select select = new Select(options);
        try{
            select.selectByVisibleText(elementText);
        }catch (NoSuchElementException e){
            handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION + "The element Text should contain the same value that the option",e);
        }
    }

    public String getElementTextAccordingToPositionReceived(List<WebElement> elements,int position){
        if (elements.size() != 0){
            try{
                scroll(elements.get(position));
                return elements.get(position).getText();
            }catch (IndexOutOfBoundsException e){
                handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }
        return "";
    }

    public String getElementTextWithWait(WebElement element){
        try {
            waitForVisibleElement(element);
            return element.getText();
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return "";
    }

    public String getElementAttribute(WebElement element, String attribute){
        try {
            return element.getAttribute(attribute);
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return "";
    }

    public String deleteAllLetters(String textWithLetters){
        return textWithLetters.replaceAll("[a-zA-Z]","");
    }

    public String changeFormatOfStringToReturnTextWithoutValueTypeFloat(String textToChangeFormat){
        try {
            return String.format("%.0f", Double.parseDouble(deleteAllLetters(textToChangeFormat)));
        }catch (NumberFormatException e){
            handleException(MESSAGE_NUMBER_FORMAT_EXCEPTION,e);
        }
        return "";
    }

    public String getElementCssValue(WebElement element, String propertyName){
        try {
            return element.getCssValue(propertyName);
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return "";
    }

    public boolean hasElementBeenSelected(WebElement element){
        try {
            try{
                return element.isSelected();
            }catch (IndexOutOfBoundsException e){
                handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return false;
    }

    public boolean isElementEnabledWithEnableWait(WebElement element){
        try {
            waitForEnableElement(element);
            return element.isEnabled();
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return false;
    }

    public boolean isElementDisplayedWithWait(WebElement element){
        try {
            waitForVisibleElement(element);
            return element.isDisplayed();
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return false;
    }

    public boolean isElementVisibleAccordingToPositionReceivedOfList(List<WebElement> elements, int position){
        if (elements.size() != 0){
            try{
                scroll(elements.get(position));
                return isElementDisplayedWithWait(elements.get(position));
            }catch (IndexOutOfBoundsException e){
                handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }
        return false;
    }

    public void waitForChargedElementsOfAWebElementList(List<WebElement> elementsList){
        String MESSAGE_TO_REJECTED_EXECUTION_EXCEPTION = "RejectedExecutionException occurred, indicating that a task submission to an executor has been rejected for execution.";

        try {
            try {
                try {
                    try {
                        FluentWait wait = new FluentWait(driver);
                        wait.withTimeout(Duration.ofSeconds(10));
                        wait.pollingEvery(Duration.ofMillis(250));
                        wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
                    }catch (RejectedExecutionException e){
                        handleException(MESSAGE_TO_REJECTED_EXECUTION_EXCEPTION,e);
                    }
                }catch (IndexOutOfBoundsException e){
                    handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
                }
            }catch (NoSuchElementException e){
                handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
            }
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    public void waitAlert(){
        try {
            try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
                wait.until(ExpectedConditions.alertIsPresent());
            }catch (NoSuchElementException e){
                handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
            }
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }

    }

    public void clickWithWait(WebElement element){
        String MESSAGE_TO_ELEMENT_CLICK_INTERCEPTED_EXCEPTION = "Element has been intercepted, possibly other element no allowed the correct click";

        try {
            try {
                waitForClick(element);
                element.click();
            }catch (ElementClickInterceptedException e){
                handleException(MESSAGE_TO_ELEMENT_CLICK_INTERCEPTED_EXCEPTION,e);
            }
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    public void switchToTab(){
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public boolean isListItemSelected(WebElement listItem) {
        String expectedClass = "active";
        String actualClass = listItem.getAttribute("class");

        return actualClass.contains(expectedClass);
    }

    public boolean isElementDropped(WebElement listItem) {
        String expectedClass = "ui-state-highlight";
        String actualClass = listItem.getAttribute("class");

        return actualClass.contains(expectedClass);
    }

    public boolean searchForVisibleElement(List<WebElement> elementsList, String value){
        String MESSAGE_TO_STALE_ELEMENT_REFERENCE_EXCEPTION = "Element could have been located and referenced, but then changes state or is removed from the DOM before an action is performed on it.";

        try{
            try{
                for (WebElement element: elementsList) {
                    if (Objects.equals(element.getText(), value)){
                        return true;
                    }
                }
            }catch (StaleElementReferenceException e){
                handleException(MESSAGE_TO_STALE_ELEMENT_REFERENCE_EXCEPTION,e);
            }
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
        return false;
    }

    public boolean validateAllListItemsAreVisible(List<WebElement> elementList){
        WebElement element = runWebElementList(elementList);
        try {
            scroll(element);
            return element.isDisplayed();
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
        return false;
    }

    public boolean validateResponseCodeIs200inAList(List<WebElement> elementList) throws IOException {
        WebElement element = runWebElementList(elementList);
        scroll(element);
        return validateHTTPS_Response(element.getAttribute("src"));
    }

    public WebElement runWebElementList(List<WebElement> elementList){
        try {
            for (WebElement element: elementList) {
                return element;
            }
        }catch (NoSuchElementException e){
            handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
        }
        return null;
    }

    public int getPositionOfOneElementInAList(List<WebElement> elementsList, String value){
        int count = 0;
        for (WebElement element: elementsList) {
            if (Objects.equals(element.getText(), value)){
                return count;
            }
            count++;
        }
        return 0;
    }

    public float subtractQuantityToParameter(float targetParameter,float valueToDeduct){
        return  targetParameter - valueToDeduct;
    }

    public int searchNumberOne(List<WebElement> dateOfDaysList){
        try {
            for (int i = 0; i<= dateOfDaysList.size(); i++){
                if (Objects.equals(dateOfDaysList.get(i).getText(), "1")){
                    return i;
                }
            }
        }catch (IndexOutOfBoundsException e){
            handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
        }
        return dateOfDaysList.size();
    }

    public List<WebElement> addElementsToList(List<WebElement> daysList){
        int index = searchNumberOne(daysList);

        ArrayList<WebElement> arrayNormalized = new ArrayList<>();

        for (int i = index; i < daysList.size(); i++) {
            arrayNormalized.add(daysList.get(i));
        }

        return arrayNormalized;
    }

    public void selectListValue(List<WebElement> list, String valueToSearch){
        int sizeList = list.size();
        int x = 0;

        for (WebElement values: list) {
            x ++;
            try {
                if (Objects.equals(values.getText(), valueToSearch)){
                    scroll(values);
                    clickWithWait(values);
                    x--;
                    break;
                } else if (x == sizeList) {
                    System.out.println("value does not available");
                }
            }catch (WebDriverException e){
                handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
            }
        }
    }

    public void selectDay(List<WebElement> daysaList, String day){
        int sizeList = daysaList.size();
        int x = 0;
        for (WebElement daysOfList: addElementsToList(daysaList)) //one method is applied that return one list of days ordered.
        {
            x ++;
            try {
                if (Objects.equals(daysOfList.getText(), day)){
                    clickWithWait(daysOfList);
                    x--;
                    break;
                }else if (x == sizeList){
                    System.out.println("day does not exist");
                }
            }catch (WebDriverException e){
                handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
            }

        }
    }

    public void doubleClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .doubleClick()
                .build()
                .perform();
    }

    public void rightClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .contextClick()
                .build()
                .perform();
    }

    public void moveElementToCoordinates(WebElement element, float xCoordinate, float yCoordinate){
        Actions actions = new Actions(driver);
        try {
            try {
                try {
                    actions.dragAndDropBy(element, (int) xCoordinate, (int) yCoordinate)
                            .build()
                            .perform();
                }catch (NumberFormatException e){
                    handleException(MESSAGE_NUMBER_FORMAT_EXCEPTION,e);
                }
            }catch (MoveTargetOutOfBoundsException e){
                handleException(MESSAGE_MOVE_TARGET_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }catch (ElementNotInteractableException e){
            handleException(MESSAGE_ELEMENT_NOT_INTERACTABLE_EXCEPTION,e);
        }
    }

    public void moveClickerToElement(WebElement element){
        try {
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(element)
                        .build()
                        .perform();
            }catch (ElementNotInteractableException e){
                handleException(MESSAGE_ELEMENT_NOT_INTERACTABLE_EXCEPTION,e);
            }
        }catch (IndexOutOfBoundsException e){
            handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
        }
    }

    public void dragDropMoveElementToTarget(WebElement sourceElement, WebElement targetElement){
        Actions actions = new Actions(driver);
        try {
            actions.dragAndDrop(sourceElement, targetElement)
                    .build()
                    .perform();
        }catch (ElementNotInteractableException e){
            handleException(MESSAGE_ELEMENT_NOT_INTERACTABLE_EXCEPTION,e);
        }
    }

    public void resizeElement(WebElement element, int sizeX, int sizeY){
        Actions actions = new Actions(driver);
        try {
            actions.clickAndHold(element)
                    .moveByOffset(sizeX, sizeY)
                    .release()
                    .build()
                    .perform();
        }catch (MoveTargetOutOfBoundsException e){
            handleException(MESSAGE_MOVE_TARGET_OUT_OF_BOUNDS_EXCEPTION,e);
        }

    }

    public boolean validateHTTPS_Response(String src) throws IOException {
        String MESSAGE_MALFORMED_URL_EXCEPTION = "URL is incorrect";
        try {
            HttpURLConnection http = (HttpURLConnection) (new URL(src).openConnection());
            http.setRequestMethod("HEAD");
            http.connect();
            int responseCode = http.getResponseCode();
            return responseCode == 200;
        }catch (MalformedURLException e){
            handleException(MESSAGE_MALFORMED_URL_EXCEPTION,e);
        }
        return false;
    }


    private void handleException(String messageException,Exception e) {
        logger.error(messageException, e);
    }
}