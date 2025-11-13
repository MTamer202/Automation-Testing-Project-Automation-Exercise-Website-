package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

    private static String userName = "Tam00ra";
    private static String userGmail = "mohamedTamer123@gmail.com";
    private static String userPassword = "Mohamed123";
    private static String userFirstName = "Mohamed";
    private static String userLastName = "Tamer";
    private static String userCompany = "ITI Army";
    private static String userAddress = "35st Mazen Ehab";
    private static String userState = "Cairo";
    private static String userCity = "El-Mukkatam";
    private static String userZipCode = "15715";
    private static String userMobileNumber= "01025829140";

    public static void signUpScenario(WebDriver webDriver) throws InterruptedException {
        /*** Click Signup/Login ***/
        By signUpButton = By.xpath("//*[contains(text(),' Signup / Login')] ");
        webDriver.findElement(signUpButton).click();

        /***  Signup/Login Page   ***/
        By signUpTextInput = By.xpath("//input[@data-qa='signup-name']");
        webDriver.findElement(signUpTextInput).sendKeys(userName);
        By signUpEmail = By.xpath("//input[@data-qa='signup-email']");
        webDriver.findElement(signUpEmail).sendKeys(userGmail);
        By signUpNavButton = By.xpath("//button[@data-qa='signup-button']");
        webDriver.findElement(signUpNavButton).click();
        Thread.sleep(1000);

        /***  Registration Form ***/
        By signUpGenderId = By.xpath("//label[@for='id_gender1']");
        webDriver.findElement(signUpGenderId).click();
        By signUpPassword = By.xpath("//input[@id='password']");
        webDriver.findElement(signUpPassword).sendKeys(userPassword);
        By signUpBirthday = By.xpath("//select[@id='days']");
        Select dropdownBirthday = new Select(webDriver.findElement(signUpBirthday));
        dropdownBirthday.selectByVisibleText("21");
        By signUpBirthmonth = By.xpath("//select[@id='months']");
        Select dropdownBirthmonth = new Select(webDriver.findElement(signUpBirthmonth));
        dropdownBirthmonth.selectByVisibleText("March");
        By signUpBirthyear = By.xpath("//select[@id='years']");
        Select dropdownBirthyear = new Select(webDriver.findElement(signUpBirthyear));
        dropdownBirthyear.selectByVisibleText("2002");
        By signUpFirstName = By.xpath("//input[@id='first_name']");
        webDriver.findElement(signUpFirstName).sendKeys(userFirstName);
        By signUpLastName = By.xpath("//input[@id='last_name']");
        webDriver.findElement(signUpLastName).sendKeys(userLastName);
        By signUpCompany = By.xpath("//input[@id='company']");
        webDriver.findElement(signUpCompany).sendKeys(userCompany);
        By signUpAddress1 = By.xpath("//input[@id='address1']");
        webDriver.findElement(signUpAddress1).sendKeys(userAddress);
        By signUpAddress2 = By.xpath("//input[@id='address2']");
        webDriver.findElement(signUpAddress2).sendKeys(userAddress);
        By signUpCountry = By.xpath("//select[@id='country']");
        Select dropdownCountry = new Select(webDriver.findElement(signUpCountry));
        dropdownCountry.selectByVisibleText("Canada");
        By signUpState = By.xpath("//input[@id='state']");
        webDriver.findElement(signUpState).sendKeys(userState);
        By signUpCity = By.xpath("//input[@id='city']");
        webDriver.findElement(signUpCity).sendKeys(userCity);
        By signUpZipCode = By.xpath("//input[@id='zipcode']");
        webDriver.findElement(signUpZipCode).sendKeys(userZipCode);
        By signUpMobile = By.xpath("//input[@id='mobile_number']");
        webDriver.findElement(signUpMobile).sendKeys(userMobileNumber);
        By signUpSubmitButton = By.xpath("//button[@type='submit']");
        webDriver.findElement(signUpSubmitButton).click();
        Thread.sleep(1000);

        /*** Confirmation Registration Page ***/
        By signUpContinueButton = By.xpath("//*[@data-qa='continue-button']");
        webDriver.findElement(signUpContinueButton).click();
        Thread.sleep(1000);

        /*** Home page and click on Delete Account ***/
        By signUpDeleteAccount = By.xpath("//*[normalize-space(text())='Delete Account']");
        webDriver.findElement(signUpDeleteAccount).click();
        Thread.sleep(1000);

        /*** Confirmation Registration Page ***/
        webDriver.findElement(signUpContinueButton).click();
        
    }

}
