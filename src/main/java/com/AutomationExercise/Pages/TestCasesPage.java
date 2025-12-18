package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TestCasesPage {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public TestCasesPage(GUIDriver driver) {
        this.driver = driver;
    }
    //Locators
    private static final String TestCasesAssertionLocator = "//h5";
    //methods
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    //validations
    @Step("Make sure that Test Cases appears")
    public HomePage testCasesAssertion() {
        By message = By.xpath(TestCasesAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("TestCasesAssertionMessage")), "TC page doesn't match");
        LogsUtils.info("Test Cases is found correctly");
        return new HomePage(driver);
    }

}
