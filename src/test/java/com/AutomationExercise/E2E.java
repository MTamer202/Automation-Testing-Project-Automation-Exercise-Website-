package com.AutomationExercise;

import com.AutomationExercise.Listeners.TestngListeners;
import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.JsonUtils;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.management.modelmbean.ModelMBeanInfo;

@Listeners(TestngListeners.class)
public class E2E {
    //variables
    /***Variables***/
    //variables
    GUIDriver driver;
    JsonUtils testData;
    String browserName;

//Homepage,SignupLoginPage,SignUpPage,SignUpConfirmation,DeleteConfirmation
    @Test(description = "TC-01: Signup with new email")
    @Story("Good scenario - Signup")
    @Description("Verify that the email is made and then delete it")
    public void SignUpScenario() throws InterruptedException {
        LogsUtils.info("Test Started: loginTest");
        new HomePage(driver)
                .signUpLogin().SignUpValuePut(testData.getJsonData("sign-up-data.username"),testData.getJsonData("sign-up-data.signup-Email"))
                .clickOnSignButton().validSignUpAssertion()
                .genderChoose(testData.getJsonData("sign-up-data.gender"))
                .addPassword(testData.getJsonData("sign-up-data.password"))
                .addBirthDate(testData.getJsonData("sign-up-data.birth-date.day"),
                        testData.getJsonData("sign-up-data.birth-date.month"),
                        testData.getJsonData("sign-up-data.birth-date.year"))
                .addName(testData.getJsonData("sign-up-data.First-name"),
                        testData.getJsonData("sign-up-data.Last-name"))
                .addCompany(testData.getJsonData("sign-up-data.Company"))
                .addAddresses(testData.getJsonData("sign-up-data.Address1"),
                        testData.getJsonData("sign-up-data.Address2"))
                .countryChoose(testData.getJsonData("sign-up-data.Country"))
                .addingState(testData.getJsonData("sign-up-data.state"))
                .addingCity(testData.getJsonData("sign-up-data.City"))
                .addingZipCode(testData.getJsonData("sign-up-data.Zip-code"))
                .addingNumber(testData.getJsonData("sign-up-data.phone-number"))
                .clickOnSubmit().signUpConfirmationAssertion()
                .RegistrationConfirmation()
                .deleteAccount().DeleteAccountConfirmation();
    }
    //configurations
    @BeforeMethod
    public void beforeClass() {
        browserName = PropertiesUtils.getPropertyValue("browserType");
        LogsUtils.info(browserName);
        driver = new GUIDriver(browserName);
        testData = new JsonUtils("test-data");
        LogsUtils.info(browserName + " is Opened Successfully");
        new HomePage(driver).navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.browserActions().closeBrowser();
        // CustomSoftAssertion.customAssertAll();

    }
}
