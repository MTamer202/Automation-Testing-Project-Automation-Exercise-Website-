package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidLogin {

    private static String userGmail = "mohamedTamer1234@gmail.com";
    private static String userPassword = "Mohamed123";

    public static void signUpScenario(WebDriver webDriver) throws InterruptedException {
        /*** Click Signup/Login ***/
        By signUpButton = By.xpath("//*[contains(text(),' Signup / Login')] ");
        webDriver.findElement(signUpButton).click();
        /***  Signup/Login Page   ***/
        By loginTextInput = By.xpath("//input[@type='email']");
        webDriver.findElement(loginTextInput).sendKeys(userGmail);
        By loginPassword = By.xpath("//input[@type='password']");
        webDriver.findElement(loginPassword).sendKeys(userPassword);
        By loginNavButton = By.xpath("//button[normalize-space(text())='Login']");
        webDriver.findElement(loginNavButton).click();
        Thread.sleep(1000);

        /*** Home page and click on Delete Account ***/
        By loginDeleteAccount = By.xpath("//*[normalize-space(text())='Delete Account']");
        webDriver.findElement(loginDeleteAccount).click();
        Thread.sleep(1000);

        /*** Confirmation Registration Page ***/
        By loginContinueButton = By.xpath("//*[@data-qa='continue-button']");
        webDriver.findElement(loginContinueButton).click();

    }
}
