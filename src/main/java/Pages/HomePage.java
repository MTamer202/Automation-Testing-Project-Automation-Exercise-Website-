package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utiles.LogsUtils;

import java.time.Duration;

public class HomePage {

    /***Locators***/
    private static final String SignUpLoginButtonLocator = "//*[contains(text(),' Signup / Login')] ";
    private static final String deleteAccountButtonLocator = "//*[normalize-space(text())='Delete Account']";
    private static final String homePageButtonLocator = "//*[normalize-space(text())='Home']";
    private static final String homePageLogoutButtonLocator = "//*[normalize-space(text())='Logout']";
    private static final String homePageProductsButtonLocator = "//*[normalize-space(text())='Products']";
    private static final String homePageCartButtonLocator = "//*[normalize-space(text())='Cart'] ";
    private static final String homePageContactUsButtonLocator = "//*[normalize-space(text())='Contact us'] ";
    private static final String homePageTestCasesButtonLocator = "//a[normalize-space(text())='Test Cases']";
    private static final String homePageSubscriptionAssertionLocator = "//h2[text()='Subscription']";
    private static final String homePageSubscriptionEmailLocator = "//input[@id='susbscribe_email']";
    private static final String homePageSubscriptionArrowButtonLocator = "//button[@id='subscribe']";
    private static final String homePageSubscriptionSuccessfullyAssertionLocator = "//*[normalize-space(text())='You have been successfully subscribed!']";
    private static final String productAddToCartLocatorPart1 = "//a[@data-product-id=\"";
    private static final String homePageCategoryAssertionLocator = "/html/body/section[2]/div/div/div[1]/div/h2";
    private static final String homePageCategoryWomenLocator = "//*[@href='#Women']";
    private static final String homePageCategoryWomenDressLocator = "//*[@href='/category_products/1']";
    private static final String homePageCategoryWomenDressAssertionLocator = "//h2[@class ='title text-center']";
    private static final String homePageCategoryMenLocator = "//*[@href='#Men']";
    private static final String homePageCategoryMenTshirtLocator = "//*[@href='/category_products/3']";
    private static final String homePageCategoryMenTshirtAssertionLocator = "//h2[@class ='title text-center']";
    private static final String homePageRecommendedItemsAssertionLocator = "//*[normalize-space(text())='recommended items']";
    private static final String homePageRecommendedItemsLocator = "//div[@class='recommended_items']/div/div/div/div/div/div/div/a";

