package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactUsPage {
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


    public static void ContactUsPutingValues(WebDriver webDriver) throws InterruptedException {
        By getInTouchName = By.xpath(getInTouchNameLocator);
        webDriver.findElement(getInTouchName).sendKeys(name);
        By getInTouchGmail = By.xpath(getInTouchEmailLocator);
        webDriver.findElement(getInTouchGmail).sendKeys(email);
        By getInTouchSubject = By.xpath(getInTouchSubjectLocator);
        webDriver.findElement(getInTouchSubject).sendKeys(subject);
        By getInTouchmessage = By.xpath(getInTouchMessageLocator);
        webDriver.findElement(getInTouchmessage).sendKeys(message);
        By getInTouchUploadButton = By.xpath(getInTouchChooseFileButtonLocator);
        webDriver.findElement(getInTouchName).click();
        WebElement uploadButton = webDriver.findElement(By.xpath(getInTouchChooseFileButtonLocator));
        uploadButton.sendKeys(filePath);
        By contactUsSubmitButton = By.xpath(getInTouchSubmitButtonLocator);
        webDriver.findElement(contactUsSubmitButton).click();
        Thread.sleep(1000);

        Alert alert = webDriver.switchTo().alert();
        alert.accept();

    }
    public static void ContactUsSecondPage(WebDriver webDriver) throws InterruptedException {
        By message = By.xpath(secondPagemessageLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(assertionMessage));
        Thread.sleep(1000);
        By contactUsHomeButton = By.xpath(secondPageHomeButtonLocator);
        webDriver.findElement(contactUsHomeButton).click();
    }


}


