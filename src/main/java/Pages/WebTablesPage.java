package Pages;

import TestComponents.config.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends PageBase {
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
        sendKeysToElement(searchBox,text);
    }

    public void fillFirstName(String name){
        sendKeysToElement(firstNameForm,name);
    }

    public void fillLastName(String lastName){
        sendKeysToElement(lastNameForm,lastName);
    }

    public void fillEmail(String email){
        sendKeysToElement(emailForm,email);
    }

    public void fillAge(String age){
        sendKeysToElement(ageForm,age);
    }

    public void fillSalary(String salary){
        sendKeysToElement(salaryForm,salary);
    }

    public void fillDepartment(String department){
        sendKeysToElement(departmentForm,department);
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
        return getElementTextWithWait(pageTitle);
    }

    public String getFirstNameOfFirstRow(){
        return getElementTextWithWait(firstRowFields.get(0));
    }

    public String getTextOfMessageNoRowsFound(){
        return getElementTextWithWait(noData);
    }

    public String getFirstNameOfFourthRow(){
       return getElementTextWithWait(fourthRowFields.get(0));
    }

    public String getLastNameOfFourthRow(){
        return getElementTextWithWait(fourthRowFields.get(1));
    }

    public String getAgeOfFourthRow(){
        return getElementTextWithWait(fourthRowFields.get(2));
    }

    public String getEmailOfFourthRow(){
        return getElementTextWithWait(fourthRowFields.get(3));
    }

    public String getSalaryOfFourthRow(){
        return getElementTextWithWait(fourthRowFields.get(4));
    }

    public String getDepartmentOfFourthRow(){
        return getElementTextWithWait(fourthRowFields.get(5));
    }
}