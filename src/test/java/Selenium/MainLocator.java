package Selenium;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class MainLocator {
    @Test
    public void SignUpScenarios() throws InterruptedException {
        WebDriver webDriver =  BaseTest.WebOpen();
        SignUpPage.signUpScenario(webDriver);

    }
}
