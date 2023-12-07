package com.amadeus.cyt.service;


import com.amadeus.cyt.util.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;


public class ApplicationInit
{
   public static Properties cytPreConfig;
   public static void init()
   {
      initLogFile();
      initConfiguration();
   }

   private static void initConfiguration() {
      // load configuration from property file
   }

   private static void initLogFile()
   {
      try {
         //logging all sys out in a file
         File file = new File(System.getProperty(Constant.USER_HOME) + Constant.CYT_INSTALLER_LOG);
         PrintStream stream = new PrintStream(file);
         System.setOut(stream);
         System.setErr(stream);

      }
      catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      }
   }
}
