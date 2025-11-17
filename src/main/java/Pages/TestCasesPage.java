package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage {
    /***Variables***/
    private static final String TestCasesAssertionMessage = "Below is the list of test Cases for you to practice the Automation";
    /***Locators***/
    private static final String TestCasesAssertionLocator = "//h5";

    public static void TestCasesAssertion(WebDriver webDriver) throws InterruptedException {
        By message = By.xpath(TestCasesAssertionLocator);
        String actualText = webDriver.findElement(message).getText();
        Assert.assertTrue(actualText.contains(TestCasesAssertionMessage));
    }

}
