package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseTest {
    static String webSiteLink = "https://www.automationexercise.com/";
    public static WebDriver WebOpen()
    {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-password-manager");
        WebDriver webDriver = new EdgeDriver();
        webDriver.get(webSiteLink);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
