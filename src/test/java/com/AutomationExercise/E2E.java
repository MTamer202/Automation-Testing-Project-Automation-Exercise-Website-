package com.AutomationExercise;

import com.AutomationExercise.Listeners.TestngListeners;
import com.AutomationExercise.Pages.HomePage;
import com.AutomationExercise.Pages.PaymentPage;
import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.JsonUtils;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestngListeners.class)
public class E2E {
    //variables
    GUIDriver driver;
    JsonUtils testData;
    String browserName;
    @Test(description = "TC-01: Signup with new email")
    @Story("Good scenario - Signup/Login Page")
    @Description("Verify that the email is made and then delete it")
    public void SignUpScenario() {
        LogsUtils.info("Test Started: loginTest");
        new HomePage(driver)
                .signUpLogin().signUpValuePut(testData.getJsonData("sign-up-data.username"), testData.getJsonData("sign-up-data.signup-Email"))
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
                .registrationConfirmation()
                .deleteAccount().deleteAccountConfirmation();
    }

    @Test(description = "TC-02: Login with a valid account")
    @Story("Good scenario - Signup/Login Page")
    @Description("Verify that the email is valid and register")
    public void ValidLogin() {
        new HomePage(driver).signUpLogin().loginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin().validLoginAssertion();
    }

    @Test(description = "TC-03: Login with a invalid account")
    @Story("Bad Scenario - Signup/Login Page")
    @Description("Verify that the login is failed due to wrong email")
    public void InValidLoginEmail() {
        new HomePage(driver).signUpLogin().loginValuePut(testData.getJsonData("login-data.invalid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin().invalidLoginAssertion().getHomePage();
    }

    @Test(description = "TC-04: Login with a invalid account")
    @Story("Bad Scenario - Signup/Login Page")
    @Description("Verify that the login is failed due to wrong password")
    public void InValidLoginPassword() {
        new HomePage(driver).signUpLogin().loginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.invalid-password"))
                .clickOnLogin().invalidLoginAssertion().getHomePage();
    }

    @Test(description = "TC-05: Logout from account")
    @Story("Good Scenario - Signup/Login Page")
    @Description("Verify that the logout is done correctly")
    public void LogoutUser() {
        new HomePage(driver).signUpLogin().loginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin().validLoginAssertion().logoutAccount().logoutAssertionNavigateToLogin();
    }

    @Test(description = "TC-06: register with existing user")
    @Story("Bad Scenario - Signup/Login Page")
    @Description("Verify that the Register is failed")
    public void RegisterWithExistingUserName() {
        new HomePage(driver).signUpLogin().signUpValuePut(testData.getJsonData("sign-up-data.username"),
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
                .puttingSubject(testData.getJsonData("contact-us.subject"))
                .puttingMessageInGetInTouch(testData.getJsonData("contact-us.message"))
                .uploadingFile(testData.getJsonData("contact-us.file-path"))
                .clickSubmit().contactUsAssertions();
    }

    @Test(description = "TC-08: Test Cases Page Perform Successfully")
    @Story("Good Scenario - Test Cases Page")
    @Description("Verify that the login is failed")
    public void TestCases() {
        new HomePage(driver)
                .testCasesPage()
                .testCasesAssertion()
                .navigateToHomePage();
    }

    @Test(description = "TC-09: Login with a valid account")
    @Story("Good Scenario - Products Page")
    @Description("Verify that the Products is shown")
    public void ProductsVerify() {
        new HomePage(driver)
                .productPage().allProductAssertion()
                .viewProduct(testData.getJsonData("products.first-product-id"))
                .productAssertion()
                .navigateToHomePage();
    }

    @Test(description = "TC-10: Search on a specific Product")
    @Story("Good Scenario - Products Page")
    @Description("Verify that the searched Product is found successfully")
    public void ProductSearch() {
        new HomePage(driver)
                .productPage().allProductAssertion()
                .productSearch(testData.getJsonData("products.first-product-name"))
                .searchProductAssertion(testData.getJsonData("products.first-product-name"))
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
                .subscriptionEmailLocationAssertion()
                .subscriptionEmail(testData.getJsonData("login-data.valid-email"))
                .clickOnArrowOfSubscription()
                .subscriptionEmailSuccessfullyAssertion();
    }

    @Test(description = "TC-13: Add products to cart")
    @Story("Good Scenario - Cart Page")
    @Description("Verify that the Product is added to cart successfully")
    public void AddToCart() {
        new HomePage(driver)
                .productPage()
                .allProductAssertion()
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .continueShopping()
                .addToCartProduct(testData.getJsonData("products.second-product-id"))
                .viewCart().navigateToHomePage();
    }

    @Test(description = "TC-14: Change the Product quantity")
    @Story("Good Scenario - Products Page")
    @Description("Verify that the quantity of a product is changed successfully")
    public void ProductQuantity() {
        new HomePage(driver)
                .productPage()
                .allProductAssertion()
                .viewProduct(testData.getJsonData("products.first-product-id"))
                .changeQuantity(testData.getJsonData("products.quantity"))
                .viewProductAddToCart()
                .viewCart()
                .productQuantityAssertion(testData.getJsonData("products.quantity"));
    }

    @Test(description = "TC-15: Place order while register")
    @Story("Good Scenario - Products Page")
    @Description("Verify that the order is placed to can we signup before place it")
    public void PlaceOrderWhileRegister() {
        new HomePage(driver)
                .productPage().allProductAssertion()
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .viewCart()
                .cartCheckout()
                .cartCheckoutLogin()
                .signUpValuePut(testData.getJsonData("sign-up-data.username"), testData.getJsonData("sign-up-data.signup-Email"))
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
                .registrationConfirmation()
                .cartPage()
                .cartCheckout();
        new PaymentPage(driver)
                .writeComment(testData.getJsonData("payment.comment"))
                .placeOrder()
                .puttingName(testData.getJsonData("payment.name"))
                .puttingNumber(testData.getJsonData("payment.card-number"))
                .puttingCVCNumber(testData.getJsonData("payment.card-CVC"))
                .putExpiryDate(testData.getJsonData("payment.expiry-month"), testData.getJsonData("payment.expiry-year"))
                .submitPayment()
                .paymentConfirmation()
                .navigateToHomePage()
                .deleteAccount()
                .deleteAccountConfirmation();
    }

    @Test(description = "TC-16: Place order After register")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can signup and place an order it went good")
    public void PlaceOrderAfterRegister() {
        new HomePage(driver)
                .signUpLogin().signUpValuePut(testData.getJsonData("sign-up-data.username"), testData.getJsonData("sign-up-data.signup-Email"))
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
                .registrationConfirmation()
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .continueShopping()
                .addToCartProduct(testData.getJsonData("products.second-product-id"))
                .viewCart()
                .cartCheckout();
        new PaymentPage(driver)
                .writeComment(testData.getJsonData("payment.comment"))
                .placeOrder()
                .puttingName(testData.getJsonData("payment.name"))
                .puttingNumber(testData.getJsonData("payment.card-number"))
                .puttingCVCNumber(testData.getJsonData("payment.card-CVC"))
                .putExpiryDate(testData.getJsonData("payment.expiry-month"), testData.getJsonData("payment.expiry-year"))
                .submitPayment()
                .paymentConfirmation()
                .navigateToHomePage()
                .deleteAccount()
                .deleteAccountConfirmation();
    }

    @Test(description = "TC-17: Place order after login")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can login and place an order it went good")
    public void PlaceOrderAfterLogin() {
        new HomePage(driver)
                .signUpLogin()
                .loginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin()
                .validLoginAssertion()
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .continueShopping()
                .addToCartProduct(testData.getJsonData("products.second-product-id"))
                .viewCart().cartCheckout();
        new PaymentPage(driver)
                .writeComment(testData.getJsonData("payment.comment"))
                .placeOrder()
                .puttingName(testData.getJsonData("payment.name"))
                .puttingNumber(testData.getJsonData("payment.card-number"))
                .puttingCVCNumber(testData.getJsonData("payment.card-CVC"))
                .putExpiryDate(testData.getJsonData("payment.expiry-month"), testData.getJsonData("payment.expiry-year"))
                .submitPayment()
                .paymentConfirmation();
    }

    @Test(description = "TC-18: remove order from Cart")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can Remove order in cart")
    public void RemoveOrderFromCart() {
        new HomePage(driver)
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .continueShopping()
                .addToCartProduct(testData.getJsonData("products.second-product-id"))
                .viewCart()
                .cartRemoveItem(testData.getJsonData("products.first-product-id"))
                .cartRemoveItem(testData.getJsonData("products.second-product-id"))
                .navigateToHomePage();
    }

    @Test(description = "TC-19: Product Category navigation")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can navigate in Categories of the product")
    public void CategoryNavigation() {
        new HomePage(driver)
                .homePageCategoryAssertion()
                .homePageCategoryWomen()
                .homePageCategoryWomenDress()
                .homePageCategoryWomenDressAssertion()
                .homePageCategoryMen()
                .homePageCategoryMenTshirt()
                .homePageCategoryMenTshirtAssertion()
                .navigateToHomePage();
    }
    @Test(description = "TC-20: Navigate the brand of the Products ")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can navigate in brands of the Products")
    public void BrandNavigation(){
        new HomePage(driver)
                .productPage()
                .allProductAssertion()
                .productBrandsAssertion()
                .productChooseBrand(testData.getJsonData("products.brands.first-brand-id"))
                .productChooseBrand(testData.getJsonData("products.brands.second-brand-id"))
                .navigateToHomePage();
    }

    @Test(description = "TC-21: Search on a Product before login")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can search For a Product and then login")
    public void SearchAndVerifyAfterLogin(){
        new HomePage(driver)
                .productPage()
                .allProductAssertion()
                .productSearch(testData.getJsonData("products.first-product-name"))
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .viewCart()
                .navigateToHomePage()
                .signUpLogin()
                .loginValuePut(testData.getJsonData("login-data.valid-email"),
                        testData.getJsonData("login-data.valid-password"))
                .clickOnLogin()
                .validLoginAssertion()
                .cartPage()
                .navigateToHomePage();
    }
    @Test(description = "TC-22: Put a review in a product")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can Put a review in a Product")
    public void ProductReview(){
        new HomePage(driver)
                .productPage()
                .viewProduct(testData.getJsonData("products.first-product-id"))
                .productAssertion()
                .writeReviewName(testData.getJsonData("review.name"))
                .writeReviewEmail(testData.getJsonData("review.email"))
                .productWriteReview(testData.getJsonData("review.review-content"))
                .pressSubmitReview()
                .reviewAssertion()
                .navigateToHomePage();
    }
    @Test(description = "TC-23: Navigate on a Recommended Items")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can navigate in Recommended Items")
    public void RecommendedItems(){
        new HomePage(driver)
                .homePageRecommendedItemsAssertion()
                .homePageCategoryRecommendedItems()
                .viewCart()
                .navigateToHomePage();
    }
    @Test(description = "TC-24: Check the address in the checkout")
    @Story("Good Scenario - Products Page")
    @Description("Verify that the right address is written in the Checkout of a product")
    public void AddressVerifyInCheckout(){
        new HomePage(driver)
                .signUpLogin().signUpValuePut(testData.getJsonData("sign-up-data.username"), testData.getJsonData("sign-up-data.signup-Email"))
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
                .registrationConfirmation()
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .viewCart().cartCheckout()
                .cartDeliveryAddressVerifyAssertion(testData.getJsonData("sign-up-data.Address1"))
                .navigateToHomePage()
                .deleteAccount().deleteAccountConfirmation();
    }
    @Test(description = "TC-25: Download Invoice after buying a product")
    @Story("Good Scenario - Products Page")
    @Description("Verify that we can download Invoice after buying product")
    public void DownloadInvoiceAfterPurchase(){
        new HomePage(driver)
                .productPage()
                .allProductAssertion()
                .addToCartProduct(testData.getJsonData("products.first-product-id"))
                .viewCart()
                .cartCheckout()
                .cartCheckoutLogin()
                .signUpValuePut(testData.getJsonData("sign-up-data.username"), testData.getJsonData("sign-up-data.signup-Email"))
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
                .registrationConfirmation()
                .cartPage().cartCheckout();
        new PaymentPage(driver)
                .writeComment(testData.getJsonData("payment.comment"))
                .placeOrder()
                .puttingName(testData.getJsonData("payment.name"))
                .puttingNumber(testData.getJsonData("payment.card-number"))
                .puttingCVCNumber(testData.getJsonData("payment.card-CVC"))
                .putExpiryDate(testData.getJsonData("payment.expiry-month"), testData.getJsonData("payment.expiry-year"))
                .submitPayment()
                .paymentConfirmation()
                .paymentDownloadInvoice()
                .paymentContinue()
                .deleteAccount()
                .deleteAccountConfirmation();
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
