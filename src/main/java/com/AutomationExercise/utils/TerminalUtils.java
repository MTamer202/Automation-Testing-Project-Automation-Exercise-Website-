package com.AutomationExercise.utils;

public class TerminalUtils {
    public static void executeTerminalCommand(String... command){
        try{
            ProcessBuilder processBuilder =new ProcessBuilder(command);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            LogsUtils.info("Command is successfully executed: " + String.join(" ",command));
        }catch (Exception e){
            LogsUtils.error("failed to execute command: "+e.getMessage());
        }
    }
}
