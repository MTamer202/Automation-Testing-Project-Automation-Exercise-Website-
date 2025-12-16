package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactUsPage {
    //code
    //variables
    private final GUIDriver driver;
    //constructors
    public ContactUsPage(GUIDriver driver){
        this.driver = driver;
    }

    /***Locators***/
    private static final String getInTouchNameLocator = "//input[@placeholder = 'Name']";
    private static final String getInTouchEmailLocator = "//input[@placeholder = 'Email']";
    private static final String getInTouchSubjectLocator = "//input[@placeholder = 'Subject']";
    private static final String getInTouchMessageLocator = "//*[@id = 'message']";
    private static final String getInTouchChooseFileButtonLocator = "//*[@type= 'file']";
    private static final String getInTouchSubmitButtonLocator = "//*[@name= 'submit']";
    private static final String secondPagemessageLocator = "//div[@class ='status alert alert-success']";
    private static final String secondPageHomeButtonLocator = "//*[@class = 'btn btn-success']";

    /***Variables***/
    private static final String name = "Mohamed";
    private static final String email = "mohamedTamer1235@gmail.com";
    private static final String subject = "Automaion Testing";
    private static final String message = "Hello I am Tamer and I am Trying to find peace";
    private static final String filePath = "E:\\study\\ITI content\\automation\\Graduation_Project\\Me.pdf";
    private static final String assertionMessage = "Success! Your details have been submitted successfully.";

    @Step("Putting the Values in Contact us Page")
    public static void ContactUsPutingValues(WebDriver webDriver) throws InterruptedException {



        By contactUsSubmitButton = By.xpath(getInTouchSubmitButtonLocator);
        webDriver.findElement(contactUsSubmitButton).click();
        Thread.sleep(1000);
        LogsUtils.info("Picture was Putted Successfully ");
        Alert alert = webDriver.switchTo().alert();
        alert.accept();
        LogsUtils.info("Contact us successfully done");
    }
    @Step("Putting Name in Contact us")
    public ContactUsPage puttingName(String name){
        By getInTouchName = By.xpath(getInTouchNameLocator);
        driver.elementActions().sendData(getInTouchName,name);
        return new ContactUsPage(driver);
    }
    @Step("Putting Email in Contact us")
    public ContactUsPage puttingEmail(String email){
        By getInTouchName = By.xpath(getInTouchEmailLocator);
        driver.elementActions().sendData(getInTouchName,email);
        return new ContactUsPage(driver);
    }
    @Step("Putting Subject in Contact us")
    public ContactUsPage puttingSubject(String subject){
        By getInTouchName = By.xpath(getInTouchSubjectLocator);
        driver.elementActions().sendData(getInTouchName,subject);
        return new ContactUsPage(driver);
    }
    @Step("Putting Message in Contact us")
    public ContactUsPage puttingMessageInGetInTouch(String message){
        By getInTouchName = By.xpath(getInTouchMessageLocator);
        driver.elementActions().sendData(getInTouchName,message);
        return new ContactUsPage(driver);
    }
    @Step("pressing Button to upload file")
    public ContactUsPage UploadingFile(String filePath){
        By getInTouchUploadButton = By.xpath(getInTouchChooseFileButtonLocator);
        driver.elementActions().clickElement(getInTouchUploadButton);
        driver.elementActions().sendData(getInTouchUploadButton,filePath);
        return new ContactUsPage(driver);
    }
    @Step("Click on submit the Message in Contact us")
    public ContactUsPage clickSubmit(){
        By contactUsSubmitButton = By.xpath(getInTouchSubmitButtonLocator);
        driver.elementActions().clickElement(contactUsSubmitButton);
        LogsUtils.info("Picture was Putted Successfully");
        Alert alert = GUIDriver.getInstance().switchTo().alert()    ;
        alert.accept();
        LogsUtils.info("Contact us successfully done");
        return new ContactUsPage(driver);
    }
    //validations
    @Step("Assert on contact us form")
    public HomePage ContactUsAssertions(){
        By message = By.xpath(secondPagemessageLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains(assertionMessage),"Contact us page didnt go well");
        LogsUtils.info("Assert on a Successfully submit");
        By contactUsHomeButton = By.xpath(secondPageHomeButtonLocator);
        driver.elementActions().clickElement(contactUsHomeButton);
        return new HomePage(driver);
    }


}


