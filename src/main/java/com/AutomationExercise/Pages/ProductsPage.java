package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductsPage {
    //code
    //variables
    private final GUIDriver driver;
    //constructors
    public ProductsPage(GUIDriver driver){
        this.driver = driver;
    }

    /***Locators***/
    private static final String allProductTextLocator = "//h2[normalize-space(text())='All Products']";
    private static final String productTextLocatorPart1 = "//a[@href = '/product_details/";
    private static final String productAddToCartLocatorPart1 = "//a[@data-product-id=\"";
    private static final String productSearchBarLocator = "//input[@id = 'search_product']";
    private static final String productSearchButtonLocator = "//button[@id= 'submit_search']";
    private static final String productContinueShopingLocator = "//button[normalize-space(text())='Continue Shopping']";
    private static final String productViewCartLocator = "//u[normalize-space(text())='View Cart']";
    private static final String productSearchProductAssertionLocator = "//h2[normalize-space(text())='Rs. 500']";
    private static final String productQuantityLocator = "//input[@id='quantity']";
    private static final String viewProductAddToCartLocator = "//button[@class='btn btn-default cart']";
    private static final String productQuantityAssertionLocatorPart1 = "//button[text()='";
    private static final String productBrandsAssertionLocator = "//h2[normalize-space(text())='Brands']";
    private static final String productBrandsChooseLocatorPart1 = "(//ul[@class='nav nav-pills nav-stacked']/li)[";
    private static final String productWriteReviewAssertionLocator = "//*[normalize-space(text())='Write Your Review']";
    private static final String productReviewNameLocator= "//input[@id='name']";
    private static final String productReviewEmailLocator = "//input[@id='email']";
    private static final String productWriteReviewContentLocator = "//textarea[@id='review']";
    private static final String productWriteReviewSubmitLocator = "//button[@id='button-review']";
    private static final String productWriteReviewSubmitionAssertionLocator = "//span[normalize-space(text())='Thank you for your review.']";


    private static final String productMessagesAssertionLocator = "//*";



    /***Variables***/
   private static final String allProductText = "ALL PRODUCTS";
   private static final String availabilityMessage = "Availability";
   private static final String conditionMessage = "Condition";
   private static final String brandMessage = "Brand";
    private static final String searchData = "Blue top";
    private static final String productSearchProductAssertion = "Rs. 500";
    private static final String reviewName = "Mohamed Tamer";
    private static final String reviewEmail = "Mohamed1234@gmail.com";
    private static final String reviewContent = "Its very good :)";





    @Step("Assertion that we are in Products Page")
    public static void AllProductAssertion(WebDriver webDriver) {
        By message = By.xpath(allProductTextLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(allProductText));
        LogsUtils.info("All Products are here");

    }
    @Step("click on View Product of number: {productNumber}")
    public static void ViewProduct(WebDriver webDriver,String productNumber) throws InterruptedException {
        By viewProductButton = By.xpath(productTextLocatorPart1+productNumber+"']");
        webDriver.findElement(viewProductButton).click();
        Thread.sleep(1000);
        LogsUtils.info("Product with number:"+productNumber+" is found");
    }
    @Step("Assert on a Product has the features of Availability,Condition and Brand")
    public static void ProductAssertion(WebDriver webDriver){
        By message = By.xpath(productMessagesAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(availabilityMessage)&&actualText.contains(conditionMessage)&&actualText.contains(brandMessage));
        LogsUtils.info("The Product has the features of Availability,Condition and Brand");
    }
    @Step("Write In the Search Bar the Product name: {searchData}")
    public static void ProductSearch(WebDriver webDriver){
        By searchBarText = By.xpath(productSearchBarLocator);
        webDriver.findElement(searchBarText).sendKeys(searchData);
        By searchSubmitButton = By.xpath(productSearchButtonLocator);
        webDriver.findElement(searchSubmitButton).click();
        By message = By.xpath(productSearchProductAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(productSearchProductAssertion));
        LogsUtils.info("The Product "+searchData+" is found");
    }
    @Step("Add the Product with number {productNumber} To Cart")
    public static void AddToCartProduct(WebDriver webDriver,String productNumber) throws InterruptedException {
        By addToCartProductButton = By.xpath(productAddToCartLocatorPart1+productNumber+"\"]");
        webDriver.findElement(addToCartProductButton).click();
        LogsUtils.info("Product with number "+productNumber+"is added to cart");
        Thread.sleep(1000);
    }
    @Step("Click on Continue Shopping")
    public static void ContinueShopping(WebDriver webDriver) throws InterruptedException {
        By continueShoppingButton = By.xpath(productContinueShopingLocator);
        webDriver.findElement(continueShoppingButton).click();
        LogsUtils.info("Continue Shopping clicked");
        Thread.sleep(1000);
    }
    @Step("Click on View Cart")
    public static void ViewCart(WebDriver webDriver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productViewCartLocator)));
        cart.click();
        LogsUtils.info("Cart is opened");
        Thread.sleep(1000);
    }
    @Step("Add a quantity for the Product (Quantity = {Quantity})")
    public static void ChangeQuantity(WebDriver webDriver,String Quantity) throws InterruptedException {
        By ProductQuantity = By.xpath(productQuantityLocator);
        webDriver.findElement(ProductQuantity).clear();
        webDriver.findElement(ProductQuantity).sendKeys(Quantity);
        LogsUtils.info(Quantity+" is added to the Product");
        Thread.sleep(1000);
    }
    @Step("Click on Add To Cart From View Product")
    public static void ViewProductAddToCart(WebDriver webDriver) throws InterruptedException {
        By ProductAddToCartQuantity = By.xpath(viewProductAddToCartLocator);
        webDriver.findElement(ProductAddToCartQuantity).click();
        LogsUtils.info("Product was Added to cart");
        Thread.sleep(1000);
    }
    @Step("Assertion on the Quantity of the Product to be equal {quantity}")
    public static void ProductQuantityAssertion(WebDriver webDriver,String quantity){
        By message = By.xpath(productQuantityAssertionLocatorPart1+quantity+"']");
        String actualText = webDriver.findElement(message).getText();
        Assert.assertEquals(actualText, quantity);
        LogsUtils.info("Product's Quantity is = "+quantity+" = the same value we put");
    }
    @Step("Assertion on the Brand of the Product")
    public static void ProductBrandsAssertion(WebDriver webDriver){
        By message = By.xpath(productBrandsAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.equalsIgnoreCase("Brands"));
        LogsUtils.info("There is a Brand in the Product");
    }
    @Step("Choose the Brand of the Product: {choice}")
    public static void ProductChooseBrand(WebDriver webDriver,String choice) throws InterruptedException {
        By ProductAddToCartQuantity = By.xpath(productBrandsChooseLocatorPart1+choice+"]");
        webDriver.findElement(ProductAddToCartQuantity).click();
        LogsUtils.info("the brand "+choice+" is chosen");
        Thread.sleep(1000);
    }
    @Step("assertion on review for the product")
    public static void ProductWriteReviewAssertion(WebDriver webDriver){
        By message = By.xpath(productWriteReviewAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains("Write Your Review"));
    }
    @Step("Writing a review for the product")
    public static void ProductWriteReview(WebDriver webDriver){
            By reviewNameContent = By.xpath(productReviewNameLocator);
            webDriver.findElement(reviewNameContent).sendKeys(reviewName);
            By reviewEmailContent = By.xpath(productReviewEmailLocator);
            webDriver.findElement(reviewEmailContent).sendKeys(reviewEmail);
            By reviewContentContent = By.xpath(productWriteReviewContentLocator);
            webDriver.findElement(reviewContentContent).sendKeys(reviewContent);
            By submitButton = By.xpath(productWriteReviewSubmitLocator);
            webDriver.findElement(submitButton).sendKeys(reviewContent);
            By message = By.xpath(productWriteReviewSubmitionAssertionLocator);
            String actualText = webDriver.findElement(message).getText();
            Assert.assertTrue(actualText.contains("Thank you"));
            LogsUtils.info("the review is written successfully");

    }





}
