package com.AutomationExercise.Listeners;

import com.AutomationExercise.drivers.GUIDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebManagementListeners implements WebDriverListener {
    public void beforeFindElements(GUIDriver driver, By locator) {
        driver.waits().waitForElementVisible(locator);
        driver.elementActions().scrollToElement(locator);
    }

}
