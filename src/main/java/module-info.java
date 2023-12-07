module com.amadeus.cyt {
   requires javafx.controls;
   requires javafx.fxml;
   requires javafx.web;

   requires org.kordamp.ikonli.javafx;

   opens com.amadeus.cyt to javafx.fxml;
   exports com.amadeus.cyt;
   exports com.amadeus.cyt.controller;
   opens com.amadeus.cyt.controller to javafx.fxml;
   exports com.amadeus.cyt.enums;
   opens com.amadeus.cyt.enums to javafx.fxml;
}
