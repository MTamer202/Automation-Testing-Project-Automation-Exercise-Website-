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
    @Story("Good scenario - Signup/Login Page")
    @Description("Verify that the email is made and then delete it")
    public void SignUpScenario() {
        LogsUtils.info("Test Started: loginTest");
        new HomePage(driver)
                .signUpLogin().SignUpValuePut(testData.getJsonData("sign-up-data.username"), testData.getJsonData("sign-up-data.signup-Email"))
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

    @Test(description = "TC-02: Login with a valid account")
    @Story("Good scenario - Signup/Login Page")
    @Description("Verify that the email is valid and register")
    public void ValidLogin() {
        new HomePage(driver).signUpLogin().LoginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin().validLoginAssertion();
    }

    @Test(description = "TC-03: Login with a invalid account")
    @Story("Bad Scenario - Signup/Login Page")
    @Description("Verify that the login is failed due to wrong email")
    public void InValidLoginEmail() {
        new HomePage(driver).signUpLogin().LoginValuePut(testData.getJsonData("login-data.invalid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin().invalidLoginAssertion().getHomePage();
    }

    @Test(description = "TC-04: Login with a invalid account")
    @Story("Bad Scenario - Signup/Login Page")
    @Description("Verify that the login is failed due to wrong password")
    public void InValidLoginPassword() {
        new HomePage(driver).signUpLogin().LoginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.invalid-password"))
                .clickOnLogin().invalidLoginAssertion().getHomePage();
    }

    @Test(description = "TC-05: Logout from account")
    @Story("Good Scenario - Signup/Login Page")
    @Description("Verify that the logout is done correctly")
    public void LogoutUser() {
        new HomePage(driver).signUpLogin().LoginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin().validLoginAssertion().logoutAccount().logoutAssertionNavigateToLogin();
    }

    @Test(description = "TC-06: register with existing user")
    @Story("Bad Scenario - Signup/Login Page")
    @Description("Verify that the Register is failed")
    public void RegisterWithExistingUserName() {
        new HomePage(driver).signUpLogin().SignUpValuePut(testData.getJsonData("sign-up-data.username"),
                        testData.getJsonData("login-data.valid-email")).clickOnSignButton()
                .invalidSignUpAssertion();

    }

    @Test(description = "TC-07: Contact us form ")
    @Story("Good Scenario - Contact us Page")
    @Description("Verify that the Contact us is formed successfully")
    public void ContactUsForm() {
        new HomePage(driver).contactUsPage().puttingName(testData.getJsonData("sign-up-data.First-name")
                        + " " + testData.getJsonData("sign-up-data.Last-name"))
                .puttingEmail(testData.getJsonData("login-data.valid-email"))
                .puttingSubject("Automaion Testing")
                .puttingMessageInGetInTouch("Hello I am Tamer and I am Trying to find peace")
                .UploadingFile("Me.pdf")
                .clickSubmit().ContactUsAssertions();
    }

    @Test(description = "TC-08: Test Cases Page Perform Successfully")
    @Story("Good Scenario - Test Cases Page")
    @Description("Verify that the login is failed")
    public void TestCases() {
        new HomePage(driver)
                .testCasesPage()
                .TestCasesAssertion()
                .navigateToHomePage();
    }

    @Test(description = "TC-09: Login with a valid account")
    @Story("Good Scenario - Products Page")
    @Description("Verify that the Products is shown")
    public void ProductsVerify() {
        new HomePage(driver)
                .productPage().AllProductAssertion()
                .ViewProduct("1")
                .ProductAssertion()
                .navigateToHomePage();
    }

    @Test(description = "TC-10: Search on a specific Product")
    @Story("Good Scenario - Products Page")
    @Description("Verify that the searched Product is found successfully")
    public void ProductSearch() {
        new HomePage(driver)
                .productPage().AllProductAssertion()
                .productSearch("Blue top")
                .searchProductAssertion("Blue top")
                .navigateToHomePage();
    }

    @Test(description = "TC-11: Subscription in home page")
    @Story("Good Scenario - Home Page")
    @Description("Verify that the subscription is performed successfully in home Page")
    public void SubscriptionInHomePage() {
        new HomePage(driver)
                .subscriptionAssertion()
                .addEmailToSubscription(testData.getJsonData("login-data.valid-email"))
                .pressArrowSubscription()
                .successfullySubscriptionEmailAssertion();
    }

    @Test(description = "TC-12: Subscription in Cart page")
    @Story("Good Scenario - Cart Page")
    @Description("Verify that the subscription is performed successfully In Cart Page")
    public void SubscriptionInCartPage() {
        new HomePage(driver)
                .cartPage()
                .SubscriptionEmailLocationAssertion()
                .SubscriptionEmail(testData.getJsonData("login-data.valid-email"))
                .clickOnArrowOfSubscription()
                .subscriptionEmailSuccessfullyAssertion();
    }

    //configurations
    @BeforeMethod
    public void beforeClass() {
        browserName = PropertiesUtils.getPropertyValue("browserType");
        LogsUtils.info(browserName);
        driver = new GUIDriver(browserName);
        testData = new JsonUtils("test-data");
        LogsUtils.info(browserName + " is Opened Successfully");
        new HomePage(driver).navigateToHomePage();
    }


    @AfterMethod
    public void tearDown() {
        driver.browserActions().closeBrowser();
        // CustomSoftAssertion.customAssertAll();

    }
}
