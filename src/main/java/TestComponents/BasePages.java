package TestComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BasePages {

    @FindBy(className = "text-center")
    protected WebElement pageTitle;
    protected WebDriver driver;

    public BasePages(WebDriver driver) {
        this.driver = driver;
    }

    public void backToPage(){
        driver.navigate().back();
    }

    public void scroll(WebElement element){
        try{
            waitForVisibleElement(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (TimeoutException e){
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.attributeContains(element, attribute, expectedValue));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public void waitForAttributeAriaDescribedByEqualToValue(WebElement element, String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(element,"aria-describedby", value));
    }

    public void waitForEnableElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForVisibleElement(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            e.printStackTrace();
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

    public boolean isElementVisibleAccordingToPositionReceivedOfList(List<WebElement> elements, int position){
        if (elements.size() != 0){
            try{
                scroll(elements.get(position));
                return elements.get(position).isDisplayed();
            }catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    public void waitForChargedElementsOfAWebElementList(List<WebElement> elementsList){
        FluentWait wait = new FluentWait(driver);
        try {
            try {
                wait.withTimeout(Duration.ofSeconds(10));
                wait.pollingEvery(Duration.ofMillis(250));
                wait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
            }catch (NoSuchElementException e){
                e.printStackTrace();
            }
        }catch (WebDriverException e){
            e.printStackTrace();
        }
    }

    public void waitAlert(){
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
            wait.until(ExpectedConditions.alertIsPresent());
        }catch (TimeoutException e){
            e.printStackTrace();
        }

    }

    public void clickWithWait(WebElement element){
        try {
            try {
                try{
                    try{
                        waitForClick(element);
                        element.click();
                    }catch (TimeoutException e){
                        e.printStackTrace();
                    }
                }catch (NoSuchElementException e){
                    e.printStackTrace();
                }

            }catch (ElementClickInterceptedException e){
                e.printStackTrace();
            }
        }catch (StaleElementReferenceException e){
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
        for (WebElement element: elementsList) {
            if (Objects.equals(element.getText(), value)){
                return true;
            }
        }
        return false;
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
        for (int i = 0; i<= dateOfDaysList.size(); i++){
            if (Objects.equals(dateOfDaysList.get(i).getText(), "1")){
                return i;
            }
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
            }catch (StaleElementReferenceException e){
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
            }catch (StaleElementReferenceException e){
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

    public void moveElementToCoordinates(WebElement element, int xCoordinate, int yCoordinate){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(element, xCoordinate, yCoordinate)
                .build()
                .perform();
    }

    public void moveClickerToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .build()
                .perform();
    }

    public void dragDropMoveElementToTarget(WebElement sourceElement, WebElement targetElement){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement)
                .build()
                .perform();
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
        HttpURLConnection http = (HttpURLConnection) (new URL(src).openConnection());
        http.setRequestMethod("HEAD");
        http.connect();

        int responseCode = http.getResponseCode();

        return responseCode == 200;
    }
}