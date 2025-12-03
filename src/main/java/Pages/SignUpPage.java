package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utiles.LogsUtils;

public class SignUpPage {
    /***Variables***/
    private static final String userPassword = "Mohamed123";
    private static final String userFirstName = "Mohamed";
    private static final String userLastName = "Tamer";
    private static final String userCompany = "ITI Army";
    private static final String userAddress = "35st Mazen Ehab";
    private static final String userState = "Cairo";
    private static final String userCity = "El-Mukkatam";
    private static final String userZipCode = "15715";
    private static final String userMobileNumber= "01025829140";
    /***Locators***/
    private static final String genderLocator = "//label[@for='id_gender1']";
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
    private static final String userStateLocator ="//input[@id='state']";
    private static final String userCityLocator = "//input[@id='city']";
    private static final String userZipCodeLocator ="//input[@id='zipcode']";
    private static final String userMobileNumberLocator= "//input[@id='mobile_number']";
    private static final String submitButton= "//button[@type='submit']";
    /***Methods***/
    @Step("put the values in the Signup Page")
    public static void signUpScenario(WebDriver webDriver) throws InterruptedException {
        /***  Registration Form ***/
        By signUpGenderId = By.xpath(genderLocator);
        webDriver.findElement(signUpGenderId).click();
        By signUpPassword = By.xpath(userPasswordLocator);
        webDriver.findElement(signUpPassword).sendKeys(userPassword);
        By signUpBirthday = By.xpath(birthdayLocator);
        Select dropdownBirthday = new Select(webDriver.findElement(signUpBirthday));
        dropdownBirthday.selectByVisibleText("21");
        By signUpBirthmonth = By.xpath(birthMonthLocator);
        Select dropdownBirthmonth = new Select(webDriver.findElement(signUpBirthmonth));
        dropdownBirthmonth.selectByVisibleText("March");
        By signUpBirthyear = By.xpath(birthYearLocator);
        Select dropdownBirthyear = new Select(webDriver.findElement(signUpBirthyear));
        dropdownBirthyear.selectByVisibleText("2002");
        By signUpFirstName = By.xpath(userFirstNameLocator);
        webDriver.findElement(signUpFirstName).sendKeys(userFirstName);
        By signUpLastName = By.xpath(userLastNameLocator);
        webDriver.findElement(signUpLastName).sendKeys(userLastName);
        By signUpCompany = By.xpath(userCompanyLocator);
        webDriver.findElement(signUpCompany).sendKeys(userCompany);
        By signUpAddress1 = By.xpath(userAddress1Locator);
        webDriver.findElement(signUpAddress1).sendKeys(userAddress);
        By signUpAddress2 = By.xpath(userAddress2Locator);
        webDriver.findElement(signUpAddress2).sendKeys(userAddress);
        By signUpCountry = By.xpath(userCountryLocator);
        Select dropdownCountry = new Select(webDriver.findElement(signUpCountry));
        dropdownCountry.selectByVisibleText("Canada");
        By signUpState = By.xpath(userStateLocator);
        webDriver.findElement(signUpState).sendKeys(userState);
        By signUpCity = By.xpath(userCityLocator);
        webDriver.findElement(signUpCity).sendKeys(userCity);
        By signUpZipCode = By.xpath(userZipCodeLocator);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        webDriver.findElement(signUpZipCode).sendKeys(userZipCode);
        By signUpMobile = By.xpath(userMobileNumberLocator);
        webDriver.findElement(signUpMobile).sendKeys(userMobileNumber);
        actions.scrollByAmount(0, 500).perform();
        By signUpSubmitButton = By.xpath(submitButton);
        webDriver.findElement(signUpSubmitButton).click();
        LogsUtils.info("All Values was Put and clicked on submit");
        Thread.sleep(1000);
    }
    @Step("Get the user address")
    public static String GetUserAddress(WebDriver webDriver){
        LogsUtils.info("Got the user name address: "+userAddress);
        return userAddress;
    }

}
