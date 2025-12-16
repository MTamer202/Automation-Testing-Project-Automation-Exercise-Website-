package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public TestCasesPage(GUIDriver driver) {
        this.driver = driver;
    }

    /***Variables***/
    private static final String TestCasesAssertionMessage = "Below is the list of test Cases for you to practice the Automation";

    /***Locators***/
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    private static final String TestCasesAssertionLocator = "//h5";

    @Step("Make sure that Test Cases appears")
    public HomePage TestCasesAssertion() {
        By message = By.xpath(TestCasesAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains(TestCasesAssertionMessage), "TC page doesn't match");
        LogsUtils.info("Test Cases is found correctly");
        return new HomePage(driver);
    }

}
