module com.santosh.prj {
   requires javafx.controls;
   requires javafx.fxml;
   requires javafx.web;

   requires org.kordamp.ikonli.javafx;

   opens com.santosh.prj to javafx.fxml;
   exports com.santosh.prj;
   exports com.santosh.prj.controller;
   opens com.santosh.prj.controller to javafx.fxml;
   exports com.santosh.prj.enums;
   opens com.santosh.prj.enums to javafx.fxml;
}
