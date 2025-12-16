package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;

public class PaymentPage {
    //code
    //variables
    private final GUIDriver driver;
    //constructors
    public PaymentPage(GUIDriver driver){
        this.driver = driver;
    }
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
    public PaymentPage WriteComment(String comment){
        By message= By.xpath(messageCommentLocator);
        driver.elementActions().sendData(message,comment);
        return new PaymentPage(driver);
    }
    @Step("Click on Place Order in Payment Page")
    public PaymentPage PlaceOrder(){
        By PlaceOrderButton= By.xpath(placeOrderButtonLocator);
        driver.elementActions().clickElement(PlaceOrderButton);
        return new PaymentPage(driver);
    }
    @Step("Place The Payment Methods in the page")
    public static void PaymentCardValues(WebDriver webDriver) throws InterruptedException {
        By submitPayment = By.xpath(paymentButtonLocator);
        webDriver.findElement(submitPayment).click();
        LogsUtils.info("Payment Method done ");
    }
    @Step("put the Card Name: {name}")
    public PaymentPage puttingName(String name){
        By cardName = By.xpath(nameOnCardLocator);
        driver.elementActions().sendData(cardName,name);
        return new PaymentPage(driver);
    }
    @Step("put the Card Number: {number}")
    public PaymentPage puttingNumber(String number){
        By cardName = By.xpath(cardNumberLocator);
        driver.elementActions().sendData(cardName,number);
        return new PaymentPage(driver);
    }
    @Step("put the Card CVC: {cvcNumber}")
    public PaymentPage puttingCVCNumber(String cvcNumber){
        By cardName = By.xpath(cardCVCLocator);
        driver.elementActions().sendData(cardName,cvcNumber);
        return new PaymentPage(driver);
    }
    @Step("place the card expiry date: {month} - {year}")
    public PaymentPage putExpiryDate(String month,String year){
        By cardExpiryMonth = By.xpath(cardExpirationMonthLocator);
        driver.elementActions().sendData(cardExpiryMonth,month);
        By cardExpiryYear = By.xpath(cardExpirationYearLocator);
        driver.elementActions().sendData(cardExpiryYear,year);
        return new PaymentPage(driver);
    }
    @Step("Click on submit")
    public PaymentPage submitPayment(){
        By submitPayment = By.xpath(paymentButtonLocator);
        driver.elementActions().clickElement(submitPayment);
        LogsUtils.info("Payment Method done ");
        return new PaymentPage(driver);
    }
    @Step("Download InVoice")
    public PaymentPage PaymentDownloadInvoice(){
        By DownloadInvoiceButton= By.xpath(paymentDownloadInvoiceButtonLocator);
        driver.elementActions().clickElement(DownloadInvoiceButton);
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
        return new PaymentPage(driver)

    }
    @Step("Continue Payment")
    public HomePage PaymentContinue(){
        By PlaceOrderButton= By.xpath(paymentContinueButtonLocator);
        driver.elementActions().clickElement(PlaceOrderButton);
        LogsUtils.info("pressed on Continue Payment");
        return new HomePage(driver);
    }
//validations
    @Step("Assertion on Payment Confirmation")
    public HomePage PaymentConfirmation(){
        By message = By.xpath(paymentMessageAssertionLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains("confirmed"),"Payment is not confirmed");
        LogsUtils.info("Assertion on Confirmation");
        return new HomePage(driver);
    }
}

