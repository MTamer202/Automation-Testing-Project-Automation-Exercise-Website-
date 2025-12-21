package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CartPage {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public CartPage(GUIDriver driver) {
        this.driver = driver;
    }

    //locators
    private static final By homePageSubscriptionAssertionLocator =By.xpath( "//h2[text()='Subscription']");
    private static final By homePageSubscriptionEmailLocator =By.xpath( "//input[@id='susbscribe_email']");
    private static final By homePageSubscriptionArrowButtonLocator =By.xpath( "//button[@id='subscribe']");
    private static final By homePageSubscriptionSuccessfullyAssertionLocator =By.xpath( "//*[normalize-space(text())='You have been successfully subscribed!']");
    private static final By cartCheckoutButtonLocator =By.xpath( "//*[normalize-space(text())='Proceed To Checkout']");
    private static final By cartRegisterSignupButtonLocator =By.xpath( "//*[normalize-space(text())='Register / Login']");
    private static final By cartDeliveryAddressLocator =By.xpath( "//ul[@id = 'address_delivery']");
    private static final By cartBillingAddressLocator =By.xpath( "//ul[@id = 'address_invoice']");

    private static final String productQuantityAssertionLocatorPart1 = "//button[text()='";
    private static final String cartRemoveItemsButtonLocator = "//a[@data-product-id='";


    //methods
    @Step("Navigate Login Page")
    public HomePage navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
        return new HomePage(driver);
    }

    @Step("SUBSCRIPTION Email In Cart Page")
    public CartPage subscriptionEmail(String email) {
        driver.elementActions().sendData(homePageSubscriptionEmailLocator, email);
        return new CartPage(driver);
    }

    @Step("Confirm Email Subescription")
    public CartPage clickOnArrowOfSubscription() {
        driver.elementActions().clickElement(homePageSubscriptionArrowButtonLocator);
        LogsUtils.info("email is written and the subscription Arrow is clicked");
        return new CartPage(driver);
    }

    @Step("Click on checkout in Cart Page")
    public CartPage cartCheckout() {
        driver.elementActions().clickElement(cartCheckoutButtonLocator);
        LogsUtils.info("Checkout button is clicked");
        return new CartPage(driver);
    }

    @Step("Click on Login in CartPage")
    public SignUpLoginPage cartCheckoutLogin() {
        driver.elementActions().clickElement(cartRegisterSignupButtonLocator);
        LogsUtils.info("Login button is clicked in checkout scenario");
        return new SignUpLoginPage(driver);
    }

    @Step("Click on remove the {productID} item in Cart Page")
    public CartPage cartRemoveItem(String ProductID) {
        By removeButton = By.xpath(cartRemoveItemsButtonLocator + ProductID + "']");
        driver.elementActions().clickElement(removeButton);
        LogsUtils.info("Item: " + ProductID + " is removed");
        return new CartPage(driver);
    }

    //validations
    @Step("Verify The Subscription in Cart Page")
    public CartPage subscriptionEmailLocationAssertion() {
        driver.validaions().validateTrue((driver.elementActions().getText(homePageSubscriptionAssertionLocator)).contains(PropertiesUtils.getPropertyValue("subscription")),
                "Subscription is not shown");
        LogsUtils.info("SUBSCRIPTION verified");
        return new CartPage(driver);
    }

    @Step("Verify The Subscription is successfully done")
    public CartPage subscriptionEmailSuccessfullyAssertion() {
        driver.validaions().validateTrue((driver.elementActions().getText(homePageSubscriptionSuccessfullyAssertionLocator)).contains(PropertiesUtils.getPropertyValue("successfullySubscribed")), "Subscription is not done successfully");
        LogsUtils.info("successfully subscribed In Cart Page");
        return new CartPage(driver);
    }

    @Step("Verify the Delivery address in Cart Page")
    public CartPage cartDeliveryAddressVerifyAssertion(String address) {
        driver.validaions().validateTrue((driver.elementActions().getText(cartDeliveryAddressLocator)).contains(address), "Address doesn't match ");
        LogsUtils.info("Delivery address is correct");
        return new CartPage(driver);
    }
    @Step("Assertion on the Quantity of the Product to be equal {quantity}")
    public ProductsPage productQuantityAssertion(String quantity) {
        By message = By.xpath(productQuantityAssertionLocatorPart1 + quantity + "']");
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateEqual(actualText, quantity, "quantity mismatch");
        LogsUtils.info("Product's Quantity is = " + quantity + " = the same value we put");
        return new ProductsPage(driver);
    }
}
