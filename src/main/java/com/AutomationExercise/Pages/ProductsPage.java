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
    private static final By  allProductTextLocator =By.xpath("//h2[normalize-space(text())='All Products']");
    private static final By  productSearchBarLocator =By.xpath("//input[@id = 'search_product']");
    private static final By  productSearchButtonLocator =By.xpath("//button[@id= 'submit_search']");
    private static final By  productContinueShopingLocator =By.xpath("//button[normalize-space(text())='Continue Shopping']");
    private static final By  productViewCartLocator =By.xpath("//u[normalize-space(text())='View Cart']");
    private static final By  productSearchProductAssertionLocator =By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p");
    private static final By  productQuantityLocator =By.xpath("//input[@id='quantity']");
    private static final By  viewProductAddToCartLocator =By.xpath("//button[@class='btn btn-default cart']");
    private static final By  productBrandsAssertionLocator =By.xpath("//h2[normalize-space(text())='Brands']");
    private static final By  productWriteReviewAssertionLocator =By.xpath("//*[normalize-space(text())='Write Your Review']");
    private static final By  productReviewNameLocator =By.xpath("//input[@id='name']");
    private static final By  productReviewEmailLocator =By.xpath("//input[@id='email']");
    private static final By  productWriteReviewContentLocator =By.xpath("//textarea[@id='review']");
    private static final By  productWriteReviewSubmitLocator =By.xpath("//button[@id='button-review']");
    private static final By  productWriteReviewSubmitionAssertionLocator =By.xpath("//span[normalize-space(text())='Thank you for your review.']");
    private static final By  productMessagesAssertionLocator =By.xpath("//*");

    private static final String productTextLocatorPart1 = "//a[@href = '/product_details/";
    private static final String  productAddToCartLocatorPart1 = "//a[@data-product-id=\"";
    private static final String  productBrandsChooseLocatorPart1 = "(//ul[@class='nav nav-pills nav-stacked']/li)[";

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
        driver.elementActions().sendData(productSearchBarLocator, searchData);
        driver.elementActions().clickElement(productSearchButtonLocator);
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
        driver.elementActions().clickElement(productContinueShopingLocator);
        LogsUtils.info("Continue Shopping clicked");
        return new ProductsPage(driver);
    }

    @Step("Click on View Cart")
    public CartPage viewCart() {
        driver.elementActions().clickElement(productViewCartLocator);
        LogsUtils.info("Cart is opened");
        return new CartPage(driver);
    }

    @Step("Add a quantity for the Product (Quantity = {quantity})")
    public ProductsPage changeQuantity(String quantity) {
        driver.elementActions().clearData(productQuantityLocator);
        driver.elementActions().sendData(productQuantityLocator, quantity);
        LogsUtils.info(quantity + " is added to the Product");
        return new ProductsPage(driver);
    }

    @Step("Click on Add To Cart From View Product")
    public ProductsPage viewProductAddToCart() {
        driver.elementActions().clickElement(viewProductAddToCartLocator);
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
        driver.elementActions().sendData(productWriteReviewContentLocator, reviewContent);
        return new ProductsPage(driver);
    }

    @Step("Press Submit review")
    public ProductsPage pressSubmitReview() {
        driver.elementActions().clickElement(productWriteReviewSubmitLocator);
        return new ProductsPage(driver);
    }

    @Step("Write review Name: {name}")
    public ProductsPage writeReviewName(String name) {
        driver.elementActions().sendData(productReviewNameLocator, name);
        return new ProductsPage(driver);
    }

    @Step("Write review Email: {email}")
    public ProductsPage writeReviewEmail(String email) {
        driver.elementActions().sendData(productReviewEmailLocator, email);
        return new ProductsPage(driver);
    }


    //validations
    @Step("Assertion that we are in Products Page")
    public ProductsPage allProductAssertion() {
        String actualText = driver.elementActions().getText(allProductTextLocator);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("allProductText")), "All product doesn't match");
        LogsUtils.info("All Products are here");
        return new ProductsPage(driver);

    }

    @Step("Assert on a Product has the features of Availability,Condition and Brand")
    public ProductsPage productAssertion() {
        String actualText = driver.elementActions().getText(productMessagesAssertionLocator);
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
        String actualText = driver.elementActions().getText(productBrandsAssertionLocator);
        driver.validaions()
                .validateTrue(actualText.equalsIgnoreCase(PropertiesUtils.getPropertyValue("brandMessage"))
                ,"there is no Brands");
        LogsUtils.info("There is a Brand in the Product");
        return new ProductsPage(driver);
    }

    @Step("assertion on review for the product")
    public ProductsPage productWriteReviewAssertion() {
        String actualText = driver.elementActions().getText(productWriteReviewAssertionLocator);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("reviewMessage"))
                , "there is no review here");
        return new ProductsPage(driver);
    }

    @Step("assertion on a product searched {searchData}")
    public ProductsPage searchProductAssertion(String searchData) {
        String actualText = driver.elementActions().getText(productSearchProductAssertionLocator).toLowerCase();
        driver.validaions().validateTrue(actualText.contains(searchData.toLowerCase()), "Search didn't go well");
        LogsUtils.info("The Product " + searchData + " is found");
        return new ProductsPage(driver);
    }

    @Step("assertion on a review")
    public ProductsPage reviewAssertion() {
        String actualText = driver.elementActions().getText(productWriteReviewSubmitionAssertionLocator);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("reviewThanks"))
                ,"product review didn't go well");
        LogsUtils.info("the review is written successfully");
        return new ProductsPage(driver);
    }
}
