package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    /***Locators***/
    private static final String SignUpLoginButtonLocator = "//*[contains(text(),' Signup / Login')] ";
    private static final String deleteAccountButtonLocator = "//*[normalize-space(text())='Delete Account']";
    private static final String homePageButtonLocator = "//*[normalize-space(text())='Home']";
    /***Methods***/
    public static void HomePage(WebDriver webDriver){
        By homeNavButton = By.xpath(homePageButtonLocator);
        webDriver.findElement(homeNavButton).click();

    }
    public static void SignUpLogin(WebDriver webDriver){
        By signUpButton = By.xpath(SignUpLoginButtonLocator);
        webDriver.findElement(signUpButton).click();

    }
    public static void DeleteAccount(WebDriver webDriver) throws InterruptedException {
        By deleteAccountButton = By.xpath(deleteAccountButtonLocator);
        webDriver.findElement(deleteAccountButton).click();
        Thread.sleep(1000);
    }
}
