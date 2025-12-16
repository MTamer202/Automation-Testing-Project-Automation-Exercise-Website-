package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    //code
    //variables
    private final GUIDriver driver;
    //constructors
    public CartPage(GUIDriver driver){
        this.driver = driver;
    }

    /***Locators***/
    private static final String homePageSubscriptionAssertionLocator = "//h2[text()='Subscription']";
    private static final String homePageSubscriptionEmailLocator = "//input[@id='susbscribe_email']";
    private static final String homePageSubscriptionArrowButtonLocator = "//button[@id='subscribe']";
    private static final String homePageSubscriptionSuccessfullyAssertionLocator = "//*[normalize-space(text())='You have been successfully subscribed!']";
    private static final String cartCheckoutButtonLocator = "//*[normalize-space(text())='Proceed To Checkout']";
    private static final String cartRegisterSignupButtonLocator = "//*[normalize-space(text())='Register / Login']";
    private static final String cartRemoveItemsButtonLocator = "//a[@data-product-id='";
    private static final String cartDeliveryAddressLocator = "//ul[@id = 'address_delivery']";
    private static final String cartBillingAddressLocator = "//ul[@id = 'address_invoice']";

    @Step("SUBSCRIPTION Email In Cart Page")
    public CartPage SubscriptionEmail(String email){
        By subscriptionEmail= By.xpath(homePageSubscriptionEmailLocator);
        driver.elementActions().sendData(subscriptionEmail,email);
        return new CartPage(driver);
    }
    @Step("Confirm Email Subescription")
    public CartPage clickOnArrowOfSubscription(){
        By subscriptionArrow= By.xpath(homePageSubscriptionArrowButtonLocator);
        driver.elementActions().clickElement(subscriptionArrow);
        LogsUtils.info("email is written and the subscription Arrow is clicked");
        return new CartPage(driver);
    }
    @Step("Click on checkout in Cart Page")
    public CartPage CartCheckout(){
        By checkoutButton= By.xpath(cartCheckoutButtonLocator);
        driver.elementActions().clickElement(checkoutButton);
        LogsUtils.info("Checkout button is clicked");
        return new CartPage(driver);
    }
    @Step("Click on Login in CartPage")
    public SignUpLoginPage CartCheckoutLogin(){
        By loginButton= By.xpath(cartRegisterSignupButtonLocator);
        driver.elementActions().clickElement(loginButton);
        LogsUtils.info("Login button is clicked in checkout scenario");
        return new SignUpLoginPage(driver);
    }
    @Step("Click on remove the {productID} item in Cart Page")
    public CartPage CartRemoveItem(String ProductID){
        By removeButton= By.xpath(cartRemoveItemsButtonLocator+ProductID+"']");
        driver.elementActions().clickElement(removeButton);
        LogsUtils.info("Item: "+ProductID+" is removed");
        return new CartPage(driver);
    }

    //validations
    @Step("Verify The Subscription in Cart Page")
    public CartPage SubscriptionEmailLocationAssertion(){
        By message = By.xpath(homePageSubscriptionAssertionLocator);
        driver.validaions().validateTrue((driver.elementActions().getText(message)).contains("SUBSCRIPTION"),"Subscription is not shown");
        LogsUtils.info("SUBSCRIPTION verified");
        return new CartPage(driver);
    }
    @Step("Verify The Subscription is successfully done")
    public CartPage subscriptionEmailSuccessfullyAssertion(){
        By SuccessfulMessage = By.xpath(homePageSubscriptionSuccessfullyAssertionLocator);
        driver.validaions().validateTrue((driver.elementActions().getText(SuccessfulMessage)).contains("successfully subscribed"),"Subscription is not done successfully");
        LogsUtils.info("successfully subscribed In Cart Page");
        return new CartPage(driver);
    }
    @Step("Verify the Delivery address in Cart Page")
    public CartPage CartDeliveryAddressVerifyAssertion(String address){
        By message = By.xpath(cartDeliveryAddressLocator);
        driver.validaions().validateTrue((driver.elementActions().getText(message)).contains(address),"Address doesn't match");
        LogsUtils.info("Delivery address is correct");
        return new CartPage(driver);
    }
}
