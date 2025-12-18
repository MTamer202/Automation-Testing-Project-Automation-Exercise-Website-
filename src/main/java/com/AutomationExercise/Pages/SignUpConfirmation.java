package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignUpConfirmation {

    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public SignUpConfirmation(GUIDriver driver) {
        this.driver = driver;
    }

    //locaters
    private static final String confirmationButtonLocator = "//*[@data-qa='continue-button']";

    //methods
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("confirmation on the registration we made")
    public HomePage registrationConfirmation() {
        By signUpContinueButton = By.xpath(confirmationButtonLocator);
        driver.elementActions().clickElement(signUpContinueButton);
        LogsUtils.info("registration success");
        return new HomePage(driver);
    }
}