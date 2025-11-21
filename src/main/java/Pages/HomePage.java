package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

    /***Methods***/
    public static void HomePage(WebDriver webDriver){
        By homeNavButton = By.xpath(homePageButtonLocator);
        webDriver.findElement(homeNavButton).click();

    }
    public static void SignUpLogin(WebDriver webDriver){
        By signUpButton = By.xpath(SignUpLoginButtonLocator);
        webDriver.findElement(signUpButton).click();

    }
    public static void DeleteAccount(WebDriver webDriver) throws InterruptedException {
        By deleteAccountButton = By.xpath(deleteAccountButtonLocator);
        webDriver.findElement(deleteAccountButton).click();
        Thread.sleep(1000);
    }
    public static void LogoutAccount(WebDriver webDriver) throws InterruptedException {
        By logoutButton = By.xpath(homePageLogoutButtonLocator);
        webDriver.findElement(logoutButton).click();
        Thread.sleep(1000);
    }
    public static void ProductPage(WebDriver webDriver){
        By productButton = By.xpath(homePageProductsButtonLocator);
        webDriver.findElement(productButton).click();

    }
    public static void CartPage(WebDriver webDriver) throws InterruptedException {
        By CartButton = By.xpath(homePageCartButtonLocator);
        webDriver.findElement(CartButton).click();
        Thread.sleep(1000);
    }
    public static void ContactUsPage(WebDriver webDriver) throws InterruptedException {
        By contactUsButton = By.xpath(homePageContactUsButtonLocator);
        webDriver.findElement(contactUsButton).click();
        Thread.sleep(1000);
    }
    public static void TestCasesPage(WebDriver webDriver) throws InterruptedException {
        By TestCasesButton = By.xpath(homePageTestCasesButtonLocator);
        webDriver.findElement(TestCasesButton).click();
        Thread.sleep(1000);
    }

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
    public static void AddToCartProduct(WebDriver webDriver,String productNumber) throws InterruptedException {
        By addToCartProductButton = By.xpath(productAddToCartLocatorPart1+productNumber+"\"]");
        webDriver.findElement(addToCartProductButton).click();
        Thread.sleep(1000);
    }
    public static void HomePageCategoryAssertion(WebDriver webDriver){
        By message = By.xpath(homePageCategoryAssertionLocator);
        String categoryAssertion = webDriver.findElement(message).getText();
        Assert.assertTrue(categoryAssertion.contains("CATEGORY"));
    }
    public static void HomePageCategoryWomen(WebDriver webDriver) {
        By womenButton = By.xpath(homePageCategoryWomenLocator);
        webDriver.findElement(womenButton).click();
    }
    public static void HomePageCategoryWomenDress(WebDriver webDriver) {
        By dressButton = By.xpath(homePageCategoryWomenDressLocator);
        webDriver.findElement(dressButton).click();
    }
    public static void HomePageCategoryWomenDressAssertion(WebDriver webDriver) {
        By message = By.xpath(homePageCategoryWomenDressAssertionLocator);
        String categoryAssertion = webDriver.findElement(message).getText();
        Assert.assertTrue(categoryAssertion.contains("WOMEN -"));
    }
    public static void HomePageCategoryMen(WebDriver webDriver) {
        By menButton = By.xpath(homePageCategoryMenLocator);
        webDriver.findElement(menButton).click();
    }
    public static void HomePageCategoryMenTshirt(WebDriver webDriver) {
        By tshirtButton = By.xpath(homePageCategoryMenTshirtLocator);
        webDriver.findElement(tshirtButton).click();
    }
    public static void HomePageCategoryMenTshirtAssertion(WebDriver webDriver) {
        By message = By.xpath(homePageCategoryMenTshirtAssertionLocator);
        String categoryAssertion = webDriver.findElement(message).getText();
        Assert.assertTrue(categoryAssertion.contains("MEN"));
    }




}





