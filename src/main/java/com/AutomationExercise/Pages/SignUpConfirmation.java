package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpConfirmation {

    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public SignUpConfirmation(GUIDriver driver) {
        this.driver = driver;
    }
    /***Locators***/
    private static final String confirmationButtonLocator = "//*[@data-qa='continue-button']";
    /***Methods***/
    @Step("confirmation on the registration we made")
    public HomePage RegistrationConfirmation(){
        By signUpContinueButton = By.xpath(confirmationButtonLocator);
        driver.elementActions().clickElement(signUpContinueButton);
        LogsUtils.info("registration success");
        return new HomePage(driver);
    }
}