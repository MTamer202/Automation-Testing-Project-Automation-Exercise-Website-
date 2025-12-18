package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class ProductsPage {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public ProductsPage(GUIDriver driver) {
        this.driver = driver;
    }

    //locators
    private static final String allProductTextLocator = "//h2[normalize-space(text())='All Products']";
    private static final String productTextLocatorPart1 = "//a[@href = '/product_details/";
    private static final String productAddToCartLocatorPart1 = "//a[@data-product-id=\"";
    private static final String productSearchBarLocator = "//input[@id = 'search_product']";
    private static final String productSearchButtonLocator = "//button[@id= 'submit_search']";
    private static final String productContinueShopingLocator = "//button[normalize-space(text())='Continue Shopping']";
    private static final String productViewCartLocator = "//u[normalize-space(text())='View Cart']";
    private static final String productSearchProductAssertionLocator = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p";
    private static final String productQuantityLocator = "//input[@id='quantity']";
    private static final String viewProductAddToCartLocator = "//button[@class='btn btn-default cart']";
    private static final String productBrandsAssertionLocator = "//h2[normalize-space(text())='Brands']";
    private static final String productBrandsChooseLocatorPart1 = "(//ul[@class='nav nav-pills nav-stacked']/li)[";
    private static final String productWriteReviewAssertionLocator = "//*[normalize-space(text())='Write Your Review']";
    private static final String productReviewNameLocator = "//input[@id='name']";
    private static final String productReviewEmailLocator = "//input[@id='email']";
    private static final String productWriteReviewContentLocator = "//textarea[@id='review']";
    private static final String productWriteReviewSubmitLocator = "//button[@id='button-review']";
    private static final String productWriteReviewSubmitionAssertionLocator = "//span[normalize-space(text())='Thank you for your review.']";
    private static final String productMessagesAssertionLocator = "//*";
    //methods
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("click on View Product of number: {productNumber}")
    public ProductsPage viewProduct(String productNumber) {
        By viewProductButton = By.xpath(productTextLocatorPart1 + productNumber + "']");
        driver.elementActions().clickElement(viewProductButton);
        LogsUtils.info("Product with number:" + productNumber + " is found");
        return new ProductsPage(driver);
    }

    @Step("Write In the Search Bar the Product name: {searchData}")
    public ProductsPage productSearch(String searchData) {
        By searchBarText = By.xpath(productSearchBarLocator);
        driver.elementActions().sendData(searchBarText, searchData);
        By searchSubmitButton = By.xpath(productSearchButtonLocator);
        driver.elementActions().clickElement(searchSubmitButton);
        return new ProductsPage(driver);
    }

    @Step("Add the Product with number {productNumber} To Cart")
    public ProductsPage addToCartProduct(String productNumber) {
        By addToCartProductButton = By.xpath(productAddToCartLocatorPart1 + productNumber + "\"]");
        driver.elementActions().clickElement(addToCartProductButton);
        LogsUtils.info("Product with number " + productNumber + "is added to cart");
        return new ProductsPage(driver);
    }

    @Step("Click on Continue Shopping")
    public ProductsPage continueShopping() {
        By continueShoppingButton = By.xpath(productContinueShopingLocator);
        driver.elementActions().clickElement(continueShoppingButton);
        LogsUtils.info("Continue Shopping clicked");
        return new ProductsPage(driver);
    }

    @Step("Click on View Cart")
    public CartPage viewCart() {
        driver.elementActions().clickElement(By.xpath(productViewCartLocator));
        LogsUtils.info("Cart is opened");
        return new CartPage(driver);
    }

    @Step("Add a quantity for the Product (Quantity = {quantity})")
    public ProductsPage changeQuantity(String quantity) {
        By ProductQuantity = By.xpath(productQuantityLocator);
        driver.elementActions().clearData(ProductQuantity);
        driver.elementActions().sendData(ProductQuantity, quantity);
        LogsUtils.info(quantity + " is added to the Product");
        return new ProductsPage(driver);
    }

    @Step("Click on Add To Cart From View Product")
    public ProductsPage viewProductAddToCart() {
        By ProductAddToCartQuantity = By.xpath(viewProductAddToCartLocator);
        driver.elementActions().clickElement(ProductAddToCartQuantity);
        LogsUtils.info("Product was Added to cart");
        return new ProductsPage(driver);
    }

    @Step("Choose the Brand of the Product: {choice}")
    public ProductsPage productChooseBrand(String choice) {
        By ProductAddToCartQuantity = By.xpath(productBrandsChooseLocatorPart1 + choice + "]");
        driver.elementActions().clickElement(ProductAddToCartQuantity);
        LogsUtils.info("the brand " + choice + " is chosen");
        return new ProductsPage(driver);
    }

    @Step("Writing a review for the product")
    public ProductsPage productWriteReview(String reviewContent) {
        By reviewContentContent = By.xpath(productWriteReviewContentLocator);
        driver.elementActions().sendData(reviewContentContent, reviewContent);
        By message = By.xpath(productWriteReviewSubmitionAssertionLocator);
        return new ProductsPage(driver);
    }

    @Step("Press Submit review")
    public ProductsPage pressSubmitReview() {
        By submitButton = By.xpath(productWriteReviewSubmitLocator);
        driver.elementActions().clickElement(submitButton);
        return new ProductsPage(driver);
    }

    @Step("Write review Name: {name}")
    public ProductsPage writeReviewName(String name) {
        By reviewNameContent = By.xpath(productReviewNameLocator);
        driver.elementActions().sendData(reviewNameContent, name);
        return new ProductsPage(driver);
    }

    @Step("Write review Email: {email}")
    public ProductsPage writeReviewEmail(String email) {
        By reviewEmailContent = By.xpath(productReviewEmailLocator);
        driver.elementActions().sendData(reviewEmailContent, email);
        return new ProductsPage(driver);
    }


    //validations
    @Step("Assertion that we are in Products Page")
    public ProductsPage allProductAssertion() {
        By message = By.xpath(allProductTextLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("allProductText")), "All product doesn't match");
        LogsUtils.info("All Products are here");
        return new ProductsPage(driver);

    }

    @Step("Assert on a Product has the features of Availability,Condition and Brand")
    public ProductsPage productAssertion() {
        By message = By.xpath(productMessagesAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions()
                .validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("availabilityMessage"))
                                && actualText.contains(PropertiesUtils.getPropertyValue("conditionMessage"))
                                &&actualText.contains(PropertiesUtils.getPropertyValue("brandMessageB")),
                        "the product assertion is failed");
        LogsUtils.info("The Product has the features of Availability,Condition and Brand");
        return new ProductsPage(driver);
    }

    @Step("Assertion on the Brand of the Product")
    public ProductsPage productBrandsAssertion() {
        By message = By.xpath(productBrandsAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions()
                .validateTrue(actualText.equalsIgnoreCase(PropertiesUtils.getPropertyValue("brandMessage"))
                ,"there is no Brands");
        LogsUtils.info("There is a Brand in the Product");
        return new ProductsPage(driver);
    }

    @Step("assertion on review for the product")
    public ProductsPage productWriteReviewAssertion() {
        By message = By.xpath(productWriteReviewAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("reviewMessage"))
                , "there is no review here");
        return new ProductsPage(driver);
    }

    @Step("assertion on a product searched {searchData}")
    public ProductsPage searchProductAssertion(String searchData) {
        By message = By.xpath(productSearchProductAssertionLocator);
        String actualText = driver.elementActions().getText(message).toLowerCase();
        driver.validaions().validateTrue(actualText.contains(searchData.toLowerCase()), "Search didn't go well");
        LogsUtils.info("The Product " + searchData + " is found");
        return new ProductsPage(driver);
    }

    @Step("assertion on a review")
    public ProductsPage reviewAssertion() {
        By message = By.xpath(productWriteReviewSubmitionAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("reviewThanks"))
                ,"product review didn't go well");
        LogsUtils.info("the review is written successfully");
        return new ProductsPage(driver);
    }
}
