package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactUsPage {
    //code
    //variables
    private final GUIDriver driver;

    //constructors
    public ContactUsPage(GUIDriver driver) {
        this.driver = driver;
    }

    //locators
    private static final By getInTouchNameLocator =By.xpath( "//input[@placeholder = 'Name']");
    private static final By getInTouchEmailLocator =By.xpath( "//input[@placeholder = 'Email']");
    private static final By getInTouchSubjectLocator =By.xpath( "//input[@placeholder = 'Subject']");
    private static final By getInTouchMessageLocator =By.xpath( "//*[@id = 'message']");
    private static final By getInTouchChooseFileButtonLocator =By.xpath( "//*[@type= 'file']");
    private static final By getInTouchSubmitButtonLocator =By.xpath( "//*[@name= 'submit']");
    private static final By secondPagemessageLocator =By.xpath( "//div[@class ='status alert alert-success']");
    private static final By secondPageHomeButtonLocator =By.xpath( "//*[@class = 'btn btn-success']");

    //methods
    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("Putting Name in Contact us")
    public ContactUsPage puttingName(String name) {
        driver.elementActions().sendData(getInTouchNameLocator, name);
        return new ContactUsPage(driver);
    }

    @Step("Putting Email in Contact us")
    public ContactUsPage puttingEmail(String email) {
        driver.elementActions().sendData(getInTouchEmailLocator, email);
        return new ContactUsPage(driver);
    }

    @Step("Putting Subject in Contact us")
    public ContactUsPage puttingSubject(String subject) {
        driver.elementActions().sendData(getInTouchSubjectLocator, subject);
        return new ContactUsPage(driver);
    }

    @Step("Putting Message in Contact us")
    public ContactUsPage puttingMessageInGetInTouch(String message) {
        driver.elementActions().sendData(getInTouchMessageLocator, message);
        return new ContactUsPage(driver);
    }

    @Step("pressing Button to upload file")
    public ContactUsPage uploadingFile(String filePath) {
        Path path = Paths.get(filePath);
        String absolutePath = path.toAbsolutePath().toString();
        driver.elementActions().sendData(getInTouchChooseFileButtonLocator, absolutePath);
        LogsUtils.info("file path: " + filePath + " and absolutePath: " + absolutePath);
        return new ContactUsPage(driver);
    }

    @Step("Click on submit the Message in Contact us")
    public ContactUsPage clickSubmit() {
        driver.elementActions().clickElement(getInTouchSubmitButtonLocator);
        LogsUtils.info("Picture was Putted Successfully");
        Alert alert = GUIDriver.getInstance().switchTo().alert();
        alert.accept();
        LogsUtils.info("Contact us successfully done");
        return new ContactUsPage(driver);
    }

    //validations
    @Step("Assert on contact us form")
    public HomePage contactUsAssertions() {
        String actualText = driver.elementActions().getText(secondPagemessageLocator);
        driver.validaions().validateTrue(actualText.contains(PropertiesUtils.getPropertyValue("successfullySubmitted")), "Contact us page didnt go well");
        LogsUtils.info("Assert on a Successfully submit");
        driver.elementActions().clickElement(secondPageHomeButtonLocator);
        return new HomePage(driver);
    }


}


