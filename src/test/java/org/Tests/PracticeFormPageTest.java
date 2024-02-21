package org.Tests;

import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormPageTest extends TestBase {
    @BeforeMethod
    public void initializeClass(){
        practiceFormPage = homePage.clickOnSectionForms().clickOnPracticeFormSection();
    }

    @Parameters("pageTitle")
    @Test
    public void validateCorrectPageTitle(String pageTitle){
        Assert.assertEquals(practiceFormPage.getPageTitleText(),pageTitle);
    }

    @Parameters("formTitle")
    @Test
    public void validateTitle(String formTitle){
        Assert.assertEquals(practiceFormPage.getTextFormTitle(),formTitle);
    }

    @Parameters("labelName")
    @Test
    public void validateLabelName(String labelName){
        Assert.assertEquals(practiceFormPage.getTextOfLabelName(), labelName);
    }

    @Parameters("labelEmail")
    @Test
    public void validateLabelEmail(String labelEmail){
        Assert.assertEquals(practiceFormPage.getTextOfLabelEmail(), labelEmail);
    }

    @Parameters("labelGender")
    @Test
    public void validateLabelGender(String labelGender){
        Assert.assertEquals(practiceFormPage.getTextOfLabelGender(), labelGender);
    }

    @Parameters("labelMobile")
    @Test
    public void validateLabelMobile(String labelMobile){
        Assert.assertEquals(practiceFormPage.getTextOfLabelMobile(), labelMobile);
    }

    @Parameters("labelBirthDate")
    @Test
    public void validateLabelBirthDate(String labelBirthDate){
        Assert.assertEquals(practiceFormPage.getTextOfLabelDateOfBirth(), labelBirthDate);
    }

    @Parameters("labelSubjects")
    @Test
    public void validateLabelSubjects(String labelSubjects){
        Assert.assertEquals(practiceFormPage.getTextOfLabelSubjects(), labelSubjects);
    }

    @Parameters("labelHobbies")
    @Test
    public void validateLabelHobbies(String labelHobbies){
        Assert.assertEquals(practiceFormPage.getTextOfLabelHobbies(), labelHobbies);
    }

    @Parameters("labelPicture")
    @Test
    public void validateLabelPicture(String labelPicture){
        Assert.assertEquals(practiceFormPage.getTextOfLabelPicture(), labelPicture);
    }

    @Parameters("labelCurrentAddress")
    @Test
    public void validateLabelCurrentAddress(String labelCurrentAddress){
        Assert.assertEquals(practiceFormPage.getTextOfLabelCurrentAddress(), labelCurrentAddress);
    }

    @Parameters("labelStateCity")
    @Test
    public void validateLabelsStateAndCity(String labelStateCity) {
        Assert.assertEquals(practiceFormPage.getTextOfLabelStateCity(), labelStateCity);
    }

    @Parameters("placeholderFirstNameField")
    @Test
    public void validatePlaceholderFirstNameField(String placeholderFirstNameField){
        Assert.assertEquals(practiceFormPage.getPlaceholderFirstNameField(), placeholderFirstNameField);
    }

    @Parameters("placeholderLastNameField")
    @Test
    public void validatePlaceholderLastNameField(String placeholderLastNameField){
        Assert.assertEquals(practiceFormPage.getPlaceholderLastNameField(), placeholderLastNameField);
    }

    @Parameters("placeholderEmailField")
    @Test
    public void validatePlaceholderEmailField(String placeholderEmailField){
        Assert.assertEquals(practiceFormPage.getPlaceholderEmailField(), placeholderEmailField);
    }

    @Parameters("placeholderMobileField")
    @Test
    public void validatePlaceholderMobileField(String placeholderMobileField){
        Assert.assertEquals(practiceFormPage.getPlaceholderMobileField(), placeholderMobileField);
    }

    @Parameters("placeholderCurrentAddressField")
    @Test
    public void validatePlaceholderCurrentAddressField(String placeholderCurrentAddressField){
        Assert.assertEquals(practiceFormPage.getPlaceholderCurrentAddressField(), placeholderCurrentAddressField);
    }

    @Parameters("placeholderStatesListBox")
    @Test
    public void validatePlaceholderStateListBox(String placeholderStatesListBox){
        Assert.assertEquals(practiceFormPage.getPlaceholderStatesListBox(), placeholderStatesListBox);
    }

    @Parameters("placeholderCitiesListBox")
    @Test
    public void validatePlaceholderCityListBox(String placeholderCitiesListBox){
        Assert.assertEquals(practiceFormPage.getPlaceholderCitiesListBox(), placeholderCitiesListBox);
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

    @Test //separate this test are much asserts that can be tested for separate
    @Parameters({"nameValue","lastnameValue","emailValue","labelGender","genderValue","phoneValue","labelBirthDate","monthValue","dayValue","yearValue","labelSubjects","subjectValue","labelHobbies","labelPicture","textValue","labelStateCity","stateValue","cityValue"})
    public void validateCorrectRegisterValues(String nameValue, String lastnameValue, String emailValue, String labelGender, String genderValue, String phoneValue, String labelBirthDate, String monthValue, String dayValue, String yearValue, String labelSubjects, String subjectValue, String labelHobbies, String labelPicture, String textValue, String labelStateCity, String stateValue, String cityValue) {

        practiceFormPage.fillAllFormFields(nameValue, lastnameValue, emailValue, genderValue, phoneValue, monthValue, dayValue, yearValue, subjectValue,"C:\\Users\\Jorge\\Pictures\\Captura.png", textValue, stateValue, cityValue);

        Assert.assertTrue(practiceFormPage.isVisibleTitleSubmitForm());
        Assert.assertEquals(practiceFormPage.getTitleLabelFieldsText(),"Label");
        Assert.assertEquals(practiceFormPage.getTitleValueFieldsText(),"Values");
        Assert.assertEquals(practiceFormPage.getStudentNameText(),"Student Name");
        Assert.assertEquals(practiceFormPage.getValueOfStudentNameRow(),nameValue + " " + lastnameValue);
        Assert.assertEquals(practiceFormPage.getStudentEmailText(),"Student Email");
        Assert.assertEquals(practiceFormPage.getValueOfStudentEmailRow(),emailValue);
        Assert.assertEquals(practiceFormPage.getGenderText(),labelGender);
        Assert.assertEquals(practiceFormPage.getValueOfGenderRow(),genderValue);
        Assert.assertEquals(practiceFormPage.getMobileText(),"Mobile");
        Assert.assertEquals(practiceFormPage.getValueOfMobileRow(),phoneValue);
        Assert.assertEquals(practiceFormPage.getDateBirthText(),labelBirthDate);
        Assert.assertEquals(practiceFormPage.getValueOfDateBirthRow(),dayValue + " " + monthValue + "," + yearValue);
        Assert.assertEquals(practiceFormPage.getSubjectsText(),labelSubjects);
        Assert.assertEquals(practiceFormPage.getValueOfSubjectsRow(),subjectValue);
        Assert.assertEquals(practiceFormPage.getHobbiesText(),labelHobbies);
        Assert.assertEquals(practiceFormPage.getValueOfHobbiesRow(),"Music");
        Assert.assertEquals(practiceFormPage.getPictureText(),labelPicture);
        Assert.assertEquals(practiceFormPage.getValueOfPictureRow(),"Captura.png");
        Assert.assertEquals(practiceFormPage.getAddressText(),"Address");
        Assert.assertEquals(practiceFormPage.getValueOfAddressRow(),textValue);
        Assert.assertEquals(practiceFormPage.getStateCityText(),labelStateCity);
        Assert.assertEquals(practiceFormPage.getValueOfStateCityRow(), stateValue + " " + cityValue);
    }

}
