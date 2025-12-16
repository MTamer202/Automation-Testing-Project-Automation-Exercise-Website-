package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    //methods

    /***Methods***/
    //navigation
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("Click on Home Page")
    public HomePage getHomePage() {
        By homeNavButton = By.xpath(homePageButtonLocator);
        driver.elementActions().clickElement(homeNavButton);
        LogsUtils.info("Clicked on home Page");
        return new HomePage(driver);
    }

    @Step("Click on Sign up/Login")
    public SignUpLoginPage signUpLogin() {
        By signUpButton = By.xpath(SignUpLoginButtonLocator);
        driver.elementActions().clickElement(signUpButton);
        LogsUtils.info("Clicked on Signup/login Page");
        return new SignUpLoginPage(driver);
    }

    @Step("Click on Delete account")
    public DeleteConfirmation deleteAccount() {
        By deleteAccountButton = By.xpath(deleteAccountButtonLocator);
        driver.elementActions().clickElement(deleteAccountButton);
        LogsUtils.info("Clicked on Delete Account");
        return new DeleteConfirmation(driver);
    }

    @Step("Click on Logout account")
    public HomePage logoutAccount() {
        By logoutButton = By.xpath(homePageLogoutButtonLocator);
        driver.elementActions().clickElement(logoutButton);
        LogsUtils.info("Clicked on Logout account");
        return new HomePage(driver);
    }

    @Step("Click on Products Page")
    public ProductsPage productPage() {
        By productButton = By.xpath(homePageProductsButtonLocator);
        driver.elementActions().clickElement(productButton);
        LogsUtils.info("Clicked on Products Page");
        return new ProductsPage(driver);
    }

    @Step("Click on Cart Page")
    public CartPage cartPage() {
        By CartButton = By.xpath(homePageCartButtonLocator);
        driver.elementActions().clickElement(CartButton);
        LogsUtils.info("Clicked on Cart Page");
        return new CartPage(driver);
    }

    @Step("Click on Contact Us Page")
    public ContactUsPage contactUsPage() {
        By contactUsButton = By.xpath(homePageContactUsButtonLocator);
        driver.elementActions().clickElement(contactUsButton);
        LogsUtils.info("Clicked on Contact Us Page");
        return new ContactUsPage(driver);
    }

    @Step("Click on Test Cases Page")
    public TestCasesPage testCasesPage() {
        By testCasesButton = By.xpath(homePageTestCasesButtonLocator);
        driver.elementActions().clickElement(testCasesButton);
        LogsUtils.info("Clicked on Test Cases Page");
        return new TestCasesPage(driver);
    }

    @Step("adding Email: email")
    public HomePage addEmailToSubscription(String email) {
        By subscriptionEmail = By.xpath(homePageSubscriptionEmailLocator);
        driver.elementActions().sendData(subscriptionEmail, email);
        return new HomePage(driver);

    }

    @Step("Subscripe to the site ")
    public HomePage pressArrowSubscription() {
        By subscriptionArrow = By.xpath(homePageSubscriptionArrowButtonLocator);
        driver.elementActions().clickElement(subscriptionArrow);
        LogsUtils.info("Putting Email and then click on SUBSCRIPTION");
        return new HomePage(driver);
    }

    //verify
    @Step("Add a Product {productNumber} to the cart")
    public HomePage AddToCartProduct(String productNumber) {
        By addToCartProductButton = By.xpath(productAddToCartLocatorPart1 + productNumber + "\"]");
        driver.elementActions().clickElement(addToCartProductButton);
        LogsUtils.info("Added a product to cart");
        return new HomePage(driver);
    }

    @Step("Click on Women Category")
    public HomePage HomePageCategoryWomen() {
        By womenButton = By.xpath(homePageCategoryWomenLocator);
        driver.elementActions().clickElement(womenButton);
        LogsUtils.info("Women Category clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on Dress in Women Category")
    public HomePage HomePageCategoryWomenDress() {
        By dressButton = By.xpath(homePageCategoryWomenDressLocator);
        driver.elementActions().clickElement(dressButton);
        LogsUtils.info("Women Category Dress clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on Men Category")
    public HomePage HomePageCategoryMen() {
        By menButton = By.xpath(homePageCategoryMenLocator);
        driver.elementActions().clickElement(menButton);
        LogsUtils.info("Men Category clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on T-shirt in Men Category")
    public HomePage HomePageCategoryMenTshirt() {
        By tshirtButton = By.xpath(homePageCategoryMenTshirtLocator);
        driver.elementActions().clickElement(tshirtButton);
        LogsUtils.info("Men Category T-shirt clicked home page");
        return new HomePage(driver);
    }

    @Step("Click on Recommended Items")
    public HomePage HomePageRecommendedItemsclick() {
        driver.elementActions().scrollToElement(By.xpath(homePageRecommendedItemsAssertionLocator));
        return new HomePage(driver);
    }

    @Step("Click on a Recommended Item")
    //verify
    public HomePage HomePageCategoryRecommendedItems() {
        driver.elementActions().clickElement(By.xpath(homePageRecommendedItemsLocator));
        LogsUtils.info("Recommended Item is chosen in home page");
        return new HomePage(driver);
    }

    //validations
    @Step("Assertion on Home Page")
    public HomePage HomePageCategoryAssertion() {
        By message = By.xpath(homePageCategoryAssertionLocator);
        driver.validaions().validateTrue(driver.elementActions().getText(message).contains("CATEGORY"), "Category Page isn't shown");
        LogsUtils.info("Category Assertion In home page");
        return new HomePage(driver);
    }

    @Step("Assert on T-shirt in Men Category")
    public HomePage HomePageCategoryMenTshirtAssertion(WebDriver webDriver) {
        By message = By.xpath(homePageCategoryMenTshirtAssertionLocator);
        driver.validaions().validateTrue(driver.elementActions().getText(message).contains("MEN"), "Men Category Page isn't shown");
        LogsUtils.info("Men Category T-shirt Assertion in home page");
        return new HomePage(driver);
    }

    @Step("Assert on Dress in Women Category")
    public HomePage HomePageCategoryWomenDressAssertion(WebDriver webDriver) {
        By message = By.xpath(homePageCategoryWomenDressAssertionLocator);
        driver.validaions().validateTrue(driver.elementActions().getText(message).contains("WOMEN -"), "Women Category Page isn't shown");
        LogsUtils.info("Women Category dress Assertion in Home page");
        return new HomePage(driver);
    }

    @Step("Verify on Recommended Items")
    public HomePage HomePageRecommendedItemsAssertion() {
        By message = By.xpath(homePageRecommendedItemsAssertionLocator);
        driver.validaions().validateTrue((driver.elementActions().getText(message).contains("RECOMMENDED")), "recommended isn't shown");
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
        By message = By.xpath(homePageSubscriptionAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains("SUBSCRIPTION"), "Subscription is not valid");
        LogsUtils.info("Assertion on SUBSCRIPTION in Home Page");
        return new HomePage(driver);

    }

    @Step("Assertion on successfully subescription")
    public HomePage successfullySubscriptionEmailAssertion() {
        By SuccessfullMessage = By.xpath(homePageSubscriptionSuccessfullyAssertionLocator);
        String Message = driver.elementActions().getText(SuccessfullMessage);
        driver.validaions().validateTrue(Message.contains("successfully subscribed"), "Subscriptions didn;t go well");
        LogsUtils.info("successfully subscribed");
        return new HomePage(driver);
    }


}





