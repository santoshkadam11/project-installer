package com.amadeus.cyt.controller;


import com.amadeus.cyt.enums.CytSoftware;
import com.amadeus.cyt.util.SoftwareChecker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class Download
{

   @FXML
   private VBox vboxPane;


   @FXML
   private void initialize()
         throws IOException
   {
      for (javafx.scene.Node node : vboxPane.getChildren()) {
         if (node instanceof Pane) {
            String version = "Not Installed";
            Label insatlledLabel = null;
            for (javafx.scene.Node node1 : ((Pane) node).getChildren()) {
               if (node1 instanceof Label) {
                  Label label = (Label) node1;
                  String softwareName = label.getText().split(" ")[0].toLowerCase();
                  if (CytSoftware.isSoftware(softwareName)) {
                     version = SoftwareChecker.isInstalled(softwareName);
                  }
                  if(label.getText().contains("Installed Version:")){
                     insatlledLabel = label;
                  }
               }
            }
            if (insatlledLabel != null) {
               //add green color
               if (!version.equals("Not Installed")) {
                  insatlledLabel.setStyle("-fx-text-fill: green");
               }
               insatlledLabel.setText(insatlledLabel.getText() + " " + version);

            }
         }
      }
   }

}
