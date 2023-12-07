package com.amadeus.cyt.enums;


public enum PrjSoftware
{
   JAVA("Java"), GIT("Git"), WEBLOGIC("Weblogic"), DATABASE("Database" ), NODE("Node");
   private final String name;


   PrjSoftware(String name)
   {
      this.name = name;
   }

   //getters
   public String getName()
   {
      return name;
   }

   public static boolean isSoftware(String text)
   {
      for (CytSoftware s : CytSoftware.values()) {
         if (s.name.equalsIgnoreCase(text)) {
            return true;
         }
      }
      return false;
   }

}
