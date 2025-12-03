package Selenium;

import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utiles.LogsUtils;

import java.time.Duration;


public class MainLocator extends BaseTest {

    public final String loginUrlValue = "https://www.automationexercise.com/login";

    @Test(description = "TC-01: Signup with new email")
    @Story("Good scenario - Signup")
    @Description("Verify that the email is made and then delete it")
    public void SignUpScenario() throws InterruptedException {
        LogsUtils.info("Test Started: loginTest");
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.SignUpValuePut(webDriver);
        SignUpPage.signUpScenario(webDriver);
        SignUpConfirmation.RegistrationConfirmation(webDriver);
        LogsUtils.info("Login Successful");
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
        BaseTest.WebClose(webDriver);
    }
    @Test(description = "TC-02: Login with a valid account")
    @Story("Good scenario - Login")
    @Description("Verify that the email is valid and register")
    public void ValidLogin() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        //HomePage.DeleteAccount(webDriver);
        //DeleteConfirmation.DeleteAccountConfirmation(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-03: Login with a invalid account")
    @Story("Bad Scenario - Login")
    @Description("Verify that the login is failed due to wrong email")
    public void InValidLoginEmail() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.inValidGmailTest(webDriver);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-04: Login with a invalid account")
    @Story("Bad Scenario - Login")
    @Description("Verify that the login is failed due to wrong password")
    public void InValidLoginPassword() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.inValidPasswordTest(webDriver);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-05: Logout from account")
    @Story("Good Scenario - Login")
    @Description("Verify that the logout is done correctly")
    public void LogoutUser() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        HomePage.LogoutAccount(webDriver);
        Assert.assertEquals(loginUrlValue,webDriver.getCurrentUrl());
        BaseTest.WebClose(webDriver);
    }
    @Test(description = "TC-06: register with existing user")
    @Story("Bad Scenario - Login")
    @Description("Verify that the Register is failed")
    public void RegisterWithExistingUserName() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.ExistingUsernameTest(webDriver);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-07: Contact us form ")
    @Story("good Scenario - Contact us")
    @Description("Verify that the Contact us is formed successfully")
    public void ContactUsForm() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        HomePage.ContactUsPage(webDriver);
        ContactUsPage.ContactUsPutingValues(webDriver);
        ContactUsPage.ContactUsSecondPage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-08: Test Cases Page Perform Successfully")
    @Story("Good Scenario - Pages")
    @Description("Verify that the login is failed")
    public void TestCases() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.TestCasesPage(webDriver);
        TestCasesPage.TestCasesAssertion(webDriver);
        Thread.sleep(1000);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-09: Login with a valid account")
    @Story("Good Scenario - Products")
    @Description("Verify that the Products is shown")
    public void ProductsVerify() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        ProductsPage.AllProductAssertion(webDriver);

        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();

        ProductsPage.ViewProduct(webDriver, "1");
        ProductsPage.ProductAssertion(webDriver);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-10: Search on a specific Product")
    @Story("Good Scenario - Products")
    @Description("Verify that the searched Product is found successfully")
    public void ProductSearch(){
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        ProductsPage.AllProductAssertion(webDriver);
        ProductsPage.ProductSearch(webDriver);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-11: Subscription in home page")
    @Story("Good Scenario -Subscription ")
    @Description("Verify that the subscription is performed successfully in home Page")
    public void SubscriptionInHomePage() {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.SubscriptionEmail(webDriver);
        BaseTest.WebClose(webDriver);
    }
    @Test(description = "TC-12: Subscription in Cart page")
    @Story("Good Scenario - Subscription")
    @Description("Verify that the subscription is performed successfully In Cart Page")
    public void SubscriptionInCartPage() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.CartPage(webDriver);
        CartPage.SubscriptionEmail(webDriver);
        BaseTest.WebClose(webDriver);
    }
    @Test(description = "TC-13: Add products to cart")
    @Story("Good Scenario - Products")
    @Description("Verify that the Product is added to cart successfully")
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
        BaseTest.WebClose(webDriver);
    }
    @Test(description = "TC-14: Change the Product quantity")
    @Story("Good Scenario - Products")
    @Description("Verify that the quantity of a product is changed successfully")
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
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-15: Place order while register")
    @Story("Good Scenario - Products")
    @Description("Verify that the order is placed to can we signup before place it")
    public void PlaceOrderWhileRegister() throws InterruptedException {
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
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-16: Place order After register")
    @Story("Good Scenario - Products")
    @Description("Verify that we can signup and place an order it went good")
    public void PlaceOrderAfterRegister() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.SignUpValuePut(webDriver);
        SignUpPage.signUpScenario(webDriver);
        SignUpConfirmation.RegistrationConfirmation(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        HomePage.AddToCartProduct(webDriver,"1");
        ProductsPage.ContinueShopping(webDriver);
        HomePage.AddToCartProduct(webDriver,"2");
        ProductsPage.ViewCart(webDriver);
        CartPage.CartCheckout(webDriver);
        PaymentPage.WriteComment(webDriver);
        PaymentPage.PlaceOrder(webDriver);
        PaymentPage.PaymentCardValues(webDriver);
        PaymentPage.PaymentConfirmation(webDriver);
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-17: Place order after login")
    @Story("Good Scenario - Products")
    @Description("Verify that we can login and place an order it went good")
    public void PlaceOrderAfterLogin() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        HomePage.AddToCartProduct(webDriver,"1");
        ProductsPage.ContinueShopping(webDriver);
        HomePage.AddToCartProduct(webDriver,"2");
        ProductsPage.ViewCart(webDriver);
        CartPage.CartCheckout(webDriver);
        PaymentPage.WriteComment(webDriver);
        PaymentPage.PlaceOrder(webDriver);
        PaymentPage.PaymentCardValues(webDriver);
        PaymentPage.PaymentConfirmation(webDriver);
        //HomePage.DeleteAccount(webDriver);
        //DeleteConfirmation.DeleteAccountConfirmation(webDriver);
        BaseTest.WebClose(webDriver);

    }

    @Test(description = "TC-18: remove order from Cart")
    @Story("Good Scenario - Products")
    @Description("Verify that we can Remove order in cart")
    public void RemoveOrderFromCart() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        HomePage.AddToCartProduct(webDriver,"1");
        ProductsPage.ContinueShopping(webDriver);
        HomePage.AddToCartProduct(webDriver,"2");
        ProductsPage.ViewCart(webDriver);
        CartPage.CartRemoveItem(webDriver,"1");
        CartPage.CartRemoveItem(webDriver,"2");
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);
    }
    @Test(description = "TC-19: Product Category navigation")
    @Story("Good Scenario - Products")
    @Description("Verify that we can navigate in Categories of the product")
    public void CategoryNavigation(){    /*Assertion Problem*/
        WebDriver webDriver = BaseTest.WebOpen();
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        HomePage.HomePageCategoryAssertion(webDriver);
        HomePage.HomePageCategoryWomen(webDriver);
        HomePage.HomePageCategoryWomenDress(webDriver);
        HomePage.HomePageCategoryWomenDressAssertion(webDriver);
        HomePage.HomePageCategoryMen(webDriver);
        actions.scrollByAmount(0, 500).perform();
        HomePage.HomePageCategoryMenTshirt(webDriver);
        HomePage.HomePageCategoryMenTshirtAssertion(webDriver);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-20: Navigate the brand of the Products ")
    @Story("Good Scenario - Products")
    @Description("Verify that we can navigate in brands of the Products")
    public void BrandNavigation() throws InterruptedException {    /*Assertion Problem*/
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 800).perform();
        ProductsPage.ProductBrandsAssertion(webDriver);
        ProductsPage.ProductChooseBrand(webDriver,"1");
        actions.scrollByAmount(0, 800).perform();
        ProductsPage.ProductChooseBrand(webDriver,"2");
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-21: Search on a Product before login")
    @Story("Good Scenario - Products")
    @Description("Verify that we can search For a Product and then login")
    public void SearchAndVerifyAfterLogin() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        ProductsPage.AllProductAssertion(webDriver);
        ProductsPage.ProductSearch(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 800).perform();
        ProductsPage.AddToCartProduct(webDriver,"1");
        ProductsPage.ViewCart(webDriver);
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.LoginValuePut(webDriver);
        HomePage.CartPage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-22: Put a review in a product")
    @Story("Good Scenario - Products")
    @Description("Verify that we can Put a review in a Product")
    public void ProductReview() throws InterruptedException {    /*Assertion Problem*/
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.ProductPage(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        ProductsPage.ViewProduct(webDriver,"1");
        ProductsPage.ProductAssertion(webDriver);
        ProductsPage.ProductWriteReview(webDriver);
        HomePage.HomePage(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-23: Navigate on a Recommended Items")
    @Story("Good Scenario - Products")
    @Description("Verify that we can navigate in Recommended Items")
    public void RecommendedItems() throws InterruptedException {
        WebDriver webDriver = BaseTest.WebOpen();

        HomePage.HomePageRecommendedItemsAssertion(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();

        HomePage.HomePageCategoryRecommendedItems(webDriver);
        ProductsPage.ViewCart(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-24: Check the address in the checkout")
    @Story("Good Scenario - Products")
    @Description("Verify that the right address is written in the Checkout of a product")
    public void AddressVerifyInCheckout() throws InterruptedException {    /*Assertion Problem*/
        WebDriver webDriver = BaseTest.WebOpen();
        HomePage.SignUpLogin(webDriver);
        SignUpLoginPage.SignUpValuePut(webDriver);
        SignUpPage.signUpScenario(webDriver);
        SignUpConfirmation.RegistrationConfirmation(webDriver);
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        HomePage.AddToCartProduct(webDriver,"1");
        ProductsPage.ViewCart(webDriver);
        CartPage.CartCheckout(webDriver);
        CartPage.CartDeliveryAddressVerify(webDriver,SignUpPage.GetUserAddress(webDriver));
        CartPage.CartBillingAddressVerify(webDriver,SignUpPage.GetUserAddress(webDriver));
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
        BaseTest.WebClose(webDriver);

    }
    @Test(description = "TC-25: Download Invoice after buying a product")
    @Story("Good Scenario - Products")
    @Description("Verify that we can download Invoice after buying product")
    public void DownloadInvoiceAfterPurchase() throws InterruptedException {
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
        PaymentPage.PaymentDownloadInvoice(webDriver);
        PaymentPage.PaymentContinue(webDriver);
        HomePage.DeleteAccount(webDriver);
        DeleteConfirmation.DeleteAccountConfirmation(webDriver);
        BaseTest.WebClose(webDriver);

    }
}
