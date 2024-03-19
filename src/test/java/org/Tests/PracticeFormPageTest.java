package org.Tests;

import Resources.ExcelReader;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class PracticeFormPageTest extends TestBase {
    private final String PAGE_TITLE = "Practice Form";
    private final String FORM_TITLE= "Student Registration Form";
    private final String LABEL_NAME = "Name";
    private final String LABEL_EMAIL = "Email";
    private final String LABEL_GENDER = "Gender";
    private final String LABEL_MOBILE = "Mobile(10 Digits)";
    private final String LABEL_BIRTHDATE = "Date of Birth";
    private final String LABEL_SUBJECTS = "Subjects";
    private final String LABEL_HOBBIES = "Hobbies";
    private final String LABEL_PICTURES = "Picture";
    private final String LABEL_CURRENT_ADDRESS = "Current Address";
    private final String LABEL_STATE_CITY = "State and City";
    private final String PLACEHOLDER_FIRST_NAME_FIELD = "First Name";
    private final String PLACEHOLDER_LAST_NAME_FIELD = "Last Name";
    private final String PLACEHOLDER_EMAIL_FIELD = "name@example.com";
    private final String PLACEHOLDER_MOBILE_FIELD = "Mobile Number";
    private final String PLACEHOLDER_CURRENT_ADDRESS_FIELD = "Current Address";
    private final String PLACEHOLDER_STATES_LIST_BOX = "Select State";
    private final String PLACEHOLDER_CITIES_LIST_BOX = "Select City";
    private final String LABEL_TITLE_FORM_SUBMIT = "Label";
    private final String LABEL_VALUES_FORM_SUBMIT = "Values";
    private final String LABEL_STUDENT_NAME_FORM_SUBMIT = "Student Name";
    private final String LABEL_STUDENT_EMAIL_FORM_SUBMIT = "Student Email";
    private final String LABEL_MOBILE_FORM_SUBMIT = "Mobile";
    private final String LABEL_ADDRESS_FORM_SUBMIT = "Address";


    @BeforeMethod
    public void initializeClass(){
        practiceFormPage = homePage.clickOnSectionForms().clickOnPracticeFormSection();
    }

    @Test
    public void validateCorrectPageTitle(){
        Assert.assertEquals(practiceFormPage.getPageTitleText(),PAGE_TITLE);
    }

    @Test
    public void validateTitle(){
        Assert.assertEquals(practiceFormPage.getTextFormTitle(),FORM_TITLE);
    }

    @Test
    public void validateLabelName(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelName(), LABEL_NAME);
    }

    @Test
    public void validateLabelEmail(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelEmail(), LABEL_EMAIL);
    }

    @Test
    public void validateLabelGender(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelGender(), LABEL_GENDER);
    }

    @Test
    public void validateLabelMobile(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelMobile(), LABEL_MOBILE);
    }

    @Test
    public void validateLabelBirthDate(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelDateOfBirth(), LABEL_BIRTHDATE);
    }

    @Test
    public void validateLabelSubjects(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelSubjects(), LABEL_SUBJECTS);
    }

    @Test
    public void validateLabelHobbies(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelHobbies(), LABEL_HOBBIES);
    }

    @Test
    public void validateLabelPicture(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelPicture(), LABEL_PICTURES);
    }

    @Test
    public void validateLabelCurrentAddress(){
        Assert.assertEquals(practiceFormPage.getTextOfLabelCurrentAddress(), LABEL_CURRENT_ADDRESS);
    }

    @Test
    public void validateLabelsStateAndCity() {
        Assert.assertEquals(practiceFormPage.getTextOfLabelStateCity(), LABEL_STATE_CITY);
    }

    @Test
    public void validatePlaceholderFirstNameField(){
        Assert.assertEquals(practiceFormPage.getPlaceholderFirstNameField(), PLACEHOLDER_FIRST_NAME_FIELD);
    }

    @Test
    public void validatePlaceholderLastNameField(){
        Assert.assertEquals(practiceFormPage.getPlaceholderLastNameField(), PLACEHOLDER_LAST_NAME_FIELD);
    }

    @Test
    public void validatePlaceholderEmailField(){
        Assert.assertEquals(practiceFormPage.getPlaceholderEmailField(), PLACEHOLDER_EMAIL_FIELD);
    }

    @Test
    public void validatePlaceholderMobileField(){
        Assert.assertEquals(practiceFormPage.getPlaceholderMobileField(), PLACEHOLDER_MOBILE_FIELD);
    }

    @Test
    public void validatePlaceholderCurrentAddressField(){
        Assert.assertEquals(practiceFormPage.getPlaceholderCurrentAddressField(), PLACEHOLDER_CURRENT_ADDRESS_FIELD);
    }

    @Test
    public void validatePlaceholderStateListBox(){
        Assert.assertEquals(practiceFormPage.getPlaceholderStatesListBox(), PLACEHOLDER_STATES_LIST_BOX);
    }

    @Test
    public void validatePlaceholderCityListBox(){
        Assert.assertEquals(practiceFormPage.getPlaceholderCitiesListBox(), PLACEHOLDER_CITIES_LIST_BOX);
    }

    @Test
    public void validateBorderColorOfFirstNameField(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeFirstNameField(), prop.getProperty("RGBRedColor"));
    }

    @Test
    public void validateBorderColorOfLastNameField(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeLastNameField(), prop.getProperty("RGBRedColor"));
    }

    @Test
    public void validateBorderColorOfEmailField(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeEmailField(), prop.getProperty("RGBGreenColor"));
    }

    @Test
    public void validateBorderColorOfGenderRadioButtonsField(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeGenderRadioButtons(), prop.getProperty("RGBARedColor"));
    }

    @Test
    public void validateBorderColorOfMobileField(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeMobileField(), prop.getProperty("RGBRedColor"));
    }

    @Test
    public void validateBorderColorOfBirthDateField(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeBirthDateField(), prop.getProperty("RGBGreenColor"));
    }

    @Test
    public void validateBorderColorOfSportsCheckboxButton(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeSportsCheckboxButton(), prop.getProperty("RGBGreenColor"));
    }

    @Test
    public void validateBorderColorOfReadingCheckboxButton(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeReadingCheckboxButton(), prop.getProperty("RGBGreenColor"));
    }

    @Test
    public void validateBorderColorOfMusicCheckboxButton(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeMusicCheckboxButton(), prop.getProperty("RGBGreenColor"));
    }

    @Test
    public void validateBorderColorOfCurrentAddressField(){
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeCurrentAddressField(), prop.getProperty("RGBGreenColor"));
    }

    @Test(dataProvider = "testData")
    public void validateCorrectRegisterValues(Object... data) {
        String nameValue = (String) data[0];
        String lastnameValue = (String) data[1];
        String emailValue = (String) data[2];
        String genderValue = (String) data[3];
        String phoneValue = (String) data[4];
        String monthValue = (String) data[5];
        String dayValue = (String) data[6];
        String yearValue = (String) data[7];
        String subjectValue = (String) data[8];
        String hobbies = (String) data[9];
        String picturePatch = (String) data[10];
        String addressValue = (String) data[11];
        String stateValue = (String) data[12];
        String cityValue = (String) data[13];

        practiceFormPage.fillAllFormFields(nameValue, lastnameValue, emailValue, genderValue, phoneValue, monthValue, dayValue, yearValue, subjectValue, hobbies, picturePatch, addressValue, stateValue, cityValue);
        Assert.assertTrue(practiceFormPage.isVisibleTitleSubmitForm());
        Assert.assertEquals(practiceFormPage.getTitleLabelFieldsText(),LABEL_TITLE_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getTitleValueFieldsText(),LABEL_VALUES_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getStudentNameText(),LABEL_STUDENT_NAME_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfStudentNameRow(),nameValue + " " + lastnameValue);
        Assert.assertEquals(practiceFormPage.getStudentEmailText(),LABEL_STUDENT_EMAIL_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfStudentEmailRow(),emailValue);
        Assert.assertEquals(practiceFormPage.getGenderText(),LABEL_GENDER);
        Assert.assertEquals(practiceFormPage.getValueOfGenderRow(),genderValue);
        Assert.assertEquals(practiceFormPage.getMobileText(),LABEL_MOBILE_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfMobileRow(),phoneValue);
        Assert.assertEquals(practiceFormPage.getDateBirthText(),LABEL_BIRTHDATE);
        Assert.assertEquals(practiceFormPage.getValueOfDateBirthRow(),dayValue + " " + monthValue + "," + yearValue);
        Assert.assertEquals(practiceFormPage.getSubjectsText(),LABEL_SUBJECTS);
        Assert.assertEquals(practiceFormPage.getValueOfSubjectsRow(),subjectValue);
        Assert.assertEquals(practiceFormPage.getHobbiesText(),LABEL_HOBBIES);
        Assert.assertEquals(practiceFormPage.getValueOfHobbiesRow(),hobbies);
        Assert.assertEquals(practiceFormPage.getPictureText(),LABEL_PICTURES);
        Assert.assertEquals(practiceFormPage.getValueOfPictureRow(),"Captura.png");
        Assert.assertEquals(practiceFormPage.getAddressText(),LABEL_ADDRESS_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfAddressRow(),addressValue);
        Assert.assertEquals(practiceFormPage.getStateCityText(),LABEL_STATE_CITY);
        Assert.assertEquals(practiceFormPage.getValueOfStateCityRow(), stateValue + " " + cityValue);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "practiceForm";
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readTestData(sheetName);
    }
}