package com.AutomationExercise.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validaions {
    private WebDriver driver;
    private BrowserActions browserActions;
    public Validaions(WebDriver driver) {
        this.driver = driver;
        browserActions = new BrowserActions(driver);
    }

    public void validateTrue(Boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public void validateFalse(Boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }

    public void validateEqual(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    public void validateNotEqual(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    public void validatePageUrl(String expected) {
        Assert.assertEquals(browserActions.getCurrentURl(), expected);
    }

    public void validateTitle(String expected) {
        Assert.assertEquals(browserActions.getPageTitle(), expected);
    }

}
