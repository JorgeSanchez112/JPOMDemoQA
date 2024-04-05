package org.Tests;

import testComponents.dataDriven.excelReader;
import testComponents.config.testBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class practiceFormPageTest extends testBase {
    private final Logger logger = LogManager.getLogger(practiceFormPageTest.class);
    private final String LABEL_GENDER = "Gender";
    private final String LABEL_BIRTHDATE = "Date of Birth";
    private final String LABEL_SUBJECTS = "Subjects";
    private final String LABEL_HOBBIES = "Hobbies";
    private final String LABEL_PICTURES = "Picture";
    private final String LABEL_STATE_CITY = "State and City";
    private final String RGB_RED_COLOR = "rgb(220, 53, 69)";
    private final String RGB_GREEN_COLOR = "rgb(40, 167, 69)";


    @BeforeMethod(groups = {"UI","Functional","Smoke"})
    public void initializeClass(){
        logger.info("-------------------Initializing PracticeFormPageTest Class------------------");
        practiceFormPage = homePage.clickOnSectionForms().clickOnPracticeFormSection();
        logger.info("-------------------Starting Test-----------------------");
    }

    @Test(groups = {"UI"})
    public void validateCorrectPageTitle(){
        String PAGE_TITLE = "Practice Form";

        logger.info("-------------------validateCorrectPageTitle-----------------------");
        Assert.assertEquals(practiceFormPage.getPageTitleText(), PAGE_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateTitle(){
        String FORM_TITLE = "Student Registration Form";

        logger.info("-------------------validateTitle-----------------------");
        Assert.assertEquals(practiceFormPage.getTextFormTitle(), FORM_TITLE);
    }

    @Test(groups = {"UI"})
    public void validateLabelName(){
        String LABEL_NAME = "Name";

        logger.info("-------------------validateLabelName-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelName(), LABEL_NAME);
    }

    @Test(groups = {"UI"})
    public void validateLabelEmail(){
        String LABEL_EMAIL = "Email";

        logger.info("-------------------validateLabelEmail-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelEmail(), LABEL_EMAIL);
    }

    @Test(groups = {"UI"})
    public void validateLabelGender(){
        logger.info("-------------------validateLabelGender-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelGender(), LABEL_GENDER);
    }

    @Test(groups = {"UI"})
    public void validateLabelMobile(){
        String LABEL_MOBILE = "Mobile(10 Digits)";

        logger.info("-------------------validateLabelMobile-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelMobile(), LABEL_MOBILE);
    }

    @Test(groups = {"UI"})
    public void validateLabelBirthDate(){
        logger.info("-------------------validateLabelBirthDate-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelDateOfBirth(), LABEL_BIRTHDATE);
    }

    @Test
    public void validateLabelSubjects(){
        logger.info("-------------------validateLabelSubjects-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelSubjects(), LABEL_SUBJECTS);
    }

    @Test(groups = {"UI"})
    public void validateLabelHobbies(){
        logger.info("-------------------validateLabelHobbies-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelHobbies(), LABEL_HOBBIES);
    }

    @Test(groups = {"UI"})
    public void validateLabelPicture(){
        logger.info("-------------------validateLabelPicture-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelPicture(), LABEL_PICTURES);
    }

    @Test(groups = {"UI"})
    public void validateLabelCurrentAddress(){
        String LABEL_CURRENT_ADDRESS = "Current Address";

        logger.info("-------------------validateLabelCurrentAddress-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelCurrentAddress(), LABEL_CURRENT_ADDRESS);
    }

    @Test(groups = {"UI"})
    public void validateLabelsStateAndCity(){
        logger.info("-------------------validateLabelsStateAndCity-----------------------");
        Assert.assertEquals(practiceFormPage.getTextOfLabelStateCity(), LABEL_STATE_CITY);
    }

    @Test(groups = {"UI"})
    public void validatePlaceholderFirstNameField(){
        String PLACEHOLDER_FIRST_NAME_FIELD = "First Name";

        logger.info("-------------------validatePlaceholderFirstNameField-----------------------");
        Assert.assertEquals(practiceFormPage.getPlaceholderFirstNameField(), PLACEHOLDER_FIRST_NAME_FIELD);
    }

    @Test(groups = {"UI"})
    public void validatePlaceholderLastNameField(){
        String PLACEHOLDER_LAST_NAME_FIELD = "Last Name";

        logger.info("-------------------validatePlaceholderLastNameField-----------------------");
        Assert.assertEquals(practiceFormPage.getPlaceholderLastNameField(), PLACEHOLDER_LAST_NAME_FIELD);
    }

    @Test(groups = {"UI"})
    public void validatePlaceholderEmailField(){
        String PLACEHOLDER_EMAIL_FIELD = "name@example.com";

        logger.info("-------------------validatePlaceholderEmailField-----------------------");
        Assert.assertEquals(practiceFormPage.getPlaceholderEmailField(), PLACEHOLDER_EMAIL_FIELD);
    }

    @Test(groups = {"UI"})
    public void validatePlaceholderMobileField(){
        String PLACEHOLDER_MOBILE_FIELD = "Mobile Number";

        logger.info("-------------------validatePlaceholderMobileField-----------------------");
        Assert.assertEquals(practiceFormPage.getPlaceholderMobileField(), PLACEHOLDER_MOBILE_FIELD);
    }

    @Test(groups = {"UI"})
    public void validatePlaceholderCurrentAddressField(){
        String PLACEHOLDER_CURRENT_ADDRESS_FIELD = "Current Address";

        logger.info("-------------------validatePlaceholderCurrentAddressField-----------------------");
        Assert.assertEquals(practiceFormPage.getPlaceholderCurrentAddressField(), PLACEHOLDER_CURRENT_ADDRESS_FIELD);
    }

    @Test(groups = {"UI"})
    public void validatePlaceholderStateListBox(){
        String PLACEHOLDER_STATES_LIST_BOX = "Select State";

        logger.info("-------------------validatePlaceholderStateListBox-----------------------");
        Assert.assertEquals(practiceFormPage.getPlaceholderStatesListBox(), PLACEHOLDER_STATES_LIST_BOX);
    }

    @Test(groups = {"UI"})
    public void validatePlaceholderCityListBox(){
        String PLACEHOLDER_CITIES_LIST_BOX = "Select City";

        logger.info("-------------------validatePlaceholderCityListBox-----------------------");
        Assert.assertEquals(practiceFormPage.getPlaceholderCitiesListBox(), PLACEHOLDER_CITIES_LIST_BOX);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfFirstNameField(){
        logger.info("-------------------validateBorderColorOfFirstNameField-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeFirstNameField(), RGB_RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfLastNameField(){
        logger.info("-------------------validateBorderColorOfLastNameField-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeLastNameField(), RGB_RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfEmailField(){
        logger.info("-------------------validateBorderColorOfEmailField-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeEmailField(), RGB_GREEN_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfGenderRadioButtonsField(){
        String RGBA_RED_COLOR = "rgba(220, 53, 69, 1)";

        logger.info("-------------------validateBorderColorOfGenderRadioButtonsField-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeGenderRadioButtons(), RGBA_RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfMobileField(){
        logger.info("-------------------validateBorderColorOfMobileField-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeMobileField(), RGB_RED_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfBirthDateField(){
        logger.info("-------------------validateBorderColorOfBirthDateField-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeBirthDateField(), RGB_GREEN_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfSportsCheckboxButton(){
        logger.info("-------------------validateBorderColorOfSportsCheckboxButton-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeSportsCheckboxButton(), RGB_GREEN_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfReadingCheckboxButton(){
        logger.info("-------------------validateBorderColorOfReadingCheckboxButton-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeReadingCheckboxButton(), RGB_GREEN_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfMusicCheckboxButton(){
        logger.info("-------------------validateBorderColorOfMusicCheckboxButton-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeMusicCheckboxButton(), RGB_GREEN_COLOR);
    }

    @Test(groups = {"UI"})
    public void validateBorderColorOfCurrentAddressField(){
        logger.info("-------------------validateBorderColorOfCurrentAddressField-----------------------");
        practiceFormPage.enterToSubmitButton();
        Assert.assertEquals(practiceFormPage.getCssAttributeCurrentAddressField(), RGB_GREEN_COLOR);
    }

    @Test(dataProvider = "testData",groups = {"Smoke","Functional"})
    public void validateCorrectRegisterValues(Object... data) {
        String LABEL_TITLE_FORM_SUBMIT = "Label";
        String LABEL_VALUES_FORM_SUBMIT = "Values";
        String LABEL_STUDENT_NAME_FORM_SUBMIT = "Student Name";
        String LABEL_STUDENT_EMAIL_FORM_SUBMIT = "Student Email";
        String LABEL_MOBILE_FORM_SUBMIT = "Mobile";
        String LABEL_ADDRESS_FORM_SUBMIT = "Address";

        logger.info("-------------------validateCorrectRegisterValues-----------------------");
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
        Assert.assertEquals(practiceFormPage.getTitleLabelFieldsText(), LABEL_TITLE_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getTitleValueFieldsText(), LABEL_VALUES_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getStudentNameText(), LABEL_STUDENT_NAME_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfStudentNameRow(),nameValue + " " + lastnameValue);
        Assert.assertEquals(practiceFormPage.getStudentEmailText(), LABEL_STUDENT_EMAIL_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfStudentEmailRow(),emailValue);
        Assert.assertEquals(practiceFormPage.getGenderText(),LABEL_GENDER);
        Assert.assertEquals(practiceFormPage.getValueOfGenderRow(),genderValue);
        Assert.assertEquals(practiceFormPage.getMobileText(), LABEL_MOBILE_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfMobileRow(),phoneValue);
        Assert.assertEquals(practiceFormPage.getDateBirthText(),LABEL_BIRTHDATE);
        Assert.assertEquals(practiceFormPage.getValueOfDateBirthRow(),dayValue + " " + monthValue + "," + yearValue);
        Assert.assertEquals(practiceFormPage.getSubjectsText(),LABEL_SUBJECTS);
        Assert.assertEquals(practiceFormPage.getValueOfSubjectsRow(),subjectValue);
        Assert.assertEquals(practiceFormPage.getHobbiesText(),LABEL_HOBBIES);
        Assert.assertEquals(practiceFormPage.getValueOfHobbiesRow(),hobbies);
        Assert.assertEquals(practiceFormPage.getPictureText(),LABEL_PICTURES);
        Assert.assertEquals(practiceFormPage.getValueOfPictureRow(),"Captura.png");
        Assert.assertEquals(practiceFormPage.getAddressText(), LABEL_ADDRESS_FORM_SUBMIT);
        Assert.assertEquals(practiceFormPage.getValueOfAddressRow(),addressValue);
        Assert.assertEquals(practiceFormPage.getStateCityText(),LABEL_STATE_CITY);
        Assert.assertEquals(practiceFormPage.getValueOfStateCityRow(), stateValue + " " + cityValue);
    }

    @DataProvider(name = "testData")
    public Object[][] testData() throws IOException {
        String sheetName = "practiceForm";
        logger.info("Accessing to: " + sheetName + " data");
        excelReader excelReader = new excelReader();
        return excelReader.readTestData(sheetName);
    }
}