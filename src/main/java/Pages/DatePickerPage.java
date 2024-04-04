package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class DatePickerPage extends BasePages {
    @FindBy(css = ".col-md-3.col-sm-12")
    private List<WebElement> labels;
    @FindBy(id = "datePickerMonthYearInput")
    private WebElement dateInput;
    @FindBy(css = ".react-datepicker__month-select > option")
    private List<WebElement> monthOfDateInput;
    @FindBy(css = ".react-datepicker__year-select > option")
    private List<WebElement> yearOfDateInput;
    @FindBy(className = "react-datepicker__day")
    private List<WebElement> days;
    @FindBy(id = "dateAndTimePickerInput")
    private WebElement dateAndTimeInput;
    @FindBy(className = "react-datepicker__month-dropdown-container")
    private WebElement monthContainer;
    @FindBy(className = "react-datepicker__month-option")
    private List<WebElement> monthsOfDateTimeInput;
    @FindBy(className = "react-datepicker__year-dropdown-container")
    private WebElement yearDateTimeContainer;
    @FindBy(className = "react-datepicker__year-option")
    private List<WebElement> yearsOfDateTimeInput;
    @FindBy(css = ".react-datepicker__year-option > a")
    private List<WebElement> upDownYearButton;
    @FindBy(className = "react-datepicker__time-list-item")
    private List<WebElement> timeOfDateTimeInput;

    private final String VALUE_ATTRIBUTE = "value";

    public DatePickerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnDateInput(){
        scroll(dateInput);
        clickWithWait(dateInput);
    }

    public void clickOnDateAndTimeInput(){
        scroll(dateAndTimeInput);
        clickWithWait(dateAndTimeInput);
    }

    public void selectDate(String month, String day, String year){
        selectListValue(monthOfDateInput,month);
        selectListValue(yearOfDateInput,year);
        selectDay(days,day);
    }

    public void selectDateAndTime(String month, String day, String year, String time){
        clickWithWait(monthContainer);
        selectListValue(monthsOfDateTimeInput,month);
        clickWithWait(yearDateTimeContainer);
        selectDateTimeYear(Integer.parseInt(year));
        selectDay(days,day);
        selectListValue(timeOfDateTimeInput,time);
    }

    public void selectDateTimeYear(Integer year){
        boolean match = false;
        do {

            for (WebElement element : yearsOfDateTimeInput){
                try{
                    try {
                        if (Objects.equals(element.getText(), "")){
                            match = false;
                        } else if (Objects.equals(element.getText(), "✓\n" + "2024")) {
                            clickWithWait(upDownYearButton.get(1));
                        } else if(Integer.parseInt(element.getText()) == year){
                            clickWithWait(element);
                            match = true;
                        } else if (Integer.parseInt(yearsOfDateTimeInput.get(1).getText()) < year) {
                            clickWithWait(upDownYearButton.get(0));
                        }else{
                            clickWithWait(upDownYearButton.get(1));
                        }
                    }catch (StaleElementReferenceException e){
                        e.printStackTrace();
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }while (!match);

    }

    public String getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getDateLabelText(){
        return getElementTextWithWait(labels.get(0));
    }

    public String getDateTimeLabelText(){
        return getElementTextWithWait(labels.get(1));
    }

    public String getDateValueText(){
        return getElementAttribute(dateInput,VALUE_ATTRIBUTE);
    }

    public String getDateTimeValueText(){
        return getElementAttribute(dateAndTimeInput,VALUE_ATTRIBUTE);
    }

}
