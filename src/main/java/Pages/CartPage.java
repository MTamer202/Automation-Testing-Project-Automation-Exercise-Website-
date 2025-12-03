package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utiles.LogsUtils;

public class CartPage {
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
    public static void SubscriptionEmail(WebDriver webDriver){
        By message = By.xpath(homePageSubscriptionAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("SUBSCRIPTION"));
        LogsUtils.info("SUBSCRIPTION verified");
        By subscriptionEmail= By.xpath(homePageSubscriptionEmailLocator);
        webDriver.findElement(subscriptionEmail).sendKeys("mohamedTamer1235@gmail.com");
        By subscriptionArrow= By.xpath(homePageSubscriptionArrowButtonLocator);
        webDriver.findElement(subscriptionArrow).click();
        LogsUtils.info("email is written and the subscription Arrow is clicked");
        By SuccessfullMessage = By.xpath(homePageSubscriptionSuccessfullyAssertionLocator);
        String Message = webDriver.findElement(SuccessfullMessage).getText();
        Assert.assertTrue(Message.contains("successfully subscribed"));
        LogsUtils.info("successfully subscribed In Cart Page");

    }
    @Step("Click on checkout in Cart Page")
    public static void CartCheckout(WebDriver webDriver){
        By checkoutButton= By.xpath(cartCheckoutButtonLocator);
        webDriver.findElement(checkoutButton).click();
        LogsUtils.info("Checkout button is clicked");
    }
    @Step("Click on Login in CartPage")
    public static void CartCheckoutLogin(WebDriver webDriver){
        By loginButton= By.xpath(cartRegisterSignupButtonLocator);
        webDriver.findElement(loginButton).click();
        LogsUtils.info("Login button is clicked in checkout scenario");
    }
    @Step("Click on remove the {productID} item in Cart Page")
    public static void CartRemoveItem(WebDriver webDriver,String ProductID){
        By removeButton= By.xpath(cartRemoveItemsButtonLocator+ProductID+"']");
        webDriver.findElement(removeButton).click();
        LogsUtils.info("Item: "+ProductID+" is removed");
    }
    @Step("Verify the Delivery address in Cart Page")
    public static void CartDeliveryAddressVerify(WebDriver webDriver,String address){
        By message = By.xpath(cartDeliveryAddressLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(address));
        LogsUtils.info("Delivery address is correct");

    }
    @Step("Verify the Billing address in Cart Page")
    public static void CartBillingAddressVerify(WebDriver webDriver,String address){
        By message = By.xpath(cartBillingAddressLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(address));
        LogsUtils.info("Billing address is correct");
    }

}
