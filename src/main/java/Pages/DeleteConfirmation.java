package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteConfirmation {
    /***Locators***/
    private static final String confirmationButtonLocator = "//*[@data-qa='continue-button']";
    /***Methods***/
    public static void DeleteAccountConfirmation(WebDriver webDriver) throws InterruptedException {
        By deleteAccountConfirmationButton = By.xpath(confirmationButtonLocator);
        webDriver.findElement(deleteAccountConfirmationButton).click();
        Thread.sleep(1000);
    }
}
