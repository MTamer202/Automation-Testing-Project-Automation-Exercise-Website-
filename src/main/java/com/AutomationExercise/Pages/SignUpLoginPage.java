package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;

public class SignUpLoginPage {

    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public SignUpLoginPage(GUIDriver driver) {
        this.driver = driver;
    }

    /***Variables***/
    private static final String userName = "Tam00ra";
    private static final String userGmail = "mohamedTamer123@gmail.com";
    private static final String validEmail = "mohamedTamer1234@gmail.com";
    private static final String validPassword = "Mohamed123";
    private static String userInValidGmail = "mohamedTamer12@gmail.com";
    private static String userInvalidPassword = "Mohamed12345";
    private static String expectedSignUpURL = "https://www.automationexercise.com/signup";

    /***Locators***/
    private static final String signUpUsernameLocator = "//input[@data-qa='signup-name']";
    private static final String signUpEmailLocator = "//input[@data-qa='signup-email']";
    private static final String signUpButtonLocator = "//button[@data-qa='signup-button']";

    private static final String loginEmailLocator = "//input[@type='email']";
    private static final String loginPasswordLocator = "//input[@type='password']";
    private static final String loginButtonLocator = "//button[normalize-space(text())='Login']";
    private static final String assertionIncorrectMessage = "//*[normalize-space(text())='Your email or password is incorrect!']";
    private static final String assertionExistsMessage = "//*[normalize-space(text())='Email Address already exist!']";
    private static final String assertionLoginAs = "//a[text() =' Logged in as ']";


    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("Signup Value Put to register")
    public SignUpLoginPage SignUpValuePut(String userName, String userGmail) {
        /***  Signup/Login Page   ***/
        By signUpTextInput = By.xpath(signUpUsernameLocator);
        driver.elementActions().sendData(signUpTextInput, userName);
        LogsUtils.info("username: " + userName + " is added");
        By signUpEmail = By.xpath(signUpEmailLocator);
        driver.elementActions().sendData(signUpEmail, userGmail);
        LogsUtils.info("Gmail: " + userGmail + " is added");
        return new SignUpLoginPage(driver);
    }

    @Step("click on sign up button")
    public SignUpLoginPage clickOnSignButton() {
        By signUpNavButton = By.xpath(signUpButtonLocator);
        driver.elementActions().clickElement(signUpNavButton);
        LogsUtils.info("signUp value was Put and signUp Button was clicked");
        return new SignUpLoginPage(driver);
    }

    @Step("Login Value Put to register")
    public SignUpLoginPage LoginValuePut(String loginEmail, String password) {
        /***  Signup/Login Page   ***/
        By loginTextInput = By.xpath(loginEmailLocator);
        driver.elementActions().sendData(loginTextInput, loginEmail);
        By loginPassword = By.xpath(loginPasswordLocator);
        driver.elementActions().sendData(loginPassword, password);
        return new SignUpLoginPage(driver);
    }

    @Step("click on login")
    public SignUpLoginPage clickOnLogin() {
        By loginNavButton = By.xpath(loginButtonLocator);
        driver.elementActions().clickElement(loginNavButton);
        LogsUtils.info("login value was Put and signUp Button was clicked");
        return new SignUpLoginPage(driver);
    }

    //validation
    public SignUpPage validSignUpAssertion() {
        driver.validaions().validateEqual(driver.browserActions().getCurrentURl(), expectedSignUpURL, "we are not in SignUp Url");
        LogsUtils.info("Went to Sign up Page");
        return new SignUpPage(driver);
    }

    public HomePage validLoginAssertion() {
        driver.validaions().validateTrue(driver.elementActions().getText(By.xpath(assertionLoginAs)).contains("Logged in as"), "we are not in SignUp Url");
        LogsUtils.info("Valid Login");
        return new HomePage(driver);
    }

    public HomePage invalidLoginAssertion() {
        By message = By.xpath(assertionIncorrectMessage);
        driver.validaions().validateTrue(driver.elementActions().getText(message).contains("incorrect"),
                "Login isn't Failed");
        LogsUtils.info("Email:" + driver.elementActions().getTextfromInput(By.xpath(loginEmailLocator)) +
                "or Password: " + driver.elementActions().getTextfromInput(By.xpath(loginPasswordLocator)) +
                "is incorecct");
        return new HomePage(driver);
    }

    public HomePage invalidSignUpAssertion() {
        By message = By.xpath(assertionExistsMessage);
        driver.validaions().validateTrue(driver.elementActions().getText(message).contains("Email Address already exist!"),
                "SignUp isn't Failed");
        LogsUtils.info("Email: " + driver.elementActions().getTextfromInput(By.xpath(signUpEmailLocator)) +
                "is already exists");
        return new HomePage(driver);
    }


}