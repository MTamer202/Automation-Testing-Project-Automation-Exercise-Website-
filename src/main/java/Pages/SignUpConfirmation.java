package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpConfirmation {
    /***Locators***/
    private static final String confirmationButtonLocator = "//*[@data-qa='continue-button']";
    /***Methods***/
    public static void RegistrationConfirmation(WebDriver webDriver) throws InterruptedException {
        By signUpContinueButton = By.xpath(confirmationButtonLocator);
        webDriver.findElement(signUpContinueButton).click();
        Thread.sleep(1000);
    }
}