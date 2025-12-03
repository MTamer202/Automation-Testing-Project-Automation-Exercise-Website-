package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.LogsUtils;

public class DeleteConfirmation {
    /***Locators***/
    private static final String confirmationButtonLocator = "//*[@data-qa='continue-button']";
    /***Methods***/
    @Step("Confirmation Page on Delete Account ")
    public static void DeleteAccountConfirmation(WebDriver webDriver) throws InterruptedException {
        By deleteAccountConfirmationButton = By.xpath(confirmationButtonLocator);
        webDriver.findElement(deleteAccountConfirmationButton).click();
        LogsUtils.info("Account Deleted Successfully");
        Thread.sleep(1000);
    }
}
