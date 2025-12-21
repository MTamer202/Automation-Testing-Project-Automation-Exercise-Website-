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
    private static final By userPasswordLocator =By.xpath("//input[@id='password']");
    private static final By birthdayLocator =By.xpath("//select[@id='days']");
    private static final By birthMonthLocator =By.xpath("//select[@id='months']");
    private static final By birthYearLocator =By.xpath("//select[@id='years']");
    private static final By userFirstNameLocator =By.xpath("//input[@id='first_name']");
    private static final By userLastNameLocator =By.xpath("//input[@id='last_name']");
    private static final By userCompanyLocator =By.xpath("//input[@id='company']");
    private static final By userAddress1Locator =By.xpath("//input[@id='address1']");
    private static final By userAddress2Locator =By.xpath("//input[@id='address2']");
    private static final By userCountryLocator =By.xpath("//select[@id='country']");
    private static final By userStateLocator =By.xpath("//input[@id='state']");
    private static final By userCityLocator =By.xpath("//input[@id='city']");
    private static final By userZipCodeLocator =By.xpath("//input[@id='zipcode']");
    private static final By userMobileNumberLocator =By.xpath("//input[@id='mobile_number']");
    private static final By submitButton =By.xpath("//button[@type='submit']");

    private static final String genderLocator = "//label[@for='id_gender";

    //methods
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("adding gender: {gender}")
    public SignUpPage genderChoose(String gender) {
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
        driver.elementActions().sendData(userPasswordLocator, password);
        LogsUtils.info("password: " + password + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding Birthday: {day} - {month} - {year}")
    public SignUpPage addBirthDate(String day, String month, String year) {
        Select dropdownBirthday = new Select(driver.elementActions().findElement(birthdayLocator));
        dropdownBirthday.selectByVisibleText(day);
        Select dropdownBirthmonth = new Select(driver.elementActions().findElement(birthMonthLocator));
        dropdownBirthmonth.selectByVisibleText(month);
        Select dropdownBirthyear = new Select(driver.elementActions().findElement(birthYearLocator));
        dropdownBirthyear.selectByVisibleText(year);
        LogsUtils.info("Birthday: " + day + " - " + month + " - " + year + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding Firstname: {firstName} and lastname: {lastname}")
    public SignUpPage addName(String firstName, String lastname) {
        driver.elementActions().sendData(userFirstNameLocator, firstName);
        driver.elementActions().sendData(userLastNameLocator, lastname);
        LogsUtils.info("full Name: " + firstName + " " + lastname + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding company: {company}")
    public SignUpPage addCompany(String company) {
        driver.elementActions().sendData(userCompanyLocator, company);
        LogsUtils.info("Company: " + company + " is added");
        return new SignUpPage(driver);
    }

    @Step("adding address 1: {address1}, and address 2: {address2}")
    public SignUpPage addAddresses(String address1, String address2) {
        driver.elementActions().sendData(userAddress1Locator, address1);
        driver.elementActions().sendData(userAddress2Locator, address2);
        return new SignUpPage(driver);
    }

    @Step("adding country: {country}")
    public SignUpPage countryChoose(String country) {
        Select dropdownCountry = new Select(driver.elementActions().findElement(userCountryLocator));
        dropdownCountry.selectByVisibleText(country);
        return new SignUpPage(driver);
    }

    @Step("adding State: {state}")
    public SignUpPage addingState(String state) {
        driver.elementActions().sendData(userStateLocator, state);
        return new SignUpPage(driver);
    }

    @Step("adding City: {city}")
    public SignUpPage addingCity(String city) {
        driver.elementActions().sendData(userCityLocator, city);
        return new SignUpPage(driver);
    }

    @Step("adding Zip Code: {code}")
    public SignUpPage addingZipCode(String code) {
        driver.elementActions().sendData(userZipCodeLocator, code);
        return new SignUpPage(driver);
    }

    @Step("adding phoneNumber: {number}")
    public SignUpPage addingNumber(String number) {
        driver.elementActions().sendData(userMobileNumberLocator, number);
        return new SignUpPage(driver);
    }

    @Step("Clicking on submit Button")
    public SignUpPage clickOnSubmit() {
        driver.elementActions().clickElement(submitButton);
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
