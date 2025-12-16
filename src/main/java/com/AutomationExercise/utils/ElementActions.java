package com.AutomationExercise.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {
    private WebDriver driver;
    private Waits waits;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
    }

    //send keys
    public void sendData(By locator, String data) {
        waits.waitForElementVisible(locator);
        scrollToElement(locator);
        findElement(locator).sendKeys(data);
        LogsUtils.info("Data: " + data + " is sent");
    }

    //clicking
    public void clickElement(By locator) {
        waits.waitForElementClickable(locator);
        scrollToElement(locator);
        findElement(locator).click();
        LogsUtils.info("the button is clicked");
    }

    public String getText(By locator) {
        waits.waitForElementVisible(locator);
        scrollToElement(locator);
        LogsUtils.info("Text: " + findElement(locator).getText() + " is got");
        return findElement(locator).getText();

    }

    //find element
    public WebElement findElement(By locator) {
        LogsUtils.info("element with wanted locator is found");
        return driver.findElement(locator);
    }

    public String getTextfromInput(By locator) {
        waits.waitForElementClickable(locator);
        scrollToElement(locator);
        LogsUtils.info("getting Text from input field ", locator.toString(), "Text: ", findElement(locator).getDomAttribute("value"));
        return findElement(locator).getDomAttribute("value");
    }
    public void scrollToElement(By locator){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",findElement(locator));
        LogsUtils.info("Scrolling to locator");

    }

}
