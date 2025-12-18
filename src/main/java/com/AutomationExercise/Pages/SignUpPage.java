package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public SignUpPage(GUIDriver driver) {
        this.driver = driver;
    }
    //locators
    private static final String userPasswordLocator = "//input[@id='password']";
    private static final String birthdayLocator = "//select[@id='days']";
    private static final String birthMonthLocator = "//select[@id='months']";
    private static final String birthYearLocator = "//select[@id='years']";
    private static final String userFirstNameLocator = "//input[@id='first_name']";
    private static final String userLastNameLocator = "//input[@id='last_name']";
    private static final String userCompanyLocator = "//input[@id='company']";
    private static final String userAddress1Locator = "//input[@id='address1']";
    private static final String userAddress2Locator = "//input[@id='address2']";
    private static final String userCountryLocator = "//select[@id='country']";
    private static final String userStateLocator = "//input[@id='state']";
    private static final String userCityLocator = "//input[@id='city']";
    private static final String userZipCodeLocator = "//input[@id='zipcode']";
    private static final String userMobileNumberLocator = "//input[@id='mobile_number']";
    private static final String submitButton = "//button[@type='submit']";

    //methods
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("put the values in the Signup Page")
    public static void signUpScenario(WebDriver webDriver) {
        /***  Registration Form ***/

        By signUpSubmitButton = By.xpath(submitButton);
        webDriver.findElement(signUpSubmitButton).click();
        LogsUtils.info("All Values was Put and clicked on submit");
    }

    @Step("adding gender: {gender}")
    public SignUpPage genderChoose(String gender) {
        final String genderLocator = "//label[@for='id_gender";
        switch (gender.toLowerCase()) {
            case "male":
                By signUpMaleGenderId = By.xpath(genderLocator + "1']");
                driver.elementActions().clickElement(signUpMaleGenderId);
                break;
            case "female":
                By signUpFemaleGenderId = By.xpath(genderLocator + "2']");
                driver.elementActions().clickElement(signUpFemaleGenderId);
                break;
        }
        LogsUtils.info("Gender: " + gender + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding password: {password}")
    public SignUpPage addPassword(String password) {
        By signUpPassword = By.xpath(userPasswordLocator);
        driver.elementActions().sendData(signUpPassword, password);
        LogsUtils.info("password: " + password + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding Birthday: {day} - {month} - {year}")
    public SignUpPage addBirthDate(String day, String month, String year) {
        By signUpBirthday = By.xpath(birthdayLocator);
        Select dropdownBirthday = new Select(driver.elementActions().findElement(signUpBirthday));
        dropdownBirthday.selectByVisibleText(day);
        By signUpBirthmonth = By.xpath(birthMonthLocator);
        Select dropdownBirthmonth = new Select(driver.elementActions().findElement(signUpBirthmonth));
        dropdownBirthmonth.selectByVisibleText(month);
        By signUpBirthyear = By.xpath(birthYearLocator);
        Select dropdownBirthyear = new Select(driver.elementActions().findElement(signUpBirthyear));
        dropdownBirthyear.selectByVisibleText(year);
        LogsUtils.info("Birthday: " + day + " - " + month + " - " + year + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding Firstname: {firstName} and lastname: {lastname}")
    public SignUpPage addName(String firstName, String lastname) {
        By signUpFirstName = By.xpath(userFirstNameLocator);
        driver.elementActions().sendData(signUpFirstName, firstName);
        By signUpLastName = By.xpath(userLastNameLocator);
        driver.elementActions().sendData(signUpLastName, lastname);
        LogsUtils.info("full Name: " + firstName + " " + lastname + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding company: {company}")
    public SignUpPage addCompany(String company) {
        By signUpCompany = By.xpath(userCompanyLocator);
        driver.elementActions().sendData(signUpCompany, company);
        LogsUtils.info("Company: " + company + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding address 1: {address1}, and address 2: {address2}")
    public SignUpPage addAddresses(String address1, String address2) {
        By signUpAddress1 = By.xpath(userAddress1Locator);
        driver.elementActions().sendData(signUpAddress1, address1);
        By signUpAddress2 = By.xpath(userAddress2Locator);
        driver.elementActions().sendData(signUpAddress2, address2);
        return new SignUpPage(driver);
    }

    @Step("adding country: {country}")
    public SignUpPage countryChoose(String country) {
        By signUpCountry = By.xpath(userCountryLocator);
        Select dropdownCountry = new Select(driver.elementActions().findElement(signUpCountry));
        dropdownCountry.selectByVisibleText(country);
        return new SignUpPage(driver);
    }

    @Step("adding State: {state}")
    public SignUpPage addingState(String state) {
        By signUpState = By.xpath(userStateLocator);
        driver.elementActions().sendData(signUpState, state);
        return new SignUpPage(driver);
    }

    @Step("adding City: {city}")
    public SignUpPage addingCity(String city) {
        By signUpCity = By.xpath(userCityLocator);
        driver.elementActions().sendData(signUpCity, city);
        return new SignUpPage(driver);
    }

    @Step("adding Zip Code: {code}")
    public SignUpPage addingZipCode(String code) {
        By signUpZipCode = By.xpath(userZipCodeLocator);
        driver.elementActions().sendData(signUpZipCode, code);
        return new SignUpPage(driver);
    }

    @Step("adding phoneNumber: {number}")
    public SignUpPage addingNumber(String number) {
        By signUpMobile = By.xpath(userMobileNumberLocator);
        driver.elementActions().sendData(signUpMobile, number);
        return new SignUpPage(driver);
    }

    @Step("Clicking on submit Button")
    public SignUpPage clickOnSubmit() {
        By signUpSubmitButton = By.xpath(submitButton);
        driver.elementActions().clickElement(signUpSubmitButton);
        LogsUtils.info("All Values was Put and clicked on submit");
        return new SignUpPage(driver);
    }

    //validations
    @Step("verify we go to sign up confirmation page")
    public SignUpConfirmation signUpConfirmationAssertion() {
        driver.validaions().validateEqual(driver.browserActions().getCurrentURl(), PropertiesUtils.getPropertyValue("SignupConfirmationPage")
                ,"confirmation didn't went successfully");
        return new SignUpConfirmation(driver);
    }


}
