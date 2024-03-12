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

public class BasePages {

    @FindBy(className = "text-center")
    protected WebElement pageTitle;
    @FindBy(id = "RightSide_Advertisement")
    protected WebElement rightSidePublicity;
    protected WebDriver driver ;

    public BasePages(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptAlertWithWait(){
        waitAlert();
        try {
            driver.switchTo().alert().accept();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public void dismissAlertWithWait(){
        waitAlert();
        try{
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public void pressEnterKey(WebElement driver){
        driver.sendKeys(Keys.ENTER);
    }

    public void backToPage(){
        driver.navigate().back();
    }

    public void scroll(WebElement element){
        try{
            try {
                waitForVisibleElement(element);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    public void hidePublicity(WebElement element){
        waitForVisibleElement(element);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", element);
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    public void sendKeysToElement(WebElement input,String text){
        try {
            input.sendKeys(text);
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    public void waitForClick(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    public void waitForElementAttributeToContain(WebElement element, String attribute, String expectedValue) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            System.out.println(element.getAttribute(attribute));
            wait.until(ExpectedConditions.attributeContains(element, attribute, expectedValue));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void waitForEnableElement(WebElement element){
        try {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(element));
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void waitForVisibleElement(WebElement element){
        try{
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
                wait.until(ExpectedConditions.visibilityOf(element));
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }catch (TimeoutException e){
            e.printStackTrace();
        }
    }

    public void selectOneElementAccordingToText(WebElement options,String elementText){
        Select select = new Select(options);
        try{
            select.selectByVisibleText(elementText);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            System.out.println("The element Text should contain the same value that the option");
        }
    }

    public String getElementTextAccordingToPositionReceived(List<WebElement> elements,int position){
        if (elements.size() != 0){
            try{
                scroll(elements.get(position));
                return elements.get(position).getText();
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        return "Error in 'getElementTextAccordingToPositionReceived' method";
    }

    public String getElementTextWithWait(WebElement element){
        try {
            waitForVisibleElement(element);
            return element.getText();
        }catch (WebDriverException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getElementAttribute(WebElement element, String attribute){
        try {
            return element.getAttribute(attribute);
        }catch (WebDriverException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String deleteAllLetters(String textWithLetters){
        return textWithLetters.replaceAll("[a-zA-Z]","");
    }

    public String changeFormatOfStringToReturnTextWithoutValueTypeFloat(String textToChangeFormat){
        try {
            return String.format("%.0f", Double.parseDouble(deleteAllLetters(textToChangeFormat)));
        }catch (NumberFormatException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String getElementCssValue(WebElement element, String propertyName){
        try {
            return element.getCssValue(propertyName);
        }catch (WebDriverException e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public boolean hasElementBeenSelected(WebElement element){
        try {
            return element.isSelected();
        }catch (WebDriverException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isElementEnabledWithEnableWait(WebElement element){
        try {
            waitForEnableElement(element);
            return element.isEnabled();
        }catch (WebDriverException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isElementDisplayedWithWait(WebElement element){
        try {
            waitForVisibleElement(element);
            return element.isDisplayed();
        }catch (WebDriverException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean isElementVisibleAccordingToPositionReceivedOfList(List<WebElement> elements, int position){
        if (elements.size() != 0){
            try{
                scroll(elements.get(position));
                return isElementDisplayedWithWait(elements.get(position));
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public void waitForChargedElementsOfAWebElementList(List<WebElement> elementsList){
        try {
            try {
                try {
                    try {
                        FluentWait wait = new FluentWait(driver);
                        wait.withTimeout(Duration.ofSeconds(10));
                        wait.pollingEvery(Duration.ofMillis(250));
                        wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
                    }catch (RejectedExecutionException e){
                        e.printStackTrace();
                    }
                }catch (IndexOutOfBoundsException e){
                    e.printStackTrace();
                }
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    public void waitAlert(){
        try {
            try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
                wait.until(ExpectedConditions.alertIsPresent());
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }catch (TimeoutException e){
            e.printStackTrace();
        }

    }

    public void clickWithWait(WebElement element){
        try {
            try {
                waitForClick(element);
                element.click();
            }catch (ElementClickInterceptedException e){
                e.printStackTrace();
            }
        }catch (WebDriverException e){
            e.printStackTrace();
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
        try{
            for (WebElement element: elementsList) {
                if (Objects.equals(element.getText(), value)){
                    return true;
                }
            }
        }catch (TimeoutException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateAllListItemsAreVisible(List<WebElement> elementList){
        WebElement element = runWebElementList(elementList);
        try {
            scroll(element);
            return element.isDisplayed();
        }catch (TimeoutException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean validateResponseCodeIs200inAList(List<WebElement> elementList) throws IOException {
        WebElement element = runWebElementList(elementList);
        scroll(element);
        System.out.println(element);
        System.out.println();
        return validateHTTPS_Response(element.getAttribute("src"));
    }

    public WebElement runWebElementList(List<WebElement> elementList){
        try {
            for (WebElement element: elementList) {
                return element;
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return elementList.get(0);
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

    public int searchNumberOne(List<WebElement> dateOfDaysList){
        try {
            for (int i = 0; i<= dateOfDaysList.size(); i++){
                if (Objects.equals(dateOfDaysList.get(i).getText(), "1")){
                    return i;
                }
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
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
                e.printStackTrace();
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
                System.out.println(e.getMessage());
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
                    e.printStackTrace();
                }
            }catch (MoveTargetOutOfBoundsException e){
                e.printStackTrace();
            }
        }catch (ElementNotInteractableException e){
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public void dragDropMoveElementToTarget(WebElement sourceElement, WebElement targetElement){
        Actions actions = new Actions(driver);
        try {
            actions.dragAndDrop(sourceElement, targetElement)
                    .build()
                    .perform();
        }catch (ElementNotInteractableException e){
            e.printStackTrace();
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
            e.printStackTrace();
        }

    }

    public boolean validateHTTPS_Response(String src) throws IOException {
        try {
            HttpURLConnection http = (HttpURLConnection) (new URL(src).openConnection());
            http.setRequestMethod("HEAD");
            http.connect();
            int responseCode = http.getResponseCode();
            return responseCode == 200;
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return false;
    }
}