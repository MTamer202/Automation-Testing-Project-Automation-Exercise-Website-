package com.AutomationExercise.utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;

import static com.AutomationExercise.utils.LogsUtils.Logs_Path;


public class AllureUtils {
//C:\Users\M.TAMER\AppData\Roaming\npm\node_modules\allure-commandline\dist\bin
    public static final String Allure_Results_Path = "test-outputs/allure-results";
    static String Allure_Report_PATH = "test-outputs/allure-report";
    static String USER_Home = System.getProperty("user.home");
    static String Allure_PATH = USER_Home+File.separator +"AppData"+File.separator
            +"Roaming"+File.separator+"npm"+File.separator+"node_modules"+File.separator
            +"allure-commandline"+File.separator+"dist"+File.separator+"bin"+File.separator+"allure";

    private AllureUtils() {
        super();
    }

    public static void generateAllureReport() {
        //allurePath,//generate,//path of the results//--single-file
        if(PropertiesUtils.getPropertyValue("os.name").toLowerCase().contains("win"))
        {
            String WIN = Allure_PATH + ".bat";
            TerminalUtils.executeTerminalCommand(WIN,"generate",Allure_Results_Path,"-o",Allure_Report_PATH,"clean","--single-file");
            LogsUtils.info("Allure Report is generated Successfully on Windows");
        }
        else {
            TerminalUtils.executeTerminalCommand(Allure_PATH,"generate",Allure_Results_Path,"-o",Allure_Report_PATH,"clean","--single-file");
            LogsUtils.info("Allure Report is generated Successfully on "+PropertiesUtils.getPropertyValue("os.name"));
        }
    }

    public static void openReport(String fileName){
        String reportPath = Allure_Report_PATH + File.separator +fileName;
        if(PropertiesUtils.getPropertyValue("openAllureAutomatically").equalsIgnoreCase("true"))
        {
            if(PropertiesUtils.getPropertyValue("os.name").toLowerCase().contains("win"))
            {
                TerminalUtils.executeTerminalCommand("cmd.exe","/c","start",reportPath);
            }
            else {
                TerminalUtils.executeTerminalCommand("open",reportPath);
            }

        }
    }

    public static String renameReport(){
        File newName = new File("Report_"+TimestampUtils.getTimeStamp()+".html");
        File oldName = new File(Allure_Report_PATH+File.separator+"index.html");
        FilesUtils.renameFile(oldName,newName);
        return newName.getName();
    }


    public static void attatchLogsToAllureReport() {
        try {
            File logFile = FilesUtils.getLatestFile(Logs_Path);
            if (!logFile.exists()) {
                LogsUtils.warn("Log file doesn't exist: " + Logs_Path);
                return;
            }
            Allure.addAttachment("Logs.log", Files.readString(logFile.toPath()));
            LogsUtils.info("Logs attatched To allure report");
        } catch (Exception e) {
            LogsUtils.error("Failed To attach logs To allure report " + e.getMessage());
        }
    }

}
