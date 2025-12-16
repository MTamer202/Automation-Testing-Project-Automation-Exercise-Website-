package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteConfirmation {
    //code
    //variables
    private final GUIDriver driver;
    //constructors
    public DeleteConfirmation(GUIDriver driver){
        this.driver = driver;
    }


    /***Locators***/
    private static final String confirmationButtonLocator = "//*[@data-qa='continue-button']";
    /***Methods***/
    @Step("Confirmation Page on Delete Account ")
    public HomePage DeleteAccountConfirmation(){
        By deleteAccountConfirmationButton = By.xpath(confirmationButtonLocator);
        driver.elementActions().clickElement(deleteAccountConfirmationButton);
        LogsUtils.info("Account Deleted Successfully");
        return new HomePage(driver);
    }
}
