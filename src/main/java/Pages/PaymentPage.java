package Pages;

import com.google.j2objc.annotations.Weak;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utiles.LogsUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PaymentPage {
    /***Locators***/
    private static final String messageCommentLocator = "//textarea[@class='form-control']";
    private static final String placeOrderButtonLocator = "//a[normalize-space(text())='Place Order']";
    private static final String nameOnCardLocator = "//input[@name='name_on_card']";
    private static final String cardNumberLocator = "//input[@name='card_number']";
    private static final String cardCVCLocator = "//input[@name='cvc']";
    private static final String cardExpirationMonthLocator = "//input[@name='expiry_month']";
    private static final String cardExpirationYearLocator = "//input[@name='expiry_year']";
    private static final String paymentButtonLocator = "//button[@id='submit']";
    private static final String paymentMessageAssertionLocator = "//p[text() ='Congratulations! Your order has been confirmed!']";
    private static final String paymentDownloadInvoiceButtonLocator = "//a[normalize-space(text())='Download Invoice']";
    private static final String paymentContinueButtonLocator = "//a[normalize-space(text())='Continue']";

    /***Variables***/
    private static final String comment = "Need Order ASAP";

    @Step("Write Comment In Payment Page")
    public static void WriteComment(WebDriver webDriver){
        By message= By.xpath(messageCommentLocator);
        webDriver.findElement(message).sendKeys(comment);
    }
    @Step("Click on Place Order in Payment Page")
    public static void PlaceOrder(WebDriver webDriver){
        By PlaceOrderButton= By.xpath(placeOrderButtonLocator);
        webDriver.findElement(PlaceOrderButton).click();
    }
    @Step("Place The Payment Methods in the page")
    public static void PaymentCardValues(WebDriver webDriver) throws InterruptedException {
        By cardName = By.xpath(nameOnCardLocator);
        webDriver.findElement(cardName).sendKeys("Mohamed Tamer");
        By cardNumer = By.xpath(cardNumberLocator);
        webDriver.findElement(cardNumer).sendKeys("1111222233334444");
        By cardCVC = By.xpath(cardCVCLocator);
        webDriver.findElement(cardCVC).sendKeys("123");
        By cardExpiryMonth = By.xpath(cardExpirationMonthLocator);
        webDriver.findElement(cardExpiryMonth).sendKeys("03");
        By cardExpiryYear = By.xpath(cardExpirationYearLocator);
        webDriver.findElement(cardExpiryYear).sendKeys("2030");
        Actions actions = new Actions(webDriver);
        actions.scrollByAmount(0, 500).perform();
        By submitPayment = By.xpath(paymentButtonLocator);
        webDriver.findElement(submitPayment).click();
        LogsUtils.info("Payment Method done ");
    }
    @Step("Assertion on Payment Confirmation")
    public static void PaymentConfirmation(WebDriver webDriver) throws InterruptedException {
    By message = By.xpath(paymentMessageAssertionLocator);
    String actualText = webDriver.findElement(message).getText();
    Assert.assertTrue(actualText.contains("confirmed"));
    LogsUtils.info("Assertion on Confirmation");
    Thread.sleep(1000);
}
    @Step("Download InVoice")
    public static void PaymentDownloadInvoice(WebDriver webDriver) throws InterruptedException {
        By DownloadInvoiceButton= By.xpath(paymentDownloadInvoiceButtonLocator);
        webDriver.findElement(DownloadInvoiceButton).click();
        LogsUtils.info("Invoice Downloading");
        /*Download Check*/
        String downloadDir = System.getProperty("user.dir") + "/downloads";
        File dir = new File(downloadDir);
        long end = System.currentTimeMillis() + 3000;
        File downloadedFile = null;
        while (System.currentTimeMillis() < end) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File f : files) {
                    String name = f.getName();
                    if (!name.endsWith(".crdownload") && f.length() > 0) {
                        downloadedFile = f;
                        break;
                    }
                }
            }
            if (downloadedFile != null) break;
            Thread.sleep(500);
        }
        LogsUtils.info("Invoice Downloaded");

    }
    @Step("Continue Payment")
    public static void PaymentContinue(WebDriver webDriver){
        By PlaceOrderButton= By.xpath(paymentContinueButtonLocator);
        webDriver.findElement(PlaceOrderButton).click();
        LogsUtils.info("pressed on Continue Payment");
    }

}

