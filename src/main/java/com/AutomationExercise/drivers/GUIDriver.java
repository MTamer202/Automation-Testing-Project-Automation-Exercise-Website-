package com.AutomationExercise.drivers;

import com.AutomationExercise.utils.*;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class GUIDriver {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public GUIDriver(String browserName) {
        WebDriver driver = getDriver(browserName).startDriver();
        setDriver(driver);

    }
    public static WebDriver getInstance(){
        return driverThreadLocal.get();
    }
    private AbstractDriver getDriver(String browserName) {
        switch (browserName) {
            case "Chrome":
                return new ChromeFactory();
            case "Edge":
                return new EdgeFactory();
            case "Firefox":
                return new FirefoxFactory();
            default:
                throw new IllegalArgumentException();
        }

    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
        LogsUtils.info("Driver is set");
    }
    public static WebDriver get(){
        if(driverThreadLocal.get()==null){
            LogsUtils.error("Driver is null");
            fail("Driver is null");
            return null;
        }
        return driverThreadLocal.get();
    }
    public ElementActions elementActions(){
        return new ElementActions(get());
    }
    public BrowserActions browserActions(){
        return new BrowserActions(get());
    }
    public Validaions validaions(){
        return new Validaions(get());
    }
    public Waits waits(){
        return new Waits(get());
    }





}
