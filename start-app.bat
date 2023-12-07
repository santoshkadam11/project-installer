@echo off
setlocal
set "JAVA_HOME=C:\Software\JAVA\RedHat\java-17-openjdk-17.0.4.1.1-1"
set "path=%JAVA_HOME%;%path%"
java -jar C:\personal\cyt-installer\out\artifacts\cyt_blr_setup_jar\cyt-installer.jar
