package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class SignUpLoginPage {

    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public SignUpLoginPage(GUIDriver driver) {
        this.driver = driver;
    }

    //locators
    private static final By signUpUsernameLocator =By.xpath("//input[@data-qa='signup-name']");
    private static final By signUpEmailLocator =By.xpath("//input[@data-qa='signup-email']");
    private static final By signUpButtonLocator =By.xpath("//button[@data-qa='signup-button']");

    private static final By loginEmailLocator =By.xpath("//input[@type='email']");
    private static final By loginPasswordLocator =By.xpath("//input[@type='password']");
    private static final By loginButtonLocator =By.xpath("//button[normalize-space(text())='Login']");
    private static final By assertionIncorrectMessage =By.xpath("//*[normalize-space(text())='Your email or password is incorrect!']");
    private static final By assertionExistsMessage =By.xpath("//*[normalize-space(text())='Email Address already exist!']");
    private static final By assertionLoginAs =By.xpath("//a[text() =' Logged in as ']");


    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("Signup Value Put to register")
    public SignUpLoginPage signUpValuePut(String userName, String userGmail) {
        /***  Signup/Login Page   ***/
        driver.elementActions().sendData(signUpUsernameLocator, userName);
        LogsUtils.info("username: " + userName + " is added");
        driver.elementActions().sendData(signUpEmailLocator, userGmail);
        LogsUtils.info("Gmail: " + userGmail + " is added");
        return new SignUpLoginPage(driver);
    }

    @Step("click on sign up button")
    public SignUpLoginPage clickOnSignButton() {
        driver.elementActions().clickElement(signUpButtonLocator);
        LogsUtils.info("signUp value was Put and signUp Button was clicked");
        return new SignUpLoginPage(driver);
    }

    @Step("Login Value Put to register")
    public SignUpLoginPage loginValuePut(String loginEmail, String password) {
        /***  Signup/Login Page   ***/
        driver.elementActions().sendData(loginEmailLocator, loginEmail);
        driver.elementActions().sendData(loginPasswordLocator, password);
        return new SignUpLoginPage(driver);
    }

    @Step("click on login")
    public SignUpLoginPage clickOnLogin() {
        driver.elementActions().clickElement(loginButtonLocator);
        LogsUtils.info("login value was Put and signUp Button was clicked");
        return new SignUpLoginPage(driver);
    }

    //validation
    public SignUpPage validSignUpAssertion() {
        driver.validaions().validateEqual(driver.browserActions().getCurrentURl(), PropertiesUtils.getPropertyValue("signupURL"), "we are not in SignUp Url");
        LogsUtils.info("Went to Sign up Page");
        return new SignUpPage(driver);
    }

    public HomePage validLoginAssertion() {
        driver.validaions().validateTrue(driver.elementActions().getText(assertionLoginAs).contains("Logged in as"), "we are not in SignUp Url");
        LogsUtils.info("Valid Login");
        return new HomePage(driver);
    }

    public HomePage invalidLoginAssertion() {
        driver.validaions().validateTrue(driver.elementActions().getText(assertionIncorrectMessage).contains("incorrect"),
                "Login isn't Failed");
        LogsUtils.info("Email:" + driver.elementActions().getTextfromInput(loginEmailLocator) +
                "or Password: " + driver.elementActions().getTextfromInput(loginPasswordLocator) +
                "is incorecct");
        return new HomePage(driver);
    }

    public HomePage invalidSignUpAssertion() {
        driver.validaions().validateTrue(driver.elementActions().getText(assertionExistsMessage)
                        .contains(PropertiesUtils.getPropertyValue("emailAlreadyExists")),
                "SignUp isn't Failed");
        LogsUtils.info("Email: " + driver.elementActions().getTextfromInput(signUpEmailLocator) +
                "is already exists");
        return new HomePage(driver);
    }


}