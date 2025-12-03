package Selenium;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeSuite;
import utiles.FilesUtils;
import utiles.LogsUtils;

import java.io.File;

public class BaseTest {
    static String webSiteLink = "https://www.automationexercise.com/";

    File allure_results = new File("test-outputs/allure-results");

    @BeforeSuite
    public void beforeSuite() {
        FilesUtils.deleteFiles(allure_results);
    }
    @Step("Opening Edge Browser")
    public static WebDriver WebOpen()
    {
        WebDriver webDriver = new EdgeDriver();
        webDriver.get(webSiteLink);
        webDriver.manage().window().maximize();
        LogsUtils.info("Edge is Opened Successfully");
        return webDriver;
    }
    public static void WebClose(WebDriver webDriver)
    {
        webDriver.close();
    }
}
