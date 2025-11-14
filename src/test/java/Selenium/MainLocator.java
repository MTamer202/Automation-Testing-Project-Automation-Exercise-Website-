package Selenium;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MainLocator {
    @Test
    public void SignUpScenarios() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.SignUpValuePut(webDriver);
        SignUpPage.signUpScenario(webDriver);
        SignUpConfirmation.RegistrationConfirmation(webDriver);
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
    }
    @Test
    public void ValidLogin() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
    }
    @Test
    public void InValidLoginEmail() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.inValidGmailTest(webDriver);
        HomePage.HomePage(webDriver);
    }
    @Test
    public void InValidLoginPassword() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.inValidPasswordTest(webDriver);
        HomePage.HomePage(webDriver);
    }
}
