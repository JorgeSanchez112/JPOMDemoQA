package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BasePages {
    @FindBy (id = "addNewRecordButton")
    private WebElement addButton;
    @FindBy (id = "searchBox")
    private  WebElement searchBox;
    @FindBy (id = "delete-record-1")
    private WebElement deleteFirstRow;
    @FindBy (id = "delete-record-2")
    private WebElement deleteSecondRow;
    @FindBy (id = "delete-record-3")
    private WebElement deleteThirdRow;
    @FindBy (css = ".rt-tr-group:nth-child(1) > .rt-tr > .rt-td")
    private List<WebElement> firstRowFields;
    @FindBy (css = ".rt-tr-group:nth-child(4) > .rt-tr > .rt-td")
    private List<WebElement> fourthRowFields;
    @FindBy (className = "rt-noData")
    private WebElement noData;
    @FindBy (id = "firstName")
    private WebElement firstNameForm;
    @FindBy (id = "lastName")
    private WebElement lastNameForm;
    @FindBy (id = "userEmail")
    private WebElement emailForm;
    @FindBy (id = "age")
    private WebElement ageForm;
    @FindBy (id = "salary")
    private WebElement salaryForm;
    @FindBy (id = "department")
    private WebElement departmentForm;
    @FindBy (id = "submit")
    private WebElement submitButton;

    public WebTablesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickOnAddButton(){
        clickWithWait(addButton);
    }

    public void clickOnDeleteFirstRow(){
        clickWithWait(deleteFirstRow);
    }

    public void clickOnDeleteSecondRow(){
        clickWithWait(deleteSecondRow);
    }

    public void clickOnSubmitButton(){
        clickWithWait(submitButton);
    }

    public void clickOnDeleteThirdRow(){
        scroll(deleteThirdRow);
        clickWithWait(deleteThirdRow);
    }

    public void typeOnSearchBox(String text){
        searchBox.sendKeys(text);
    }

    public void fillFirstName(String name){
        firstNameForm.sendKeys(name);
    }

    public void fillLastName(String lastName){
        lastNameForm.sendKeys(lastName);
    }

    public void fillEmail(String email){
        emailForm.sendKeys(email);
    }

    public void fillAge(String age){
        ageForm.sendKeys(age);
    }

    public void fillSalary(String salary){
        salaryForm.sendKeys(salary);
    }

    public void fillDepartment(String department){
        departmentForm.sendKeys(department);
    }

    public void createRegistrationForm(String name, String lastName, String email, String age, String salary, String department){
        clickOnAddButton();
        fillFirstName(name);
        fillLastName(lastName);
        fillEmail(email);
        fillAge(age);
        fillSalary(salary);
        fillDepartment(department);
        clickOnSubmitButton();
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getFirstNameOfFirstRow(){
        return firstRowFields.get(0).getText();
    }

    public String getTextOfMessageNoRowsFound(){
        return noData.getText();
    }

    public String getFirstNameOfFourthRow(){
       return fourthRowFields.get(0).getText();
    }

    public String getLastNameOfFourthRow(){
        return fourthRowFields.get(1).getText();
    }

    public String getAgeOfFourthRow(){
        return fourthRowFields.get(2).getText();
    }

    public String getEmailOfFourthRow(){
        return fourthRowFields.get(3).getText();
    }

    public String getSalaryOfFourthRow(){
        return fourthRowFields.get(4).getText();
    }

    public String getDepartmentOfFourthRow(){
        return fourthRowFields.get(5).getText();
    }

}
