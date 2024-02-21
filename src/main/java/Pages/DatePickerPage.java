package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(className = "react-datepicker__time-list-item")
    private List<WebElement> timeOfDateTimeInput;

    public DatePickerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnDateInput(){
        dateInput.click();
    }

    public void clickOnDateAndTimeInput(){
        dateAndTimeInput.click();
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
        selectListValue(yearsOfDateTimeInput,year);
        selectDay(days,day);
        selectListValue(timeOfDateTimeInput,time);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getDateLabelText(){
        return labels.get(0).getText();
    }

    public String getDateTimeLabelText(){
        return labels.get(1).getText();
    }

    public String getDateValueText(){
        return dateInput.getAttribute("value");
    }

    public String getDateTimeValueText(){
        return dateAndTimeInput.getAttribute("value");
    }

}
