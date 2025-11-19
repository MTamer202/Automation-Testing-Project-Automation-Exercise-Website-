package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    /***Locators***/
    private static final String homePageSubscriptionAssertionLocator = "//h2[text()='Subscription']";
    private static final String homePageSubscriptionEmailLocator = "//input[@id='susbscribe_email']";
    private static final String homePageSubscriptionArrowButtonLocator = "//button[@id='subscribe']";
    private static final String homePageSubscriptionSuccessfullyAssertionLocator = "//*[normalize-space(text())='You have been successfully subscribed!']";


    public static void SubscriptionEmail(WebDriver webDriver){
        By message = By.xpath(homePageSubscriptionAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("SUBSCRIPTION"));
        By subscriptionEmail= By.xpath(homePageSubscriptionEmailLocator);
        webDriver.findElement(subscriptionEmail).sendKeys("mohamedTamer1235@gmail.com");
        By subscriptionArrow= By.xpath(homePageSubscriptionArrowButtonLocator);
        webDriver.findElement(subscriptionArrow).click();
        By SuccessfullMessage = By.xpath(homePageSubscriptionSuccessfullyAssertionLocator);
        String Message = webDriver.findElement(SuccessfullMessage).getText();
        Assert.assertTrue(Message.contains("successfully subscribed"));
    }
}
