package com.AutomationExercise.Pages;

import com.AutomationExercise.drivers.GUIDriver;
import com.AutomationExercise.utils.LogsUtils;
import com.AutomationExercise.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

    @Step("Navigate Login Page")
    public void navigateToHomePage() {
        driver.browserActions().navigateToURl(PropertiesUtils.getPropertyValue("baseURL"));
    }

    @Step("Putting Name in Contact us")
    public ContactUsPage puttingName(String name) {
        By getInTouchName = By.xpath(getInTouchNameLocator);
        driver.elementActions().sendData(getInTouchName, name);
        return new ContactUsPage(driver);
    }

    @Step("Putting Email in Contact us")
    public ContactUsPage puttingEmail(String email) {
        By getInTouchName = By.xpath(getInTouchEmailLocator);
        driver.elementActions().sendData(getInTouchName, email);
        return new ContactUsPage(driver);
    }

    @Step("Putting Subject in Contact us")
    public ContactUsPage puttingSubject(String subject) {
        By getInTouchName = By.xpath(getInTouchSubjectLocator);
        driver.elementActions().sendData(getInTouchName, subject);
        return new ContactUsPage(driver);
    }

    @Step("Putting Message in Contact us")
    public ContactUsPage puttingMessageInGetInTouch(String message) {
        By getInTouchName = By.xpath(getInTouchMessageLocator);
        driver.elementActions().sendData(getInTouchName, message);
        return new ContactUsPage(driver);
    }

    @Step("pressing Button to upload file")
    public ContactUsPage UploadingFile(String filePath) {
        By getInTouchUploadButton = By.xpath(getInTouchChooseFileButtonLocator);
        Path path = Paths.get(filePath);
        String absolutePath = path.toAbsolutePath().toString();
        driver.elementActions().sendData(getInTouchUploadButton, absolutePath);
        LogsUtils.info("file path: " + filePath + " and absolutePath: " + absolutePath);
        return new ContactUsPage(driver);
    }

    @Step("Click on submit the Message in Contact us")
    public ContactUsPage clickSubmit() {
        By contactUsSubmitButton = By.xpath(getInTouchSubmitButtonLocator);
        driver.elementActions().clickElement(contactUsSubmitButton);
        LogsUtils.info("Picture was Putted Successfully");
        Alert alert = GUIDriver.getInstance().switchTo().alert();
        alert.accept();
        LogsUtils.info("Contact us successfully done");
        return new ContactUsPage(driver);
    }

    //validations
    @Step("Assert on contact us form")
    public HomePage ContactUsAssertions() {
        By message = By.xpath(secondPagemessageLocator);
        String actualText = driver.elementActions().getText(message);
        driver.validaions().validateTrue(actualText.contains(assertionMessage), "Contact us page didnt go well");
        LogsUtils.info("Assert on a Successfully submit");
        By contactUsHomeButton = By.xpath(secondPageHomeButtonLocator);
        driver.elementActions().clickElement(contactUsHomeButton);
        return new HomePage(driver);
    }


}


