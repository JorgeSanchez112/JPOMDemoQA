package Pages;

import TestComponents.BasePages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeFormPage extends BasePages {
    @FindBy(css = "div.practice-form-wrapper > h5")
    private WebElement titleForm;
    @FindBy(id = "userName-label")
    private WebElement nameLabel;
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(id = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "userEmail-label")
    private WebElement emailLabel;
    @FindBy(id = "userEmail")
    private WebElement emailField;
    @FindBy(css = "div#genterWrapper > div:nth-child(1)")
    private WebElement genderLabel;
    @FindBy(css = "div#genterWrapper > div:nth-child(2) > div > label")
    private List<WebElement> radioButtonGenders;
    @FindBy(id = "userNumber-label")
    private WebElement mobileLabel;
    @FindBy(id = "userNumber")
    private WebElement mobileField;
    @FindBy(id = "dateOfBirth-label")
    private WebElement birthDateLabel;
    @FindBy(id = "dateOfBirthInput")
    private WebElement birthDateField;
    @FindBy(css = ".react-datepicker__month-select > option")
    private List<WebElement> months;
    @FindBy(css = ".react-datepicker__year-select > option")
    private List<WebElement> years;
    @FindBy(className = "react-datepicker__day")
    private List<WebElement> calendarDays;
    @FindBy(css = "#subjects-label:nth-child(1)")
    private List<WebElement> threeLabelsBeforeCurrentAddressLabel;
    @FindBy(id = "subjectsInput")
    private WebElement subjectField;
    @FindBy(css = ".custom-checkbox > label")
    private List<WebElement> checkboxes;
    @FindBy(id = "uploadPicture")
    private WebElement selectFieldButton;
    @FindBy(id = "currentAddress-label")
    private WebElement currentAddressLabel;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressField;
    @FindBy(id = "stateCity-label")
    private WebElement stateCityLabel;
    @FindBy(id = "react-select-3-input")
    private WebElement listStatesBox;
    @FindBy(id = "react-select-4-input")
    private WebElement listCitiesBox;
    @FindBy(css = ".css-1wa3eu0-placeholder")
    private List<WebElement> placeholdersStateAndCity;
    @FindBy(id = "submit")
    private WebElement submitButton;

    //Form submitted
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement titleOfSubmitForm;
    @FindBy(css = "thead > tr > th")
    private List<WebElement> tableTitles;
    @FindBy(css = "tbody > tr:nth-child(1) > td")
    private List<WebElement> firstRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(2) > td")
    private List<WebElement> secondRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(3) > td")
    private List<WebElement> thirdRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(4) > td")
    private List<WebElement> fourthRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(5) > td")
    private List<WebElement> fifthRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(6) > td")
    private List<WebElement> sixthRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(7) > td")
    private List<WebElement> seventhRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(8) > td")
    private List<WebElement> eighthRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(9) > td")
    private List<WebElement> ninthRowOfFormTable;
    @FindBy(css = "tbody > tr:nth-child(10) > td")
    private List<WebElement> tenthRowOfFormTable;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void typeInFirstNameField(String firstName){
        sendKeysToElement(firstNameField,firstName);
    }

    public void typeInLastNameField(String lastName){
        sendKeysToElement(lastNameField,lastName);
    }

    public void typeInEmailField(String email){
        sendKeysToElement(emailField,email);
    }

    public void selectOneGender(String nameRadioButton){
        selectListValue(radioButtonGenders,nameRadioButton);
    }

    public void typeInMobileField(String phoneNumber){
        sendKeysToElement(mobileField,phoneNumber);
    }

    public void selectDate( String month, String day, String year){
        scroll(birthDateField);
        clickWithWait(birthDateField);
        selectListValue(months,month);
        selectListValue(years,year);
        selectDay(calendarDays,day);
    }

    public void typeInSubjectField(String subject){
        clickWithWait(subjectField);
        sendKeysToElement(subjectField,subject);
        subjectField.sendKeys(Keys.ENTER);
    }

    public void clickOnMusicCheckBoxButton(){
        scroll(checkboxes.get(2));
        clickWithWait(checkboxes.get(2));
    }

    public void selectAPicture(String picturePath){
        sendKeysToElement(selectFieldButton,picturePath);
    }

    public void typeInCurrentAddressField(String text){
        sendKeysToElement(currentAddressField,text);
    }

    public void typeInStateListBox(String state){
        sendKeysToElement(listStatesBox,state);
        listStatesBox.sendKeys(Keys.ENTER);
    }

    public void typeInCityListBox(String city){
        sendKeysToElement(listCitiesBox,city);
        listCitiesBox.sendKeys(Keys.ENTER);
    }

    public void enterToSubmitButton(){
        submitButton.sendKeys(Keys.ENTER);
    }

    public void fillAllFormFields(String name, String lastname,String email, String gender, String phone, String month, String day, String year, String subject, String picturePath, String text, String state, String city){
        typeInFirstNameField(name);
        typeInLastNameField(lastname);
        typeInEmailField(email);
        selectOneGender(gender);
        typeInMobileField(phone);
        selectDate(month, day, year);
        typeInSubjectField(subject);
        clickOnMusicCheckBoxButton();
        selectAPicture(picturePath);
        typeInCurrentAddressField(text);
        typeInStateListBox(state);
        typeInCityListBox(city);
        enterToSubmitButton();
    }

    public String  getPageTitleText(){
        return getElementTextWithWait(pageTitle);
    }

    public String getTextFormTitle(){
        return getElementTextWithWait(titleForm);
    }

    public String getTextOfLabelName(){
        scroll(nameLabel);
        return getElementTextWithWait(nameLabel);
    }

    public String getPlaceholderFirstNameField(){
        return firstNameField.getAttribute("placeholder");
    }

    public String getCssAttributeFirstNameField(){
        waitForElementAttributeToContain(firstNameField,"border-color","rgb(220, 53, 69)");
        return firstNameField.getCssValue("border-color");
    }

    public String getPlaceholderLastNameField(){
        return lastNameField.getAttribute("placeholder");
    }

    public String getCssAttributeLastNameField(){
        waitForElementAttributeToContain(lastNameField,"border-color","rgb(220, 53, 69)");
        return lastNameField.getCssValue("border-color");
    }

    public String getTextOfLabelEmail(){
        scroll(emailLabel);
        return getElementTextWithWait(emailLabel);
    }

    public String getPlaceholderEmailField(){
        return emailField.getAttribute("placeholder");
    }

    public String getCssAttributeEmailField(){
        waitForElementAttributeToContain(emailField,"border-color","rgb(40, 167, 69)");
        return emailField.getCssValue("border-color");
    }

    public String getTextOfLabelGender(){
        return getElementTextWithWait(genderLabel);
    }

    public String getCssAttributeGenderRadioButtons(){
        waitForElementAttributeToContain(radioButtonGenders.get(0),"border-color","rgba(220, 53, 69, 1)");
        return radioButtonGenders.get(0).getCssValue("color");
    }

    public String getTextOfLabelMobile(){
        return getElementTextWithWait(mobileLabel);
    }

    public String getPlaceholderMobileField(){
        return mobileField.getAttribute("placeholder");
    }

    public String getCssAttributeMobileField(){
        waitForElementAttributeToContain(mobileField,"border-color","rgb(220, 53, 69)");
        return mobileField.getCssValue("border-color");
    }

    public String getTextOfLabelDateOfBirth(){
        return getElementTextWithWait(birthDateLabel);
    }

    public String getCssAttributeBirthDateField(){
        waitForElementAttributeToContain(emailField,"border-color","rgb(220, 53, 69)");
        return emailField.getCssValue("border-color");
    }

    public String getTextOfLabelSubjects(){
        return getElementTextWithWait(threeLabelsBeforeCurrentAddressLabel.get(0));
    }

    public String getTextOfLabelHobbies(){
        return getElementTextWithWait(threeLabelsBeforeCurrentAddressLabel.get(1));
    }

    public String getCssAttributeSportsCheckboxButton(){
        waitForElementAttributeToContain(checkboxes.get(0),"border-color","rgb(40, 167, 69)");
        return checkboxes.get(0).getCssValue("border-color").intern();
    }

    public String getCssAttributeReadingCheckboxButton(){
        waitForElementAttributeToContain(checkboxes.get(1),"border-color","rgb(40, 167, 69)");
        return checkboxes.get(1).getCssValue("border-color").intern();
    }

    public String getCssAttributeMusicCheckboxButton(){
        waitForElementAttributeToContain(checkboxes.get(2),"border-color","rgb(40, 167, 69)");
        return checkboxes.get(2).getCssValue("border-color").intern();
    }

    public String getTextOfLabelPicture(){
        return getElementTextWithWait(threeLabelsBeforeCurrentAddressLabel.get(2));
    }

    public String getTextOfLabelCurrentAddress(){
        return getElementTextWithWait(currentAddressLabel);
    }

    public String getPlaceholderCurrentAddressField(){
        return currentAddressField.getAttribute("placeholder");
    }

    public String getCssAttributeCurrentAddressField(){
        waitForElementAttributeToContain(currentAddressField,"border-color","rgba(220, 53, 69, 1)");
        return currentAddressField.getCssValue("border-color");
    }

    public String getTextOfLabelStateCity(){
        return getElementTextWithWait(stateCityLabel);
    }

    public String getPlaceholderStatesListBox(){
        return getElementTextWithWait(placeholdersStateAndCity.get(1));
    }

    public String getPlaceholderCitiesListBox(){
        return getElementTextWithWait(placeholdersStateAndCity.get(2));
    }

    public boolean isVisibleTitleSubmitForm(){
        return isElementDisplayedWithWait(titleOfSubmitForm);
    }

    public String getTitleLabelFieldsText(){
        return getElementTextWithWait(tableTitles.get(0));
    }

    public String getTitleValueFieldsText(){
        return getElementTextWithWait(tableTitles.get(1));
    }

    public String getStudentNameText(){
        return getElementTextWithWait(firstRowOfFormTable.get(0));
    }

    public String getValueOfStudentNameRow(){
        return getElementTextWithWait(firstRowOfFormTable.get(1));
    }

    public String getStudentEmailText(){
        return getElementTextWithWait(secondRowOfFormTable.get(0));
    }

    public String getValueOfStudentEmailRow(){
        return getElementTextWithWait(secondRowOfFormTable.get(1));
    }

    public String getGenderText(){
        return getElementTextWithWait(thirdRowOfFormTable.get(0));
    }

    public String getValueOfGenderRow(){
        return getElementTextWithWait(thirdRowOfFormTable.get(1));
    }

    public String getMobileText(){
        return getElementTextWithWait(fourthRowOfFormTable.get(0));
    }

    public String getValueOfMobileRow(){
        return getElementTextWithWait(fourthRowOfFormTable.get(1));
    }

    public String getDateBirthText(){
        return getElementTextWithWait(fifthRowOfFormTable.get(0));
    }

    public String getValueOfDateBirthRow(){
        return getElementTextWithWait(fifthRowOfFormTable.get(1));
    }

    public String getSubjectsText(){
        return getElementTextWithWait(sixthRowOfFormTable.get(0));
    }

    public String getValueOfSubjectsRow(){
        return getElementTextWithWait(sixthRowOfFormTable.get(1));
    }

    public String getHobbiesText(){
        return getElementTextWithWait(seventhRowOfFormTable.get(0));
    }

    public String getValueOfHobbiesRow(){
        return getElementTextWithWait(seventhRowOfFormTable.get(1));
    }

    public String getPictureText(){
        return getElementTextWithWait(eighthRowOfFormTable.get(0));
    }

    public String getValueOfPictureRow(){
        return getElementTextWithWait(eighthRowOfFormTable.get(1));
    }

    public String getAddressText(){
        return getElementTextWithWait(ninthRowOfFormTable.get(0));
    }

    public String getValueOfAddressRow(){
        return getElementTextWithWait(ninthRowOfFormTable.get(1));
    }

    public String getStateCityText(){
        return getElementTextWithWait(tenthRowOfFormTable.get(0));
    }

    public String getValueOfStateCityRow(){
        return getElementTextWithWait(tenthRowOfFormTable.get(1));
    }
}