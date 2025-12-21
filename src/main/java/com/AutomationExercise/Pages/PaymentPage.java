package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.io.File;

public class PaymentPage {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public PaymentPage(GUIDriver driver) {
        this.driver = driver;
    }

    //locators
    private static final By messageCommentLocator =By.xpath( "//textarea[@class='form-control']");
    private static final By placeOrderButtonLocator =By.xpath( "//a[normalize-space(text())='Place Order']");
    private static final By nameOnCardLocator =By.xpath( "//input[@name='name_on_card']");
    private static final By cardNumberLocator =By.xpath( "//input[@name='card_number']");
    private static final By cardCVCLocator =By.xpath( "//input[@name='cvc']");
    private static final By cardExpirationMonthLocator =By.xpath( "//input[@name='expiry_month']");
    private static final By cardExpirationYearLocator =By.xpath( "//input[@name='expiry_year']");
    private static final By paymentButtonLocator =By.xpath( "//button[@id='submit']");
    private static final By paymentMessageAssertionLocator =By.xpath( "//p[text() ='Congratulations! Your order has been confirmed!']");
    private static final By paymentDownloadInvoiceButtonLocator =By.xpath( "//a[normalize-space(text())='Download Invoice']");
    private static final By paymentContinueButtonLocator =By.xpath( "//a[normalize-space(text())='Continue']");

    //navigate
    @Step("Navigate Login Page")
    public HomePage navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
        return new HomePage(driver);
    }
    //methods
    @Step("Write Comment In Payment Page")
    public PaymentPage writeComment(String comment) {
        driver.elementActions().sendData(messageCommentLocator, comment);
        return new PaymentPage(driver);
    }

    @Step("Click on Place Order in Payment Page")
    public PaymentPage placeOrder() {
        driver.elementActions().clickElement(placeOrderButtonLocator);
        return new PaymentPage(driver);
    }

    @Step("Place The Payment Methods in the page")
    public static void paymentCardValues(WebDriver webDriver){
        webDriver.findElement(paymentButtonLocator).click();
        LogsUtils.info("Payment Method done ");
    }

    @Step("put the Card Name: {name}")
    public PaymentPage puttingName(String name) {
        driver.elementActions().sendData(nameOnCardLocator, name);
        return new PaymentPage(driver);
    }

    @Step("put the Card Number: {number}")
    public PaymentPage puttingNumber(String number) {
        driver.elementActions().sendData(cardNumberLocator, number);
        return new PaymentPage(driver);
    }

    @Step("put the Card CVC: {cvcNumber}")
    public PaymentPage puttingCVCNumber(String cvcNumber) {
        driver.elementActions().sendData(cardCVCLocator, cvcNumber);
        return new PaymentPage(driver);
    }

    @Step("place the card expiry date: {month} - {year}")
    public PaymentPage putExpiryDate(String month, String year) {
        driver.elementActions().sendData(cardExpirationMonthLocator, month);
        driver.elementActions().sendData(cardExpirationYearLocator, year);
        return new PaymentPage(driver);
    }

    @Step("Click on submit")
    public PaymentPage submitPayment() {
        driver.elementActions().clickElement(paymentButtonLocator);
        LogsUtils.info("Payment Method done ");
        return new PaymentPage(driver);
    }

    @Step("Download InVoice")
    public PaymentPage paymentDownloadInvoice() {
        driver.elementActions().clickElement(paymentDownloadInvoiceButtonLocator);
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
        }
        LogsUtils.info("Invoice Downloaded");
        return new PaymentPage(driver);

    }

    @Step("Continue Payment")
    public HomePage paymentContinue() {
        driver.elementActions().clickElement(paymentContinueButtonLocator);
        LogsUtils.info("pressed on Continue Payment");
        return new HomePage(driver);
    }

    //validations
    @Step("Assertion on Payment Confirmation")
    public PaymentPage paymentConfirmation() {
        String actualText = driver.elementActions().getText(paymentMessageAssertionLocator);
        driver.validaions().validateTrue(actualText.contains("confirmed"), "Payment is not confirmed");
        LogsUtils.info("Assertion on Confirmation");
        return new PaymentPage(driver);
    }
}

