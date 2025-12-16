package com.AutomationExercise.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {
    private WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToURl(String url) {
        driver.get(url);
        LogsUtils.info("Navigated to URL: " + url);
    }

    public String getCurrentURl() {
        LogsUtils.info("Got the URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }

    public String getPageTitle() {
        LogsUtils.info("Got the Page Title: " + driver.getTitle());
        return driver.getTitle();

    }

    public void refreshPage() {
        driver.navigate().refresh();
        LogsUtils.info("Refreshing the Page");
    }

    //close browser
    @Step("Closing the browser")
    public void closeBrowser() {
        LogsUtils.info("Closing the browser");
        if (driver != null) {
            driver.quit(); // 🚀 Ensure this is called
        }


    }
}
