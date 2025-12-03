package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utiles.LogsUtils;

public class SignUpConfirmation {
    /***Locators***/
    private static final String confirmationButtonLocator = "//*[@data-qa='continue-button']";
    /***Methods***/
    @Step("confirmation on the registration we made")
    public static void RegistrationConfirmation(WebDriver webDriver) throws InterruptedException {
        By signUpContinueButton = By.xpath(confirmationButtonLocator);
        webDriver.findElement(signUpContinueButton).click();
        LogsUtils.info("registration success");
        Thread.sleep(1000);
    }
}