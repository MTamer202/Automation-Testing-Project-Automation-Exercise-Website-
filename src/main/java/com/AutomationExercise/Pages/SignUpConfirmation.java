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
    private static final By confirmationButtonLocator =By.xpath("//*[@data-qa='continue-button']");

    //methods
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("confirmation on the registration we made")
    public HomePage registrationConfirmation() {
        driver.elementActions().clickElement(confirmationButtonLocator);
        LogsUtils.info("registration success");
        return new HomePage(driver);
    }
}