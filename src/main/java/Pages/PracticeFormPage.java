package Pages;

import TestComponents.BasePages;
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

    private final String BORDER_COLOR_ATTRIBUTE = "border-color";
    private final String PLACEHOLDER_ATTRIBUTE = "placeholder";
    private final String COLOR_PROPERTY = "color";
    private final String RGB_RED_COLOR = "rgb(220, 53, 69)";
    private final String RGBA_RED_COLOR = "rgba(220, 53, 69, 1)";
    private final String RGB_GREEN_COLOR = "rgb(40, 167, 69)";

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
        selectDay(calendarDays,removeBeginZero(day));
    }

    public void typeInSubjectField(String subject){
        clickWithWait(subjectField);
        sendKeysToElement(subjectField,subject);
        pressEnterKey(subjectField);
    }

    public void selectHobbies(String hobby){
        scroll(checkboxes.get(0));
        switch (hobby){
            case "Sports":
                clickWithWait(checkboxes.get(0));
                break;
            case "Reading":
                clickWithWait(checkboxes.get(1));
                break;
            case "Music":
                clickWithWait(checkboxes.get(2));
                break;
            default:
                System.out.println("Hobby selected is not available");
        }
    }

    public void selectAPicture(String picturePath){
        sendKeysToElement(selectFieldButton,picturePath);
    }

    public void typeInCurrentAddressField(String text){
        sendKeysToElement(currentAddressField,text);
    }

    public void typeInStateListBox(String state){
        sendKeysToElement(listStatesBox,state);
        pressEnterKey(listStatesBox);
    }

    public void typeInCityListBox(String city){
        sendKeysToElement(listCitiesBox,city);
        pressEnterKey(listCitiesBox);
    }

    public void enterToSubmitButton(){
        pressEnterKey(submitButton);
    }

    public void fillAllFormFields(String name, String lastname,String email, String gender, String phone, String month, String day, String year, String subject, String hobby, String picturePath, String text, String state, String city){
        typeInFirstNameField(name);
        typeInLastNameField(lastname);
        typeInEmailField(email);
        selectOneGender(gender);
        typeInMobileField(phone);
        selectDate(month, day, year);
        typeInSubjectField(subject);
        selectHobbies(hobby);
        selectAPicture(picturePath);
        typeInCurrentAddressField(text);
        typeInStateListBox(state);
        typeInCityListBox(city);
        enterToSubmitButton();
    }

    public String  getPageTitleText(){
        scroll(pageTitle);
        return getElementTextWithWait(pageTitle);
    }

    public String getTextFormTitle(){
        scroll(titleForm);
        return getElementTextWithWait(titleForm);
    }

    public String getTextOfLabelName(){
        scroll(nameLabel);
        return getElementTextWithWait(nameLabel);
    }

    public String getPlaceholderFirstNameField(){
        scroll(firstNameField);
        return getElementAttribute(firstNameField,PLACEHOLDER_ATTRIBUTE);
    }

    public String getCssAttributeFirstNameField(){
        waitForElementAttributeToContain(firstNameField,BORDER_COLOR_ATTRIBUTE,RGB_RED_COLOR);
        return getElementCssValue(firstNameField,BORDER_COLOR_ATTRIBUTE);
    }

    public String getPlaceholderLastNameField(){
        scroll(lastNameField);
        return getElementAttribute(lastNameField,PLACEHOLDER_ATTRIBUTE);
    }

    public String getCssAttributeLastNameField(){
        waitForElementAttributeToContain(lastNameField,BORDER_COLOR_ATTRIBUTE,RGB_RED_COLOR);
        return getElementCssValue(lastNameField,BORDER_COLOR_ATTRIBUTE);
    }

    public String getTextOfLabelEmail(){
        scroll(emailLabel);
        return getElementTextWithWait(emailLabel);
    }

    public String getPlaceholderEmailField(){
        scroll(emailField);
        return getElementAttribute(emailField,PLACEHOLDER_ATTRIBUTE);
    }

    public String getCssAttributeEmailField(){
        waitForElementAttributeToContain(emailField,BORDER_COLOR_ATTRIBUTE,RGB_GREEN_COLOR);
        return getElementCssValue(emailField,BORDER_COLOR_ATTRIBUTE);
    }

    public String getTextOfLabelGender(){
        scroll(genderLabel);
        return getElementTextWithWait(genderLabel);
    }

    public String getCssAttributeGenderRadioButtons(){
        waitForElementAttributeToContain(radioButtonGenders.get(0),BORDER_COLOR_ATTRIBUTE,RGBA_RED_COLOR);
        return getElementCssValue(radioButtonGenders.get(0),COLOR_PROPERTY);
    }

    public String getTextOfLabelMobile(){
        scroll(mobileLabel);
        return getElementTextWithWait(mobileLabel);
    }

    public String getPlaceholderMobileField(){
        scroll(mobileField);
        return getElementAttribute(mobileField,PLACEHOLDER_ATTRIBUTE);
    }

    public String getCssAttributeMobileField(){
        waitForElementAttributeToContain(mobileField,BORDER_COLOR_ATTRIBUTE,RGB_RED_COLOR);
        return getElementCssValue(mobileField,BORDER_COLOR_ATTRIBUTE);
    }

    public String getTextOfLabelDateOfBirth(){
        scroll(birthDateLabel);
        return getElementTextWithWait(birthDateLabel);
    }

    public String getCssAttributeBirthDateField(){
        waitForElementAttributeToContain(emailField,BORDER_COLOR_ATTRIBUTE,RGB_RED_COLOR);
        return getElementCssValue(emailField,BORDER_COLOR_ATTRIBUTE);
    }

    public String getTextOfLabelSubjects(){
        scroll(threeLabelsBeforeCurrentAddressLabel.get(0));
        return getElementTextWithWait(threeLabelsBeforeCurrentAddressLabel.get(0));
    }

    public String getTextOfLabelHobbies(){
        scroll(threeLabelsBeforeCurrentAddressLabel.get(1));
        return getElementTextWithWait(threeLabelsBeforeCurrentAddressLabel.get(1));
    }

    public String getCssAttributeSportsCheckboxButton(){
        waitForElementAttributeToContain(checkboxes.get(0),BORDER_COLOR_ATTRIBUTE,RGB_GREEN_COLOR);
        return getElementCssValue(checkboxes.get(0),BORDER_COLOR_ATTRIBUTE);//intern
    }

    public String getCssAttributeReadingCheckboxButton(){
        waitForElementAttributeToContain(checkboxes.get(1),BORDER_COLOR_ATTRIBUTE,RGB_GREEN_COLOR);
        return getElementCssValue(checkboxes.get(1),BORDER_COLOR_ATTRIBUTE);//intern
    }

    public String getCssAttributeMusicCheckboxButton(){
        waitForElementAttributeToContain(checkboxes.get(2),BORDER_COLOR_ATTRIBUTE,RGB_GREEN_COLOR);
        return getElementCssValue(checkboxes.get(2),BORDER_COLOR_ATTRIBUTE);//intern
    }

    public String getTextOfLabelPicture(){
        scroll(threeLabelsBeforeCurrentAddressLabel.get(2));
        return getElementTextWithWait(threeLabelsBeforeCurrentAddressLabel.get(2));
    }

    public String getTextOfLabelCurrentAddress(){
        scroll(currentAddressLabel);
        return getElementTextWithWait(currentAddressLabel);
    }

    public String getPlaceholderCurrentAddressField(){
        scroll(currentAddressField);
        return getElementAttribute(currentAddressField,PLACEHOLDER_ATTRIBUTE);
    }

    public String getCssAttributeCurrentAddressField(){
        waitForElementAttributeToContain(currentAddressField,BORDER_COLOR_ATTRIBUTE,RGBA_RED_COLOR);
        return getElementCssValue(currentAddressField,BORDER_COLOR_ATTRIBUTE);
    }

    public String getTextOfLabelStateCity(){
        scroll(stateCityLabel);
        return getElementTextWithWait(stateCityLabel);
    }

    public String getPlaceholderStatesListBox(){
        scroll(placeholdersStateAndCity.get(1));
        return getElementTextWithWait(placeholdersStateAndCity.get(1));
    }

    public String getPlaceholderCitiesListBox(){
        scroll(placeholdersStateAndCity.get(2));
        return getElementTextWithWait(placeholdersStateAndCity.get(2));
    }

    public boolean isVisibleTitleSubmitForm(){
        scroll(titleOfSubmitForm);
        return isElementDisplayedWithWait(titleOfSubmitForm);
    }

    public String getTitleLabelFieldsText(){
        scroll(tableTitles.get(0));
        return getElementTextWithWait(tableTitles.get(0));
    }

    public String getTitleValueFieldsText(){
        scroll(tableTitles.get(1));
        return getElementTextWithWait(tableTitles.get(1));
    }

    public String getStudentNameText(){
        scroll(firstRowOfFormTable.get(0));
        return getElementTextWithWait(firstRowOfFormTable.get(0));
    }

    public String getValueOfStudentNameRow(){
        scroll(firstRowOfFormTable.get(1));
        return getElementTextWithWait(firstRowOfFormTable.get(1));
    }

    public String getStudentEmailText(){
        scroll(secondRowOfFormTable.get(0));
        return getElementTextWithWait(secondRowOfFormTable.get(0));
    }

    public String getValueOfStudentEmailRow(){
        scroll(secondRowOfFormTable.get(1));
        return getElementTextWithWait(secondRowOfFormTable.get(1));
    }

    public String getGenderText(){
        scroll(thirdRowOfFormTable.get(0));
        return getElementTextWithWait(thirdRowOfFormTable.get(0));
    }

    public String getValueOfGenderRow(){
        scroll(thirdRowOfFormTable.get(1));
        return getElementTextWithWait(thirdRowOfFormTable.get(1));
    }

    public String getMobileText(){
        scroll(fourthRowOfFormTable.get(0));
        return getElementTextWithWait(fourthRowOfFormTable.get(0));
    }

    public String getValueOfMobileRow(){
        scroll(fourthRowOfFormTable.get(1));
        return getElementTextWithWait(fourthRowOfFormTable.get(1));
    }

    public String getDateBirthText(){
        scroll(fifthRowOfFormTable.get(0));
        return getElementTextWithWait(fifthRowOfFormTable.get(0));
    }

    public String getValueOfDateBirthRow(){
        scroll(fifthRowOfFormTable.get(1));
        return getElementTextWithWait(fifthRowOfFormTable.get(1));
    }

    public String getSubjectsText(){
        scroll(sixthRowOfFormTable.get(0));
        return getElementTextWithWait(sixthRowOfFormTable.get(0));
    }

    public String getValueOfSubjectsRow(){
        scroll(sixthRowOfFormTable.get(1));
        return getElementTextWithWait(sixthRowOfFormTable.get(1));
    }

    public String getHobbiesText(){
        scroll(seventhRowOfFormTable.get(0));
        return getElementTextWithWait(seventhRowOfFormTable.get(0));
    }

    public String getValueOfHobbiesRow(){
        scroll(seventhRowOfFormTable.get(1));
        return getElementTextWithWait(seventhRowOfFormTable.get(1));
    }

    public String getPictureText(){
        scroll(eighthRowOfFormTable.get(0));
        return getElementTextWithWait(eighthRowOfFormTable.get(0));
    }

    public String getValueOfPictureRow(){
        scroll(eighthRowOfFormTable.get(1));
        return getElementTextWithWait(eighthRowOfFormTable.get(1));
    }

    public String getAddressText(){
        scroll(ninthRowOfFormTable.get(0));
        return getElementTextWithWait(ninthRowOfFormTable.get(0));
    }

    public String getValueOfAddressRow(){
        scroll(ninthRowOfFormTable.get(1));
        return getElementTextWithWait(ninthRowOfFormTable.get(1));
    }

    public String getStateCityText(){
        scroll(tenthRowOfFormTable.get(0));
        return getElementTextWithWait(tenthRowOfFormTable.get(0));
    }

    public String getValueOfStateCityRow(){
        scroll(tenthRowOfFormTable.get(1));
        return getElementTextWithWait(tenthRowOfFormTable.get(1));
    }

    public String removeBeginZero(String originalValue){
        return originalValue.replaceAll("^0+", ""); // Remove leading zeros
    }
}