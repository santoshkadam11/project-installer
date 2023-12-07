package com.santosh.prj.util;


import com.santosh.prj.enums.CytSoftware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SoftwareChecker
{
   public static String isInstalled(String softwareName)
   {
      String result = "Not Installed";
      ProcessBuilder processBuilder = getProcessBuilder(softwareName);
      if (!processBuilder.command().isEmpty()) {

         try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
               String line;
               StringBuilder versionInfo = new StringBuilder();
               while ((line = reader.readLine()) != null) {
                  versionInfo.append(line).append("\n");
               }
               result = versionInfo.toString();
            }
            if (result.isEmpty() && softwareName.equals("java")) {
               BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
               String line;
               StringBuilder versionInfo = new StringBuilder();
               while ((line = reader.readLine()) != null) {
                  versionInfo.append(line).append("\n");
               }

               result = versionInfo.toString();
               result = result.replaceAll("[^\\d.]", "");
               result =result.substring(0,6);

            }
            if (softwareName.equalsIgnoreCase(CytSoftware.DATABASE.name())) {

               result = result.replaceAll("[^\\d.]", "");
               result =result.substring(0,6);
            }

         }
         catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
         }
      }

      return result;

   }

   private static ProcessBuilder getProcessBuilder(String softwareName)
   {
      ProcessBuilder processBuilder = new ProcessBuilder();
      //check java version
      if (softwareName.equalsIgnoreCase(CytSoftware.JAVA.getName())) {
         processBuilder.command("cmd.exe", "/c", "java -version");
         System.out.println(System.getProperty("java.specification.version"));
      }
      //check node js version
      else if (softwareName.equalsIgnoreCase(CytSoftware.NODE.getName())) {
         processBuilder.command("cmd.exe", "/c", "node -v");
         System.out.println(System.getProperty("node.version"));
      }
      //check git bash version
      else if (softwareName.equalsIgnoreCase(CytSoftware.GIT.getName())) {
         processBuilder.command("cmd.exe", "/c", "git --version");
      }
      //check oracle database version
      else if (softwareName.equalsIgnoreCase(CytSoftware.DATABASE.getName())) {
         processBuilder.command("cmd.exe", "/c", "sqlplus -v");
      }
      return processBuilder;
   }

}
