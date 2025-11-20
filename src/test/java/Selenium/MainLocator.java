package Selenium;

import Pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class MainLocator {

    public final String loginUrlValue = "https://www.automationexercise.com/login";

    @Test
    public void SignUpScenario() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.SignUpValuePut(webDriver);
        SignUpPage.signUpScenario(webDriver);
        SignUpConfirmation.RegistrationConfirmation(webDriver);
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
    }
    @Test
    public void ValidLogin() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
    }
    @Test
    public void InValidLoginEmail() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.inValidGmailTest(webDriver);
        HomePage.HomePage(webDriver);
    }
    @Test
    public void InValidLoginPassword() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.inValidPasswordTest(webDriver);
        HomePage.HomePage(webDriver);
    }
    @Test
    public void LogoutUser() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        HomePage.LogoutAccount(webDriver);
        Assert.assertEquals(loginUrlValue,webDriver.getCurrentUrl());
    }
    @Test
    public void RegisterWithExistingUserName() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.ExistingUsernameTest(webDriver);
        HomePage.HomePage(webDriver);
    }
    @Test
    public void ContactUsForm() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.ContactUsPage(webDriver);
        ContactUsPage.ContactUsPutingValues(webDriver);
        ContactUsPage.ContactUsSecondPage(webDriver);
    }
    @Test
    public void TestCases() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.TestCasesPage(webDriver);
        TestCasesPage.TestCasesAssertion(webDriver);
        Thread.sleep(1000);
        HomePage.HomePage(webDriver);
    }
    @Test
    public void ProductsVerify() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        ProductsPage.AllProductAssertion(webDriver);

        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();

        ProductsPage.ViewProduct(webDriver, "1");
        ProductsPage.ProductAssertion(webDriver);
        HomePage.HomePage(webDriver);
    }
    @Test
    public void ProductSearch(){
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        ProductsPage.AllProductAssertion(webDriver);
        ProductsPage.ProductSearch(webDriver);
        HomePage.HomePage(webDriver);
    }
    @Test
    public void SubscriptionInHomePage() {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.SubscriptionEmail(webDriver);
    }
    @Test
    public void SubscriptionInCartPage() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.CartPage(webDriver);
        CartPage.SubscriptionEmail(webDriver);
    }
    @Test
    public void AddToCart() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        ProductsPage.AllProductAssertion(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        ProductsPage.AddToCartProduct(webDriver, "1");
        ProductsPage.ContinueShopping(webDriver);
        ProductsPage.AddToCartProduct(webDriver, "2");
        ProductsPage.ViewCart(webDriver);
    }
    @Test
    public void ProductQuantity() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        ProductsPage.AllProductAssertion(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        ProductsPage.ViewProduct(webDriver, "1");
        ProductsPage.ChangeQuantity(webDriver,"4");
        ProductsPage.ViewProductAddToCart(webDriver);
        ProductsPage.ViewCart(webDriver);
        ProductsPage.ProductQuantityAssertion(webDriver,"4");
    }
    @Test
    public void PlaceOrder() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        HomePage.AddToCartProduct(webDriver,"1");
        ProductsPage.ViewCart(webDriver);
        CartPage.CartCheckout(webDriver);
        CartPage.CartCheckoutLogin(webDriver);
        SignUpLoginPage.SignUpValuePut(webDriver);
        SignUpPage.signUpScenario(webDriver);
        SignUpConfirmation.RegistrationConfirmation(webDriver);
        HomePage.CartPage(webDriver);
        CartPage.CartCheckout(webDriver);
        PaymentPage.WriteComment(webDriver);
        PaymentPage.PlaceOrder(webDriver);
        PaymentPage.PaymentCardValues(webDriver);
        PaymentPage.PaymentConfirmation(webDriver);
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
    }

}
