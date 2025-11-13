package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InValidLogin {
    private static String userGmail = "mohamedTamer1235@gmail.com";
    private static String userPassword = "Mohamed123";
    private static String userInValidGmail = "mohamedTamer12@gmail.com";
    private static String userInvalidPassword = "Mohamed12345";
    private static String expectedText = "Your email or password is incorrect!";
    public static void inValidGmailTest(WebDriver webDriver) throws InterruptedException {
        /*** Click Signup/Login ***/
        By signUpButton = By.xpath("//*[contains(text(),' Signup / Login')] ");
        webDriver.findElement(signUpButton).click();
        /***  Signup/Login Page   ***/
        By loginTextInput = By.xpath("//input[@type='email']");
        webDriver.findElement(loginTextInput).sendKeys(userInValidGmail);
        By loginPassword = By.xpath("//input[@type='password']");
        webDriver.findElement(loginPassword).sendKeys(userPassword);
        By loginNavButton = By.xpath("//button[normalize-space(text())='Login']");
        webDriver.findElement(loginNavButton).click();
        Thread.sleep(1000);
        By message = By.xpath("//*[normalize-space(text())='Your email or password is incorrect!']");
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("incorrect"));
        Thread.sleep(1000);

        By homeNavButton = By.xpath("//*[normalize-space(text())='Home']");
        webDriver.findElement(homeNavButton).click();
    }

    public static void inValidPasswordTest(WebDriver webDriver) throws InterruptedException {
        /*** Click Signup/Login ***/
        By signUpButton = By.xpath("//*[contains(text(),' Signup / Login')] ");
        webDriver.findElement(signUpButton).click();
        /***  Signup/Login Page   ***/
        By loginTextInput = By.xpath("//input[@type='email']");
        webDriver.findElement(loginTextInput).sendKeys(userGmail);
        By loginPassword = By.xpath("//input[@type='password']");
        webDriver.findElement(loginPassword).sendKeys(userInvalidPassword);
        By loginNavButton = By.xpath("//button[normalize-space(text())='Login']");
        webDriver.findElement(loginNavButton).click();
        Thread.sleep(1000);
        By message = By.xpath("//*[normalize-space(text())='Your email or password is incorrect!']");
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("incorrect"));

        By homeNavButton = By.xpath("//*[normalize-space(text())='Home']");
        webDriver.findElement(homeNavButton).click();
    }

}
