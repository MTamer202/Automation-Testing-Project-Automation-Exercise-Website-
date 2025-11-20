package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage {
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



    private static final String productMessagesAssertionLocator = "//*";



    /***Variables***/
   private static final String allProductText = "ALL PRODUCTS";
   private static final String availabilityMessage = "Availability";
   private static final String conditionMessage = "Condition";
   private static final String brandMessage = "Brand";
   private static final String searchData = "Blue top";
   private static final String productSearchProductAssertion = "Rs. 500";





    public static void AllProductAssertion(WebDriver webDriver) {
        By message = By.xpath(allProductTextLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(allProductText));
    }
    public static void ViewProduct(WebDriver webDriver,String productNumber) throws InterruptedException {
        By viewProductButton = By.xpath(productTextLocatorPart1+productNumber+"']");
        webDriver.findElement(viewProductButton).click();
        Thread.sleep(1000);
    }
    public static void ProductAssertion(WebDriver webDriver){
        By message = By.xpath(productMessagesAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(availabilityMessage)&&actualText.contains(conditionMessage)&&actualText.contains(brandMessage));
    }

    public static void ProductSearch(WebDriver webDriver){
        By searchBarText = By.xpath(productSearchBarLocator);
        webDriver.findElement(searchBarText).sendKeys(searchData);
        By searchSubmitButton = By.xpath(productSearchButtonLocator);
        webDriver.findElement(searchSubmitButton).click();
        By message = By.xpath(productSearchProductAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(productSearchProductAssertion));
    }
    public static void AddToCartProduct(WebDriver webDriver,String productNumber) throws InterruptedException {
        By addToCartProductButton = By.xpath(productAddToCartLocatorPart1+productNumber+"\"]");
        webDriver.findElement(addToCartProductButton).click();
        Thread.sleep(1000);
    }

    public static void ContinueShopping(WebDriver webDriver) throws InterruptedException {
        By continueShoppingButton = By.xpath(productContinueShopingLocator);
        webDriver.findElement(continueShoppingButton).click();
        Thread.sleep(1000);
    }

    public static void ViewCart(WebDriver webDriver) throws InterruptedException {
        By viewCartProductButton = By.xpath(productViewCartLocator);
        webDriver.findElement(viewCartProductButton).click();
        Thread.sleep(1000);
    }

    public static void ChangeQuantity(WebDriver webDriver,String Quantity) throws InterruptedException {
        By ProductQuantity = By.xpath(productQuantityLocator);
        webDriver.findElement(ProductQuantity).clear();
        webDriver.findElement(ProductQuantity).sendKeys(Quantity);
        Thread.sleep(1000);
    }

    public static void ViewProductAddToCart(WebDriver webDriver) throws InterruptedException {
        By ProductAddToCartQuantity = By.xpath(viewProductAddToCartLocator);
        webDriver.findElement(ProductAddToCartQuantity).click();
        Thread.sleep(1000);
    }

    public static void ProductQuantityAssertion(WebDriver webDriver,String quantity){
        By message = By.xpath(productQuantityAssertionLocatorPart1+quantity+"']");
        String actualText = webDriver.findElement(message).getText();
        Assert.assertEquals(actualText, quantity);
    }

}
