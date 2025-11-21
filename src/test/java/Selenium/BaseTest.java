package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseTest {
    static String webSiteLink = "https://www.automationexercise.com/";
    public static WebDriver WebOpen()
    {
        WebDriver webDriver = new EdgeDriver();
        webDriver.get(webSiteLink);
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
