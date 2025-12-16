package com.AutomationExercise.Listeners;


import com.AutomationExercise.utils.AllureUtils;
import com.AutomationExercise.utils.CustomSoftAssertion;
import com.AutomationExercise.utils.FilesUtils;
import com.AutomationExercise.utils.LogsUtils;
import org.testng.*;

import java.io.File;

import static com.AutomationExercise.utils.PropertiesUtils.loadProperties;


public class TestngListeners implements IExecutionListener, ITestListener, IInvokedMethodListener {
    File allure_results = new File("test-outputs/allure-results");
    File Logs = new File("test-outputs/Logs");

    @Override
    public void onExecutionStart() {
        LogsUtils.info("Test Execution Started");
        loadProperties();
        FilesUtils.deleteFiles(allure_results);
        FilesUtils.cleanDirectory(Logs);
    }

    @Override
    public void onExecutionFinish() {
        LogsUtils.info("Test Execution Finished");
        AllureUtils.generateAllureReport();
        String reportFile =  AllureUtils.renameReport();
        AllureUtils.openReport(reportFile);

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            CustomSoftAssertion.customAssertAll(testResult);
            AllureUtils.attatchLogsToAllureReport();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test Case", result.getName(), "Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtils.info("Test Case", result.getName(), "Failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test Case", result.getName(), "Skipped  ");

    }
}
