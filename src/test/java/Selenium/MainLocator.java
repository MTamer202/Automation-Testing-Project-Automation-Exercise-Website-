package Selenium;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MainLocator {

    public final String loginUrlValue = "https://www.automationexercise.com/login";

    @Test
    public void SignUpScenario() throws InterruptedException {
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
    @Test
    public void LogoutUser() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        HomePage.LogoutAccount(webDriver);
        Assert.assertEquals(loginUrlValue,webDriver.getCurrentUrl());
    }

}
