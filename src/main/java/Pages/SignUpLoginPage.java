package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUpLoginPage {
    /***Variables***/
    private static final String userName = "Tam00ra";
    private static final String userGmail = "mohamedTamer123@gmail.com";
    private static final String validEmail =  "mohamedTamer123@gmail.com";
    private static final String validPassword = "Mohamed123";
    private static String userInValidGmail = "mohamedTamer12@gmail.com";
    private static String userInvalidPassword = "Mohamed12345";
    private static String expectedText = "Your email or password is incorrect!";
    /***Locators***/
    private static final String signUpUsernameLocator = "//input[@data-qa='signup-name']";
    private static final String signUpEmailLocator = "//input[@data-qa='signup-email']";
    private static final String signUpButtonLocator = "//button[@data-qa='signup-button']";

    private static final String loginEmailLocator = "//input[@type='email']";
    private static final String loginPasswordLocator = "//input[@type='password']";
    private static final String loginButtonLocator = "//button[normalize-space(text())='Login']";
    private static final String assertionIncorrectMessage ="//*[normalize-space(text())='Your email or password is incorrect!']";




    public static void SignUpValuePut(WebDriver webDriver) throws InterruptedException {
        /***  Signup/Login Page   ***/
        By signUpTextInput = By.xpath(signUpUsernameLocator);
        webDriver.findElement(signUpTextInput).sendKeys(userName);
        By signUpEmail = By.xpath(signUpEmailLocator);
        webDriver.findElement(signUpEmail).sendKeys(userGmail);
        By signUpNavButton = By.xpath(signUpButtonLocator);
        webDriver.findElement(signUpNavButton).click();
        Thread.sleep(1000);
    }

    public static void LoginValuePut(WebDriver webDriver) throws InterruptedException {
        /***  Signup/Login Page   ***/
        By loginTextInput = By.xpath(loginEmailLocator);
        webDriver.findElement(loginTextInput).sendKeys(validEmail);
        By loginPassword = By.xpath(loginPasswordLocator);
        webDriver.findElement(loginPassword).sendKeys(validPassword);
        By loginNavButton = By.xpath(loginButtonLocator);
        webDriver.findElement(loginNavButton).click();
        Thread.sleep(1000);
    }

    public static void inValidGmailTest(WebDriver webDriver) throws InterruptedException {
        By loginTextInput = By.xpath(loginEmailLocator);
        webDriver.findElement(loginTextInput).sendKeys(userInValidGmail);
        By loginPassword = By.xpath(loginPasswordLocator);
        webDriver.findElement(loginPassword).sendKeys(validPassword);
        By loginNavButton = By.xpath(loginButtonLocator);
        webDriver.findElement(loginNavButton).click();
        Thread.sleep(1000);
        By message = By.xpath(assertionIncorrectMessage);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("incorrect"));
        Thread.sleep(1000);
    }

    public static void inValidPasswordTest(WebDriver webDriver) throws InterruptedException {
        By loginTextInput = By.xpath(loginEmailLocator);
        webDriver.findElement(loginTextInput).sendKeys(userGmail);
        By loginPassword = By.xpath(loginPasswordLocator);
        webDriver.findElement(loginPassword).sendKeys(userInvalidPassword);
        By loginNavButton = By.xpath(loginButtonLocator);
        webDriver.findElement(loginNavButton).click();
        Thread.sleep(1000);
        By message = By.xpath(assertionIncorrectMessage);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("incorrect"));
        Thread.sleep(1000);
    }

    }