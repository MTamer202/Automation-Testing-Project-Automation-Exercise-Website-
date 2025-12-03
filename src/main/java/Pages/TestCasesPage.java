package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utiles.LogsUtils;

public class TestCasesPage {
    /***Variables***/
    private static final String TestCasesAssertionMessage = "Below is the list of test Cases for you to practice the Automation";
    /***Locators***/
    private static final String TestCasesAssertionLocator = "//h5";
    @Step("Make sure that Test Cases appears")
    public static void TestCasesAssertion(WebDriver webDriver) throws InterruptedException {
        By message = By.xpath(TestCasesAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(TestCasesAssertionMessage));
        LogsUtils.info("Test Cases is found correctly");
    }

}
