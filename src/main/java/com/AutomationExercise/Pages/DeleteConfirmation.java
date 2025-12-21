package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeleteConfirmation {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public DeleteConfirmation(GUIDriver driver) {
        this.driver = driver;
    }


    //locators
    private static final By confirmationButtonLocator =By.xpath( "//*[@data-qa='continue-button']");

    //methods
       @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("Confirmation Page on Delete Account ")
    public HomePage deleteAccountConfirmation() {
        driver.elementActions().clickElement(confirmationButtonLocator);
        LogsUtils.info("Account Deleted Successfully");
        return new HomePage(driver);
    }
}
