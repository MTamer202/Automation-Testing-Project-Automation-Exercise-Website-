package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    /***Locators***/
    private static final String SignUpLoginButtonLocator = "//*[contains(text(),' Signup / Login')] ";
    private static final String deleteAccountButtonLocator = "//*[normalize-space(text())='Delete Account']";
    private static final String homePageButtonLocator = "//*[normalize-space(text())='Home']";
    private static final String homePageLogoutButtonLocator = "//*[normalize-space(text())='Logout']";
    private static final String homePageProductsButtonLocator = "//*[normalize-space(text())='Products']";
    private static final String homePageCartButtonLocator = "//*[normalize-space(text())='Cart'] ";
    private static final String homePageContactUsButtonLocator = "//*[normalize-space(text())='Contact us'] ";
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
    public static void LogoutAccount(WebDriver webDriver) throws InterruptedException {
        By logoutButton = By.xpath(homePageLogoutButtonLocator);
        webDriver.findElement(logoutButton).click();
        Thread.sleep(1000);
    }
    public static void ProductPage(WebDriver webDriver){
        By productButton = By.xpath(homePageProductsButtonLocator);
        webDriver.findElement(productButton).click();

    }
    public static void CartPage(WebDriver webDriver) throws InterruptedException {
        By CartButton = By.xpath(homePageCartButtonLocator);
        webDriver.findElement(CartButton).click();
        Thread.sleep(1000);
    }
    public static void ContactUsPage(WebDriver webDriver) throws InterruptedException {
        By contactUsButton = By.xpath(homePageContactUsButtonLocator);
        webDriver.findElement(contactUsButton).click();
        Thread.sleep(1000);
    }

}
