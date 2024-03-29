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
    Logger logger = LogManager.getLogger(BasePages.class);

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

    /**
     * Description: This function wait to appear or detect an alert and then accept it.
     * */
    public void acceptAlertWithWait(){
        waitAlert();
        try {
            logger.info("Alert accepted");
            driver.switchTo().alert().accept();
        }catch (NoAlertPresentException e){
            handleException(MESSAGE_TO_NO_ALERT_PRESENT_EXCEPTION, e);
        }
    }

    /**
     * Description: This function wait to appear or detect an alert and then dismiss it.
     * @exception NoAlertPresentException: it is a common exception that appear when the alert doesn't appear.
     * */
    public void dismissAlertWithWait(){
        waitAlert();
        try{
            driver.switchTo().alert().dismiss();
            logger.info("Alert Dismiss");
        }catch (NoAlertPresentException e){
            handleException(MESSAGE_TO_NO_ALERT_PRESENT_EXCEPTION,e);
        }
    }

    /**
     * Description: This function press enter with SendKeys.
     * @param driver WebElement to send the Enter Action.
     * */
    public void pressEnterKey(WebElement driver){
        driver.sendKeys(Keys.ENTER);
        logger.info("Enter key pressed");
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void scroll(WebElement element){
        try{
            try {
                try{
                    waitForVisibleElement(element);
                    logger.info("Scroll to: " + element);
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

    /**
     * Description: Hide an element of the view changing display to none. Chiefly used against publicity.
     * @param element WebElement target to hide from the Page Web.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void hidePublicity(WebElement element){
        waitForVisibleElement(element);
        try {
            logger.info("Hide element: " + element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", element);
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    /**
     * Description: Type the desired value into an input text like username or a search box.
     * @param input WebElement target to send the text or value. It is often an input.
     * @param text Value desired to send to the input.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void sendKeysToElement(WebElement input,String text){
        try {
            logger.info("Send keys to: " + input);
            logger.info("value sent: " + text);
            input.sendKeys(text);
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    /**
     * Description: Wait during 10 seconds until the element is clickable.
     * @param element WebElement target that waits until it is clickable.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void waitForClick(WebElement element){
        try{
            logger.info("Wait for element: " + element + " is clickable");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    /**
     * Description: Wait during 10 second until element contains inside attribute the expected value.
     * @param element WebElement target that waits until it contains inside attribute the expected value.
     * @param attribute They are additional values that configure elements or adjust their behavior in various ways to meet user criteria.
     * @param expectedValue It is the expected value contained in the attribute.
     * @exception TimeoutException: it refers the action does not accomplish during to the wait expected.
     * */
    public void waitForElementAttributeToContain(WebElement element, String attribute, String expectedValue) {
        try {
            logger.info("Wait for element: " + element + " attribute: " + attribute + "contain: " + expectedValue);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.attributeContains(element, attribute, expectedValue));
        } catch (TimeoutException e) {
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
    }

    /**
     * Description: Wait for the visibility of target element during 10 seconds
     * @param element WebElement target to be waited
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception TimeoutException: it refers the element was not visible during the wait expected.
     * */
    public void waitForVisibleElement(WebElement element){
        try{
            try {
                logger.info("wait for visible Element: " + element);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(element));
            }catch (NoSuchElementException e){
                handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
            }
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
    }

    /**
     * Description: Select one option between an element with different options using the Class Select.
     * @param options WebElement target with different options
     * @param elementText Text of the element required to be selected. It must be equal to the text showed in the options.
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.

     * */
    public void selectOneElementAccordingToText(WebElement options,String elementText){
        Select select = new Select(options);
        try{
            select.selectByVisibleText(elementText);
            logger.info("Value expected to be selected: " + elementText);
        }catch (NoSuchElementException e){
            handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION + "The element Text should contain the same value that the option",e);
        }
    }

    /**
     * Description: It obtains the element text according to the position received.
     * @param elements It is a group of WebElements in a list.
     * @param position It is the position in elements desired to get its text.
     * @return The text obtain of element.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * */
    public String getElementTextAccordingToPositionReceived(List<WebElement> elements,int position){
        if (elements.size() != 0){
            try{
                WebElement element = elements.get(position);
                scroll(element);
                String elementText = getElementTextWithWait(element);
                logger.info("Element text received " + elementText + "according to position: " + position);
                return elementText;
            }catch (IndexOutOfBoundsException e){
                handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }
        return "";
    }

    /**
     * Description: It waits for the visibility of target element during 10 seconds to get its text
     * @param element WebElement target to get text.
     * @return The text obtain of element.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public String getElementTextWithWait(WebElement element){
        try {
            String elementText = element.getText();

            waitForVisibleElement(element);
            logger.info("Text received: " + elementText + " of element: " + element);
            return elementText;
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return "";
    }

    /**
     * Description: It obtains the attribute of an element.
     * @param element WebElement target obtain its attribute.
     * @return Attribute text.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public String getElementAttribute(WebElement element, String attribute){
        try {
            String elementAttribute = element.getAttribute(attribute);
            logger.info("Attribute obtained: " + elementAttribute + "of element: " + element);
            return elementAttribute;
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return "";
    }

    /**
     * Description: It deletes all the letter in a text just keeping the numbers.
     * @param textWithLetters Text that its letters will be deleted.
     * @return a new string but without the letters.
     * */
    public String deleteAllLetters(String textWithLetters){
        logger.info("All the letters in this string: " + textWithLetters + "were deleted");
        return textWithLetters.replaceAll("[a-zA-Z]","");
    }

    /**
     * Description: it changes a string with (0.1213) to return a new string without the format float or double.
     * @param textToChangeFormat Text that its format will be change.
     * @return a new string without a value type float or double.
     * @exception NumberFormatException: Method expects a string representation of a numeric value.
     * */
    public String changeFormatOfStringToReturnTextWithoutValueTypeFloat(String textToChangeFormat){
        try {
            logger.info("String format was changed to return value: " + textToChangeFormat + " without value tpe float");
            return String.format("%.0f", Double.parseDouble(deleteAllLetters(textToChangeFormat)));
        }catch (NumberFormatException e){
            handleException(MESSAGE_NUMBER_FORMAT_EXCEPTION,e);
        }
        return "";
    }

    /**
     * Description: It obtains a CSS values of an element and return it as text.
     * @param element WebElement target to get CSS value.
     * @param propertyName It is the desired CSS property name.
     * @return The CSS property name value as text.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public String getElementCssValue(WebElement element, String propertyName){
        try {
            String elementCSS = element.getCssValue(propertyName);
            logger.info("Css value: " + elementCSS + " obtain with this property name: " + propertyName + " suing this element: " + element);
            return element.getCssValue(propertyName);
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return "";
    }

    /**
     * Description: It validates if an element has been selected.
     * @param element WebElement target to validate if it has been selected.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean hasElementBeenSelected(WebElement element){
        try {
            try{
                boolean elementSelected = element.isSelected();
                logger.info("Element: " + " was selected: " + elementSelected);
                return elementSelected;
            }catch (IndexOutOfBoundsException e){
                handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return false;
    }

    /**
     * Description: It identifies if an element is enabled.
     * @param element WebElement target to validate is enabled.
     * @return true if the element is enabled.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean isElementEnabled(WebElement element){
        try {
            boolean elementEnabled = element.isEnabled();
            logger.info("Is element: " + element + "enabled: " + elementEnabled);
            return elementEnabled;
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return false;
    }

    /**
     * Description: It validates if an element is displayed with a wait of 10 seconds.
     * @param element WebElement target to validate is displayed.
     * @return true if the element is displayed.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean isElementDisplayedWithWait(WebElement element){
        try {
            boolean elementDisplayed = element.isDisplayed();
            waitForVisibleElement(element);
            logger.info("Is element: " + element + "displayed: " + elementDisplayed);
            return elementDisplayed;
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
        return false;
    }

    /**
     * Description: it validates if an webElement of a list WebElements is visible.
     * @param elements List WebElement.
     * @param position Position of the WebElement in the list.
     * @return true if the desired Element is visible.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * */
    public boolean isElementVisibleAccordingToPositionReceivedOfList(List<WebElement> elements, int position){
        if (elements.size() != 0){
            try{
                WebElement element = elements.get(position);
                scroll(elements.get(position));
                boolean elementDisplayed = isElementDisplayedWithWait(elements.get(position));
                logger.info("is Element" + element + "visible: " + elementDisplayed + "according to position: " + position);
                return elementDisplayed;
            }catch (IndexOutOfBoundsException e){
                handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
            }
        }
        return false;
    }

    /**
     * Description: Wait for 10 seconds with and interval of 250 millis that all elements of a WebElement List were charged.
     * @param elementsList List WebElement.
     * @exception RejectedExecutionException: It indicates that a task submission to an executor has been rejected for execution.
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void waitForChargedElementsOfAWebElementList(List<WebElement> elementsList){
        String MESSAGE_TO_REJECTED_EXECUTION_EXCEPTION = "RejectedExecutionException occurred, indicating that a task submission to an executor has been rejected for execution.";

        try {
            try {
                try {
                    try {
                        logger.info("Fluent wait execution with this list elements: " + elementsList);
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

    /**
     * Description: Wait for 10 second until an alert is present.
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception TimeoutException: it refers the action does not accomplish during to the wait expected.
     * */
    public void waitAlert(){
        try {
            try {
                logger.info("Wait for alert");
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
                wait.until(ExpectedConditions.alertIsPresent());
            }catch (NoSuchElementException e){
                handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
            }
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }

    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void clickWithWait(WebElement element){
        String MESSAGE_TO_ELEMENT_CLICK_INTERCEPTED_EXCEPTION = "Element has been intercepted, possibly other element no allowed the correct click";

        try {
            try {
                waitForClick(element);
                element.click();
                logger.info("Click on element: " + element);
            }catch (ElementClickInterceptedException e){
                handleException(MESSAGE_TO_ELEMENT_CLICK_INTERCEPTED_EXCEPTION,e);
            }
        }catch (WebDriverException e){
            handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
        }
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void switchToTab(){
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                logger.info("Switch to tab: " + windowHandle);
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean isListItemSelected(WebElement listItem) { //this and 'is Element Dropped could be replaced in just one method'
        String expectedClass = "active";
        String actualClass = listItem.getAttribute("class");
        boolean elementContainsExpectedClass = actualClass.contains(expectedClass);

        logger.info("Element: " + listItem + "contain: " + expectedClass + "in attribute: " + actualClass + " = " + elementContainsExpectedClass);
        return elementContainsExpectedClass;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean isElementDropped(WebElement listItem) {
        String expectedClass = "ui-state-highlight";
        String actualClass = listItem.getAttribute("class");
        boolean elementContainsExpectedClass = actualClass.contains(expectedClass);

        logger.info("Element: " + listItem + "contain: " + expectedClass + "in attribute: " + actualClass + " = " + elementContainsExpectedClass);
        return elementContainsExpectedClass;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean searchForVisibleElement(List<WebElement> elementsList, String value){
        String MESSAGE_TO_STALE_ELEMENT_REFERENCE_EXCEPTION = "Element could have been located and referenced, but then changes state or is removed from the DOM before an action is performed on it.";

        try{
            try{
                for (WebElement element: elementsList) {
                    logger.info("Element: " + element);
                    if (Objects.equals(element.getText(), value)){
                        logger.info("is visible");
                        return true;
                    }
                    logger.info("is not visible");
                }
            }catch (StaleElementReferenceException e){
                handleException(MESSAGE_TO_STALE_ELEMENT_REFERENCE_EXCEPTION,e);
            }
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
        return false;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean validateAllListItemsAreVisible(List<WebElement> elementList){
        WebElement element = runWebElementList(elementList);
        try {
            scroll(element);
            boolean elementDisplayed = isElementDisplayedWithWait(element);
            logger.info("Element: " + element + "is visible: " + elementDisplayed);
            return elementDisplayed;
        }catch (TimeoutException e){
            handleException(MESSAGE_TO_TIME_OUT_EXCEPTION,e);
        }
        return false;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean validateResponseCodeIs200inAList(List<WebElement> elementList) throws IOException {
        WebElement element = runWebElementList(elementList);
        scroll(element);
        boolean hTTPResponse = validateHTTPS_Response(element.getAttribute("src"));
        logger.info("HTTP Code of element: " + element + " is 200: " + hTTPResponse);
        return hTTPResponse;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public WebElement runWebElementList(List<WebElement> elementList){
        try {
            for (WebElement element: elementList) {
                logger.info("Element: " + element + "was returned");
                return element;
            }
        }catch (NoSuchElementException e){
            handleException(MESSAGE_TO_NO_SUCH_ELEMENT_EXCEPTION,e);
        }
        return null;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public int getPositionOfOneElementInAList(List<WebElement> elementsList, String value){
        int count = 0;
        for (WebElement element: elementsList) {
            if (Objects.equals(element.getText(), value)){
                logger.info("Element with this text: " + value + "is in the position: " + count);
                return count;
            }
            count++;
        }
        return 0;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public float subtractQuantityToParameter(float targetParameter,float valueToDeduct){
        float result = targetParameter - valueToDeduct;
        logger.info("Subtract: " + targetParameter + " with: " + valueToDeduct + " = " + result);
        return result;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public int searchNumberOne(List<WebElement> dateOfDaysList){
        try {
            for (int i = 0; i<= dateOfDaysList.size(); i++){
                if (Objects.equals(dateOfDaysList.get(i).getText(), "1")){
                    logger.info("Searching the number one in a list: " + dateOfDaysList);
                    return i;
                }
            }
        }catch (IndexOutOfBoundsException e){
            handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
        }
        return dateOfDaysList.size();
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public List<WebElement> addElementsToList(List<WebElement> daysList){
        int index = searchNumberOne(daysList);

        logger.info("Creating a new WebElement List");
        ArrayList<WebElement> arrayNormalized = new ArrayList<>();

        logger.info("Adding elements");
        for (int i = index; i < daysList.size(); i++) {
            arrayNormalized.add(daysList.get(i));
        }

        logger.info("Return List");
        return arrayNormalized;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void selectListValue(List<WebElement> list, String valueToSearch){
        int sizeList = list.size();
        int x = 0;

        logger.info("Searching element: " + valueToSearch + " in list: " + list);
        for (WebElement values: list) {
            x ++;
            try {
                if (Objects.equals(values.getText(), valueToSearch)){
                    scroll(values);
                    clickWithWait(values);
                    x--;
                    break;
                } else if (x == sizeList) {
                    logger.info("Value: " + valueToSearch + " did not find");
                    System.out.println("value does not available");
                }
            }catch (WebDriverException e){
                handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
            }
        }
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void selectDay(List<WebElement> daysaList, String day){
        int sizeList = daysaList.size();
        int x = 0;
        logger.info("Searching day");
        for (WebElement daysOfList: addElementsToList(daysaList)) //one method is applied that return one list of days ordered.
        {
            x ++;
            try {
                if (Objects.equals(daysOfList.getText(), day)){
                    clickWithWait(daysOfList);
                    x--;
                    break;
                }else if (x == sizeList){
                    logger.info("Day: " + day + " did not find");
                    System.out.println("day does not exist");
                }
            }catch (WebDriverException e){
                handleException(MESSAGE_TO_WEB_DRIVER_EXCEPTION,e);
            }

        }
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void doubleClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .doubleClick()
                .build()
                .perform();
        logger.info("Double click on element: " + element);
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void rightClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .contextClick()
                .build()
                .perform();
        logger.info("Right click on element: " + element);
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void moveElementToCoordinates(WebElement element, float xCoordinate, float yCoordinate){
        Actions actions = new Actions(driver);
        try {
            try {
                try {
                    logger.info("Moving element to X coordinate: " + xCoordinate + " Y coordinate: " + yCoordinate);
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

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void moveClickerToElement(WebElement element){
        try {
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(element)
                        .build()
                        .perform();
                logger.info("Move clicker to element: " + element);
            }catch (ElementNotInteractableException e){
                handleException(MESSAGE_ELEMENT_NOT_INTERACTABLE_EXCEPTION,e);
            }
        }catch (IndexOutOfBoundsException e){
            handleException(MESSAGE_TO_INDEX_OUT_OF_BOUNDS_EXCEPTION,e);
        }
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void dragDropMoveElementToTarget(WebElement sourceElement, WebElement targetElement){
        Actions actions = new Actions(driver);
        try {
            logger.info("Drag and Drop element to element: " + targetElement);
            actions.dragAndDrop(sourceElement, targetElement)
                    .build()
                    .perform();
        }catch (ElementNotInteractableException e){
            handleException(MESSAGE_ELEMENT_NOT_INTERACTABLE_EXCEPTION,e);
        }
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public void resizeElement(WebElement element, int sizeX, int sizeY){
        Actions actions = new Actions(driver);
        try {
            logger.info("Resize element: " + element + " size X: " + sizeX + " size Y: " + sizeY);
            actions.clickAndHold(element)
                    .moveByOffset(sizeX, sizeY)
                    .release()
                    .build()
                    .perform();
        }catch (MoveTargetOutOfBoundsException e){
            handleException(MESSAGE_MOVE_TARGET_OUT_OF_BOUNDS_EXCEPTION,e);
        }

    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    public boolean validateHTTPS_Response(String src) throws IOException {
        String MESSAGE_MALFORMED_URL_EXCEPTION = "URL is incorrect";
        try {
            HttpURLConnection http = (HttpURLConnection) (new URL(src).openConnection());
            http.setRequestMethod("HEAD");
            http.connect();
            int responseCode = http.getResponseCode();
            logger.info("HTTP response: " + responseCode);
            return responseCode == 200;
        }catch (MalformedURLException e){
            handleException(MESSAGE_MALFORMED_URL_EXCEPTION,e);
        }
        return false;
    }

    /**
     * Description: Wait for the visibility of target element and then scroll up or down until the element is into view.
     * @param element WebElement target to do Scroll
     * @exception NoSuchElementException: it points out that element can't be found, likely an irregular locator or delay charge.
     * @exception IndexOutOfBoundsException: it points out an attempt to access or manipulate an element at an invalid index position within a collection or array.
     * @exception WebDriverException: it points out when an unexpected error occurred while interacting with the WebDriver.
     * */
    private void handleException(String messageException,Exception e) {
        logger.error(messageException, e);
    }
}