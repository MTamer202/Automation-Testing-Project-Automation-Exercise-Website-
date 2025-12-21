package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {

    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public HomePage(GUIDriver driver) {
        this.driver = driver;
    }
    //locators
    /***Locators***/
    private static final By SignUpLoginButtonLocator =By.xpath( "//*[contains(text(),' Signup / Login')] ");
    private static final By deleteAccountButtonLocator =By.xpath( "//*[normalize-space(text())='Delete Account']");
    private static final By homePageButtonLocator =By.xpath( "//*[normalize-space(text())='Home']");
    private static final By homePageLogoutButtonLocator =By.xpath( "//*[normalize-space(text())='Logout']");
    private static final By homePageProductsButtonLocator =By.xpath( "//*[normalize-space(text())='Products']");
    private static final By homePageCartButtonLocator =By.xpath( "//*[normalize-space(text())='Cart'] ");
    private static final By homePageContactUsButtonLocator =By.xpath( "//*[normalize-space(text())='Contact us'] ");
    private static final By homePageTestCasesButtonLocator =By.xpath( "//a[normalize-space(text())='Test Cases']");
    private static final By homePageSubscriptionAssertionLocator =By.xpath( "//h2[text()='Subscription']");
    private static final By homePageSubscriptionEmailLocator =By.xpath( "//input[@id='susbscribe_email']");
    private static final By homePageSubscriptionArrowButtonLocator =By.xpath( "//button[@id='subscribe']");
    private static final By homePageSubscriptionSuccessfullyAssertionLocator =By.xpath( "//*[normalize-space(text())='You have been successfully subscribed!']");
    private static final By homePageCategoryAssertionLocator =By.xpath( "/html/body/section[2]/div/div/div[1]/div/h2");
    private static final By homePageCategoryWomenLocator =By.xpath( "//*[@href='#Women']");
    private static final By homePageCategoryWomenDressLocator =By.xpath( "//*[@href='/category_products/1']");
    private static final By homePageCategoryWomenDressAssertionLocator =By.xpath( "//h2[@class ='title text-center']");
    private static final By homePageCategoryMenLocator =By.xpath( "//*[@href='#Men']");
    private static final By homePageCategoryMenTshirtLocator =By.xpath( "//*[@href='/category_products/3']");
    private static final By homePageCategoryMenTshirtAssertionLocator =By.xpath( "//h2[@class ='title text-center']");
    private static final By homePageRecommendedItemsAssertionLocator =By.xpath( "//*[normalize-space(text())='recommended items']");
    private static final By homePageRecommendedItemsLocator =By.xpath( "//div[@class='recommended_items']/div/div/div/div/div/div/div/a");

    private static final String productAddToCartLocatorPart1 = "//a[@data-product-id=\"";

    //navigation
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    //methods
    @Step("Click on Home Page")
    public HomePage getHomePage() {
        driver.elementActions().clickElement(homePageButtonLocator);
        LogsUtils.info("Clicked on home Page");
        return new HomePage(driver);
    }

    @Step("Click on Sign up/Login")
    public SignUpLoginPage signUpLogin() {
        driver.elementActions().clickElement(SignUpLoginButtonLocator);
        LogsUtils.info("Clicked on Signup/login Page");
        return new SignUpLoginPage(driver);
    }

    @Step("Click on Delete account")
    public DeleteConfirmation deleteAccount() {
        driver.elementActions().clickElement(deleteAccountButtonLocator);
        LogsUtils.info("Clicked on Delete Account");
        return new DeleteConfirmation(driver);
    }

    @Step("Click on Logout account")
    public HomePage logoutAccount() {
        driver.elementActions().clickElement(homePageLogoutButtonLocator);
        LogsUtils.info("Clicked on Logout account");
        return new HomePage(driver);
    }

    @Step("Click on Products Page")
    public ProductsPage productPage() {
        driver.elementActions().clickElement(homePageProductsButtonLocator);
        LogsUtils.info("Clicked on Products Page");
        return new ProductsPage(driver);
    }

    @Step("Click on Cart Page")
    public CartPage cartPage() {
        driver.elementActions().clickElement(homePageCartButtonLocator);
        LogsUtils.info("Clicked on Cart Page");
        return new CartPage(driver);
    }

    @Step("Click on Contact Us Page")
    public ContactUsPage contactUsPage() {
        driver.elementActions().clickElement(homePageContactUsButtonLocator);
        LogsUtils.info("Clicked on Contact Us Page");
        return new ContactUsPage(driver);
    }

    @Step("Click on Test Cases Page")
    public TestCasesPage testCasesPage() {
        driver.elementActions().clickElement(homePageTestCasesButtonLocator);
        LogsUtils.info("Clicked on Test Cases Page");
        return new TestCasesPage(driver);
    }

    @Step("adding Email: email")
    public HomePage addEmailToSubscription(String email) {
        driver.elementActions().sendData(homePageSubscriptionEmailLocator, email);
        return new HomePage(driver);

    }

    @Step("Subscripe to the site ")
    public HomePage pressArrowSubscription() {
        driver.elementActions().clickElement(homePageSubscriptionArrowButtonLocator);
        LogsUtils.info("Putting Email and then click on SUBSCRIPTION");
        return new HomePage(driver);
    }

    @Step("Add a Product {productNumber} to the cart")
    public ProductsPage addToCartProduct(String productNumber) {
        By addToCartProductButton = By.xpath(productAddToCartLocatorPart1 + productNumber + "\"]");
        driver.elementActions().clickElement(addToCartProductButton);
        LogsUtils.info("Added a product to cart");
        return new ProductsPage(driver);
    }

    @Step("Click on Women Category")
    public HomePage homePageCategoryWomen() {
        driver.elementActions().clickElement(homePageCategoryWomenLocator);
        LogsUtils.info("Women Category clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on Dress in Women Category")
    public HomePage homePageCategoryWomenDress() {
        driver.elementActions().clickElement(homePageCategoryWomenDressLocator);
        LogsUtils.info("Women Category Dress clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on Men Category")
    public HomePage homePageCategoryMen() {
        driver.elementActions().clickElement(homePageCategoryMenLocator);
        LogsUtils.info("Men Category clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on T-shirt in Men Category")
    public HomePage homePageCategoryMenTshirt() {
        driver.elementActions().clickElement(homePageCategoryMenTshirtLocator);
        LogsUtils.info("Men Category T-shirt clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on Recommended Items")
    public HomePage homePageRecommendedItemsclick() {
        driver.elementActions().scrollToElement(homePageRecommendedItemsAssertionLocator);
        return new HomePage(driver);
    }

    @Step("Click on a Recommended Item")
    public ProductsPage homePageCategoryRecommendedItems() {
        driver.elementActions().clickElement(homePageRecommendedItemsLocator);
        LogsUtils.info("Recommended Item is chosen in home page");
        return new ProductsPage(driver);
    }

    //validations
    @Step("Assertion on Home Page")
    public HomePage homePageCategoryAssertion() {
        driver.validaions().validateTrue(driver.elementActions().getText(homePageCategoryAssertionLocator).contains("CATEGORY"), "Category Page isn't shown");
        LogsUtils.info("Category Assertion In home page");
        return new HomePage(driver);
    }

    @Step("Assert on T-shirt in Men Category")
    public HomePage homePageCategoryMenTshirtAssertion() {
        driver.validaions().validateTrue(driver.elementActions().getText(homePageCategoryMenTshirtAssertionLocator).contains("MEN"), "Men Category Page isn't shown");
        LogsUtils.info("Men Category T-shirt Assertion in home page");
        return new HomePage(driver);
    }

    @Step("Assert on Dress in Women Category")
    public HomePage homePageCategoryWomenDressAssertion() {
        driver.validaions().validateTrue(driver.elementActions().getText(homePageCategoryWomenDressAssertionLocator).contains("WOMEN -"), "Women Category Page isn't shown");
        LogsUtils.info("Women Category dress Assertion in Home page");
        return new HomePage(driver);
    }

    @Step("Verify on Recommended Items")
    public HomePage homePageRecommendedItemsAssertion() {
        driver.validaions().validateTrue((driver.elementActions().getText(homePageRecommendedItemsAssertionLocator).contains("RECOMMENDED")), "recommended isn't shown");
        LogsUtils.info("Recommended Items visiable in home page");
        return new HomePage(driver);
    }

    @Step("Verify on Recommended Items")
    public SignUpLoginPage logoutAssertionNavigateToLogin() {
        driver.validaions().validateEqual(driver.browserActions().getCurrentURl(), PropertiesUtils.getPropertyValue("loginURL"), "its not Login Page");
        return new SignUpLoginPage(driver);
    }

    @Step("verify on Subscription")
    public HomePage subscriptionAssertion() {
        String actualText = driver.elementActions().getText(homePageSubscriptionAssertionLocator);
        driver.validaions().validateTrue(actualText.contains("SUBSCRIPTION"), "Subscription is not valid");
        LogsUtils.info("Assertion on SUBSCRIPTION in Home Page");
        return new HomePage(driver);

    }

    @Step("Assertion on successfully subescription")
    public HomePage successfullySubscriptionEmailAssertion() {
        String Message = driver.elementActions().getText(homePageSubscriptionSuccessfullyAssertionLocator);
        driver.validaions().validateTrue(Message.contains("successfully subscribed"), "Subscriptions didn;t go well");
        LogsUtils.info("successfully subscribed");
        return new HomePage(driver);
    }


}