    /***Methods***/
    @Step("Click on Home Page")
    public static void HomePage(WebDriver webDriver){
        By homeNavButton = By.xpath(homePageButtonLocator);
        webDriver.findElement(homeNavButton).click();
        LogsUtils.info("Clicked on home Page");
    }
    @Step("Click on Sign up/Login")
    public static void SignUpLogin(WebDriver webDriver){
        By signUpButton = By.xpath(SignUpLoginButtonLocator);
        webDriver.findElement(signUpButton).click();
        LogsUtils.info("Clicked on Signup/login Page");
    }
    @Step("Click on Delete account")
    public static void DeleteAccount(WebDriver webDriver) throws InterruptedException {
        By deleteAccountButton = By.xpath(deleteAccountButtonLocator);
        webDriver.findElement(deleteAccountButton).click();
        Thread.sleep(1000);
        LogsUtils.info("Clicked on Delete Account");

    }
    @Step("Click on Logout account")
    public static void LogoutAccount(WebDriver webDriver) throws InterruptedException {
        By logoutButton = By.xpath(homePageLogoutButtonLocator);
        webDriver.findElement(logoutButton).click();
        Thread.sleep(1000);
        LogsUtils.info("Clicked on Logout account");
    }
    @Step("Click on Products Page")
    public static void ProductPage(WebDriver webDriver){
        By productButton = By.xpath(homePageProductsButtonLocator);
        webDriver.findElement(productButton).click();
        LogsUtils.info("Clicked on Products Page");
    }
    @Step("Click on Cart Page")
    public static void CartPage(WebDriver webDriver) throws InterruptedException {
        By CartButton = By.xpath(homePageCartButtonLocator);
        webDriver.findElement(CartButton).click();
        LogsUtils.info("Clicked on Cart Page");
        Thread.sleep(1000);
    }
    @Step("Click on Contact Us Page")
    public static void ContactUsPage(WebDriver webDriver) throws InterruptedException {
        By contactUsButton = By.xpath(homePageContactUsButtonLocator);
        webDriver.findElement(contactUsButton).click();
        LogsUtils.info("Clicked on Contact Us Page");
        Thread.sleep(1000);
    }
    @Step("Click on Test Cases Page")
    public static void TestCasesPage(WebDriver webDriver) throws InterruptedException {
        By TestCasesButton = By.xpath(homePageTestCasesButtonLocator);
        webDriver.findElement(TestCasesButton).click();
        LogsUtils.info("Clicked on Test Cases Page");
        Thread.sleep(1000);
    }
    @Step("Send a Subscription Email")
    public static void SubscriptionEmail(WebDriver webDriver){
        By message = By.xpath(homePageSubscriptionAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("SUBSCRIPTION"));
        LogsUtils.info("Assertion on SUBSCRIPTION in Home Page");
        By subscriptionEmail= By.xpath(homePageSubscriptionEmailLocator);
        webDriver.findElement(subscriptionEmail).sendKeys("mohamedTamer1235@gmail.com");
        By subscriptionArrow= By.xpath(homePageSubscriptionArrowButtonLocator);
        webDriver.findElement(subscriptionArrow).click();
        LogsUtils.info("Putting Email and then click on SUBSCRIPTION");
        By SuccessfullMessage = By.xpath(homePageSubscriptionSuccessfullyAssertionLocator);
        String Message = webDriver.findElement(SuccessfullMessage).getText();
        Assert.assertTrue(Message.contains("successfully subscribed"));
        LogsUtils.info("successfully subscribed");
    }
    @Step("Add a Product {productNumber} to the cart")
    public static void AddToCartProduct(WebDriver webDriver,String productNumber) throws InterruptedException {
        By addToCartProductButton = By.xpath(productAddToCartLocatorPart1+productNumber+"\"]");
        webDriver.findElement(addToCartProductButton).click();
        LogsUtils.info("Added a product to cart");
        Thread.sleep(1000);
    }
    @Step("Assertion on Home Page")
    public static void HomePageCategoryAssertion(WebDriver webDriver){
        By message = By.xpath(homePageCategoryAssertionLocator);
        String categoryAssertion = webDriver.findElement(message).getText();
        Assert.assertTrue(categoryAssertion.contains("CATEGORY"));
        LogsUtils.info("Category Assertion In home page");
    }
    @Step("Click on Women Category")
    public static void HomePageCategoryWomen(WebDriver webDriver) {
        By womenButton = By.xpath(homePageCategoryWomenLocator);
        webDriver.findElement(womenButton).click();
        LogsUtils.info("Women Category clicked home page");
    }
    @Step("Click on Dress in Women Category")
    public static void HomePageCategoryWomenDress(WebDriver webDriver) {
        By dressButton = By.xpath(homePageCategoryWomenDressLocator);
        webDriver.findElement(dressButton).click();
        LogsUtils.info("Women Category Dress clicked home page");
    }
    @Step("Assert on Dress in Women Category")
    public static void HomePageCategoryWomenDressAssertion(WebDriver webDriver) {
        By message = By.xpath(homePageCategoryWomenDressAssertionLocator);
        String categoryAssertion = webDriver.findElement(message).getText();
        Assert.assertTrue(categoryAssertion.contains("WOMEN -"));
        LogsUtils.info("Women Category dress Assertion in Home page");

    }
    @Step("Click on Men Category")
    public static void HomePageCategoryMen(WebDriver webDriver) {
        By menButton = By.xpath(homePageCategoryMenLocator);
        webDriver.findElement(menButton).click();
        LogsUtils.info("Men Category clicked home page");
    }
    @Step("Click on T-shirt in Men Category")
    public static void HomePageCategoryMenTshirt(WebDriver webDriver) {
        By tshirtButton = By.xpath(homePageCategoryMenTshirtLocator);
        webDriver.findElement(tshirtButton).click();
        LogsUtils.info("Men Category T-shirt clicked home page");

    }
    @Step("Assert on T-shirt in Men Category")
    public static void HomePageCategoryMenTshirtAssertion(WebDriver webDriver) {
        By message = By.xpath(homePageCategoryMenTshirtAssertionLocator);
        String categoryAssertion = webDriver.findElement(message).getText();
        Assert.assertTrue(categoryAssertion.contains("MEN"));
        LogsUtils.info("Men Category T-shirt Assertion in home page");
    }
    @Step("Click on Recommended Items")
    public static void HomePageRecommendedItemsAssertion(WebDriver webDriver) {
        By message = By.xpath(homePageRecommendedItemsAssertionLocator);
        String categoryAssertion = webDriver.findElement(message).getText();
        Assert.assertTrue(categoryAssertion.contains("RECOMMENDED"));
        LogsUtils.info("Recommended Items visiable in home page");
        WebElement element = webDriver.findElement(By.xpath(homePageRecommendedItemsAssertionLocator));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
    }
    @Step("Click on a Recommended Item")
    public static void HomePageCategoryRecommendedItems(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(homePageRecommendedItemsLocator)));
        product.click();
        LogsUtils.info("Recommended Item is chosen in home page");
    }



}





